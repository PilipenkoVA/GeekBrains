import java.util.Random;
import java.util.Scanner;

public class GameXO { // Пепепроверить повторно код проверки и до разбераться с алгоритмом

        private static int size_X = 5;
        private static int size_Y = 5;
        private static char empty_DOT = '.';
        private static char player_DOT = 'X';
        private static char comp_DOT = '0';
        private static int to_WIN = 4;

        private static Scanner scanner;
        private static char[][] map = new char[size_Y][size_X];

        public static void main(String[] args) {
            initField();
            printField();

            while (true){
                playerStep();
                printField();
                System.out.println();
                if (checkWin(player_DOT)){
                    System.out.println("YOU WIN");
                    break;
                }
                if (checkDraw()){
                    System.out.println("THE END (Нет свободных ходов)");
                    break;
                }
                compStep();
                printField();
                System.out.println();
                if (checkWin(comp_DOT)){
                    System.out.println("YOU LOSE");
                    break;
                }
                if (checkDraw()){
                    System.out.println("THE END (Нет свободных ходов)");
                    break;
                }
                try {
                    Thread.sleep(700);
                }catch (InterruptedException ignored){
                }

            }



        }
        private static void initField(){
            scanner = new Scanner(System.in);
            for (int i = 0; i < size_Y; i++){
                for (int j = 0; j < size_X; j++){
                    map[i][j] = empty_DOT;
                }
            }
        }
        private static void printField() {
            for (int i = 0; i < size_Y; i++) {
                System.out.print("|");
                for (int j = 0; j < size_X; j++) {
                    System.out.print(map[i][j] + "|");
                }
                System.out.println();
            }

        }
        private static void playerStep(){
            int x = -1;
            int y = -1;
            do{
                System.out.println("Введите координаты: Столбец № (от 1 до " + size_X + ")");
                if (scanner.hasNext()){
                    x = scanner.nextInt() - 1;
                }
                System.out.println("Введите координаты: Строка № (от 1 до " + size_Y + ")");
                if (scanner.hasNext()) {
                    y = scanner.nextInt() - 1;
                }
                scanner.nextLine();
            }while (!isValid(y, x));
            isChar(y, x, player_DOT);

        }
        private static boolean isValid (int x, int y){
            if (x < 0 || y < 0 || x > size_X || y > size_Y) {
                return false;
            }
            return map[x][y] == empty_DOT;

        }
        private static void compStep(){
            Random random = new Random();
            int x;
            int y;
            do{
                x = random.nextInt(size_X);
                y = random.nextInt(size_Y);
            }while (!isValid(y, x));
            isChar(y, x, comp_DOT);

        }
        private static boolean checkDraw() {
            for (int i = 0; i < size_Y; i++) {
                for (int j = 0; j < size_X; j++) {
                    if (map[i][j] == empty_DOT){
                        return false;
                    }
                }
            }
            return true;

        }
        public static boolean checkWin (char symbol,int countLength){
            int countX=0,countY=0,countL=0,countR=0;
            for (int l = 0; l < size_Y-(countLength-1) ; l++) {
                int subRightDiag=0,subRightDiag1=0;
                int subLeftDiag=0,subLeftDiag1=0;
                for (int i = 0; i < map.length; i++) {
                    for (int j = 0; j < map[i].length; j++) {
                        if (map[i][j] == symbol) {
                            countX++;
                        }
                        if (countX == countLength) {
                            return true;
                        }
                        if (map[i][j] == empty_DOT && countX < countLength) {
                            countX = 0;
                        }
                        if (map[j][i] == symbol) {
                            countY++;
                        }
                        if (countY == countLength) {
                            return true;
                        }
                        if (map[j][i] == empty_DOT && countY < countLength) {
                            countY = 0;
                        }
                        if (i == j && map[i][j] == symbol) {
                            countR++;
                        }
                        if (i == j && map[i][j] == empty_DOT && countR < countLength) {
                            countR = 0;
                        }
                        if (countR == countLength) {
                            return true;
                        }
                        if (j == map.length - i - 1 && map[i][j] == symbol) {
                            countL++;
                        }
                        if (j == map.length - i - 1 && map[i][j] == empty_DOT && countL < countLength) {
                            countL = 0;
                        }
                        if (countL == countLength) {
                            return true;
                        }
                        if(j==i+l&&map[i][j]==symbol){
                            subRightDiag++;
                        }
                        if(subRightDiag==countLength){
                            return true;
                        }
                        if(j==i+l&&map[i][j]==empty_DOT){
                            subRightDiag=0;
                        }
                        if(i==j+l&&map[i][j]==symbol){
                            subRightDiag1++;
                        }
                        if(subRightDiag1==countLength){
                            return true;
                        }
                        if(i==j+l&&map[i][j]==empty_DOT){
                            subRightDiag1=0;
                        }
                        if (j==map[i].length-1-l-i&&map[i][j]==symbol){
                            subLeftDiag++;
                        }
                        if(subLeftDiag==countLength){
                            return true;
                        }
                        if(j==map[i].length-1-l-i&&map[i][j]==empty_DOT){
                            subLeftDiag=0;
                        }
                        if(i==map.length+l-j-1&&map[i][j]==symbol){
                            subLeftDiag1++;
                        }
                        if(subLeftDiag1==countLength){
                            return true;
                        }
                        if(i==map.length+l-j-1&&j==map.length-i&&map[i][j]==empty_DOT){
                            subLeftDiag1=0;
                        }
                    }
                    countX = countY = 0;
                }
            }
            return false;
        }
}
