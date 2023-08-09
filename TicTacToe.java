package TicTacToe;
import java.util.Scanner;

public class TicTacToe 
{
    public static void main (String [] args)
    {
        int n = 3;
        char [][] board = new char [n][n];
        for( int i = 0; i < n; i++){
            for (int j = 0; j < n; j++) {
                board[i][j] = '-';
            }
        }
            try (Scanner sc = new Scanner(System.in)) {
                System.out.println("Welcome to TICTACTOE!");
                //ask for player one's name
                System.out.print("Player 1, what is your name? ");
                String p1 = sc.nextLine();
                //ask for player two's name
                System.out.print("Player 2, what is your name? ");
                String p2 = sc.nextLine();
                //assign booleans to check if its player one's turn (using conditional statement)
                boolean player1 = true;
                boolean gameEnded = false;
                //conditional statement
                while ( !gameEnded) {
                    //use this to pass the 2d array to the drawBoard parameter
                    drawBoard(board);
                    if (player1) {
                        System.out.println( p1 + "'s turn (x):");
                    } else {
                    System.out.println(p2 + "'s turn (o):");
                    }
                //assign x or o depending on whose turn it is
                char c = '-';
                if (player1) {
                    c = 'x';
                } else {
                    c = 'o';
                }
                //declare the row and column values
                int row = 0;
                int col = 0;
                //another conditional statement to check if a move has already been played, or if the vlaue entered is out of bounds
                while(true) {
                //ask user where they want to play their turn
                System.out.print("what row do you want to play in? ");
                row = sc.nextInt();
                System.out.print("What column do you want to play at? ");
                col = sc.nextInt();
                //if statement to check the validity of value entered
                if( row < 1 || col < 1 || row > n || col > n) {
                    System.out.println("This position is out of bounds... Try again! ");
                } else if (board[row-1][col-1] != '-') {
                    System.out.println("someone has already made a move in this spot... Try again!");
                } else {
                  break;
                }
      }
                // set the "x" or "o" at the desired location on the board
                row = row - 1;
                col = col - 1;
                board[row][col] = c;
                if( ifWon(board) == 'x') {
                    System.out.println( p1 + " Has won!");
                    gameEnded = true;
                } else if (ifWon(board) == 'o') {
                    System.out.println( p2 + " Has won!");
                    gameEnded = true;
                } else {
                    if (gameIsFull(board)) {
                        System.out.println("The game is a tie!");
                        gameEnded = true;
                    } else {
                     player1 =  !player1;
                    }
                }

      }
            }
            drawBoard(board);
    }
    public static void drawBoard(char[][] board) {
		System.out.println("Board:");
		for(int i = 0; i < board.length; i++) {
			//The inner for loop prints out each row of the board
			for(int j = 0; j < board[i].length; j++) {
				System.out.print(board[i][j]);
			}
			//This print statement makes a new line so that each row is on a separate line
			System.out.println();
		}
	}
    // new function created to return the winning char
    public static char ifWon ( char [][] board) {
        //nested for loop here to iterate through every row element
        for( int i = 0; i < board.length; i++) {
            //inAROW is true when all the elements in the row have the same element and false otherwise
            boolean inAROW = true; 
            char value = board[i][0];
            //checks if there is a dash in that specified index
            if( value == '-') {
                inAROW = false;
            } else {
                //this for loop iterates through all of the rows, the if statement says if the value (x or o) is not is not equal to the specified index, the person has not won yet
                for ( int j = 1; j < board[i].length; j++ ) {
                    if(board[i][j] != value) {
                    inAROW = false;
                    break;
                    }
                }
            }
            if(inAROW) {
                return value;
            }
        }
            //for loop used to check every column
            for (int j = 0; j < board[0].length; j++) {
                boolean inACOL = true;
                char value = board[0][j];
                if(value == '-') {
                    inACOL = false;
                } else {
                    for( int i = 1; i < board.length; i++) {
                        if( board[i][j] != value ) {
                            inACOL = false;
                            break;
                        }
                    }
                }
            
            if (inACOL){
                return value;
            }
        }
        //create new boolean and start from the first cell in the board
        boolean inADiag = true;
        char value1 = board[0][0];
        //if statement here to return false if it sees a dash on the cell (no one has played there yet)
        if (value1 == '-') {
            inADiag = false;
        } else {
            //this checks the diagonal from upper left to lower right
            for (int i = 1; i < board.length; i++){
                if(board[i][i] != value1) {
                    inADiag = false;
                    break;
                }
            }
        }
            if (inADiag) {
                return value1;
            }
        boolean inADiag2 = true;
        char value2 = board[0][board.length - 1];
        if(value2 == '-') {
            inADiag = false; 
        } else {
            for ( int i = 0; i < board.length; i++ ) { 
                if (board[i][board.length -1] != value2) {
                    inADiag2 = false;
                    break;
                }
            }
            
        }
        if (inADiag2) {
            return value2;
        }
        return ' ';
    }
    public static boolean gameIsFull ( char [][] board) {
        for(int i = 0; i < board.length; i++) {
            for (int j = 0; j < board[i].length; j++) {
                if (board[i][j] == '-') {
                    return false; 
                }
            }
        }
        return true;
    }
}
