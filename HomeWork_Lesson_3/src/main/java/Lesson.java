import java.util.Scanner;

public class Lesson {

    private static Scanner scanner = new Scanner(System.in);
    public static void main(String[] args) {

        // 1 задание:

        System.out.println("Ваша задача угадать число");
        int range = 9;
        int number = (int) (Math.random() * range);
        playLevel(range, number);
        scanner.close();

    }
    private static void playLevel (int range, int number){
        int n = 3;
        while (n > 0){
            System.out.println("Угадайте число от 0 до " + range);
            int input_number = scanner.nextInt();
            if (input_number == number){
                System.out.println("Вы угадали");
                break;
            }else if (input_number < number){
                System.out.println("Данное число меньше");
                n--;
            }else {
                System.out.println("Данное число больше");
                n--;
            }
        }
    }
//  НЕ ХВАТАЕТ :После победы или проигрыша выводится запрос – «Повторить игру еще раз? 1 – да / 0 – нет»(1 – повторить, 0 – нет).
//  Программа в данный момент дает только три попытки для ввода, необходимо дать возможность Повторить игру
}
