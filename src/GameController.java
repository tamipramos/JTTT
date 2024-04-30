import Table.Table;
import GameSettings.Token;

import java.util.Scanner;


public class GameController{
        private final Token X = Token.X;
        private final Token O = Token.O;

        private Token currentPlayer = X;

        private Table table = new Table(3, 3);

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

                System.out.print("Ingrese fila: ");
                row = input.nextInt();
                System.out.print("Ingrese columna: ");
                column = input.nextInt();
                placeToken(column, row);

        }

        private void placeToken(int row, int column) {
                if (table.getToken(row, column) == Token.EMPTY.getVisual()) {
                        table.setCursor(row, column, currentPlayer.getVisual());
                        currentPlayer = (currentPlayer == X) ? O : X;
                }
        }
}




