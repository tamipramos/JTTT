package Table;

import GameSettings.Token;

import java.util.Arrays;

public class Table {
    String[][] table;
    int horizontal;
    int vertical;

    public Table(int horizontal, int vertical) {
        this.horizontal = horizontal;
        this.vertical = vertical;
        this.table = new String[horizontal][vertical];
        int row = 0;
        for (String[] v : this.table) {
            int column = 0;
            for (String h : v) {
                this.table[row][column] = Token.EMPTY.getVisual();
                column++;
            }
            row++;
        }
    }


    public void drawTable() {
        for (String[] v : this.table) {
            for (String h : v) {
                System.out.print(h + "\t");
            }
            System.out.println();
        }
    }

    public void clearTable() {
        int row = 0;
        for (String[] v : this.table) {
            int column = 0;
            for (String h : v) {
                this.table[row][column] = Token.EMPTY.getVisual();
                column++;
            }
            row++;
        }
    }

    public void setCursor(int row, int column, String token) {
        this.table[column - 1][row - 1] = token;
    }

    public String getToken(int row, int column) {
        return this.table[column - 1][row - 1];
    }

    public boolean checkForLine(String currentCharacter) {
        /*
        Row Case:               Order [0,0]->[0,1]->[0,2]
           {{1},{1},{1}},       Math [x,y+n]
           {{0},{0},{0}},
           {{0},{0},{0}}
        Column Case:            Order [0,0]->[1,0]->[2,0]
           {{1},{0},{0}},       Math [x+n,y]
           {{1},{0},{0}},
           {{1},{0},{0}}
        Positive Cross Case;    Order [0,0]->[1,1]->[2,2]
           {{1},{0},{0}},       Math [x+n,y+n]
           {{0},{1},{0}},
           {{0},{0},{1}}
        Negative Cross Case:    Order [0,2]->[1,1]->[2,0]
           {{0},{0},{1}},       Math [x+n,y-n]
           {{0},{1},{0}},
           {{1},{0},{0}}
         */
        for (int x = 0; x<2 ; x++) {
                if
                    (this.table[x][0] == currentCharacter
                        &&this.table[x][1] == currentCharacter
                        &&this.table[x][2] == currentCharacter) {
                            drawTable();
                            System.out.println("GANADOR: " + currentCharacter + "\n");
                            return true;
                }
                else if
                    (this.table[0][x] == currentCharacter
                        && this.table[1][x] == currentCharacter
                        && this.table[2][x] == currentCharacter){
                            drawTable();
                            System.out.println("GANADOR: " + currentCharacter + "\n");
                            return true;
                }
            }
        if (this.table[0][0] == currentCharacter
                && this.table[1][1] == currentCharacter
                && this.table[2][2] == currentCharacter){
            drawTable();
            System.out.println("GANADOR: " + currentCharacter + "\n");
            return true;
        } else if (this.table[0][2] == currentCharacter
                && this.table[1][1] == currentCharacter
                && this.table[2][0] == currentCharacter){
            drawTable();
            System.out.println("GANADOR: " + currentCharacter + "\n");
            return true;
        }
        return false;
    }

    public boolean setDraw(){
        if (!Arrays.stream(this.table).flatMap(Arrays::stream).anyMatch(x -> x.equals(Token.EMPTY.getVisual()))){
            return true;
        }
        return false;
    }
}