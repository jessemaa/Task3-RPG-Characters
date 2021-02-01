package itemthings.armorthings;

import java.util.HashMap;

// An interface which tells how to store the bonus stats on armor
public interface ArmorType {
    HashMap countBonusStats(int level, String slot, int health, int strength, int agility, int intellect);
    void setArmorPieceToSlot(HashMap itemSlots, Armor armor);
}