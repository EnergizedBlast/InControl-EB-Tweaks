package mcjty.incontrol.compat;

import mcjty.incontrol.setup.ModSetup;
import mcjty.incontrol.tools.rules.IEventQuery;
import mcjty.incontrol.tools.rules.IModRuleCompatibilityLayer;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.item.ItemStack;
import net.minecraft.util.ResourceLocation;
import net.minecraft.util.text.TranslationTextComponent;
import net.minecraft.world.IWorld;
import net.minecraft.world.biome.Biome;

public class ModRuleCompatibilityLayer implements IModRuleCompatibilityLayer {

    @Override
    public boolean hasBaubles() {
        return ModSetup.baubles;
    }

    @Override
    public int[] getAmuletSlots() {
        return BaublesSupport.getAmuletSlots();
    }

    @Override
    public int[] getBeltSlots() {
        return BaublesSupport.getBeltSlots();
    }

    @Override
    public int[] getBodySlots() {
        return BaublesSupport.getBodySlots();
    }

    @Override
    public int[] getCharmSlots() {
        return BaublesSupport.getCharmSlots();
    }

    @Override
    public int[] getHeadSlots() {
        return BaublesSupport.getHeadSlots();
    }

    @Override
    public int[] getRingSlots() {
        return BaublesSupport.getRingSlots();
    }

    @Override
    public int[] getTrinketSlots() {
        return BaublesSupport.getTrinketSlots();
    }

    @Override
    public ItemStack getBaubleStack(PlayerEntity player, int slot) {
        return BaublesSupport.getStack(player, slot);
    }

    @Override
    public boolean hasGameStages() {
        return ModSetup.gamestages;
    }

    @Override
    public boolean hasGameStage(PlayerEntity player, String stage) {
        return GameStageSupport.hasGameStage(player, stage);
    }

    @Override
    public void addGameStage(PlayerEntity player, String stage) {
        GameStageSupport.addGameStage(player, stage);
    }

    @Override
    public void removeGameStage(PlayerEntity player, String stage) {
        GameStageSupport.removeGameStage(player, stage);
    }

    @Override
    public boolean hasLostCities() {
        return ModSetup.lostcities;
    }

    @Override
    public <T> boolean isCity(IEventQuery<T> query, T event) {
        return LostCitySupport.isCity(query, event);
    }

    @Override
    public <T> boolean isStreet(IEventQuery<T> query, T event) {
        return LostCitySupport.isStreet(query, event);
    }

    @Override
    public <T> boolean inSphere(IEventQuery<T> query, T event) {
        return LostCitySupport.inSphere(query, event);
    }

    @Override
    public <T> boolean isBuilding(IEventQuery<T> query, T event) {
        return LostCitySupport.isBuilding(query, event);
    }

    @Override
    public boolean hasSereneSeasons() {
        return ModSetup.sereneSeasons;
    }

    @Override
    public boolean isSpring(IWorld world) {
        return SereneSeasonsSupport.isSpring(world);
    }

    @Override
    public boolean isSummer(IWorld world) {
        return SereneSeasonsSupport.isSummer(world);
    }

    @Override
    public boolean isWinter(IWorld world) {
        return SereneSeasonsSupport.isWinter(world);
    }

    @Override
    public boolean isAutumn(IWorld world) {
        return SereneSeasonsSupport.isAutumn(world);
    }

    @Override
    public boolean hasEnigmaScript() {
        return false;
    }

    @Override
    public String getPlayerState(PlayerEntity player, String statename) {
        return null;
    }

    @Override
    public String getState(IWorld world, String statename) {
        return null;
    }

    @Override
    public void setPlayerState(PlayerEntity player, String statename, String statevalue) {
        // Not supported by In Control
    }

    @Override
    public void setState(IWorld world, String statename, String statevalue) {
        // Not supported by In Control
    }

    @Override
    public String getBiomeName(Biome biome) {
        ResourceLocation resourceLocation = biome.getRegistryName();
        String s = "biome." + resourceLocation.getNamespace() + "." + resourceLocation.getPath();
        return new TranslationTextComponent(s).getString();
    }
}
