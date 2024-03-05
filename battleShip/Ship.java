package battleShip;

public class Ship {

    /* Classic game ships:
        Aircraft Carrier - size 5 - A
        Battleship - size 4 - B
        Submarine - size 3 - S
        Destroyer - size 3 - D
        Patrol Boat - size 2 - P
     */

    private int size;
    private char name;
    private char direction;
    private Coordinate coordinate;

    Ship(char name, char direction, Coordinate c){
        this.name=name;
        this.direction=direction;
        this.coordinate=c;
        if (name == 'A'){
            size = 5;
        } else if (name == 'B'){
            size = 4;
        } else if (name == 'S' || name == 'D'){
            size = 3;
        } else{
            size = 2;
        }
    }

    public int getSize() {
        return size;
    }

    public char getName() {
        return name;
    }

    public char getDirection() {
        return direction;
    }

    public Coordinate getCoordinates() {
        return coordinate;
    }
}