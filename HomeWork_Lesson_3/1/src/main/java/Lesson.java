import java.util.Random;
import java.util.Scanner;

public class Lesson {

    private static Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) {

        playLevelOne();
//        playLevelTwo();
        scanner.close();

    }
    // Игра №1 "Угадай число":

    private static void playLevelOne (){
        System.out.println("Ваша задача угадать число");
        int round = 3;
        int range = 9;
        int number = (int) (Math.random() * range);
        while (round > 0){
            System.out.println("Угадайте число от 0 до " + range);
            System.out.println("У вас  " + round + " попытки");
            int input_number = scanner.nextInt();
            if (input_number == number){
                System.out.println("Вы угадали");
            }else if (input_number < number){
                System.out.println("Загаданное число больше");
                round--;
            }else {
                System.out.println("Загаданное число меньше");
                round--;
            }if (round == 0 || input_number == number){
                System.out.println("THE END");
                // запускаем повтор игры
                int not = 1;
                int yes = 2;
                System.out.println("Повторить игру еще раз? 1 – NO / 2 – YES");
                int input_level = scanner.nextInt();
                if (input_level == yes){
                    playLevelOne();
                }else {
                    return;
                }
            }
        }
    }
    // Игра №2 "Угадай слово":

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
                return;
            }
            char[] charsAnswer = answer.toCharArray();     // из введенного слова делаем массив для проведения посимвольной проверки
            for (int i = 0; i < lenWord; i++) {
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
