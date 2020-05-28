package dev.hephaestus.tweaks.mixin.client.gui.screen.ingame;

import net.fabricmc.api.EnvType;
import net.fabricmc.api.Environment;
import net.minecraft.block.entity.SignBlockEntity;
import net.minecraft.client.gui.screen.ingame.SignEditScreen;
import org.spongepowered.asm.mixin.Final;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.Shadow;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfo;

@Mixin(SignEditScreen.class)
@Environment(EnvType.CLIENT)
public class SignEditScreenMixin {
	@Shadow @Final private String[] field_24285;

	@Shadow @Final private SignBlockEntity sign;

	@Inject(method = "init", at = @At("TAIL"))
	private void setRows(CallbackInfo ci) {
		for (int i = 0; i < 4; ++i) {
			this.field_24285[i] = this.sign.getTextOnRow(i).asString();
		}
	}
}
