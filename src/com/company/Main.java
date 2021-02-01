package com.company;
import itemthings.armorthings.*;
import herothings.*;
import itemthings.weaponthings.*;

public class Main {
    public static void main(String[] args) {
        // Initialize the setStats and printStats to be used later in main
        SetStats setStats = new SetStats();
        PrintStats printStats = new PrintStats();

        // Create some armorpieces
        Armor breastPlateOfMight = new Armor("Body", new PlateArmor(), 2, "Breastplate of Might", "Plate");
        Armor giantStalkersLeggings = new Armor("Legs", new LeatherArmor(), 1, "Giantstalker's Leggings", "Leather");
        Armor arcanistCrown = new Armor("Head", new ClothArmor(), 3, "Arcanist Crown", "Cloth");

        // Create some legendary weapons
        Weapon sulfuras = new Weapon( "Sulfuras, Hand of Ragnaros", 2, new MeleeWeapon(), "Melee");
        Weapon rhokdelar = new Weapon("Rhok'delar, Longbow of the Ancient Keepers", 3, new RangedWeapon(), "Ranged");
        Weapon atiesh = new Weapon("Atiesh, Greatstaff of the Guardian", 3, new MagicWeapon(), "Magic");

        // Initiate Tauren warchief, Cairne Bloodhoof as Warrior
        Hero hordeWarrior = new Warrior();
        setStats.setHeroStats(hordeWarrior, "Cairne Bloodhoof (Warrior)", 150, 10, 3, 1);

        // Initiate long lost Alliance hunter, Alleria Windrunner as a Hunter
        Hero allianceHunter = new Hunter();
        setStats.setHeroStats(allianceHunter, "Alleria Windrunner (Hunter)", 120, 5,10, 2);

        // Initiate the second strongest mage in Azeroth, Jaina Proudmoore as Mage
        Hero allianceMage = new Mage();
        setStats.setHeroStats(allianceMage, "Jaina Proudmoore (Mage)", 100, 2, 3, 10);

        // Create a Warrior, Hunter and a Mage and print their stats + recommended items / their stats
        System.out.println("\nCreated a character: Warrior");
        printStats.printCharacterStats(hordeWarrior);
        System.out.println("\nWarrior's recommended items are:");
        printStats.printArmorStats(breastPlateOfMight);
        printStats.printWeaponStats(sulfuras);

        System.out.println("\nCreated a character: Hunter");
        printStats.printCharacterStats(allianceHunter);
        System.out.println("\nRanger's recommended items are:");
        printStats.printArmorStats(giantStalkersLeggings);
        printStats.printWeaponStats(rhokdelar);

        System.out.println("\nCreated a character: Mage");
        printStats.printCharacterStats(allianceMage);
        System.out.println("\nMage's recommended items are:");
        printStats.printArmorStats(arcanistCrown);
        printStats.printWeaponStats(atiesh);

        // Equip recommended armor and weapon to the Mage (Jaina Proudmoore)
        System.out.println("\nJaina Proudmoore equipped the " + arcanistCrown.getNameOfArmor() + "!");
        allianceMage.equipArmor(arcanistCrown);
        System.out.println("\nJaina Proudmoore equipped " + atiesh.getWeaponName() + "!");
        allianceMage.equipWeapon(atiesh);
        System.out.println("\nJaina's stats have been increased with new gear!");
        printStats.printCharacterStats(allianceMage);

        // Demonstrate experience gain and leveling + stats increase
        System.out.println("\nJaina was given 25 experience points!");
        allianceMage.gainExperience(25);
        System.out.println("\nJaina was given 666 experience points!");
        allianceMage.gainExperience(666);
        System.out.println("\nWith new levels, Jaina gained significant increases to her stats!");
        printStats.printCharacterStats(allianceMage);

        // Demonstrate attacking which scales with level, stats and weapon accordingly
        System.out.println("\nJaina sees threat that must be eliminated!");
        allianceMage.attack();
    }
}