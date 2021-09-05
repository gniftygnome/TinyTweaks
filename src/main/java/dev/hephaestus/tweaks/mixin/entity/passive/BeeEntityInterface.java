package dev.hephaestus.tweaks.mixin.entity.passive;

import net.minecraft.entity.passive.BeeEntity;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.gen.Invoker;

@Mixin(BeeEntity.class)
public interface BeeEntityInterface {
    @Invoker
    void callSetHasNectar(boolean hasNectar);
}
