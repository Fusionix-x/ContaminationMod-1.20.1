package net.fusionix.contamination.datagen;

import net.fusionix.contamination.ContaminationMod;
import net.fusionix.contamination.item.ModItems;
import net.minecraft.data.PackOutput;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.item.Item;
import net.minecraftforge.client.model.generators.ItemModelBuilder;
import net.minecraftforge.client.model.generators.ItemModelProvider;
import net.minecraftforge.common.data.ExistingFileHelper;
import net.minecraftforge.registries.RegistryObject;

public class ModItemModelProvider extends ItemModelProvider {
    public ModItemModelProvider(PackOutput output, ExistingFileHelper existingFileHelper) {
        super(output, ContaminationMod.MOD_ID, existingFileHelper);
    }

    @Override
    protected void registerModels() {
        simpleItem(ModItems.URANIUM_INGOT);
        simpleItem(ModItems.RAW_URANIUM);
        simpleItem(ModItems.TITANIUM_INGOT);
        simpleItem(ModItems.RAW_TITANIUM);
        simpleItem(ModItems.LEAD_INGOT);
        simpleItem(ModItems.RAW_LEAD);

    }

    private ItemModelBuilder simpleItem(RegistryObject<Item> item) {
        return withExistingParent(item.getId().getPath(),
                new ResourceLocation("item/generated")).texture("layer0",
                new ResourceLocation(ContaminationMod.MOD_ID, "item/" + item.getId().getPath()));
    }
}
