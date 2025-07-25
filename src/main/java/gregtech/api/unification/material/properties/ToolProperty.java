package gregtech.api.unification.material.properties;

import gregtech.api.items.toolitem.EnchantmentLevel;

import net.minecraft.enchantment.Enchantment;

import it.unimi.dsi.fastutil.objects.Object2ObjectArrayMap;
import it.unimi.dsi.fastutil.objects.Object2ObjectMap;

public class ToolProperty {

    /**
     * Harvest speed of tools made from this Material.
     * <p>
     * Default: 1.0F
     */
    private float harvestSpeed;

    /**
     * Attack damage of tools made from this Material
     * <p>
     * Default: 1.0F
     */
    private float attackDamage;

    /**
     * Attack speed of tools made from this Material
     * <p>
     * Default: 0.0F
     */
    private float attackSpeed;

    /**
     * Durability of tools made from this Material.
     * <p>
     * Default: 100
     */
    private int durability;

    /**
     * Harvest level of tools made of this Material.
     * <p>
     * Default: 2 (Iron).
     */
    private int harvestLevel;

    /**
     * Enchantability of tools made from this Material.
     * <p>
     * Default: 10
     */
    private int enchantability;

    /**
     * A multiplier to the base durability for this material Mostly for modpack makers
     */
    private int durabilityMultiplier;

    /**
     * If crafting tools should not be made from this material
     */
    private boolean ignoreCraftingTools;

    /**
     * If tools made of this material should be unbreakable and ignore durability checks.
     */
    private boolean isUnbreakable;

    /**
     * If tools made of this material should be "magnetic," meaning items go directly into the player's inventory
     * instead of dropping on the ground.
     */
    private boolean isMagnetic;

    /**
     * Enchantment to be applied to tools made from this Material.
     */
    private final Object2ObjectMap<Enchantment, EnchantmentLevel> enchantments;

    public ToolProperty(float harvestSpeed, float attackDamage, int durability, int harvestLevel) {
        this.harvestSpeed = harvestSpeed;
        this.attackDamage = attackDamage;
        this.durability = durability;
        this.harvestLevel = harvestLevel;
        enchantments = new Object2ObjectArrayMap<>();
    }

    public ToolProperty() {
        this(1.0F, 1.0F, 100, 2);
    }

    public ToolProperty(ToolProperty property) {
        harvestSpeed = property.harvestSpeed;
        attackDamage = property.attackDamage;
        attackSpeed = property.attackSpeed;
        durability = property.durability;
        harvestLevel = property.harvestLevel;
        enchantability = property.enchantability;
        durabilityMultiplier = property.durabilityMultiplier;
        ignoreCraftingTools = property.ignoreCraftingTools;
        isUnbreakable = property.isUnbreakable;
        isMagnetic = property.isMagnetic;
        enchantments = new Object2ObjectArrayMap<>(property.enchantments);
    }

    public float getToolSpeed() {
        return harvestSpeed;
    }

    public ToolProperty setToolSpeed(float toolSpeed) {
        this.harvestSpeed = toolSpeed;
        return this;
    }

    public float getToolAttackDamage() {
        return attackDamage;
    }

    public ToolProperty setToolAttackDamage(float toolAttackDamage) {
        this.attackDamage = toolAttackDamage;
        return this;
    }

    public float getToolAttackSpeed() {
        return attackSpeed;
    }

    public ToolProperty setToolAttackSpeed(float toolAttackSpeed) {
        this.attackSpeed = toolAttackSpeed;
        return this;
    }

    public int getToolDurability() {
        return durability;
    }

    public ToolProperty setToolDurability(int toolDurability) {
        this.durability = toolDurability;
        return this;
    }

    public int getToolHarvestLevel() {
        return this.harvestLevel;
    }

    public ToolProperty setToolHarvestLevel(int toolHarvestLevel) {
        this.harvestLevel = toolHarvestLevel;
        return this;
    }

    public int getToolEnchantability() {
        return enchantability;
    }

    public ToolProperty setToolEnchantability(int toolEnchantability) {
        this.enchantability = toolEnchantability;
        return this;
    }

    public boolean getShouldIgnoreCraftingTools() {
        return ignoreCraftingTools;
    }

    public ToolProperty setShouldIgnoreCraftingTools(boolean ignore) {
        this.ignoreCraftingTools = ignore;
        return this;
    }

    public boolean getUnbreakable() {
        return isUnbreakable;
    }

    public ToolProperty setUnbreakable(boolean isUnbreakable) {
        this.isUnbreakable = isUnbreakable;
        return this;
    }

    public Object2ObjectMap<Enchantment, EnchantmentLevel> getEnchantments() {
        return enchantments;
    }

    public ToolProperty setMagnetic(boolean isMagnetic) {
        this.isMagnetic = isMagnetic;
        return this;
    }

    public boolean isMagnetic() {
        return isMagnetic;
    }

    public ToolProperty setDurabilityMultiplier(int multiplier) {
        this.durabilityMultiplier = multiplier;
        return this;
    }

    public int getDurabilityMultiplier() {
        return durabilityMultiplier;
    }

    public void addEnchantmentForTools(Enchantment enchantment, int level) {
        this.addEnchantmentForTools(enchantment, level, 0);
    }

    public void addEnchantmentForTools(Enchantment enchantment, double level, double levelGrowth) {
        enchantments.put(enchantment, new EnchantmentLevel(level, levelGrowth));
    }
}
