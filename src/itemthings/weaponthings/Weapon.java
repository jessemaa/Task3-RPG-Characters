package itemthings.weaponthings;

// Create a class for weapons, which all have the following attributes
public class Weapon {
    public String weaponName;
    public int weaponBaseDamage;
    public int weaponLevel;
    public WeaponType weaponType;
    public String type;

    // Create constructor for the general weapon class (name, level, type and damage)
    public Weapon(String weaponName, int weaponLevel, WeaponType weaponType, String type) {
        this.weaponName = weaponName;
        this.weaponLevel = weaponLevel;
        this.weaponType = weaponType;
        this.type = type;
        this.weaponBaseDamage = countBaseDamage();
    }

    // Create getters and setters
    public String getWeaponName() {

        return weaponName;
    }

    public int getWeaponBaseDamage() {

        return weaponBaseDamage;
    }

    public int getWeaponLevel() {

        return weaponLevel;
    }

    public String getType() {

        return type;
    }

    public int countBaseDamage() {

        return weaponType.countBaseDamage(this.getWeaponLevel());
    }
}