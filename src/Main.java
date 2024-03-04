// Enum WeaponType
enum WeaponType {
    SWORD,
    AXE,
    BOW
}

// Класс Weapon
class Weapon {
    private WeaponType weaponType;
    private String weaponName;

    public Weapon(WeaponType weaponType, String weaponName) {
        this.weaponType = weaponType;
        this.weaponName = weaponName;
    }

    public WeaponType getWeaponType() {
        return weaponType;
    }

    public void setWeaponType(WeaponType weaponType) {
        this.weaponType = weaponType;
    }

    public String getWeaponName() {
        return weaponName;
    }

    public void setWeaponName(String weaponName) {
        this.weaponName = weaponName;
    }
}

// Класс GameEntity
class GameEntity {
    private String name;
    private int health;

    public GameEntity(String name, int health) {
        this.name = name;
        this.health = health;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getHealth() {
        return health;
    }

    public void setHealth(int health) {
        this.health = health;
    }
}

// Класс Boss
class Boss extends GameEntity {
    private Weapon weapon;

    public Boss(String name, int health, Weapon weapon) {
        super(name, health);
        this.weapon = weapon;
    }

    public Weapon getWeapon() {
        return weapon;
    }

    public void setWeapon(Weapon weapon) {
        this.weapon = weapon;
    }

    public String printInfo() {
        return "Boss: " + getName() + ", Health: " + getHealth() + ", Weapon: " +
                weapon.getWeaponType() + " - " + weapon.getWeaponName();
    }
}

// Класс Skeleton
class Skeleton extends Boss {
    private int arrows;

    public Skeleton(String name, int health, Weapon weapon, int arrows) {
        super(name, health, weapon);
        this.arrows = arrows;
    }

    public int getArrows() {
        return arrows;
    }

    public void setArrows(int arrows) {
        this.arrows = arrows;
    }

    @Override
    public String printInfo() {
        return "Skeleton: " + getName() + ", Health: " + getHealth() +
                ", Weapon: " + getWeapon().getWeaponType() + " - " + getWeapon().getWeaponName() +
                ", Arrows: " + arrows;
    }
}

// Класс Main
public class Main {
    public static void main(String[] args) {
        Weapon bossWeapon = new Weapon(WeaponType.SWORD, "Sword of Power");
        Boss boss = new Boss("Evil Boss", 1000, bossWeapon);
        System.out.println(boss.printInfo());

        Weapon skeletonWeapon1 = new Weapon(WeaponType.AXE, "Axe of Doom");
        Skeleton skeleton1 = new Skeleton("Skeleton 1", 200, skeletonWeapon1, 50);

        Weapon skeletonWeapon2 = new Weapon(WeaponType.BOW, "Bow of Shadows");
        Skeleton skeleton2 = new Skeleton("Skeleton 2", 150, skeletonWeapon2, 30);

        System.out.println(skeleton1.printInfo());
    }
}