package herothings;
import itemthings.armorthings.Armor;
import itemthings.weaponthings.Weapon;
import java.util.HashMap;

// Create constructor for the general Hero abstract class (stats, exp, weapon and inventory)
public abstract class Hero {
    public String heroName;
    public int heroHealthPoints;
    public int heroStrength;
    public int heroAgility;
    public int heroIntellect;
    public int heroLevel;
    public int expNeededForLevel;
    public int gainedExp;
    public Weapon heroWeapon;
    HashMap<String, Armor> itemInventory = new HashMap<>();

    // Create getters and setters
    public String getHeroName() {

        return heroName;
    }

    public void setHeroName(String heroName) {

        this.heroName = heroName;
    }

    public int getHeroHealthPoints() {

        return heroHealthPoints;
    }

    public void setHeroHealthPoints(int heroHealthPoints) {

        this.heroHealthPoints = heroHealthPoints;
    }

    public int getHeroStrength() {

        return heroStrength;
    }

    public void setHeroStrength(int heroStrength) {

        this.heroStrength = heroStrength;
    }

    public int getHeroAgility() {

        return heroAgility;
    }

    public void setHeroAgility(int heroAgility) {

        this.heroAgility = heroAgility;
    }

    public int getHeroIntellect() {

        return heroIntellect;
    }

    public void setHeroIntellect(int heroIntellect) {

        this.heroIntellect = heroIntellect;
    }

    public int getHeroLevel() {

        return heroLevel;
    }

    public void setHeroLevel(int heroLevel) {

        this.heroLevel = heroLevel;
    }

    public int getExpNeededForLevel() {

        return expNeededForLevel;
    }

    public void setExpNeededForLevel(int expNeededForLevel) {

        this.expNeededForLevel = expNeededForLevel;
    }

    public int getGainedExp() {

        return gainedExp;
    }

    public void setGainedExp(int gainedExp) {

        this.gainedExp = gainedExp;
    }

    public Weapon getHeroWeapon() {

        return heroWeapon;
    }

    public void setHeroWeapon(Weapon heroWeapon) {

        this.heroWeapon = heroWeapon;
    }

    public HashMap<String, Armor> getItemInventory() {

        return itemInventory;
    }

    // Calculate gained experience - if gained exp and current exp are same or over needed exp, level up and pass the remaining over exp
    public void gainExperience(int exp){
        if (this.getGainedExp() + exp >= this.getExpNeededForLevel()) {
            this.levelUp(this.getGainedExp() + exp);
        } else {
            this.setGainedExp(this.getGainedExp() + exp);
        }
    }

    // Level up the hero - set new needed exp amount, update stats, increase new needed exp and check if gained exp is enough for another levelup
    public void levelUp(int exp){
        this.setGainedExp(exp - this.getExpNeededForLevel());
        this.updateStats();
        double newExpNeeded = this.getExpNeededForLevel() * 1.1;
        int intExp = (int) newExpNeeded;
        this.setExpNeededForLevel(intExp);
        if (this.getGainedExp() >= this.getExpNeededForLevel()) {
            this.levelUp(this.getGainedExp());
        }
    }

    // Update stats is abstract and depends on the hero's class (warriors, hunters and mages have different stat upgrades regarding the levelup)
    public abstract void updateStats();

    // Set the inventory to be "Head", "Body" and "Legs" - they are null at the start
    public void setInventory() {
        itemInventory.put("Head", null);
        itemInventory.put("Body", null);
        itemInventory.put("Legs", null);
    }

    // Equip armor to the hero - params are the actual armor item and slot is the actual armor slot it goes in to
    // if there is no armor then add it - if there is, replace it and the stats the item provides
    public void equipArmor(Armor item) {
        String armorSlot = item.getArmorSlot();
        if (itemInventory.get(armorSlot) != null) {
            unequipArmor(armorSlot);
        }
        item.setArmorToSlot(itemInventory, item);
        updateStats(item);
    }

    // Unequpping armor is used if there is already existing armor in given slot - calculate the stats accordingly (extract old ones and add new ones)
    public void unequipArmor(String slot){
        Armor usedArmor = itemInventory.get(slot);
        this.setHeroHealthPoints(this.getHeroHealthPoints() - usedArmor.getBonusHealth());
        this.setHeroStrength(this.getHeroStrength() - usedArmor.getBonusStrength());
        this.setHeroAgility(this.getHeroAgility() - usedArmor.getBonusAgility());
        this.setHeroIntellect(this.getHeroIntellect() - usedArmor.getBonusIntellect());
    }

    // Equipping a weapon is simpler, because there is only one slot for weapon and it doesn't give any stats, only damage which the weapon object holds itself
    public void equipWeapon(Weapon weapon) {

        this.setHeroWeapon(weapon);
    }

    // Update the stats according to the armor item equipped (just extracting and summing up base stats and bonus stats)
    public void updateStats(Armor item){
        this.setHeroHealthPoints(this.getHeroHealthPoints() + item.getBonusHealth());
        this.setHeroStrength(this.getHeroStrength() + item.getBonusStrength());
        this.setHeroAgility(this.getHeroAgility() + item.getBonusAgility());
        this.setHeroIntellect(this.getHeroIntellect() + item.getBonusIntellect());
    }

    // Attack - try if hero has a weapon "melee", "ranged" or "magic" - multiply the damage by 1.5, 2 or 3 times the stat which affects it
    // Also print cool line of battle cry
    // If there is no weapon equipped, just catch an error and print a notice
    public void attack() {
        try {
            if (this.getHeroWeapon().getType().equals("Melee")) {
                double damage = this.getHeroWeapon().getWeaponBaseDamage() + 1.5 * this.getHeroStrength();
                int intDamage = (int) damage;
                System.out.println("Slashing the enemy for " + intDamage +" melee damage. The enemy is bleeding! Time to execute!");
            } else if (this.getHeroWeapon().getType().equals("Ranged")) {
                double damage = this.getHeroWeapon().getWeaponBaseDamage() + 2 * this.getHeroAgility();
                System.out.println("Aiming carefully and hitting for " + damage + " ranged damage. The enemy took an arrow to the knee! Bad aim.");
            } else if (this.getHeroWeapon().getType().equals("Magic")) {
                double damage = this.getHeroWeapon().getWeaponBaseDamage() + 3 * this.getHeroIntellect();
                System.out.println("Casting a Greater Arcane Barrage for " + damage + " magic damage. The enemy is blinded by the magic. Strike now!");
            }
        } catch (NullPointerException ex) {
            System.out.println("Dang it. No damage dealt. You're gonna die..");
        }
    }
}
