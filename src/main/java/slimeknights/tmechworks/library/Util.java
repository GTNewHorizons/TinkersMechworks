package slimeknights.tmechworks.library;

import com.mojang.authlib.GameProfile;
import net.minecraft.util.ResourceLocation;
import net.minecraft.world.World;
import net.minecraft.world.server.ServerWorld;
import net.minecraftforge.common.util.FakePlayer;
import net.minecraftforge.common.util.FakePlayerFactory;
import slimeknights.tmechworks.TMechworks;

import java.lang.ref.WeakReference;
import java.util.Locale;
import java.util.Random;
import java.util.UUID;

public class Util
{

    public static final String RESOURCE = TMechworks.modId;
    public static final Random rand = new Random();

    public static WeakReference<FakePlayer> createFakePlayer (World world)
    {
        if (!(world instanceof ServerWorld))
        {
            return null;
        }

        return new WeakReference<FakePlayer>(FakePlayerFactory.get((ServerWorld) world, new GameProfile(UUID.randomUUID(), "MechworksWorker")));
    }

    /**
     * Returns the given Resource prefixed with tinkers resource location. Use this function instead of hardcoding
     * resource locations.
     */
    public static String resource (String res)
    {
        return String.format("%s:%s", RESOURCE, res);
    }

    public static ResourceLocation getResource (String res)
    {
        return new ResourceLocation(RESOURCE, res);
    }

//    public static ResourceLocation getModelResource (String res, String variant)
//    {
//        return new ModelResourceLocation(resource(res), variant);
//    }

    /**
     * Prefixes the given unlocalized name with tinkers prefix. Use this when passing unlocalized names for a uniform
     * namespace.
     */
    public static String prefix (String name)
    {
        return String.format("%s:%s", RESOURCE, name.toLowerCase(Locale.US));
    }

}
