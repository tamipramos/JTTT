package Table;

import GameSettings.Token;

public class Table {
    String[][] table;
    int horizontal;
    int vertical;

    public Table(int horizontal, int vertical) {
        this.horizontal = horizontal;
        this.vertical = vertical;
        this.table = new String[horizontal][vertical];
        int row=0;
        for (String[] v : this.table) {
            int column=0;
            for (String h : v) {
                    this.table[row][column]= Token.EMPTY.getVisual();
                    column++;
                }
            row++;
            }
        }


    public void drawTable(){
        for (String[] v : this.table) {
            for (String h : v) {
                    System.out.print(h+"\t");
                }
            System.out.println();
        }
    }

    public void clearTable(){
        int row=0;
        for (String[] v : this.table) {
            int column=0;
            for (String h : v) {
                this.table[row][column]= Token.EMPTY.getVisual();
                column++;
            }
            row++;
        }
    }

    public void setCursor(int row, int column, String token){
            this.table[column-1][row-1] = token;
    }

    public String getToken(int row, int column){
        return this.table[column-1][row-1];
    }

    public boolean checkForLine(String currentCharacter) {
        int x=0;
        for (String[] v : this.table) {
            int y=0;
            for (String h : v) {
                if (h == currentCharacter){
                    try {
                        if ((this.table[x][y + 1] == currentCharacter && this.table[x][y + 2] == currentCharacter)
                        || (this.table[x+1][y] == currentCharacter && this.table[x+2][y] == currentCharacter)
                        || (this.table[x+1][y+1] == currentCharacter && this.table[x+2][y+2] == currentCharacter)
                        || (this.table[x+1][y-1] == currentCharacter && this.table[x+2][y-2] == currentCharacter)){
                            System.out.println("GANADOR: "+currentCharacter+"\n");
                            return true;

                        }
                    } catch (Exception e){
                        return false;
                    }
                }
                y++;
            }
            x++;
        }
        return false;
    }

}