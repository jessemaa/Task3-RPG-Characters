package itemthings.armorthings;

import java.util.HashMap;

public class LeatherArmor implements ArmorType {

    // Counting the bonus stats for leather armor
    @Override
    public HashMap countBonusStats(int level, String slot, int health, int str, int agility, int intellect) {
        HashMap<String, Integer> stats = new HashMap<>();

        // Based on the item type (head, legs or body) the stats are going to be decreased
        double itemTypeScaling = 1;

        if (slot.equals("Head")) {
            itemTypeScaling = 0.8;

        } else if (slot.equals("Legs")) {
            itemTypeScaling = 0.6;
        }

        // Calculate the correct amount of stats and return stats as a map
        // Leather armor has only hp, str and agi
        double healthPoints = ((health + 20) + level * 8) / itemTypeScaling;
        int intHealth = (int) healthPoints;
        stats.put("hp", intHealth);

        double strength = ((str + 1) + level * 1) / itemTypeScaling;
        int intStrength = (int) strength;
        stats.put("str", intStrength);

        double agi = ((agility + 3) + level * 2) / itemTypeScaling;
        int agilityInt = (int) agi;
        stats.put("agi", agilityInt);

        stats.put("int", 0);

        return stats;
    }

    @Override
    public void setArmorPieceToSlot(HashMap itemSlots, Armor armor) {
        String slot = armor.getArmorSlot();
        itemSlots.put(slot, armor);
    }
}