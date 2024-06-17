package dev.thomasglasser.chickenengineer.primordialplayables;

import dev.thomasglasser.chickenengineer.primordialplayables.data.PrimordialPlayablesDataGenerators;
import dev.thomasglasser.chickenengineer.primordialplayables.world.item.PrimordialPlayablesItems;
import dev.thomasglasser.chickenengineer.primordialplayables.world.level.block.PrimordialPlayablesBlocks;
import net.minecraft.resources.ResourceLocation;
import net.neoforged.bus.api.IEventBus;
import org.slf4j.Logger;

import com.mojang.logging.LogUtils;

import net.neoforged.fml.common.Mod;

@Mod(PrimordialPlayables.MOD_ID)
public class PrimordialPlayables
{
    public static final String MOD_ID = "primordialplayables";
    private static final Logger LOGGER = LogUtils.getLogger();

    public PrimordialPlayables(IEventBus bus)
    {
        PrimordialPlayablesItems.init();
        PrimordialPlayablesBlocks.init();

        bus.addListener(PrimordialPlayablesDataGenerators::onGatherData);
    }

    public static ResourceLocation modLoc(String path)
    {
        return new ResourceLocation(MOD_ID, path);
    }
}
