package dev.fantasyfrontiers;

import dev.fantasyfrontiers.registry.FantasyItems;
import net.neoforged.bus.api.IEventBus;
import net.neoforged.fml.common.Mod;

@Mod(FantasyFrontiers.MOD_ID)
public final class FantasyFrontiers {
    public static final String MOD_ID = "fantasyfrontiers";

    public FantasyFrontiers(IEventBus modEventBus) {
        FantasyItems.ITEMS.register(modEventBus);
        FantasyItems.CREATIVE_TAB.register(modEventBus);
    }
}
