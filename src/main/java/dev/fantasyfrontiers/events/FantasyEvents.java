package dev.fantasyfrontiers.events;

import dev.fantasyfrontiers.registry.FantasyItems;
import net.minecraft.network.chat.Component;
import net.minecraft.server.level.ServerPlayer;
import net.neoforged.bus.api.SubscribeEvent;
import net.neoforged.fml.common.EventBusSubscriber;
import net.neoforged.neoforge.event.entity.player.PlayerEvent;

@EventBusSubscriber(modid = "fantasyfrontiers")
public final class FantasyEvents {
    @SubscribeEvent
    public static void onPlayerJoin(PlayerEvent.PlayerLoggedInEvent event) {
        if (event.getEntity() instanceof ServerPlayer player && !player.getTags().contains("ff_intro")) {
            player.addTag("ff_intro");
            player.sendSystemMessage(Component.literal("§6Fantasy Frontiers §7— §fYour quest begins. Use /ff quests to view the campaign."));
            player.sendSystemMessage(Component.literal("§7The first objective: obtain a spellbook, a hearty meal, and a quest compass."));
            player.getInventory().placeItemBackInInventory(FantasyItems.QUEST_COMPASS.get().getDefaultInstance());
        }
    }

    private FantasyEvents() {}
}
