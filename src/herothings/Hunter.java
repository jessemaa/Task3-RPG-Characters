package herothings;

public class Hunter extends Hero {

    // Hunter has stats which are affected by the class (hunter)
    // This method is called when a levelup occurs and stats are updated
    @Override
    public void updateStats() {
        this.setHeroHealthPoints(this.getHeroHealthPoints() + 20);
        this.setHeroStrength(this.getHeroStrength() + 2);
        this.setHeroAgility(this.getHeroAgility() + 5);
        this.setHeroIntellect(this.getHeroIntellect() + 1);
        this.setHeroLevel(this.getHeroLevel() + 1);
        System.out.println("Your hunter gained a level and your stats have been increased!");
    }
}