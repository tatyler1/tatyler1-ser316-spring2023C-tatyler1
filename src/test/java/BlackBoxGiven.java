import org.junit.Test;
import org.junit.runner.RunWith;
import java.lang.reflect.Constructor;
import java.util.Arrays;
import java.util.Collection;
import org.junit.runners.Parameterized;

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

    /** dealDamage()
     * Boundry Value Analysis/ Equivalence Partition.
     * Health = 100
     * 5 Experience gained, Normal damage
     */
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
    /** takeDamage().
     * Equivalence Partition
     * 0 > BlowDamage > 100
     * Represenative: 5
     */
    public void takeDamageNormalExperience() {
        Wizard wiz = new Wizard();

        //Taking one hit
        game.takeDamage(wiz, 5);
        assertEquals(wiz.health, 96);
    }
    /** takeDamage().
     * Equivalence Partition / Boundry Value Analysis
     * BlowDamage > 100
     * Represenative: 101
     */

    @Test
    public void takeDamageOneLargeHit() {
        Wizard wiz = new Wizard();

        //Taking one large hit, health should be at 0
        game.takeDamage(wiz, 101);
        assertEquals(wiz.health, 0);
    }
    /** takeDamage().
     * Equivalence Partition / Boundry Value Analysis
     * BlowDamage < 0
     * Represenative: -1
     */

    @Test
    public void takeDamageNegative() {
        Wizard wiz = new Wizard();

        //Taking one negative hit
        game.takeDamage(wiz, -1);
        assertEquals(wiz.health, 101);
    }

    /** takeDamage().
     * Equivalence Partition / Boundry Value Analysis
     * BlowDamage == protection
     * Represenative: 1
     */

    @Test
    public void takeDamageEqualProtection() {
        Wizard wiz = new Wizard();

        //Taking one damage, equal to wizards protection
        game.takeDamage(wiz, wiz.protection);
        assertEquals(wiz.health, 100);
        assertEquals(wiz.experience, 0);
    }

    /** takeDamage().
     * Equivalence Partition / Boundry Value Analysis
     * BlowDamage == 0
     * Represenative: 0
     */

    @Test
    public void takeDamageNoDamage() {
        Wizard wiz = new Wizard();

        //No damage taken
        game.takeDamage(wiz, 0);
        assertEquals(wiz.health, 100);
    }

    /** takeDamage().
     * Boundry Value Analysis
     * BlowDamage = 2
     * 1 Health should be lost
     */

    @Test
    public void takeDamageTwoDamage() {
        Wizard wiz = new Wizard();

        game.takeDamage(wiz, 2);
        assertEquals(wiz.health, 99);
    }
    /** takeDamage().
     * Boundry Value Analysis
     * BlowDamage = 24
     * 23 Health should be lost
     */

    @Test
    public void takeDamage24Damage() {
        Wizard wiz = new Wizard();

        game.takeDamage(wiz, 24);
        assertEquals(wiz.health, 77);
    }

    /** takeDamage().
     * Boundry Value Analysis
     * BlowDamage = 10
     * 9 Health should be lost
     */

    @Test
    public void takeDamage10Damage() {
        Wizard wiz = new Wizard();

        game.takeDamage(wiz, 10);
        assertEquals(wiz.health, 91);
    }

    /** takeDamage().
     * Boundry Value Analysis
     * BlowDamage = 99
     * 98 Health should be lost
     */

    @Test
    public void takeDamage99Damage() {
        Wizard wiz = new Wizard();

        game.takeDamage(wiz, 99);
        assertEquals(wiz.health, 2);
    }
    /** takeDamage().
     * Boundry Value Analysis
     * BlowDamage = 100
     * 99 Health should be lost
     */

    @Test
    public void takeDamage100Damage() {
        Wizard wiz = new Wizard();

        game.takeDamage(wiz, 100);
        assertEquals(wiz.health, 1);
    }

    //dealdamage() Tests
    /** dealdamage().
     * Equivalence Partition
     * Wiz.health < 0
     * Representative : -5
     */

    @Test
    public void dealDamageNegativeHealth() {
        Wizard wiz = new Wizard();

        wiz.health = -5;
        game.dealDamage(wiz);
        assertEquals(wiz.experience, 0);
    }

    /** dealDamage()
     * Equivalence Partition/ Boundry Value Analysis
     * Wiz.health == 0
     * Representative : 0
     */

    @Test
    public void dealDamageNoHealth() {
        Wizard wiz = new Wizard();

        wiz.health = 0;
        game.dealDamage(wiz);
        assertEquals(wiz.experience, 0);
    }

    /** dealDamage()
     * Equivalence Partition
     * 0 >Wiz.health > 10
     * Representative : 6
     */

    @Test
    public void dealDamageDoubleDamage() {
        Wizard wiz = new Wizard();

        wiz.health = 6;
        assertEquals(game.dealDamage(wiz),10);
        assertEquals(wiz.experience, 5);
    }

    //dealdamage() Boundry Value Analysis
    /** dealdamage().
     * Boundry Value Analysis
     * Health = 1
     * 5 Experience gained, Double damage
     */

    @Test
    public void dealDamage1Health() {
        Wizard wiz = new Wizard();

        wiz.health = 1;
        assertEquals(game.dealDamage(wiz),10);
        assertEquals(wiz.experience, 5);
    }

    /** dealDamage().
     * Boundry Value Analysis
     * Health = 10
     * 5 Experience gained, Normal damage
     */

    @Test
    public void dealDamage10Health() {
        Wizard wiz = new Wizard();

        wiz.health = 10;
        assertEquals(game.dealDamage(wiz),5);
        assertEquals(wiz.experience, 5);
    }

    /** dealDamage().
     * Boundry Value Analysis
     * Health = 25
     * 5 Experience gained, Normal damage
     */

    @Test
    public void dealDamage25Health() {
        Wizard wiz = new Wizard();

        wiz.health = 25;
        int i = game.dealDamage(wiz);
        assertEquals(i,5);
        assertEquals(wiz.experience, 5);
    }

    /** dealDamage().
     * Boundry Value Analysis
     * Health = 50
     * 5 Experience gained, Normal damage
     */

    @Test
    public void dealDamage50Health() {
        Wizard wiz = new Wizard();

        wiz.health = 50;
        int i = game.dealDamage(wiz);
        assertEquals(i,5);
        assertEquals(wiz.experience, 5);
    }

    /** dealDamage().
     * Boundry Value Analysis
     * Health = 99
     * 5 Experience gained, Normal damage
     */

    @Test
    public void dealDamage99Health() {
        Wizard wiz = new Wizard();

        wiz.health = 99;
        int i = game.dealDamage(wiz);
        assertEquals(i,5);
        assertEquals(wiz.experience, 5);
    }

    //attack(wiz,bar) tests

    /** attack().
     * Equivalence Partition
     * Wiz.health < 0, bar.health < 0
     * -5, -5
     */

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

    /** attack()
     * Equivalence Partition/ Boundry Value Analysis
     * Wiz.health ==0, bar.health == 0
     * 0, 0
     */
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

    /** attack()
     * Equivalence Partition/ Boundry Value Analysis
     * Wiz.health > 0, bar.health > 0
     * 100, 100
     *
     */

    @Test
    public void attackNormalExperience() {
        Wizard wiz = new Wizard();
        Barbarian bar = new Barbarian();

        game.attack(wiz,bar);
        assertEquals(wiz.health,91);
        assertEquals(bar.health,102);
    }

    /** attack()
     * Equivalence Partition
     * 0 > Wiz.health > 10,  0 > bar.health > 10
     * 8,8
     */

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
    /** attack()
     * Equivalence Partition
     * Wiz.health < 0 , bar.health > 0
     * -5, 100
     */

    @Test
    public void attackOneNegative() {
        Wizard wiz = new Wizard();
        Barbarian bar = new Barbarian();

        wiz.health = -5;
        game.attack(wiz,bar);
        assertEquals(wiz.health,-5);
        assertEquals(bar.health,100);
    }

    /** attack()
     * Boundry Value Analysis
     * Wiz.health = 1 , bar.health = 1
     * wiz dies, bar one health
     */

    @Test
    public void attackOneHealth() {
        Wizard wiz = new Wizard();
        Barbarian bar = new Barbarian();

        wiz.health = 1;
        bar.health = 1;
        game.attack(wiz,bar);
        assertEquals(wiz.health,0);
        assertEquals(bar.health,1);
    }

    /** attack()
     * Boundry Value Analysis
     * Wiz.health = 50 , bar.health = 50
     * wiz 41 health, bar 52 health
     */

    @Test
    public void attack50Health() {
        Wizard wiz = new Wizard();
        Barbarian bar = new Barbarian();

        wiz.health = 50;
        bar.health = 50;
        game.attack(wiz,bar);
        assertEquals(wiz.health,41);
        assertEquals(bar.health,52);
    }

    /** attack()
     * Boundry Value Analysis
     * Wiz.health = 99 , bar.health = 99
     * wiz 90 health, bar 101 health
     */

    @Test
    public void attack99Health() {
        Wizard wiz = new Wizard();
        Barbarian bar = new Barbarian();

        wiz.health = 99;
        bar.health = 99;
        game.attack(wiz,bar);
        assertEquals(wiz.health,90);
        assertEquals(bar.health,101);
    }

}