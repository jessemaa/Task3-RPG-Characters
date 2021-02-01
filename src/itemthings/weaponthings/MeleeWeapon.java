package itemthings.weaponthings;

public class MeleeWeapon implements WeaponType {

    // Melee weapons have a base damage which is 15, and its increased by 2 times the weapon level
    @Override
    public int countBaseDamage(int level) {
        int calculatedDamage = 15 + (2 * level);
        return calculatedDamage;
    }
}