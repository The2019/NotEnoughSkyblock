package net.the2019.skyblock.mixin;

import net.minecraft.client.MinecraftClient;
import net.minecraft.client.gui.screen.Screen;
import net.minecraft.client.gui.screen.ingame.InventoryScreen;
import net.minecraft.client.gui.widget.ButtonWidget;
import net.minecraft.text.LiteralText;
import net.minecraft.text.Text;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfo;

@Mixin(InventoryScreen.class)
public abstract class inventoryHudMixin extends Screen {
    private static final MinecraftClient mc = MinecraftClient.getInstance();

    protected inventoryHudMixin(Text title) {
        super(title);
    }

    @Inject(method = "render", at = @At("HEAD"))
    private void renderChat( CallbackInfo ci) {
        assert this.client != null;
        assert this.client.player != null;
        this.addDrawableChild(new ButtonWidget(10 , 10, 90, 20, new LiteralText("Hub") , (buttonWidget) -> {
            this.client.player.sendChatMessage("/warp hub");
        }));
    }
}
