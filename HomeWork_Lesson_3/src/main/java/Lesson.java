import java.util.Scanner;

public class Lesson {

    private static Scanner scanner = new Scanner(System.in);
    public static void main(String[] args) {
        System.out.println("Ваша задача угадать число");
        int range = 9;
        int number = (int) (Math.random() * range);



    }
    private static void playLevel (int range, int number){
        while (true){
            System.out.println("Угадайте число от 0 до " + range);
        }
    }
}
