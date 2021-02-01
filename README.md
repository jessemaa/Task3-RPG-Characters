# Role Playing Game Characters

This is a command line Java application from where the user can create an RPG-Character.
The character will have a class: Warrior, Hunter or Mage. Depending on the character class, it can use
either melee, ranged or magic weapons and wear plate, leather or cloth armor.
## Main specifications

- Create a hero as a class of Warrior, Hunter or Mage
    * Warriors wear plate gear and use melee weapons
    * Hunters wear leather gear and use ranged weapons
    * Mages wear cloth and use magic weapons
- Hero starts at level 1 and can be leveled by giving experience
    * Each level increases hero stats by certain amount, based on the class specifications
    * Each level increases the experience needed to level up again by 10%
- Create armor items for the hero to wear
    * Armor can be either plate, leather or cloth
    * Armor can be worn in either head, body or legs
    * Armor can be switched or replaced
    * Armor increases hero stats by the type of armor
- Create weapons for the hero to use
    * Weapons can be either melee, ranged or magic
    * Weapons have base damage, which increases by the weapon level
    * Weapons can be attacked with, but without one, the hero can't do damage

### Methods

The application has been created using classes, abstract classes and interfaces and is scalable for adding new hero classes, weapon types and armor types/slots.