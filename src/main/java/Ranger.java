public class Ranger extends Character {

    public Ranger() {
        protection = 8;
        damage = 8;
        speed = 2.5;
        pointsPerLevel = 15;
    }

    public void levelUp() {
        this.damage += this.damage%10;
        this.speed += 0.5;
        this.protection += this.protection%5;
    }

}