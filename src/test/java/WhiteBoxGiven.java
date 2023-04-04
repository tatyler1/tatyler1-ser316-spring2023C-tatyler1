import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;

public class WhiteBoxGiven {


    @Before
    public void setUp() throws Exception {
    }

    @After
    public void tearDown() throws Exception {
    }

    // simple attack test with test of experience after attack
    @Test
    public void equalDP() {
        Character wiz1 = new Wizard();
        Character wiz2 = new Wizard();

        GamePlay game = new GamePlay(wiz1, wiz2);
        game.attack(wiz1, wiz2);

        assertEquals(wiz1.experience, 7);
        assertEquals(wiz2.experience, 7);
    }
    @Test
    public void emptyGameplayArray() {
        GamePlay game = new GamePlay(new Barbarian(), null);
        int i = 0;
        for(Character opponent : game.Opponents) {
            System.out.println(opponent);
            i++;
        }
        assertEquals(1,i);
    }
    //Play should not calculate experience since it is already done in attack()
    @Test
    public void playSpeedEquals0() {
        Character wiz1 = new Wizard();
        Character wiz2 = new Wizard();
        wiz1.speed = 0;
        wiz2.speed = 0;

        GamePlay game = new GamePlay(wiz1,wiz2);

        game.play();

        assertEquals(7,wiz1.experience);

    }

    @Test
    public void opponentDead() {
        Character wiz1 = new Wizard();
        Character wiz2 = new Wizard();
        wiz2.health = 0;

        GamePlay game = new GamePlay(wiz1,wiz2);
        game.play();
        assertEquals(game.Opponents.size(), 0);
    }
    @Test
    public void opponentVeryDead() {
        Character wiz1 = new Wizard();
        Character wiz2 = new Wizard();
        wiz2.health = -100;

        GamePlay game = new GamePlay(wiz1,wiz2);
        game.play();
        assertEquals(game.Opponents.size(), 0);
    }

}