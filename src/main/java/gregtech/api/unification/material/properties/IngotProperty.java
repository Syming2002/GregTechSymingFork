package gregtech.api.unification.material.properties;

import gregtech.api.unification.material.Material;

import org.jetbrains.annotations.Nullable;

public class IngotProperty implements IMaterialProperty {

    /**
     * Specifies a material into which this material parts turn when heated
     */
    private Material smeltInto;

    /**
     * Specifies a material into which this material parts turn when heated in arc furnace
     */
    private Material arcSmeltInto;

    /**
     * Specifies a Material into which this Material Macerates into.
     * <p>
     * Default: this Material.
     */
    private Material macerateInto;

    /**
     * Material which obtained when this material is polarized
     */
    @Nullable
    private Material magneticMaterial;

    public IngotProperty setSmeltingInto(Material smeltInto) {
        this.smeltInto = smeltInto;
        return this;
    }

    public Material getSmeltingInto() {
        return this.smeltInto;
    }

    public IngotProperty setArcSmeltingInto(Material arcSmeltingInto) {
        this.arcSmeltInto = arcSmeltingInto;
        return this;
    }

    public Material getArcSmeltInto() {
        return this.arcSmeltInto;
    }

    public IngotProperty setMagneticMaterial(@Nullable Material magneticMaterial) {
        this.magneticMaterial = magneticMaterial;
        return this;
    }

    @Nullable
    public Material getMagneticMaterial() {
        return magneticMaterial;
    }

    public IngotProperty setMacerateInto(Material macerateInto) {
        this.macerateInto = macerateInto;
        return this;
    }

    public Material getMacerateInto() {
        return macerateInto;
    }

    @Override
    public void verifyProperty(MaterialProperties properties) {
        properties.ensureSet(PropertyKey.DUST, true);
        if (properties.hasProperty(PropertyKey.GEM)) {
            throw new IllegalStateException(
                    "Material " + properties.getMaterial() +
                            " has both Ingot and Gem Property, which is not allowed!");
        }

        if (smeltInto == null) smeltInto = properties.getMaterial();
        else smeltInto.getProperties().ensureSet(PropertyKey.INGOT, true);

        if (arcSmeltInto == null) arcSmeltInto = properties.getMaterial();
        else arcSmeltInto.getProperties().ensureSet(PropertyKey.INGOT, true);

        if (macerateInto == null) macerateInto = properties.getMaterial();
        else macerateInto.getProperties().ensureSet(PropertyKey.INGOT, true);

        if (magneticMaterial != null) magneticMaterial.getProperties().ensureSet(PropertyKey.INGOT, true);
    }
}
