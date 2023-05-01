public class Wizard extends Character {

    public Wizard() {
        protection = 1;
        damage = 5;
        speed = 5.0;
        pointsPerLevel = 10;
    }
    public void levelUp() {
        this.damage += 5;
        this.speed += 1;
        this.protection += 1;
    }

}