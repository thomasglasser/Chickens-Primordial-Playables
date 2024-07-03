package dev.thomasglasser.chickenengineer.primordialplayables;

import com.mojang.logging.LogUtils;
import dev.thomasglasser.chickenengineer.primordialplayables.data.PrimordialPlayablesDataGenerators;
import dev.thomasglasser.chickenengineer.primordialplayables.world.item.PrimordialPlayablesItems;
import dev.thomasglasser.chickenengineer.primordialplayables.world.level.block.PrimordialPlayablesBlocks;
import dev.thomasglasser.tommylib.api.platform.TommyLibServices;
import net.minecraft.resources.ResourceLocation;
import net.neoforged.bus.api.IEventBus;
import net.neoforged.fml.common.Mod;
import org.slf4j.Logger;

@Mod(PrimordialPlayables.MOD_ID)
public class PrimordialPlayables {
    public static final String MOD_ID = "primordialplayables";
    public static final String MOD_NAME = "Chickens Primordial Playables";
    private static final Logger LOGGER = LogUtils.getLogger();

    public PrimordialPlayables(IEventBus bus) {
        LOGGER.info("Initializing {} for {} in a {} environment...", MOD_NAME, TommyLibServices.PLATFORM.getPlatformName(), TommyLibServices.PLATFORM.getEnvironmentName());

        PrimordialPlayablesItems.init();
        PrimordialPlayablesBlocks.init();

        bus.addListener(PrimordialPlayablesDataGenerators::onGatherData);
    }

    public static ResourceLocation modLoc(String path) {
        return ResourceLocation.fromNamespaceAndPath(MOD_ID, path);
    }
}
