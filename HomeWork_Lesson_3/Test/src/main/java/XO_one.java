import java.util.Random;
import java.util.Scanner;

public class XO_one {

    private static int size_X = 5;
    private static int size_Y = 5;
    private static char empty_DOT = '.';
    private static char player_DOT = 'X';
    private static char comp_DOT = '0';

    private static Scanner scanner;
    private static char[][] map = new char[size_Y][size_X];

    public static void main(String[] args) {
        initField();
        printField();

        while (true) {
            playerStep();
            printField();
            System.out.println();
            if (checkWin(player_DOT)) {
                System.out.println("YOU WIN");
                break;
            }
            if (checkDraw()) {
                System.out.println("THE END (Нет свободных ходов)");
                break;
            }
            compStep();
            printField();
            System.out.println();
            if (checkWin(comp_DOT)) {
                System.out.println("YOU LOSE");
                break;
            }
            if (checkDraw()) {
                System.out.println("THE END (Нет свободных ходов)");
                break;
            }
            try {
                Thread.sleep(700);
            } catch (InterruptedException ignored) {
            }

        }


    }

    private static void initField() {                                // (1) - СОЗДАНИЕ ПОЛЯ
        scanner = new Scanner(System.in);
        for (int i = 0; i < size_Y; i++) {
            for (int j = 0; j < size_X; j++) {
                map[i][j] = empty_DOT;
            }
        }
    }

    private static void printField() {                              // (2) - ПЕЧАТЬ ПОЛЯ
        for (int i = 0; i < size_Y; i++) {
            System.out.print("|");
            for (int j = 0; j < size_X; j++) {
                System.out.print(map[i][j] + "|");
            }
            System.out.println();
        }

    }

    private static void playerStep() {                                // (3) - ХОД ИГРОКА
        int x = -1;
        int y = -1;
        do {
            System.out.println("Введите координаты: Столбец № (от 1 до " + size_X + ")");
            if (scanner.hasNext()) {
                x = scanner.nextInt() - 1;
            }
            System.out.println("Введите координаты: Строка № (от 1 до " + size_Y + ")");
            if (scanner.hasNext()) {
                y = scanner.nextInt() - 1;
            }
            scanner.nextLine();
        } while (!isValid(y, x));
        map[y][x] = player_DOT;

    }

    private static boolean isValid(int x, int y) {                    // (4) - ОПРЕДЕЛЕНИЕ ЗАНЯТОСТИ КЛЕТКИ ДЛЯ ХОДА
        if (x < 0 || y < 0 || x > size_X || y > size_Y) {
            return false;
        }
        return map[x][y] == empty_DOT;

    }

    private static void compStep() {                                  // (5) - ХОД КОМПЬЮТЕРА
        Random random = new Random();
        int x;
        int y;
        do {
            x = random.nextInt(size_X);
            y = random.nextInt(size_Y);
        } while (!isValid(y, x));
        map[y][x] = comp_DOT;

    }

    private static boolean checkDraw() {                              // (6) - РОВЕРКА НА НИЧЬЮ
        for (int i = 0; i < size_Y; i++) {
            for (int j = 0; j < size_X; j++) {
                if (map[i][j] == empty_DOT) {
                    return false;
                }
            }
        }
        return true;

    }                                                                 // (7) - ПРОВЕРКА НА ПОБЕДУ

    public static boolean checkWin(char c) {
        int countX = 0, countY = 0, countL = 0, countR = 0, subRightDiag = 0, subRightDiag1 = 0, subLeftDiag = 0, subLeftDiag1 = 0;

        for (int i = 0; i < map.length; i++) {
            for (int j = 0; j < map[i].length; j++) {
                if (map[i][j] == c) {                                                         // стороки
                    countX++;
                }
                if (countX == 4) {
                    return true;
                }
                if (map[i][j] == empty_DOT && countX < 4) {
                    countX = 0;
                }
                if (map[j][i] == c) {                                                         // столбцы
                    countY++;
                }
                if (countY == 4) {
                    return true;
                }
                if (map[j][i] == empty_DOT && countY < 4) {
                    countY = 0;
                }
                if (i == j && map[i][j] == c) {                                               // средняя левая
                    countR++;
                }
                if (i == j && map[i][j] == empty_DOT && countR < 4) {
                    countR = 0;
                }
                if (countR == 4) {
                    return true;
                }
                if (j == map.length - i - 1 && map[i][j] == c) {                              // средняя правая
                    countL++;
                }
                if (j == map.length - i - 1 && map[i][j] == empty_DOT && countL < 4) {
                    countL = 0;
                }
                if (countL == 4) {
                    return true;
                }
                if (j == i + 1 && map[i][j] == c) {                                          // верхняя левая
                    subRightDiag++;
                }
                if (subRightDiag == 4) {
                    return true;
                }
                if (j == i + 1 && map[i][j] == empty_DOT) {
                    subRightDiag = 0;
                }
                if (i == j + 1 && map[i][j] == c) {                                           // нижняя левая
                    subRightDiag1++;
                }
                if (subRightDiag1 == 4) {
                    return true;
                }
                if (i == j + 1 && map[i][j] == empty_DOT) {
                    subRightDiag1 = 0;
                }
                if (j == map[i].length - 2 - i && map[i][j] == c) {                           // верхняя правая
                    subLeftDiag++;
                }
                if (subLeftDiag == 4) {
                    return true;
                }
                if (j == map[i].length - 2 - i && map[i][j] == empty_DOT) {
                    subLeftDiag = 0;
                }

                if(j == 1 + map[i].length - 1 - i && map[i][j] == c){                        // нижняя правая
                    subLeftDiag1++;
                }
                if(subLeftDiag1 == 4){
                    return true;
                }
                if (j == 1 + map[i].length - 1 - i && map[i][j] == empty_DOT) {
                    subLeftDiag1 = 0;
                }
            }
            countX = countY = 0;
        }return false;

    }
}
