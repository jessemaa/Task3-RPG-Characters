package itemthings.armorthings;

import java.util.HashMap;

public class ClothArmor implements ArmorType{

    // Counting the bonus stats for cloth armor
    @Override
    public HashMap countBonusStats(int level, String slot, int health, int strength, int agility, int intellect) {
        HashMap<String, Integer> stats = new HashMap<>();

        // Based on the item type (head, legs or body) the stats are going to be decreased
        double itemTypeScaling = 1;

        if (slot.equals("Head")) {
            itemTypeScaling = 0.8;

        } else if (slot.equals("Legs")) {
            itemTypeScaling = 0.6;
        }

        // Calculate the correct amount of stats and return stats as a map
        // Cloth armor has only hp, int and agi
        double healthPoints = ((health + 10) + level * 5) / itemTypeScaling;
        int intHealth = (int) healthPoints;
        stats.put("hp", intHealth);

        stats.put("str", 0);

        double agi = ((agility + 1) + level * 1) / itemTypeScaling;
        int agilityInt = (int) agi;
        stats.put("agi", agilityInt);

        double intelligence = ((intellect + 3) + level * 2) / itemTypeScaling;
        int intIntelligence = (int) intelligence;
        stats.put("int", intIntelligence);

        return stats;
    }


    @Override
    public void setArmorPieceToSlot(HashMap itemSlots, Armor armor) {
        String slot = armor.getArmorSlot();
        itemSlots.put(slot, armor);
    }
}