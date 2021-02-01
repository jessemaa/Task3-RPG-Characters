package itemthings.armorthings;
import java.util.HashMap;

// Create a class for armor, which all have the following attributes
public class Armor {
    public ArmorType armorType;
    public String typeOfArmor;
    public String nameOfArmor;
    public String armorSlot;
    public int bonusHealth;
    public int bonusStrength;
    public int bonusAgility;
    public int bonusIntellect;
    public int armorLevel;

    // Create constructor for the general armor class (type, name, slot, stats and level)
    public Armor(String armorSlot, ArmorType armorType, int armorLevel, String nameOfArmor, String typeOfArmor) {
        this.armorSlot = armorSlot;
        this.armorType = armorType;
        this.armorLevel = armorLevel;
        this.nameOfArmor = nameOfArmor;
        this.typeOfArmor = typeOfArmor;
        this.bonusHealth = (int) countArmorStats().get("hp");
        this.bonusStrength = (int) countArmorStats().get("str");
        this.bonusAgility = (int) countArmorStats().get("agi");
        this.bonusIntellect = (int) countArmorStats().get("int");
    }

    // Create getters and setters
    public String getTypeOfArmor() {

        return typeOfArmor;
    }

    public String getNameOfArmor() {

        return nameOfArmor;
    }

    public int getArmorLevel() {

        return armorLevel;
    }

    public String getArmorSlot() {

        return armorSlot;
    }

    public int getBonusHealth() {

        return bonusHealth;
    }

    public int getBonusStrength() {

        return bonusStrength;
    }

    public int getBonusAgility() {

        return bonusAgility;
    }

    public int getBonusIntellect() {

        return bonusIntellect;
    }

    // Returns a hashmap for bonus stats affected by the armor level
    public HashMap countArmorStats() {
        return armorType.countBonusStats(this.getArmorLevel(),
                this.getArmorSlot(),
                this.getBonusHealth(),
                this.getBonusStrength(),
                this.getBonusAgility(),
                this.getBonusIntellect());
    }

    // Puts the armor item into a slot
    public void setArmorToSlot(HashMap itemSlots, Armor armor){

        armorType.setArmorPieceToSlot(itemSlots, armor);
    }
}