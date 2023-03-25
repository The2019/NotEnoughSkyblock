package net.the2019.skyblock.mixin;

import net.minecraft.client.gui.screen.ChatScreen;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfo;

@Mixin(ChatScreen.class)
public class chatRenderMixin {

    @Inject(method = "init", at = @At("HEAD"),cancellable = true)
    private void renderChat( CallbackInfo ci){
    }
}
