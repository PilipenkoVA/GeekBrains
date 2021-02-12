public class Lesson {


    public static void main(String[] args) {

//        1 задание:

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

        int[] two = new int[8];
        for (int i = 0; i < two.length; i++) {
            two[i] = i * 3;
        }
        System.out.println();

        for (int i = 0; i < two.length; i++) {
            System.out.print(two[i] + "  ");
        }

        // 3 задание:

        int[] three = {1, 5, 3, 2, 11, 4, 5, 2, 4, 8, 9, 1};
        System.out.println();
        for (int i = 0; i < three.length; i++) {
            if (three[i] < 6) {
                three[i] *= 2;
            }
            System.out.print(three[i] + " ");
        }

        // 4 задание:

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

}
