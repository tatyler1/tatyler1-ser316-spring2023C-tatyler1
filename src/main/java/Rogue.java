public class Rogue extends Character {

    public Rogue() {
        protection = 6;
        damage = 5;
        speed = 3.5;
        pointsPerLevel = 20;
    }

    public void levelUp() {
        this.damage += this.damage/3;
        this.speed += 1.25;
        this.protection += 3;
    }

}