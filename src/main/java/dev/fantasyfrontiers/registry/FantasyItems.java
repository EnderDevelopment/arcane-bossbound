package dev.fantasyfrontiers.registry;

import dev.fantasyfrontiers.FantasyFrontiers;
import net.minecraft.core.registries.Registries;
import net.minecraft.network.chat.Component;
import net.minecraft.world.item.CreativeModeTab;
import net.minecraft.world.item.Item;
import net.neoforged.neoforge.registries.DeferredHolder;
import net.neoforged.neoforge.registries.DeferredRegister;

public final class FantasyItems {
    public static final DeferredRegister.Items ITEMS = DeferredRegister.createItems(FantasyFrontiers.MOD_ID);
    public static final DeferredRegister<CreativeModeTab> CREATIVE_TAB = DeferredRegister.create(Registries.CREATIVE_MODE_TAB, FantasyFrontiers.MOD_ID);

    public static final DeferredHolder<Item, Item> QUEST_COMPASS = ITEMS.registerSimpleItem("quest_compass", new Item.Properties());
    public static final DeferredHolder<Item, Item> ARCANE_RATION = ITEMS.registerSimpleItem("arcane_ration", new Item.Properties().food(FantasyFood.ARCANE_RATION));
    public static final DeferredHolder<Item, Item> BOSS_TROPHY = ITEMS.registerSimpleItem("boss_trophy", new Item.Properties());

    public static final DeferredHolder<CreativeModeTab, CreativeModeTab> TAB = CREATIVE_TAB.register("main", () -> CreativeModeTab.builder()
            .title(Component.translatable("itemGroup.fantasyfrontiers"))
            .icon(() -> QUEST_COMPASS.get().getDefaultInstance())
            .displayItems((parameters, output) -> {
                output.accept(QUEST_COMPASS);
                output.accept(ARCANE_RATION);
                output.accept(BOSS_TROPHY);
            }).build());

    private FantasyItems() {}
}
