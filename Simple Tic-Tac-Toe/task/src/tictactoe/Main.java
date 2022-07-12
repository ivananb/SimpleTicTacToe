package tictactoe;

import java.util.*;

public class Main {
    public static Scanner scan = new Scanner(System.in);
    public static String[][] game = new String[3][3];
    public static String turn = "X";
    public static String result = null;

    public static void printBattlefield() {
        System.out.println("---------");
        System.out.println("| " + game[0][0] + " " + game[0][1] + " " + game[0][2] + " |");
        System.out.println("| " + game[1][0] + " " + game[1][1] + " " + game[1][2] + " |");
        System.out.println("| " + game[2][0] + " " + game[2][1] + " " + game[2][2] + " |");
        System.out.println("---------");
    }


    public static String changeTurn() {
        if (turn.equals("X")) {
            turn = "O";
        } else {
            turn = "X";
        }
        return turn;
    }

    public static void updateBattlefield() {
        int n = 0;
        int x, y;

        do {
            System.out.print("Enter the coordinates: ");
            x = scan.nextInt();
            y = scan.nextInt();
            x--;
            y--;
            if (x > 3 || x < 0 || y > 3 || y < 0) {
                System.out.println("Coordinates should be from 1 to 3!");
            } else if (x != 0 && x != 1 && x != 2 || y != 0 && y != 1 && y != 2) {
                System.out.println("You should enter numbers!");
            } else if (!(game[x][y].equals(" ")) ) {
                System.out.println("This cell is occupied! Choose another one!");
            } else {
                n = 1;
            }
        } while (n != 1);


        game [x][y] = turn;
        printBattlefield();
        changeTurn();
    }


    //check game state
    public static String checkState(String game[][]) {


        //counts how many empty spaces, Xs and Os are in the game
        int countEmptySpace = 0;
        for (int row = 0; row < game.length; row++) {
            for (int col = 0; col < game[row].length; col++) {
                if (game[row][col].equals(" ")){
                    countEmptySpace++;
                }
            }
        }

        // states which are the possible winning lines
        for (int winningLines = 0; winningLines < 8; winningLines++) {
            String line = null;
            switch (winningLines) {
                case 0:
                    line = game[0][0] + game[0][1] + game[0][2];
                    break;
                case 1:
                    line = game[1][0] + game[1][1] + game[1][2];
                    break;
                case 2:
                    line = game[2][0] + game[2][1] + game[2][2];
                    break;
                case 3:
                    line = game[0][0] + game[1][0] + game[2][0];
                    break;
                case 4:
                    line = game[0][1] + game[1][1] + game[2][1];
                    break;
                case 5:
                    line = game[0][2] + game[1][2] + game[2][2];
                    break;
                case 6:
                    line = game[0][0] + game[1][1] + game[2][2];
                    break;
                case 7:
                    line = game[0][2] + game[1][1] + game[2][0];
                    break;
            }

            //checking winners
            if (line.equals("XXX")){
                result = "X wins";
            } else if (line.equals("OOO")) {
                result = "O wins";
            } else if (result == null && countEmptySpace == 0) {
                result = "Draw";
            }


        }
        return result;
    }



    public static void main(String[] args) {

        //create empty grid
        int n = 0;
        for (int row = 0; row < game.length; row++) {
            for (int col = 0; col < game[0].length; col++) {
                game[row][col] = " ";
                n++;
            }
        }

        printBattlefield();
        do {
            updateBattlefield();
        } while (checkState(game) == null);
        System.out.println(checkState(game));

    }

}