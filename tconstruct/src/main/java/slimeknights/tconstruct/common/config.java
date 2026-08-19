package slimeknights.tconstruct.common;

import net.minecraft.core.registries.BuiltInRegistries;
import net.minecraft.resources.ResourceLocation;
import net.neoforged.fml.ModLoadingContext;
import net.neoforged.fml.config.ModConfig;
import net.neoforged.neoforge.common.ModConfigSpec;
import org.apache.commons.lang3.tuple.Pair;

import java.util.List;

public class config {

    /**
     * Common specific configuration
     */
    public static class Common {
        Common(ModConfigSpec.Builder builder) {
            builder.comment("Everything to do with gameplay").push("gameplay");


        }
    }

    /**
     * Client specific configuration - only loaded clientside from tconstruct-client.toml
     */
    public static class Client {
        Client(ModConfigSpec.Builder builder) {
            builder.comment("Client only settings").push("client");
        }
    }
    public static final ModConfigSpec clientSpec;
    public static final Client CLIENT;

    static {
        final Pair<Client, ModConfigSpec> specPair = new ModConfigSpec.Builder().configure(Client::new);
        clientSpec = specPair.getRight();
        CLIENT = specPair.getLeft();
    }

    public static final ModConfigSpec commonSpec;
    public static final Common COMMON;

    static {
        final Pair<Common, ModConfigSpec> specPair = new ModConfigSpec.Builder().configure(Common::new);
        commonSpec = specPair.getRight();
        COMMON = specPair.getLeft();
    }

    /** Registers any relevant listeners for config */
//    public static void init() {
//        ModLoadingContext.get().registerConfig(ModConfig.Type.COMMON, Config.commonSpec);
//        ModLoadingContext.get().registerConfig(ModConfig.Type.CLIENT, Config.clientSpec);
//    }

    /** Method of syncing the tool inventory on open to prevent desyncs down the line. */
    public enum ToolSyncType {
        FULL_STACK,
        MINIMAL,
        DISABLED;
    }
}
