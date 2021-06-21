package mcjty.incontrol;


import mcjty.incontrol.setup.ModSetup;
import mcjty.tools.cache.StructureCache;
import net.minecraftforge.common.MinecraftForge;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.event.lifecycle.FMLCommonSetupEvent;
import net.minecraftforge.fml.event.server.FMLServerStoppedEvent;
import net.minecraftforge.fml.javafmlmod.FMLJavaModLoadingContext;

@Mod(InControl.MODID)
public class InControl {

    public static final String MODID = "incontrol";

    public static ModSetup setup = new ModSetup();

    public InControl() {
        FMLJavaModLoadingContext.get().getModEventBus().addListener((FMLCommonSetupEvent event) -> setup.init());
        MinecraftForge.EVENT_BUS.addListener((FMLServerStoppedEvent event) -> StructureCache.CACHE.clean());
        MinecraftForge.EVENT_BUS.addListener(ErrorHandler::onPlayerJoinWorld);
    }
}
