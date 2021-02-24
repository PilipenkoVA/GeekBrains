import java.util.Arrays;
import java.util.Random;
import java.util.Scanner;

public class ХО {

    private static char [][] map;
    private static  int SIZE;
    private static  int SIZE_FISH;
    private static final char EMPTY_DOT = '•';
    private static final char X_DOT = 'X';
    private static final char O_DOT = 'O';
    private static Scanner sc;

    public static void main(String[] args) {
        System.out.println("На каком поле будем играть? (3,4,5...)");
        Scanner sc=new Scanner(System.in);
        SIZE=sc.nextInt();
        System.out.println("Сколько фишек подряд для победы?");
        for(;;){
            SIZE_FISH = sc.nextInt();
            if (SIZE_FISH > SIZE) {
                System.out.println("Сколько фишек подряд для победы? (фишек д.б. равно или меньше размера поля)");
                continue;
            }break;
        }
        initMap();
        //printMap();
        while (true) {
            printMap();
            humanTurn();
            System.out.println();
            if (checkWin(X_DOT)) {
                System.out.println("Вы выиграли");
                break;
            }
            if (checkDraw()) {
                System.out.println("Ничья");
                break;
            }
            computerTurn();
            printMap();
            //System.out.println();
            if (checkWin(O_DOT)) {
                System.out.println("Вы проиграли");
                break;
            }
            if (checkDraw()) {
                System.out.println("Ничья");
                break;
            }
            try {
                Thread.sleep(500);
            } catch (InterruptedException ignored) {
            }
        }
    }

    private static boolean checkDraw() { //проверка на ничью
        for (char[] chars : map) {
            for (char aChar : chars) {
                if (aChar == EMPTY_DOT) {
                    return false;
                }
            }
        }
        return true;
    }

    private static boolean checkWin(char c) { // проверка на победу
        int diag1, diag2, vert, goriz;
        for (int i = 0; i < SIZE_FISH; i++) { //проверка по горизонтали и вертикали
            vert = 0; goriz = 0;
            for (int j = 0; j < SIZE_FISH; j++) {
                if (map[i][j] == c) {
                    goriz++;
                }
                if (map[j][i] == c) {
                    vert++;

                }
            }
            if (goriz == SIZE_FISH || vert == SIZE_FISH) {
                return true;
            }
        }    System.out.println(Arrays.deepToString(map)+" ");
        diag1=0; diag2=0;
        for(int i=0;i<SIZE_FISH;i++) { //проверка по диагонали
            if (map[i][i] == c) {
                diag1++;
            }
            if (map[i][SIZE_FISH - i - 1] == c) {
                diag2++;
            }
        }
        if(diag1 == SIZE_FISH || diag2 == SIZE_FISH) {
            return true;
        }
        return false;
    }


    private static void computerTurn() { //ход ИИ
        int xCoordinate=-1;
        int yCoordinate=-1;
        boolean ai_win=false;
        boolean user_win=false;
        if (!ai_win) {
            for (int i = 0; i < SIZE; i++) {
                for (int j = 0; j < SIZE; j++) {
                    if (!isValidCell(i, j)) { //свободная ячейка
                        map[i][j] = X_DOT; // метка игрока "Х"
                        if (checkWin(X_DOT)) //проверка линий на выигрышную
                        {
                            xCoordinate = i;
                            yCoordinate = j;
                            user_win = true;
                        }
                        map[j][i] = X_DOT; // символ "."
                        //System.out.println(Arrays.deepToString(map)+" ");
                    }
                }
            }
        }

        if (!ai_win && !user_win) {
            do {
                Random rnd = new Random();
                xCoordinate = rnd.nextInt(SIZE);
                yCoordinate = rnd.nextInt(SIZE);
            }
            while (!isValidCell(xCoordinate, yCoordinate));
        }
        map[xCoordinate][yCoordinate] = O_DOT;
    }

    private static void humanTurn() { //ход человека
        int xCoordinate=-1;
        int yCoordinate=-1;
        do {
            System.out.println("Введите координаты в формате x- столбик пробел y- строка");
            if (sc.hasNextInt()) {
                xCoordinate = sc.nextInt() - 1;
            }
            if (sc.hasNextInt()) {
                yCoordinate = sc.nextInt() - 1;
            }
            sc.nextLine();
        } while (!isValidCell(xCoordinate, yCoordinate));
        map[yCoordinate][xCoordinate] = X_DOT;
    }

    private static boolean isValidCell(int x, int y) { //поиск свободной ячейки
        if (x < 0 || y < 0 || x > map.length - 1 || y > map.length - 1) {
            return false;
        }
        return map[y][x] == EMPTY_DOT;
    }

    private static void printMap() { //вывод игрового поля
        for(int i=0;i<=SIZE;i++){
            System.out.print(i + " ");
        }
        System.out.println();
        for (int i = 0; i < SIZE; i++) {
            System.out.print((i+1)+" ");
            for (int j = 0; j < SIZE; j++) {
                System.out.print(map[i][j] + " ");
            }
            System.out.println();
        }
    }

    private static void initMap() { //проверка на заполняемость поля
        sc = new Scanner(System.in);
        map = new char[SIZE][SIZE];
        for (char[] chars : map) {
            Arrays.fill(chars, EMPTY_DOT);
        }
    }
}

