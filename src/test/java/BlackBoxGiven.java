import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;

import java.lang.reflect.Constructor;
import java.util.Arrays;
import java.util.Collection;

import static org.junit.Assert.*;

@RunWith(Parameterized.class)
public class BlackBoxGiven {

    private Class<GamePlay> classUnderTest;

    @SuppressWarnings("unchecked")
    public BlackBoxGiven(Object classUnderTest) {
        this.classUnderTest = (Class<GamePlay>) classUnderTest;
    }

    // Define all classes to be tested
    @Parameterized.Parameters
    public static Collection<Object[]> cartClassUnderTest() {
        Object[][] classes = {
            {GamePlay1.class},
            {GamePlay2.class},
            {GamePlay3.class},
            {GamePlay4.class},
            {GamePlay5.class}
        };
        return Arrays.asList(classes);
    }

    private GamePlay createGame() throws Exception {
        Constructor<GamePlay> constructor = classUnderTest.getConstructor();
        return constructor.newInstance();
    }

    GamePlay game;

    @org.junit.Before
    public void setUp() throws Exception {
        game = createGame();
    }


    // normal experience when healthy
    @Test
    public void dealtDamageNormalExperience() {
        Wizard wiz = new Wizard();
        Barbarian bar = new Barbarian();
        Bard bard = new Bard();
        Druid dru = new Druid();
        Ranger ran = new Ranger();
        Rogue ro = new Rogue();
        
        game.dealDamage(wiz);
        assertEquals(wiz.experience, 5);

        game.dealDamage(bar);
        assertEquals(bar.experience, 10);

        game.dealDamage(bard);
        assertEquals(bard.experience, 6);

        game.dealDamage(dru);
        assertEquals(dru.experience, 7);

        game.dealDamage(ran);
        assertEquals(ran.experience, 8);

        game.dealDamage(ro);
        assertEquals(ro.experience, 5);
    }


    //Tests for takeDamage
    @Test
    //Equivalence Partition
    public void takeDamageNormalExperience() {
        Wizard wiz = new Wizard();

        //Taking one hit
        game.takeDamage(wiz, 5);
        assertEquals(wiz.health, 96);
    }
    @Test
    public void takeDamageOneLargeHit() {
        Wizard wiz = new Wizard();

        //Taking one large hit, health should be at 0
        game.takeDamage(wiz, 101);
        assertEquals(wiz.health, 0);
    }

    @Test
    public void takeDamageNegative() {
        Wizard wiz = new Wizard();

        //Taking one negative hit
        game.takeDamage(wiz, -1);
        assertEquals(wiz.health, 101);
    }

    @Test
    public void takeDamageEqualProtection() {
        Wizard wiz = new Wizard();

        //Taking one damage, equal to wizards protection
        game.takeDamage(wiz, wiz.protection);
        assertEquals(wiz.health, 100);
        assertEquals(wiz.experience, 0);
    }
    @Test
    public void takeDamageNoDamage() {
        Wizard wiz = new Wizard();

        //No damage taken
        game.takeDamage(wiz, 0);
        assertEquals(wiz.health, 100);
    }
    //Boundry Value Analysis for takeDamage()
    @Test
    public void takeDamageNegativeDamage() {
        Wizard wiz = new Wizard();

        game.takeDamage(wiz, -1);
        assertEquals(wiz.health, 101);
    }
    @Test
    public void takeDamageTwoDamage() {
        Wizard wiz = new Wizard();

        game.takeDamage(wiz, 2);
        assertEquals(wiz.health, 99);
    }
    @Test
    public void takeDamage24Damage() {
        Wizard wiz = new Wizard();

        game.takeDamage(wiz, 24);
        assertEquals(wiz.health, 77);
    }
    @Test
    public void takeDamage10Damage() {
        Wizard wiz = new Wizard();

        game.takeDamage(wiz, 10);
        assertEquals(wiz.health, 91);
    }
    @Test
    public void takeDamage99Damage() {
        Wizard wiz = new Wizard();

        game.takeDamage(wiz, 99);
        assertEquals(wiz.health, 2);
    }
    @Test
    public void takeDamage100Damage() {
        Wizard wiz = new Wizard();

        game.takeDamage(wiz, 100);
        assertEquals(wiz.health, 1);
    }



    //dealdamage() Tests
    @Test
    public void dealDamageNegativeHealth() {
        Wizard wiz = new Wizard();

        wiz.health = -5;
        game.dealDamage(wiz);
        assertEquals(wiz.experience, 0);
    }
    @Test
    public void dealDamageNoHealth() {
        Wizard wiz = new Wizard();

        wiz.health = 0;
        game.dealDamage(wiz);
        assertEquals(wiz.experience, 0);
    }
    @Test
    public void dealDamageDoubleDamage() {
        Wizard wiz = new Wizard();

        wiz.health = 6;
        assertEquals(game.dealDamage(wiz),10);
        assertEquals(wiz.experience, 5);
    }
    //dealdamage() Boundry Value Analysis
    @Test
    public void dealDamage1Health() {
        Wizard wiz = new Wizard();

        wiz.health = 1;
        assertEquals(game.dealDamage(wiz),10);
        assertEquals(wiz.experience, 5);
    }
    @Test
    public void dealDamage10Health() {
        Wizard wiz = new Wizard();

        wiz.health = 10;
        assertEquals(game.dealDamage(wiz),5);
        assertEquals(wiz.experience, 5);
    }
    @Test
    public void dealDamage25Health() {
        Wizard wiz = new Wizard();

        wiz.health = 25;
        int i = game.dealDamage(wiz);
        assertEquals(i,5);
        assertEquals(wiz.experience, 5);
    }
    @Test
    public void dealDamage50Health() {
        Wizard wiz = new Wizard();

        wiz.health = 50;
        int i = game.dealDamage(wiz);
        assertEquals(i,5);
        assertEquals(wiz.experience, 5);
    }
    @Test
    public void dealDamage99Health() {
        Wizard wiz = new Wizard();

        wiz.health = 99;
        int i = game.dealDamage(wiz);
        assertEquals(i,5);
        assertEquals(wiz.experience, 5);
    }

    //attack(wiz,bar) tests
    @Test
    public void attackNegativeHealth() {
        Wizard wiz = new Wizard();
        Barbarian bar = new Barbarian();

        wiz.health = -5;
        bar.health = -5;

        game.attack(wiz,bar);
        assertEquals(wiz.health,-5);
        assertEquals(bar.health,-5);
    }
    @Test
    public void attackBothZero() {
        Wizard wiz = new Wizard();
        Barbarian bar = new Barbarian();

        wiz.health = 0;
        bar.health = 0;

        game.attack(wiz,bar);
        assertEquals(wiz.health,0);
        assertEquals(bar.health,0);
    }
    @Test
    public void attackNormalExperience() {
        Wizard wiz = new Wizard();
        Barbarian bar = new Barbarian();

        game.attack(wiz,bar);
        assertEquals(wiz.health,91);
        assertEquals(bar.health,102);
    }
    @Test
    public void attackDoubleDamage() {
        Wizard wiz = new Wizard();
        Barbarian bar = new Barbarian();

        wiz.health = 8;
        bar.health = 8;
        game.attack(wiz,bar);
        assertEquals(wiz.health,0);
        assertEquals(bar.health,8);
    }
    @Test
    public void attackOneNegative() {
        Wizard wiz = new Wizard();
        Barbarian bar = new Barbarian();

        wiz.health = -5;
        game.attack(wiz,bar);
        assertEquals(wiz.health,-5);
        assertEquals(bar.health,100);
    }
}