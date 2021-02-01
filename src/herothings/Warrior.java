package herothings;

public class Warrior extends Hero {

    // Warrior has stats which are affected by the class (warrior)
    // This method is called when a levelup occurs and stats are updated
    @Override
    public void updateStats() {
        this.setHeroHealthPoints(this.getHeroHealthPoints() + 30);
        this.setHeroStrength(this.getHeroStrength() + 5);
        this.setHeroAgility(this.getHeroAgility() + 2);
        this.setHeroIntellect(this.getHeroIntellect() + 1);
        this.setHeroLevel(this.getHeroLevel() + 1);
        System.out.println("Your warrior gained a level and your stats have been increased!");
    }
}