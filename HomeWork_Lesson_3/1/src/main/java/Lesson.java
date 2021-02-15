import java.util.Random;
import java.util.Scanner;

public class Lesson {

    private static Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) {

        playLevelOne();
//        playLevelTwo();
        scanner.close();

    }
    // 1 задание:

    private static void playLevelOne (){
        System.out.println("Ваша задача угадать число");
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
                    playLevelOne();
                }
            }
        }
    }
    // 2 задание:

    private static void playLevelTwo(){
        String[] words = {"apple", "orange", "lemon", "banana", "apricot", "avocado", "broccoli", "carrot", "cherry",
                "garlic", "grape", "melon", "leak", "kiwi", "mango", "mushroom", "nut", "olive", "pea", "peanut",
                "pear", "pepper", "pineapple", "pumpkin", "potato"};
        //загадаем слово из массива
        Random random = new Random();
        int indWord = random.nextInt(words.length - 1);
        String word = words[indWord];
        int lenWord = word.length();
        System.out.println("Я загадал слово, попробуй отгадать его");
        //System.out.println(word); Что бы увидеть загаданное слово введи команду.

        do {
            System.out.println("Введи свой ответ: (для выхода из игры, просто нажмите Enter)");
            String answer = scanner.nextLine();

            if (answer.equals("")){
                break;
            }else if (word.equals(answer)) {
                System.out.println("Вы угадали слово, игра закончена!!!");
                break;
            }
            char[] charsAnswer = answer.toCharArray();     // из введенного слова делаем массив для проведения посимвольной проверки
            for (int i = 0; i < lenWord; i++) {            //  условие массива (определяем количество символов в загаданном слове
                if (i >= charsAnswer.length) {
                    break;
                }if (word.charAt(i) != charsAnswer[i]){    // сравниваем слова посимвольно
                    charsAnswer[i] = '#';                  // если символ не совпал производие его замену на символ "#"
                }

            }
            String masAnswer = new String(charsAnswer);    //   получаем массив после сравнения слов
            StringBuffer sb = new StringBuffer(masAnswer); //   преабразуем массив в строку
            sb = new StringBuffer(sb);
            System.out.println(sb.replace(2, 14, "#############")); // открываем первые 2 буквы если совпали, а далее производим замену символов на "#"
        }
        while (true);

    }


}
