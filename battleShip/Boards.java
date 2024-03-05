package battleShip;

public class Boards {

    private char[][] boardA = new char[8][10];
    private char[][] boardB = new char[8][10];

    private int aircraftCarrierPlayer = 0;
    private int battleshipPlayer = 0;
    private int submarinePlayer = 0;
    private int destroyerPlayer = 0;
    private int patrolBoatPlayer = 0;

    private int aircraftCarrierComputer = 0;
    private int battleshipComputer = 0;
    private int submarineComputer = 0;
    private int destroyerComputer = 0;
    private int patrolBoatComputer = 0;

    public void initBoardA() {
        boardA[0][0] = ' ';
        int nr = 1;
        for (int i=48;i<=54;i++){
            boardA[nr][0]=(char)i;
            nr++;
        }
        nr = 1;
        for (char i=48;i<=56;i++){
            boardA[0][nr]=i;
            nr++;
        }
        for (int i=1;i<boardA.length;i++){
            for (int j=1;j<boardA[0].length;j++) {
                boardA[i][j] = '.';
            }
        }
    }

    public void initBoardB() {
        boardB[0][0] = ' ';
        int nr = 1;
        for (int i=48;i<=54;i++){
            boardB[nr][0]=(char)i;
            nr++;
        }
        nr = 1;
        for (char i=48;i<=56;i++){
            boardB[0][nr]=i;
            nr++;
        }
        for (int i=1;i<boardB.length;i++){
            for (int j=1;j<boardB[0].length;j++) {
                boardB[i][j] = '.';
            }
        }
    }

    public Boards() {
        initBoardA();
        initBoardB();
    }

    public boolean validLocation(Coordinate c, Ship s){
        int X = c.getX()+1;
        int Y = c.getY()+1;

        if (X < 0 || X >= boardA[0].length || Y < 0 || Y >= boardA.length){
            return false;
        }

        if (s.getDirection() == 'u' && Y - (s.getSize() - 1) < 0) {
            return false;
        } else if (s.getDirection() == 'd' && Y + (s.getSize() - 1) >= boardA.length) {
            return false;
        } else if (s.getDirection() == 'r' && X + (s.getSize() - 1) >= boardA[0].length) {
            return false;
        } else if (s.getDirection() == 'l' && X - (s.getSize() - 1) < 0) {
            return false;
        }

        for (int i = 0; i < s.getSize(); i++) {
            if (s.getDirection() == 'u' && boardA[Y - i][X] != '.') {
                return false;
            } else if (s.getDirection() == 'd' && boardA[Y + i][X] != '.') {
                return false;
            } else if (s.getDirection() == 'r' && boardA[Y][X + i] != '.') {
                return false;
            } else if (s.getDirection() == 'l' && boardA[Y][X - i] != '.') {
                return false;
            }
        }

        return true;
    }



    public boolean validAttack(Coordinate c){

        int Y = c.getY() + 1;
        int X = c.getX() + 1;

        if(X < 1 || X >= boardA[0].length){
            return false;
        }
        if(Y < 1 || Y >= boardA.length){
            return false;
        }

        return true;

    }

    public char[][] getBoardA() {
        return boardA;
    }

    public char[][] getBoardB() {
        return boardB;
    }

    public void printBoardA() {

        for(int i = 0; i < boardA.length; i++){
            for(int j=0; j<boardA[0].length;j++){
                System.out.print(boardA[i][j] + "   ");
            }
            System.out.println();
        }

    }

    public void printBoardB() {

        for(int i = 0; i < boardB.length; i++){
            for(int j=0; j<boardB[0].length;j++){
                System.out.print(boardB[i][j] + "   ");
            }
            System.out.println();
        }

    }

    public char hitMissComputer(Coordinate c, Computer opposition){

        int Y = c.getY() + 1;
        int X = c.getX() + 1;

        if(opposition.getBoardA()[Y][X] == 'A'){
            aircraftCarrierComputer++;
            if(aircraftCarrierComputer == 5) {
                System.out.println("You sunk your opponent's aircraft carrier!");
            }
        } else if(opposition.getBoardA()[Y][X]=='B'){
            battleshipComputer++;
            if(battleshipComputer == 4) {
                System.out.println("You sunk your opponent's battleship!");
            }
        } else if(opposition.getBoardA()[Y][X]=='S'){
            submarineComputer++;
            if(submarineComputer == 3) {
                System.out.println("You sunk your opponent's submarine!");
            }
        } else if(opposition.getBoardA()[Y][X]=='D'){
            destroyerComputer++;
            if(destroyerComputer == 3) {
                System.out.println("You sunk your opponent's destroyer!");
            }
        } else if(opposition.getBoardA()[Y][X]=='P'){
            patrolBoatComputer++;
            if(patrolBoatComputer == 2) {
                System.out.println("You sunk your opponent's patrol boat!");
            }
        }

        if(opposition.getBoardA()[Y][X] != '.'){
            this.getBoardB()[Y][X]='H';
            opposition.getBoardA()[Y][X] = 'X';
            return 'H';
        }

        this.getBoardB()[Y][X]='M';
        return 'M';

    }

    public char hitMissPlayer(Coordinate c, Player opposition){

        int Y = c.getY() + 1;
        int X = c.getX() + 1;

        if(opposition.getBoardA()[Y][X]=='A'){
            aircraftCarrierPlayer++;
            if(aircraftCarrierPlayer == 5) {
                System.out.println("Your opponent has sunk your aircraft carrier!");
            }
        } else if(opposition.getBoardA()[Y][X]=='B'){
            battleshipPlayer++;
            if(battleshipPlayer == 4) {
                System.out.println("Your opponent has sunk your battleship!");
            }
        } else if(opposition.getBoardA()[Y][X]=='S'){
            submarinePlayer++;
            if(submarinePlayer == 3) {
                System.out.println("Your opponent has sunk your submarine!");
            }
        } else if(opposition.getBoardA()[Y][X]=='D'){
            destroyerPlayer++;
            if(destroyerPlayer == 3) {
                System.out.println("Your opponent has sunk your destroyer!");
            }
        } else if(opposition.getBoardA()[Y][X]=='P'){
            patrolBoatPlayer++;
            if(patrolBoatPlayer == 2) {
                System.out.println("Your opponent has sunk your patrol boat!");
            }
        }

        if(opposition.getBoardA()[Y][X] != '.' && opposition.getBoardA()[Y][X] != 'x'){
            opposition.getBoardA()[Y][X] = 'X';
            this.getBoardB()[Y][X]='H';
            return 'H';
        } else {
            opposition.getBoardA()[Y][X] = 'x';
            this.getBoardB()[Y][X] = 'M';
            return 'M';
        }

    }

    public void printResult(char result){

        if(result == 'M'){
            System.out.println("You missed!");
        } else {
            System.out.println("You hit the enemy ship!");
        }

    }

    public void placeShips(Coordinate c, Ship s){

        int Y = c.getY() + 1;
        int X = c.getX() + 1;

        boardA[Y][X]=s.getName();

        if(s.getDirection() == 'u'){
            for(int i = Y; i>=Y - (s.getSize() - 1); i--){
                boardA[i][X]=s.getName();
            }
        } else if (s.getDirection()=='d'){
            for(int i = Y; i<=Y + (s.getSize() - 1); i++){
                boardA[i][X]=s.getName();
            }
        } else if (s.getDirection()=='r'){
            for(int i = X; i<=X + (s.getSize() - 1); i++){
                boardA[Y][i]=s.getName();
            }
        } else if (s.getDirection()=='l'){
            for(int i = X; i>=X - (s.getSize() - 1); i--){
                boardA[Y][i]=s.getName();
            }
        }

    }

}
