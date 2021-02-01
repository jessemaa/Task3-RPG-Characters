package itemthings.weaponthings;

public class RangedWeapon implements WeaponType {

    // Ranged weapons have a base damage which is 5, and its increased by 3 times the weapon level
    @Override
    public int countBaseDamage(int level) {
        int calculatedDamage = 5 + (3 * level);
        return calculatedDamage;
    }
}