package battleShip;

import java.util.Scanner;

public class Player {

    Boards bds = new Boards();
    Scanner scn = new Scanner(System.in);

    public Player(){
        bds.initBoardB();
        bds.initBoardA();
    }

    public void playerSetUp(){

        System.out.println("Time to set up your ships!");
        bds.printBoardA();

        System.out.println("First: Aircraft Carrier of size 5");
        System.out.println("What direction do you wanna place it in?");
        System.out.println("Up - u");
        System.out.println("Down - d");
        System.out.println("Left - l");
        System.out.println("Right - r");

        char dir = scn.next().charAt(0);

        System.out.println("Now decide the coordinates for it!");
        int X = scn.nextInt();
        int Y = scn.nextInt();

        Coordinate c = new Coordinate(X,Y);

        Ship aircraftCarrier = new Ship('A',dir,c);
        while(!bds.validLocation(c, aircraftCarrier)){
            System.out.println("Please enter a valid location!");
            int newX = scn.nextInt();
            int newY = scn.nextInt();
            c=new Coordinate(newX,newY);
        }

        bds.placeShips(c,aircraftCarrier);
        bds.printBoardA();

        System.out.println("Second: Battleship of size 4");
        System.out.println("What direction do you wanna place it in?");
        System.out.println("Up - u");
        System.out.println("Down - d");
        System.out.println("Left - l");
        System.out.println("Right - r");

        dir = scn.next().charAt(0);

        System.out.println("Now decide the coordinates for it!");
        X = scn.nextInt();
        Y = scn.nextInt();

        c = new Coordinate(X,Y);

        Ship battleship = new Ship('B',dir,c);
        while(!bds.validLocation(c, battleship)){
            System.out.println("Please enter a valid location!");
            int newX = scn.nextInt();
            int newY = scn.nextInt();
            c=new Coordinate(newX,newY);
        }

        bds.placeShips(c,battleship);
        bds.printBoardA();

        System.out.println("Third: Submarine of size 3");
        System.out.println("What direction do you wanna place it in?");
        System.out.println("Up - u");
        System.out.println("Down - d");
        System.out.println("Left - l");
        System.out.println("Right - r");

        dir = scn.next().charAt(0);

        System.out.println("Now decide the coordinates for it!");
        X = scn.nextInt();
        Y = scn.nextInt();

        c = new Coordinate(X,Y);

        Ship submarine = new Ship('S',dir,c);
        while(!bds.validLocation(c, submarine)){
            System.out.println("Please enter a valid location!");
            int newX = scn.nextInt();
            int newY = scn.nextInt();
            c=new Coordinate(newX,newY);
        }

        bds.placeShips(c,submarine);
        bds.printBoardA();

        System.out.println("Forth: Destroyer of size 3");
        System.out.println("What direction do you wanna place it in?");
        System.out.println("Up - u");
        System.out.println("Down - d");
        System.out.println("Left - l");
        System.out.println("Right - r");

        dir = scn.next().charAt(0);

        System.out.println("Now decide the coordinates for it!");
        X = scn.nextInt();
        Y = scn.nextInt();

        c = new Coordinate(X,Y);

        Ship destroyer = new Ship('D',dir,c);
        while(!bds.validLocation(c, destroyer)){
            System.out.println("Please enter a valid location!");
            int newX = scn.nextInt();
            int newY = scn.nextInt();
            c=new Coordinate(newX,newY);
        }

        bds.placeShips(c,destroyer);
        bds.printBoardA();

        System.out.println("Last one: Patrol Boat of size 2");
        System.out.println("What direction do you wanna place it in?");
        System.out.println("Up - u");
        System.out.println("Down - d");
        System.out.println("Left - l");
        System.out.println("Right - r");

        dir = scn.next().charAt(0);

        System.out.println("Now decide the coordinates for it!");
        X = scn.nextInt();
        Y = scn.nextInt();

        c = new Coordinate(X,Y);

        Ship patrolBoat = new Ship('P',dir,c);
        while(!bds.validLocation(c, patrolBoat)){
            System.out.println("Please enter a valid location!");
            int newX = scn.nextInt();
            int newY = scn.nextInt();
            c=new Coordinate(newX,newY);
        }

        bds.placeShips(c,patrolBoat);
        bds.printBoardA();

        System.out.println("You have set up your board!");
    }

    public Coordinate playerAttack(){
        System.out.println("Enter the coordinate of your attack!");
        int attackX = scn.nextInt();
        int attackY = scn.nextInt();

        Coordinate attack = new Coordinate(attackX,attackY);

        while(!bds.validAttack(attack)){

            System.out.println("Please enter a valid coordinate for the attack!");
            int newAttackX = scn.nextInt();
            int newAttackY = scn.nextInt();

            attack = new Coordinate(newAttackX,newAttackY);

        }
        return attack;
    }

    public void attackComputer(Computer comp,Coordinate attack){
        bds.printResult(bds.hitMissComputer(attack,comp));
    }

    public void printBoard(char[][] board){
        for(int i = 0; i < board.length; i++){
            for(int j=0; j<board[0].length;j++){
                System.out.print(board[i][j] + "   ");
            }
            System.out.println();
        }
    }

    public boolean verifyPlayerWinning(Computer comp){
        for(int i = 1; i < comp.getBoardA().length; i++){
            for(int j = 1; j<comp.getBoardA()[0].length;j++){
                if(comp.getBoardA()[i][j] != '.' && bds.getBoardB()[i][j] != 'H'){
                    return false;
                }
            }
        }
        return true;
    }

    public char[][] getBoardA(){
        return bds.getBoardA();
    }

    public char[][] getBoardB(){
        return bds.getBoardB();
    }

}