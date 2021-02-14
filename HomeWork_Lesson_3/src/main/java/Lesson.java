import java.util.Scanner;

public class Lesson {

    private static Scanner scanner = new Scanner(System.in);
    public static void main(String[] args) {

        // 1 задание:

        System.out.println("Ваша задача угадать число");
        playLevel();
        scanner.close();

    }
    private static void playLevel (){
        int n = 3;
        int range = 9;
        int number = (int) (Math.random() * range);
        while (n > 0){
            System.out.println("Угадайте число от 0 до " + range);
            System.out.println("У вас  " + n + " попытки");
            int input_number = scanner.nextInt();
            if (input_number == number){
                System.out.println("Вы угадали");
            }else if (input_number < number){
                System.out.println("Данное число меньше");
                n--;
            }else {
                System.out.println("Данное число больше");
                n--;
            }if (n == 0 || input_number == number){
                int a = 0;
                int b = 1;
                System.out.println("THE END");
                System.out.println("Повторить игру еще раз? 1 – да / 0 – нет");
                int input_level = scanner.nextInt();
                if (input_level == a){
                    break;
                }else {
                    n = 3;
                }
            }
        }
    }
}
