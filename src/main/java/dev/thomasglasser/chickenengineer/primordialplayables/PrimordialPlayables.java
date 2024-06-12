package dev.thomasglasser.chickenengineer.primordialplayables;

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

    }

    public static ResourceLocation modLoc(String path)
    {
        return new ResourceLocation(MOD_ID, path);
    }
}
