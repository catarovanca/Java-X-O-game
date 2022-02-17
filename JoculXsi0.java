package ro.itschool;

import java.util.Scanner;

public class JoculXsi0 {
    public static void main(String[] args) {
        char[][] matrix = new char[3][3];
        int option;
        do{
            System.out.println("--Welcome to X&0 game!--");
            System.out.println("1.Start game.");
            System.out.println("0.Exit.");
            Scanner scanner = new Scanner(System.in);
            option = scanner.nextInt();
            if(option == 1){
                playGame(matrix);
            }
        }while(option != 0);
    }
    public static void dispalyMatrix(char[][] matrix){
        for(int i = 0 ; i < matrix.length ; i++) {
            System.out.print("Line " + i + " ");
            for (int j = 0; j < matrix[i].length; j++) {
                System.out.print("[ " + matrix[i][j] + " ]");
            }
            System.out.println();
        }
    }
    public static void playGame(char[][] matrix){
        Scanner scanner = new Scanner(System.in);
        //initializing a boolean variable which will be used to exit the do-while loop
        boolean winner = false;

        do {
            boolean occupiedPlayer1 = true;
            // Player 1
            do {
                System.out.println();
                System.out.println("Player 1 enter a line no!");
                int player1Line = scanner.nextInt();
                System.out.println("Player 1 enter a column no!");
                int player1Column = scanner.nextInt();

                if (matrix[player1Line][player1Column] == 0) {
                    matrix[player1Line][player1Column] = 'X';
                    occupiedPlayer1 = false;
                    dispalyMatrix(matrix);
                } else {
                    System.out.println("Line " + player1Line + " and column " + player1Column + " is occupied,try different no!");
                }
            } while (occupiedPlayer1 == true);

            // check for player 1 winner
            boolean checkPlayer1Winner = checkWinner(matrix, 'X');

            if (checkPlayer1Winner == true)
            {
                System.out.println();
                System.out.println("Player 1 win!");
                System.out.println();
                winner = true;
            }

            //Player 2 - Computer
            //verifying player 1 did not win the game before player 2 playing
            if (winner == false) {
                int minim = 0;
                int maxim = 2;
                int coef = maxim - minim + 1;

                System.out.println();
                System.out.println("Player 2 entering value!");
                boolean occupiedPlayer2 = true;
                // verifying player 2 if has entered a value in an empty space
                do {
                    int player2Line = (int) (Math.random() * coef + minim);
                    int player2Column = (int) (Math.random() * coef + minim);
                    if (matrix[player2Line][player2Column] == 0) {
                        matrix[player2Line][player2Column] = 'O';
                        occupiedPlayer2 = false;
                        dispalyMatrix(matrix);
                    }
                } while (occupiedPlayer2 == true);


                // check player 2 win
                boolean checkPlayer2Winner = checkWinner(matrix, 'O');

                if (checkPlayer2Winner == true)
                {
                    System.out.println();
                    System.out.println("Player 2 win!");
                    System.out.println();
                    winner = true;
                }
            }
        }while(winner == false);

    }

    // checking if a player has won the game
    public static boolean checkWinner(char[][] matrix,char playerSymbol){
        boolean winner = false;

        if (matrix[0][0] == playerSymbol && matrix[0][1] == playerSymbol && matrix[0][2] == playerSymbol) {
            winner = true;
        } else if (matrix[1][0] == playerSymbol && matrix[1][1] == playerSymbol && matrix[1][2] == playerSymbol) {
            winner = true;
        } else if (matrix[2][0] == playerSymbol && matrix[2][1] == playerSymbol && matrix[2][2] == playerSymbol) {
            winner = true;
        } else if (matrix[0][0] == playerSymbol && matrix[1][1] == playerSymbol && matrix[2][2] == playerSymbol) {
            winner = true;
        } else if (matrix[0][2] == playerSymbol && matrix[1][1] == playerSymbol && matrix[2][0] == playerSymbol) {
            winner = true;
        }
        return winner;
    }
}
