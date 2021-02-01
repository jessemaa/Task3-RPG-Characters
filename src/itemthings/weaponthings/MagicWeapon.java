package itemthings.weaponthings;

public class MagicWeapon implements WeaponType {

    // Magic weapons have a base damage which is 25, and its increased by 2 times the weapon level
    @Override
    public int countBaseDamage(int level) {
        int calculatedDamage = 25 + (2 * level);
        return calculatedDamage;
    }
}