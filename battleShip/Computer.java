package battleShip;
import java.util.ArrayList;

public class Computer {

    Boards bds = new Boards();
    ArrayList<Coordinate> coord = new ArrayList<Coordinate>();
    ArrayList<Coordinate> choose = new ArrayList<Coordinate>();

    public Computer(){
        bds.initBoardA();
        bds.initBoardB();
    }

    public void compSetUp(){
        char direction = randomDirection();
        Coordinate c = randomCoordinate();
        Ship aircraftCarrier = new Ship('A', direction, c);
        while(!bds.validLocation(c, aircraftCarrier)){
            c = randomCoordinate();
        }
        bds.placeShips(c,aircraftCarrier);

        direction = randomDirection();
        c = randomCoordinate();
        Ship battleShip = new Ship('B', direction, c);
        while(!bds.validLocation(c, battleShip)){
            c = randomCoordinate();
        }
        bds.placeShips(c,battleShip);

        direction = randomDirection();
        c = randomCoordinate();
        Ship submarine = new Ship('S', direction, c);
        while(!bds.validLocation(c, submarine)){
            c = randomCoordinate();
        }
        bds.placeShips(c,submarine);

        direction = randomDirection();
        c = randomCoordinate();
        Ship destroyer = new Ship('D', direction, c);
        while(!bds.validLocation(c, destroyer)){
            c = randomCoordinate();
        }
        bds.placeShips(c,destroyer);

        direction = randomDirection();
        c = randomCoordinate();
        Ship patrolBoat = new Ship('P', direction, c);
        while(!bds.validLocation(c, patrolBoat)){
            c = randomCoordinate();
        }
        bds.placeShips(c,patrolBoat);

        System.out.println("The computer finished placing its ships!");
        System.out.println("'X' represents where the computer has attacked your board.");
    }

    public void attackPlayer(Player p, Coordinate attack){
        printResult(bds.hitMissPlayer(attack,p));
    }

    public void printResult(char result){
        if(result=='H'){
            System.out.println("The computer has successfully HIT your ship!");
        } else {
            System.out.println("The computer has MISSED your ships.");
        }
    }

    public Coordinate getPredictedCoordinate(Player p){
        Coordinate c = randomCoordinate();
        if(!coord.isEmpty()){
            c=coord.get(coord.size()-1);
            if(bds.hitMissPlayer(c,p)=='H'){
                choose = chooseAdjacentLocations(c);
                int randNr = (int)(Math.random()*choose.size())+1;
                while(!bds.validAttack(choose.get(randNr-1)) || bds.getBoardB()[choose.get(randNr-1).getY()+1][choose.get(randNr-1).getX()+1]!='.'){
                    randNr = (int)(Math.random()*choose.size())+1;
                }
                coord.add(choose.get(randNr-1));
                return choose.get(randNr-1);
            }
        }
        c = randomCoordinate();
        while(!bds.validAttack(c)||bds.getBoardB()[c.getY()+1][c.getX()+1] != '.'){
            c = randomCoordinate();
        }
        coord.add(c);
        return c;
    }

    public ArrayList<Coordinate>chooseAdjacentLocations(Coordinate c){
        ArrayList<Coordinate>adjacentCoord = new ArrayList<Coordinate>();
        if(c.getX() == 0 && c.getY() == 0){
            adjacentCoord.add(new Coordinate(c.getX()+1,c.getY()));
            adjacentCoord.add(new Coordinate(c.getX(),c.getY()+1));
        } else if(c.getX() == 0 && c.getY() == 9){
            adjacentCoord.add(new Coordinate(c.getX()+1,c.getY()));
            adjacentCoord.add(new Coordinate(c.getX(),c.getY()-1));
        } else if(c.getX() == 9 && c.getY() == 0){
            adjacentCoord.add(new Coordinate(c.getX()-1,c.getY()));
            adjacentCoord.add(new Coordinate(c.getX(),c.getY()+1));
        } else if(c.getX() == 9 && c.getY() == 9){
            adjacentCoord.add(new Coordinate(c.getX()-1,c.getY()));
            adjacentCoord.add(new Coordinate(c.getX(),c.getY()-1));
        } else if(c.getX() == 0){
            adjacentCoord.add(new Coordinate(c.getX()+1,c.getY()));
            adjacentCoord.add(new Coordinate(c.getX(),c.getY()+1));
            adjacentCoord.add(new Coordinate(c.getX(),c.getY()-1));
        } else if(c.getX() == 9){
            adjacentCoord.add(new Coordinate(c.getX()-1,c.getY()));
            adjacentCoord.add(new Coordinate(c.getX(),c.getY()+1));
            adjacentCoord.add(new Coordinate(c.getX(),c.getY()-1));
        } else if(c.getY() == 0){
            adjacentCoord.add(new Coordinate(c.getX()-1,c.getY()));
            adjacentCoord.add(new Coordinate(c.getX()+1,c.getY()));
            adjacentCoord.add(new Coordinate(c.getX(),c.getY()+1));
        } else if(c.getY() == 9){
            adjacentCoord.add(new Coordinate(c.getX()-1,c.getY()));
            adjacentCoord.add(new Coordinate(c.getX()+1,c.getY()));
            adjacentCoord.add(new Coordinate(c.getX(),c.getY()-1));
        } else {
            adjacentCoord.add(new Coordinate(c.getX(),c.getY()-1));
            adjacentCoord.add(new Coordinate(c.getX(),c.getY()+1));
            adjacentCoord.add(new Coordinate(c.getX()-1,c.getY()));
            adjacentCoord.add(new Coordinate(c.getX()+1,c.getY()));
        }
        return adjacentCoord;
    }

    public boolean verifyCompWinning(Player p){
        for(int i = 1; i < p.getBoardA().length; i++){
            for(int j = 1; j<p.getBoardA()[0].length;j++){
                if(p.getBoardA()[i][j] != '.' && bds.getBoardB()[i][j] != 'H'){
                    return false;
                }
            }
        }
        return true;
    }

    public char randomDirection(){
        int dirNr = (int)(Math.random()*4+1);
        if(dirNr==1){
            return 'u';
        } else if(dirNr==2){
            return 'd';
        } if(dirNr==3){
            return 'r';
        } else {
            return 'l';
        }
    }

    public Coordinate randomCoordinate(){
        int randNr1 = (int)(Math.random() * 10);
        int randNr2 = (int)(Math.random() * 10);

        return new Coordinate(randNr1,randNr2);
    }

    public char[][] getBoardA(){
        return bds.getBoardA();
    }

    public char[][] getBoardB(){
        return bds.getBoardB();
    }

}
