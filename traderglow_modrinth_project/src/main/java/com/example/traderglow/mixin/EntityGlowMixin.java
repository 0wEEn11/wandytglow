package com.example.traderglow.mixin;

import com.example.traderglow.TraderGlowMod;
import net.minecraft.world.entity.Entity;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfoReturnable;

@Mixin(Entity.class)
public class EntityGlowMixin {

    @Inject(method = "isCurrentlyGlowing", at = @At("HEAD"), cancellable = true)
    private void traderglow$forceGlow(CallbackInfoReturnable<Boolean> cir) {
        if (TraderGlowMod.isTrader((Entity) (Object) this)) {
            cir.setReturnValue(true);
        }
    }
}
