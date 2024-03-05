package battleShip;

import java.sql.SQLOutput;

public class Main {
    public static void main(String[] args) {

        Player p = new Player();
        Computer c = new Computer();

        System.out.println("Welcome to BattleShip!");
        p.playerSetUp();
        c.compSetUp();

        while(!p.verifyPlayerWinning(c)&&!c.verifyCompWinning(p)){

            Coordinate attackOnComputer = p.playerAttack();
            p.attackComputer(c, attackOnComputer);

            Coordinate attackOnPlayer = c.getPredictedCoordinate(p);
            c.attackPlayer(p, attackOnPlayer);

            System.out.println("Your board A:");
            p.printBoard(p.getBoardA());

            System.out.println("Computer's board B:");
            p.printBoard(p.getBoardB());

        }

        if(p.verifyPlayerWinning(c)){
            System.out.println("GAME OVER! YOU WON!");
        } else if(c.verifyCompWinning(p)){
            System.out.println("GAME OVER! YOU LOST!");
        }

    }
}