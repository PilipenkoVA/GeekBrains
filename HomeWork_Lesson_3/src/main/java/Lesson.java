import java.util.Scanner;

public class Lesson {

    private static Scanner scanner = new Scanner(System.in);
    public static void main(String[] args) {
        System.out.println("Ваша задача угадать число");
        int range = 9;
        int number = (int) (Math.random() * range);
        playLevel(range, number);

        scanner.close();

    }
    private static void playLevel (int range, int number){
        while (true){// Заменить бесконечный цикл на 3 попытки
            System.out.println("Угадайте число от 0 до " + range);
            int input_number = scanner.nextInt();
            if (input_number == number){
                System.out.println("Вы угадали");
                // заменить на бесконечный цикл игр но с выводом сообщение "Выхотите продолжить игру" (да)(нет)
                break;
            }else if (input_number < number){
                System.out.println("Данное число меньше");
            }else {
                System.out.println("Данное число больше");
            }
        }
    }
}
