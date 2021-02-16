public class Text {


    public static void main(String[] args) {
//        isOne();
//        isTwo();
//        isFree();
        isFour();

    }
    private static void isOne() {                        // ПРИМЕР: "Многомеоного массива с разными значениями"
        int[][] arr = new int[5][5];                     // Создаем массивы

        for (int i = 0; i < arr.length; i++) {
            for (int j = 0; j < arr[i].length ; j++) {
                                                             // Определяем взаимосвязь i от j для прописывания услови (что мы хотим получить)
                if (i == j || j == arr[i].length - 1 - i) {  // Если (i == j)  или (j == ширине i - 1 + i)
                    arr[i][j] = 1;                           // ставим "1"
                }
                System.out.print(arr[i][j] + " ");

            }
            System.out.println();
        }
    }

    private static void isTwo(){                       // ПРИМЕР: "Многомеоного массива с одинаковыми значениями"
        int[][] foo = new int[10][10];                 // Создаем массивы

        for (int i = 0; i < foo.length; i++){          // Прописываем условие массива №1
            for (int j = 0; j < foo[i].length; j++){   // Прописываем условие массива №2
                foo[i][j] = 1;                         // задаем значение индексам
                System.out.print(foo[i][j] + " ");
            }
            System.out.println();                      // Если не пропечатать 1 - "все будет в одной строке"
                                                       // Если пропечатать    2 - "получится квадрат"
        }
    }
    private static void isFree(){                 // ПРИМЕР: "Одномерного массива"
        int [] arr = new int[10];                 // Создаем массив

        for (int i = 0; i < arr.length; i++) {    // Прописываем условие массива
            System.out.print(arr[i] + " ");       // Выводим пустой массив с "null-ми" если (print-печатается вправо)
                                                  //                                        (println-напечатается вниз)
        }

        for (int i = 0; i < arr.length; i++) {    // Прописываем условие нашего массива еще раз если хотим задать ему значения
            arr[i] = i + 1;                       // задаем значение индексам
        }
        System.out.println();                     // Для разделения первого и второго массивов (ПРОБЕЛ) иначе "все будет в одной строке"

        for (int i = 0; i < arr.length; i++) {
            System.out.print(arr[i] + " ");       // Выводим на консоль со значениями (главное находится в "for")
        }
    }
    private static void isFour() {                                  // ПРИМЕР: "Определяем "MAX" и "MIN" значение в массиве"
        int[] arr5 = {5, 7, 3, 1, 9, 6, 4, 2, 8};
        int min = arr5[0], max = arr5[0], indMax = 0, indMin = 0;   // Прописываем переменные ("min", "max", "indMax", "indMin")

        for (int i = 0; i < arr5.length; i++) {                     // Пропичываем условие массива

            if (arr5[i] > max) {                                    // Если: значение индекса [i] в массиве MAX (т.е. максимальное)
                max = arr5[i];                                      // Значит: "max" будет == этому (значению индекса [i])
                indMax = i;                                         // а так же "indMax" будет == этому (индексу [i])
            }
            if (arr5[i] < min) {                                    // Если: значение индекса [i] в массиве MIN (т.е. максимальное)
                min = arr5[i];                                      // Значит: "min" будет == этому (значению индекса [i])
                indMin = i;                                         // а так же "indMin" будет == этому (индексу [i])
            }
        }
        System.out.println("Максимальный элемент находится в массиве под индексом " + indMax + " со значением  = " + max);
        System.out.println("Минимальный элемент находится в массиве под индексом " + indMin + " со значением  = " + min);
    }
    
}
