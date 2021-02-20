public class Lesson {


    public static void main(String[] args) {

        // 1 задание:
        // Задать целочисленный массив, состоящий из элементов 0 и 1. Например: [ 1, 1, 0, 0, 1, 0, 1, 1, 0, 0 ].
        // С помощью цикла и условия заменить 0 на 1, 1 на 0;

        int[] one = {1, 1, 0, 0, 0, 1, 1};
        for (int i = 0; i < one.length; i++) {
            if (one[i] == 1) {
                one[i] = 0;
            } else {
                one[i] = 1;
            }
            System.out.print(one[i] + " ");
        }

        // 2 задание:
        // Задать пустой целочисленный массив размером 8. С помощью цикла заполнить его значениями 0 3 6 9 12 15 18 21;

        int[] two = new int[8];
        for (int i = 0; i < two.length; i++) {
            two[i] = i * 3;
        }
        System.out.println();

        for (int i = 0; i < two.length; i++) {
            System.out.print(two[i] + "  ");
        }

        // 3 задание:
        // Задать массив [ 1, 5, 3, 2, 11, 4, 5, 2, 4, 8, 9, 1 ] пройти по нему циклом, и числа меньшие 6 умножить на 2;

        int[] three = {1, 5, 3, 2, 11, 4, 5, 2, 4, 8, 9, 1};
        System.out.println();
        for (int i = 0; i < three.length; i++) {
            if (three[i] < 6) {
                three[i] *= 2;
            }
            System.out.print(three[i] + " ");
        }

        // 4 задание:
        // Создать квадратный двумерный целочисленный массив (количество строк и столбцов одинаковое)
        // и с помощью цикла(-ов) заполнить его диагональные элементы единицами;

        System.out.print("\r\n");// строка прописана для пробела т.к. массив соединяется с преведущим из-за чего не получается куб

        int four[][] = new int[5][5];
        for (int i = 0; i < four.length; i++) {
            for (int j = 0; j < four[i].length; j++) {
                if (i == j || j == four[i].length - 1 - i) {
                    four[i][j] = 1;
                }
                System.out.print(four[i][j] + " ");
            }
            System.out.println();
        }


        // 5 задание:
        // Задать одномерный массив и найти в нем минимальный и максимальный элементы (без помощи интернета);

        int[] five = {7, 1, 3, 8, 5, 2};
        int Max = five.length;
        for (int i = 0; i < five.length; i++) {
            int arr = five[i];
            for (int j = 0; j < five.length; j++) {
                if (arr > five[j] && arr > Max){
                    Max = arr;
                }
            }
        }
        System.out.print("Answer to task five: Max = "+ Max);

        System.out.print("\r\n");// строка прописана для пробела т.к. массив соединяется с преведущим

        int Min = five.length;
        for (int i = 0; i < five.length; i++) {
            int arr = five[i];
            for (int j = 0; j < five.length; j++) {
                if (arr < five[j] && arr < Min){
                    Min = arr;
                }
            }
        }System.out.print("Answer to task five: Min = "+ Min);


        // 6 задание:
        // ** Написать метод, в который передается не пустой одномерный целочисленный массив, метод должен вернуть true,
        // если в массиве есть место, в котором сумма левой и правой части массива равны.
        // Примеры: checkBalance([2, 2, 2, 1, 2, 2, || 10, 1]) → true, checkBalance([1, 1, 1, || 2, 1]) → true,
        // граница показана символами ||, эти символы в массив не входят.

        System.out.print("\r\n"); // строка прописана для пробела т.к. массив соединяется с преведущим

        int[] six = {1, 1, 1, 2, 1};
        System.out.println("Answer to task six = " + checkBalance(six));
    }

    private static boolean checkBalance(int[] arr) {
        int leftSum, rightSum;
        for (int i = 0; i < arr.length + 1; i++) {
            leftSum = 0;
            rightSum = 0;
            for (int j = 0; j < i; j++) {
                leftSum += arr[j];
            }
            for (int j = i; j < arr.length; j++) {
                rightSum += arr[j];
            }
            if (leftSum == rightSum) return true;
        }
        return false;
    }
    // 7 задание:
    // **** Написать метод, которому на вход подается одномерный массив и число n (может быть положительным,
    // или отрицательным), при этом метод должен сместить все элементы массива на n позиций.
    // Элементы смещаются циклично. Для усложнения задачи нельзя пользоваться вспомогательными массивами.
    // Примеры: [ 1, 2, 3 ] при n = 1 (на один вправо) -> [ 3, 1, 2 ];
    // [ 3, 5, 6, 1] при n = -2 (на два влево) -> [ 6, 1, 3, 5 ].
    // При каком n в какую сторону сдвиг можете выбирать сами
}
