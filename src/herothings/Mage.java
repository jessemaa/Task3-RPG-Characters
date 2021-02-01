package herothings;

public class Mage extends Hero {

    // Mage has stats which are affected by the class (mage)
    // This method is called when a levelup occurs and stats are updated
    @Override
    public void updateStats() {
        this.setHeroHealthPoints(this.getHeroHealthPoints() + 15);
        this.setHeroStrength(this.getHeroStrength() + 1);
        this.setHeroAgility(this.getHeroAgility() + 2);
        this.setHeroIntellect(this.getHeroIntellect() + 5);
        this.setHeroLevel(this.getHeroLevel() + 1);
        System.out.println("Your mage gained a level and your stats have been increased!");
    }
}