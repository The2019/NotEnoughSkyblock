package net.the2019.skyblock.mixin;

import net.minecraft.client.gui.hud.InGameHud;
import net.minecraft.client.util.math.MatrixStack;
import net.the2019.skyblock.render.hudRender;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfo;

@Mixin(InGameHud.class)
public class hudRenderMixin {

    @Inject(method = "render", at = @At("RETURN"),cancellable = true)
    public void renderHud(MatrixStack matrices, float tickDelta, CallbackInfo ci){
        hudRender.render(matrices, tickDelta);
    }
}
