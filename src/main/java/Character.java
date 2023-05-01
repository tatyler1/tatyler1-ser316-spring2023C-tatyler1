public class Character {
    private int health=100;
    private int level=1;
    int experience=0;
    private int protection=0;
    private int damage=0;
    private double speed=0.0;
    int pointsPerLevel=100;

    public void printInfo() {
        System.out.println("Class: " + this.getClass().toString());
        System.out.println("Level: " + level);
        System.out.println("Health: " + health);
        System.out.println("Experience: " + experience);
        System.out.println("Protection: " + protection);
        System.out.println("Damage: " + damage);
        System.out.println("Speed: " + speed);
        System.out.println("Points per Level: " + pointsPerLevel);
        System.out.println("\n");
    }

    public void setHealth(int health) {
        this.health = health;
    }

    public void setDamage(int damage) {
        this.damage = damage;
    }

    public void setExperience(int experience) {
        this.experience = experience;
    }

    public void setLevel(int level) {
        this.level = level;
    }

    public void setPointsPerLevel(int pointsPerLevel) {
        this.pointsPerLevel = pointsPerLevel;
    }

    public void setProtection(int protection) {
        this.protection = protection;
    }


    public void setSpeed(double speed) {
        this.speed = speed;
    }

    public double getSpeed() {
        return speed;
    }

    public int getDamage() {
        return damage;
    }

    public int getExperience() {
        return experience;
    }

    public int getHealth() {
        return health;
    }

    public int getLevel() {
        return level;
    }

    public int getPointsPerLevel() {
        return pointsPerLevel;
    }

    public int getProtection() {
        return protection;
    }
}