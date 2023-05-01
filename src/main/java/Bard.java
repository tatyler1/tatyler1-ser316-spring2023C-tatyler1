public class Bard extends Character {

    public Bard() {
        protection = 3;
        damage = 6;
        speed = 4.5;
        pointsPerLevel = 10;
    }
    public void levelUp() {
        this.damage += 10;
        this.speed += 0.25;
        this.protection +=2;
    }

}