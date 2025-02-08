package net.fusionix.contamination.datagen;

import net.fusionix.contamination.block.ModBlocks;
import net.fusionix.contamination.item.ModItems;
import net.minecraft.advancements.critereon.ItemPredicate;
import net.minecraft.data.PackOutput;
import net.minecraft.data.recipes.*;
import net.minecraft.world.item.Item;
import net.minecraft.world.level.ItemLike;

import java.util.List;
import java.util.function.Consumer;

public class ModRecipeProvider extends RecipeProvider {
    private List<ItemLike> URANIUM_SMELTABLES = List.of(ModItems.RAW_URANIUM.get(), ModBlocks.URANIUM_ORE.get());
    private List<ItemLike> TITANIUM_SMELTABLES = List.of(ModItems.RAW_TITANIUM.get(), ModBlocks.TITANIUM_ORE.get());
    private List<ItemLike> LEAD_SMELTABLES = List.of(ModItems.RAW_LEAD.get(), ModBlocks.LEAD_ORE.get());

    public ModRecipeProvider(PackOutput pOutput) {
        super(pOutput);
    }

    @Override
    protected void buildRecipes(Consumer<FinishedRecipe> consumer) {
        ShapedRecipeBuilder.shaped(RecipeCategory.MISC, ModBlocks.URANIUM_BLOCK.get())
                .pattern("AAA")
                .pattern("AAA")
                .pattern("AAA")
                .define('A', ModItems.URANIUM_INGOT.get())
                .unlockedBy("has_uranium_ingot", inventoryTrigger(ItemPredicate.Builder.item().
                        of(ModItems.URANIUM_INGOT.get()).build()))
                .save(consumer);


        ShapelessRecipeBuilder.shapeless(RecipeCategory.MISC, ModItems.URANIUM_INGOT.get(), 9)
                .requires(ModBlocks.URANIUM_BLOCK.get())
                .unlockedBy("has_uranium_block", inventoryTrigger(ItemPredicate.Builder.item().
                        of(ModBlocks.URANIUM_BLOCK.get()).build()))
                .save(consumer);

        nineBlockStorageRecipes(consumer, RecipeCategory.MISC, ModItems.TITANIUM_INGOT.get(), RecipeCategory.MISC, ModBlocks.TITANIUM_BLOCK.get());
        nineBlockStorageRecipes(consumer, RecipeCategory.MISC, ModItems.LEAD_INGOT.get(), RecipeCategory.MISC, ModBlocks.LEAD_BLOCK.get());

        oreSmelting(consumer, URANIUM_SMELTABLES, RecipeCategory.MISC, ModItems.URANIUM_INGOT.get(), 0.75f, 200, "uranium");
        oreBlasting(consumer, URANIUM_SMELTABLES, RecipeCategory.MISC, ModItems.URANIUM_INGOT.get(), 0.75f, 100, "uranium");
        oreSmelting(consumer, TITANIUM_SMELTABLES, RecipeCategory.MISC, ModItems.TITANIUM_INGOT.get(), 0.75f, 200, "titanium");
        oreBlasting(consumer, TITANIUM_SMELTABLES, RecipeCategory.MISC, ModItems.TITANIUM_INGOT.get(), 0.75f, 100, "titanium");
        oreSmelting(consumer, LEAD_SMELTABLES, RecipeCategory.MISC, ModItems.LEAD_INGOT.get(), 0.75f, 200, "lead");
        oreBlasting(consumer, LEAD_SMELTABLES, RecipeCategory.MISC, ModItems.LEAD_INGOT.get(), 0.75f, 100, "lead");
    }
}
