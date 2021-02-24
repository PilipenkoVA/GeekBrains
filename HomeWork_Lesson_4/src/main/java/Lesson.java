import java.util.Random;
import java.util.Scanner;

public class Lesson {

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
    private static void isChar(int y, int x, char sym){
        map[y][x] = sym;
    }

    private static boolean checkWin(char dot) {
        for (int i = 0; i < size_Y; i++) {
            for (int j = 0; j < size_X; j++) {
                if (checkLine(i, j, 0, 1,  dot)) return true;
                if (checkLine(i, j, 1, 1,  dot)) return true;
                if (checkLine(i, j, 1, 0,  dot)) return true;
                if (checkLine(i, j, -1, 1, dot)) return true;
            }
        }
        return false;
    }
    private static boolean checkLine(int y, int x, int dy, int dx, char sym){
        int wayX = x + (to_WIN - 1) * dx;
        int wayY = y + (to_WIN - 1) * dy;
        if (wayX < 0 || wayY < 0 || wayX > size_X - 1 || wayY > size_Y - 1) return false;
        for (int i = 0; i < to_WIN; i++) {
            int itemY = y + i * dy;
            int itemX = x + i * dx;
            if (map[itemY][itemX] != sym) return false;
        }
        return true;
    }
}
