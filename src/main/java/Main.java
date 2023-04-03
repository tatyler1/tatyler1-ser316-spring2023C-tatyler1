public class Main {
    
    public static void main(String[] args) {

        System.out.println("**** GAME A ****");
        GamePlay GamePlay = new GamePlay();
        for (int round = 1; round < 9; round++) {
            System.out.println("\tRound " + round);
            if (GamePlay.player.getHealth() > 0)
                System.out.println("\t\tYou gained " + GamePlay.play() + " experience points during this round!!!!\n");
            if (GamePlay.player.getHealth() <= 0) {
                System.out.println("\t\tBut your player died. Better luck next time.\n\n");
                break;
            }
        }

        System.out.println("**** GAME B ****");
        GamePlay gamePlay1 = new GamePlay(new Wizard());
        gamePlay1.player.setHealth(10);
        for (int round = 1; round < 9; round++) {
            System.out.println("\tRound " + round);
            if (gamePlay1.player.getHealth() > 0)
                System.out.println("\t\tYou gained " + gamePlay1.play() + " experience points during this round!!!!\n");
            if (gamePlay1.player.getHealth() <= 0) {
                System.out.println("\t\tBut your player died. Better luck next time.\n\n");
                break;
            }
        }

        System.out.println("**** GAME C ****");
        GamePlay gamePlay2 = new GamePlay(new Barbarian(), new Wizard());
        gamePlay2.Opponents.get(0).setHealth(5);
        for (int round = 1; round < 9; round++) {
            System.out.println("\tRound " + round);
            if (gamePlay2.player.getHealth() > 0)
                System.out.println("\t\tYou gained " + gamePlay2.play() + " experience points during this round!!!!\n");
            if (gamePlay2.player.getHealth() <= 0) {
                System.out.println("\t\tBut your player died. Better luck next time.\n\n");
                break;
            }
        }

    }
    
}