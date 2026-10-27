package connors.pigeons.entity;

import connors.pigeons.Connorspigeons;
import connors.pigeons.entity.custom.MaxEntity;
import net.minecraft.core.Registry;
import net.minecraft.core.registries.BuiltInRegistries;
import net.minecraft.core.registries.Registries;
import net.minecraft.resources.Identifier;
import net.minecraft.resources.ResourceKey;
import net.minecraft.world.entity.EntityType;
import net.minecraft.world.entity.MobCategory;

public class ModEntities {
    public static final ResourceKey<EntityType<?>> MAX_KEY = ResourceKey.create(Registries.ENTITY_TYPE,
            Identifier.fromNamespaceAndPath(Connorspigeons.MOD_ID, "max"));

    public static final EntityType<MaxEntity> MAX = Registry.register(BuiltInRegistries.ENTITY_TYPE,
            Identifier.fromNamespaceAndPath(Connorspigeons.MOD_ID, "max"));
            EntityType.Builder.of(MaxEntity::new, MobCategory.CREATURE).sized(0.75f, 0.5).build(MAX_KEY));


}
