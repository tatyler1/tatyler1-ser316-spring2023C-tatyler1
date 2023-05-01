public class Barbarian extends Character {

    public Barbarian() {
        protection = 10;
        damage = 10;
        speed = 2.0;
        pointsPerLevel = 20;
    }

    public void levelUp() {
        this.damage += this.damage/2;
        this.speed += 0.5;
        this.protection += this.protection/2;
    }

}