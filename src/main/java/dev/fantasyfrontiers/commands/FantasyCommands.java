package dev.fantasyfrontiers.commands;

import com.mojang.brigadier.CommandDispatcher;
import net.minecraft.commands.CommandSourceStack;
import net.minecraft.commands.Commands;
import net.minecraft.network.chat.Component;
import net.neoforged.bus.api.SubscribeEvent;
import net.neoforged.fml.common.EventBusSubscriber;
import net.neoforged.neoforge.event.RegisterCommandsEvent;

@EventBusSubscriber(modid = "fantasyfrontiers")
public final class FantasyCommands {
    @SubscribeEvent
    public static void register(RegisterCommandsEvent event) {
        CommandDispatcher<CommandSourceStack> dispatcher = event.getDispatcher();
        dispatcher.register(Commands.literal("ff").then(Commands.literal("quests").executes(context -> {
            CommandSourceStack source = context.getSource();
            source.sendSuccess(() -> Component.literal("§6§lFANTASY FRONTIERS CAMPAIGN"), false);
            send(source, "1. A Frontier Worth Fighting For", "Gather a quest compass and prepare for the first gate.");
            send(source, "2. The First Spellbook", "Master a spell from Iron's Spells n Spellbooks and defeat a dangerous foe.");
            send(source, "3. Beyond the Overworld", "Explore the Aether and Twilight Forest dimensions.");
            send(source, "4. Forged for the Hunt", "Craft and improve a Tetra weapon before challenging a major boss.");
            send(source, "5. A Hero's Feast", "Cook an Arcane Ration and stock up with Farmer's Delight meals.");
            send(source, "6. Proof of Victory", "Claim a trophy from a major boss and begin the Terramity endgame.");
            return 1;
        })));
    }

    private static void send(CommandSourceStack source, String title, String description) {
        source.sendSuccess(() -> Component.literal("§e" + title + " §8— §7" + description), false);
    }

    private FantasyCommands() {}
}
