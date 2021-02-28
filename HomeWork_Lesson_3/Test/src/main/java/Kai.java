import java.util.*;
public class Kai {
    public static void main(String[] args) {
        ticTocToeGame();
        //printDeck(5, new int [] {0,2});

    }
//Helpers section:
//Create and print deck

    static int [] [] createDeck(int size) {
        int [] [] deck = new int[size][size];
        return deck;
    }

    static void printDeck(int [] [] deck) {
//        int [] [] deck = new int[size][size];
        String empty_cell = "*";
        String user_cell = "x";
        String comp_cell = "o";
        for (int i = 0; i < deck.length; i++) { //this equals to the row in our matrix.
            for (int j = 0; j < deck[i].length; j++) { //this equals to the column in each row.
                String cell = empty_cell;
                if (deck[i][j] == 1) {
                    cell = user_cell;
                } else if (deck[i][j] == 2) {
                    cell = comp_cell;
                }
                System.out.print(cell + " | ");
            }
            System.out.println(); //change line on console as row comes to end in the matrix.
        }
    }

    //User input
    static int [] userTurn (){
        Scanner userturn = new Scanner(System.in);
        System.out.println("Please enter the row number: ");
        int row = userturn.nextInt();
        System.out.println("Please enter the column number: ");
        int column = userturn.nextInt();
        int [] coordinates = {row, column};
        return coordinates;
    }

    //Computer input
    static int [] compTurn (int size, int[][] deck) {
        int r, c;
        do {
            Random rand = new Random();
            r = rand.nextInt(size);
            c = rand.nextInt(size);
        } while (deck[r][c] != 0);
        int[] comp_coordinates = new int[] {r + 1, c + 1};
        return comp_coordinates;
    }

    //Winner check
    static boolean isWinner(int size, int[][] deck, int who) {
        for (int i = 0; i < size; i++) {
            boolean allInRow = true;
            for (int j = 0; j < size; j++) {
                if (deck[i][j] != who) {
                    allInRow = false;
                }
            }
            if (allInRow) {
                return true;
            }
        }
        for (int i = 0; i < size; i++) {
            boolean allInColumn = true;
            for (int j = 0; j < size; j++) {
                if (deck[j][i] != who) {
                    allInColumn = false;
                }
            }
            if (allInColumn) {
                return true;
            }
        }
        boolean allInDiagonal1 = true;
        boolean allInDiagonal2 = true;
        for (int i = 0; i < size; i++) {
            if (deck[i][i] != who) {
                allInDiagonal1 = false;
            }
            if (deck[i][size - i - 1] != who) {
                allInDiagonal2 = false;
            }
        }
        return allInDiagonal1 || allInDiagonal2;
    }

    //Game section
    static void ticTocToeGame () {
        int cellsFilled = 0;
        Scanner input = new Scanner(System.in);

        //At first we need to choose the deck size.
        System.out.println("Please decide the deck size. The deck is square, please input the number you prefer: ");
        int size = input.nextInt();

        int[][] deck = createDeck(size);
        printDeck(deck);
        int winner = 0;

        //On each step of game we are requesting user turn, making comp turn and saving deck state
        while (cellsFilled < size * size) {

            //user turn
            System.out.println("Your turn! Input row and column coordinates for your turn.");

            //saving user input
            cellsFilled++;
            int[] coordinates = userTurn();
            while (deck[coordinates[0]-1][coordinates[1]-1] == 1 || deck[coordinates[0]-1][coordinates[1]-1] == 2){
                System.out.println("This cell is already taken. Please try once more!");
                coordinates = userTurn();
            }
            deck[coordinates[0] - 1][coordinates[1] - 1] = 1;
            printDeck(deck);
            if (isWinner(size, deck, 1)) {
                winner = 1;
                break;
            }

            if (cellsFilled == size * size) {
                break;
            }

            // saving comp coordinates
            cellsFilled++;
            int[] comp_coordinates = compTurn(size, deck);
            deck[comp_coordinates[0] - 1][comp_coordinates[1] - 1] = 2;
            System.out.println("Computer turn: ");
            printDeck(deck);
            if (isWinner(size, deck, 2)) {
                winner = 2;
                break;
            }
        }

        if (winner == 0) {
            System.out.println("Draw!");
        } else if (winner == 1) {
            System.out.println("User won!");
        } else if (winner == 2) {
            System.out.println("Comp won!");
        }
    }
}
