public class Text {


    public static void main(String[] args) {
        isOne();
//        isTwo();
//        isFree();

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
}
