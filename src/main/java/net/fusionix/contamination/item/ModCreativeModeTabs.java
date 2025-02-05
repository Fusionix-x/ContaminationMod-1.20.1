package net.fusionix.contamination.item;

import net.fusionix.contamination.ContaminationMod;
import net.fusionix.contamination.block.ModBlocks;
import net.minecraft.core.registries.Registries;
import net.minecraft.network.chat.Component;
import net.minecraft.world.item.CreativeModeTab;
import net.minecraft.world.item.ItemStack;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.RegistryObject;

public class ModCreativeModeTabs {
    public static final DeferredRegister<CreativeModeTab> CREATIVE_MODE_TABS =
            DeferredRegister.create(Registries.CREATIVE_MODE_TAB, ContaminationMod.MOD_ID);


    public static final RegistryObject<CreativeModeTab> CONTAMINATION_TAB = CREATIVE_MODE_TABS.register("contamination_tab",
            () -> CreativeModeTab.builder().icon(() -> new ItemStack(ModItems.URANIUM_INGOT.get()))
                    .title(Component.translatable("creativetab.contamination_tab"))
                    .displayItems((itemDisplayParameters, output) -> {
                        output.accept(ModItems.URANIUM_INGOT.get());
                        output.accept(ModItems.RAW_URANIUM.get());
                        output.accept(ModItems.TITANIUM_INGOT.get());
                        output.accept(ModItems.RAW_TITANIUM.get());
                        output.accept(ModItems.LEAD_INGOT.get());
                        output.accept(ModItems.RAW_LEAD.get());


                        output.accept(ModBlocks.URANIUM_BLOCK.get());
                        output.accept(ModBlocks.URANIUM_ORE.get());
                        output.accept(ModBlocks.TITANIUM_BLOCK.get());
                        output.accept(ModBlocks.TITANIUM_ORE.get());
                        output.accept(ModBlocks.LEAD_BLOCK.get());
                        output.accept(ModBlocks.LEAD_ORE.get());

                    }).build());

    public static void register(IEventBus eventBus) {
        CREATIVE_MODE_TABS.register(eventBus);
    }
}
