package herothings;
import itemthings.armorthings.Armor;
import itemthings.weaponthings.Weapon;

public class PrintStats {
    // A simple method of printing the hero's stats
    public void printCharacterStats(Hero hero){
        System.out.println("\n"
                            + hero.getHeroName() + " character stats:"
                            + "\nHealth Points: " + hero.getHeroHealthPoints()
                            + "\nStrength: " + hero.getHeroStrength()
                            + "\nAgility: " + hero.getHeroAgility()
                            + "\nIntellect: " + hero.getHeroIntellect()
                            + "\nLevel: " + hero.getHeroLevel()
                            + "\nExperience needed for next level: " + (hero.getExpNeededForLevel() - hero.getGainedExp()));
    }

    // A simple method of printing the armor stats
    public void printArmorStats(Armor armor) {
        System.out.println("\n"
                            + armor.getNameOfArmor()
                            + "\nArmor slot: " + armor.getArmorSlot()
                            + "\nArmor type: " + armor.getTypeOfArmor()
                            + "\nBonus health: " + armor.getBonusHealth());
        // If there is no bonuses to strength, agility or intellect, then those are not added
        if (armor.getBonusStrength() != 0) { System.out.println("Bonus strength: " + armor.getBonusStrength()); }
        if (armor.getBonusAgility() != 0) { System.out.println("Bonus agility: " + armor.getBonusAgility()); }
        if (armor.getBonusIntellect() != 0) { System.out.println("Bonus intellect: " + armor.getBonusIntellect()); }
        System.out.println("Armor level: " + armor.getArmorLevel());
    }

    // A simple method of printing the weapon stats
    public void printWeaponStats(Weapon weapon) {
        System.out.println("\n"
                            + weapon.getWeaponName()
                            + "\nWeapon type: " + weapon.getType()
                            + "\nWeapon damage: " + weapon.getWeaponBaseDamage()
                            + "\nWeapon level: " + weapon.getWeaponLevel());
    }

}