public class Druid extends Character {

    public Druid() {
        protection = 4;
        damage = 7;
        speed = 3.0;
        pointsPerLevel = 15;
    }
    public void levelUp() {
        this.damage += 10;
        this.speed += 0.25;
        this.protection += 2;
    }

}