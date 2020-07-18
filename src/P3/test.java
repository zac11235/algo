package P3;

import java.util.Scanner;

public class test {
    public static void main(final String... args) {
//        int[] arr = new int[5];
//        arr[0] = 11;
//        arr[1] = 30;
//        arr[2] = 1;
//        arr[3] = 1;
//        arr[4] = 3;
//        test k = new test();
//        boolean flag=k.knapsack(arr, 0, 16, 16);
//        System.out.println(flag);
        Scanner sc=new Scanner(System.in);

        String n = "";

        for (int i=0;i<26;i++){
           n=n+"\'"+sc.next()+"\'"+",";
        }
        System.out.println(n);
    }

    /**
     *@param arr    all of items in knapsack
     *@param start  the start item to be put into the knapsack
     *@param left   the remaining capacity of knapsack
     *@param sum    capacity of knapsack
     */
    public boolean knapsack(int[] arr, int start, int left, int sum) {

        if (arr.length == 0) {
            return false;
        }

        // start from the next item in original array
        if (start == arr.length) {
            int[] tempArr = new int[arr.length - 1];
            for (int i = 0; i < tempArr.length; i++) {
                tempArr[i] = arr[i + 1];
            }
            return knapsack(tempArr, 0, sum, sum);
        }
        else if (arr[start] > left) {
            return knapsack(arr, start + 1, left, sum);
        }
        else if (arr[start] == left) {
            for (int i = 0; i < start + 1; i++) {
                // print the answer out
                System.out.print(arr[i] + "\t");
            }
            System.out.println();
            return true;
        }
        else {
            return knapsack(arr, start + 1, left - arr[start], sum);
        }
    }
}
