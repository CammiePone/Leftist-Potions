package dev.cammiescorner.leftistpotions.mixin;

import net.minecraft.client.gui.screen.ingame.AbstractInventoryScreen;
import net.minecraft.client.gui.screen.ingame.HandledScreen;
import net.minecraft.entity.player.PlayerInventory;
import net.minecraft.screen.ScreenHandler;
import net.minecraft.text.Text;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.ModifyVariable;

@Mixin(AbstractInventoryScreen.class)
public abstract class AbstractInventoryScreenMixin<T extends ScreenHandler> extends HandledScreen<T> {
	public AbstractInventoryScreenMixin(T handler, PlayerInventory inventory, Text title) { super(handler, inventory, title); }

	@ModifyVariable(method = "drawStatusEffects", at = @At(value = "STORE", ordinal = 0), ordinal = 2)
	public int potionX(int i) {
		boolean wide = this.width - (this.x - this.backgroundWidth + 74) >= 435;
		return wide ? this.x - this.backgroundWidth + 74 : this.x - this.backgroundWidth + 162;
	}

	@ModifyVariable(method = "drawStatusEffects", at = @At(value = "STORE", ordinal = 0))
	public boolean shouldBeSmallIcon(boolean bl) {
		return this.width - (this.x - this.backgroundWidth + 74) >= 435;
	}
}
