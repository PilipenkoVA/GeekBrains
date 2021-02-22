import java.util.Random;
import java.util.Scanner;

public class Lesson {

    private static int size_X = 5;                              // РАЗМЕРЫ ПОЛЯ (СТОЛБЦЫ)
    private static int size_Y = 5;                              // РАЗМЕРЫ ПОЛЯ (СТРОКИ)
    private static char empty_DOT = '.';
    private static char player_DOT = 'X';
    private static char comp_DOT = '0';

    private static Scanner scanner;
    private static char[][] map = new char[size_Y][size_X];     // СОЗДАЕМ ПОЛЕ ПО УКАЗАННЫМ НАМИ РАЗМЕРАМ

    public static void main(String[] args) {
        initField();
        printField();

        while (true){
            playerStep();
            printField();
            System.out.println();

            compStep();
            printField();
            System.out.println();

            if (checkDraw()){
                System.out.println("Игра закончена (Нет свободных ходов)");
                break;
            }

            try {
                Thread.sleep(1000);
            }catch (InterruptedException ignored){
            }

        }



    }
    private static void initField(){                              // (1) - "ИНИЦИАЛИЗАЦИЯ ПОЛЯ"
        scanner = new Scanner(System.in);                         // (старт) сканера
        for (int i = 0; i < size_Y; i++){
            for (int j = 0; j < size_X; j++){
                map[i][j] = empty_DOT;
            }
        }
    }
    private static void printField() {                            // (2) - "ПРОРИСОВКА ПОЛЯ"
        for (int i = 0; i < size_Y; i++) {                        // (строки)
            System.out.print("|");                                // палочка перед каждой (строкой)
            for (int j = 0; j < size_X; j++) {                    // (столбцы)
                System.out.print(map[i][j] + "|");                // палочка в каждом (столбце)
            }
            System.out.println();                                 // если не будет то все напечатается в одну строку
        }                                                         // т.к. есть 'ln' и печать переходит на новую строку

    }
    private static void playerStep(){                             // (3) - "ХОД ИГРОКА"
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
        map [y][x] = player_DOT;

    }
    private static boolean isValid (int x, int y){                 // (4) - "ОПРЕДЕЛЯЕМ ВОЗМОЖНОСТЬ ОСУЩЕСТВЛЕНИЯ ХОДА"
        if (x < 0 || y < 0 || x > map.length || y > map.length) {
            return false;
        }
        return map[x][y] == empty_DOT;

    }
    private static void compStep(){                                // (5) - "ХОД КОМПЬЮТЕРА"
        Random random = new Random();
        int x;
        int y;
        do{
            x = random.nextInt(size_X);
            y = random.nextInt(size_Y);
        }while (!isValid(y, x));
        map [y][x] = comp_DOT;

    }
    private static boolean checkDraw() {                          // (6) - "ПРОВЕРКА НА НИЧЬЮ"
        for (int i = 0; i < size_Y; i++) {
            for (int j = 0; j < size_X; j++) {
                if (map[i][j] == empty_DOT){                       // если на поле есть пустые места (продолжаем игру)
                    return false;
                }
            }
        }
        return true;                                               // если на поле нет пустых мест (конец игры "НИЧЬЯ")

    }
    private static void checkWIN(char dot){                        // (7) - ПРОВЕРКА ПОБЕДЫ
        for (int i = 0; i < 3; i++)
            if ((table[i][0] == dot && table[i][1] == dot && table[i][2] == dot) || (table[0][i] == dot && table[1][i] == dot && table[2][i] == dot)){
                return true;
            }esle {
            ((table[0][0] == dot && table[1][1] == dot && table[2][2] == dot) || (table[2][0] == dot && table[1][1] == dot && table[0][2] == dot));
            return true;
            }
        }
        return false;

    }

}

