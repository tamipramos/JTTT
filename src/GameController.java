import Table.Table;
import GameSettings.Token;

import java.util.Scanner;


public class GameController{
        private final Token X = Token.X;
        private final Token O = Token.O;

        private Token currentPlayer = X;
        int tableRows=3;
        int tableColumns=3;
        private Table table = new Table(tableRows, tableColumns);

        public GameController(Boolean gameModeNumbers) {

                if (!gameModeNumbers) {
                        while(true) {
                                startGame_numbers();
                        }
                } else {
                        System.out.print("ARROWS");
                }

        }

        public void startGame_numbers() {
                Scanner input = new Scanner(System.in);
                table.drawTable();
                int column;
                int row;
                System.out.println("Turno del jugador -> "+currentPlayer.getVisual());
                System.out.print("Ingrese fila: ");
                try {
                        row = input.nextInt();
                } catch (Exception e) {
                        row=-1;
                }
                System.out.print("Ingrese columna: ");
                try {
                        column = input.nextInt();
                } catch (Exception e){
                        column=-1;
                        System.out.print("\u001b[31m[!] Error de input\u001b[0m\n\n\n");
                }
                placeToken(column, row);

        }

        private void placeToken(int row, int column) {
                if ((row < this.tableRows+1 && row > 0) && (column < this.tableColumns+1 && column > 0)){
                        if (table.getToken(row, column) == Token.EMPTY.getVisual()){
                                table.setCursor(row, column, currentPlayer.getVisual());
                                if (!table.checkForLine(currentPlayer.getVisual())){
                                        currentPlayer = (currentPlayer == X) ? O : X;
                                } else {
                                        Scanner nextGame = new Scanner(System.in);
                                        System.out.println("[Presione <ENTER> para continuar]");
                                        nextGame.nextLine();
                                        this.table.clearTable();
                                }
                                if (table.setDraw()){
                                        Scanner nextGame = new Scanner(System.in);
                                        System.out.println("\n" + Token.X.getVisual()+" [EMPATE] "+Token.O.getVisual()+"\n");
                                        System.out.println("[Presione <ENTER> para continuar]");
                                        nextGame.nextLine();
                                        this.table.clearTable();
                                }
                        }
                }
        }

}




