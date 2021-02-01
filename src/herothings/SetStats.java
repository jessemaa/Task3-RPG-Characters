package herothings;

public class SetStats {

    // A method that sets the base stats for the hero - level, exp needed to level up, gained exp and inventory are same for every hero
    // Only the name, healthpoints, strength, agility and intellect are dependant on the hero class
    public void setHeroStats(Hero hero, String name, int health, int strength, int agility, int intellect){
        hero.setHeroName(name);
        hero.setHeroHealthPoints(health);
        hero.setHeroStrength(strength);
        hero.setHeroAgility(agility);
        hero.setHeroIntellect(intellect);
        hero.setHeroLevel(1);
        hero.setExpNeededForLevel(100);
        hero.setGainedExp(0);
        hero.setInventory();
    }
}