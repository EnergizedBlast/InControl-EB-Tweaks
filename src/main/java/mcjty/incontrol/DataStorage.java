package mcjty.incontrol;

import net.minecraft.nbt.CompoundNBT;
import net.minecraft.server.MinecraftServer;
import net.minecraft.world.World;
import net.minecraft.world.server.ServerWorld;
import net.minecraft.world.storage.DimensionSavedDataManager;
import net.minecraft.world.storage.WorldSavedData;

import javax.annotation.Nonnull;

public class DataStorage extends WorldSavedData {

    private static final String NAME = "InControlData";

    private Boolean isDay = null;
    private int daycounter = 0;

    public DataStorage() {
        super(NAME);
    }

    @Nonnull
    public static DataStorage getData(World world) {
        if (world.isClientSide()) {
            throw new RuntimeException("Don't access this client-side!");
        }
        MinecraftServer server = world.getServer();
        ServerWorld overworld = server.getLevel(World.OVERWORLD);

        DimensionSavedDataManager storage = overworld.getDataStorage();
        return storage.computeIfAbsent(DataStorage::new, NAME);
    }

    public int getDaycounter() {
        return daycounter;
    }

    public void setDaycounter(int daycounter) {
        this.daycounter = daycounter;
    }

    public Boolean getDay() {
        return isDay;
    }

    public void setDay(Boolean day) {
        isDay = day;
    }

    public void tick(World world) {
        long time = world.getDayTime() % 24000;
        boolean day = time >= 0 && time < 12000;
        if (isDay == null) {
            isDay = day;
            setDirty();
        } else {
            if (day != isDay) {
                if (day) {    // New day
                    daycounter++;
                }
                isDay = day;
                setDirty();
            }
        }
    }

    @Override
    public void load(CompoundNBT tag) {
        daycounter = tag.getInt("daycounter");
        if (tag.contains("isday")) {
            isDay = tag.getBoolean("isday");
        } else {
            isDay = null;
        }
    }

    @Override
    public CompoundNBT save(CompoundNBT tag) {
        tag.putInt("daycounter", daycounter);
        if (isDay != null) {
            tag.putBoolean("isday", isDay);
        }
        return tag;
    }
}
