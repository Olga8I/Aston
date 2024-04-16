package lesson_1;

public class Main {
    public static void main(String[] args) {
        Tasks.printThreeWords();//1
        Tasks.checkSumSign();//2
        Tasks.printColor();//3
        Tasks.compareNumbers();//4

        System.out.println(Tasks.isSumInRange(22, 6));//5
        System.out.println(Tasks.isSumInRange(8, 2));
        System.out.println(Tasks.isSumInRange(15, 5));

        Tasks.checkNumber(5);//6
        Tasks.checkNumber(-10);
        Tasks.checkNumber(0);

        System.out.println(Tasks.isNegative(-5));//7

        Tasks.printString("Hello, World!",3);//8

        System.out.println(Tasks.leapYear(2020));//9

        int[] arr = {1, 1, 0, 0, 1, 0, 1, 1, 0, 0};//10
        Tasks.invertArray(arr);

        int[] arr1 = new int[100];//11
        Tasks.fillArray(arr1);

        int[] arr2 = {1, 5, 3, 2, 11, 4, 5, 2, 4, 8, 9, 1};//12
        Tasks.multiplyNum(arr2);

        Tasks.fillDiagonal(5);//13

        Tasks.printArray(Tasks.createArray(4, 8));//14
    }
}
