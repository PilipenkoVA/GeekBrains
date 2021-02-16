public class Text {


    public static void main(String[] args) {
        isOne();
//        isTwo();
//        isFree();

    }
    private static void isOne() {
        int[] arr = new int[5];
        int[] arr = {3, 2, 6};

        for (int i = 0; i < arr.length; i++) {
            for (int j = 0; j < arr.length ; j++) {
                arr[i] = 1;
                System.out.print(arr[i][j] + "  ");
            }
        }

    }

    private static void isTwo(){                       // ПРИМЕР: "Многомеоного массива"
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

        for (int i = 0; i < arr.length; i++) {    // Прописываем условие массива еще раз
            arr[i] = i + 1;                       // задаем значение индексам
        }
        System.out.println();                     // Для разделения массивов

        for (int i = 0; i < arr.length; i++) {
            System.out.print(arr[i] + " ");       // Выводим на консоль со значениями (главное находится в "for")
        }
    }
}
