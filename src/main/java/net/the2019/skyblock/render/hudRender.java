package net.the2019.skyblock.render;

import net.minecraft.client.MinecraftClient;
import net.minecraft.client.util.math.MatrixStack;

import java.awt.*;

public class hudRender {

    private static MinecraftClient mc = MinecraftClient.getInstance();

    public static void render(MatrixStack matrixStack, float tickDelta){
        darvenRender(matrixStack);
    }
    public static void darvenRender(MatrixStack matrixStack){
        mc.textRenderer.drawWithShadow(matrixStack, "Test Render", 10, 10, Color.GREEN.getRGB());
    }

}
