package P3;

import P2.Linqueue;
import java.util.Random;
import java.util.Scanner;

public class Bag {
    Linqueue bag=new Linqueue();
    int num=0;
    public boolean knapsack(int[] arr, int start, int left, int sum) throws Exception {
        int t=0;
        if (arr.length == 0&&num==0) {
            return false;
        }
        if (arr.length == 0&&num>0)
            return true;

        // start from the next item in original array
        if (start == arr.length) {
            bag.dAll();
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
                // print the answer out
            bag.append(arr[start]);
            //可求不同首重物品的多解
            num++;
            System.out.println("第"+num+"解如下");
            bag.out_d_All();
            System.out.println();

            return knapsack(arr, arr.length, sum, sum);
        }
        else {
            bag.append(arr[start]);
            return knapsack(arr, start + 1, left - arr[start], sum);
        }
    }

    public static void bubbleSort2(int[] a, int n) {
        if (n <= 1) return;

        // 最后一次交换的位置
        int lastExchange = 0;
        // 无序数据的边界,每次只需要比较到这里即可退出
        int sortBorder = n - 1;
        for (int i = 0; i < n; i++) {
            // 提前退出标志位
            boolean flag = false;
            for (int j = 0; j < sortBorder; j++) {
                if (a[j] > a[j + 1]) {
                    int tmp = a[j];
                    a[j] = a[j + 1];
                    a[j + 1] = tmp;
                    // 此次冒泡有数据交换
                    flag = true;
                    // 更新最后一次交换的位置
                    lastExchange = j;
                }
            }
            sortBorder = lastExchange;
            if (!flag) break;    // 没有数据交换，提前退出
        }
    }
        public static void main(final String[] args) throws Exception {
            Random random = new Random();
            Scanner sc=new Scanner(System.in);
            System.out.println("请输入背包容量");
            int s=sc.nextInt();
            System.out.println("请输入物品数量");
            int n=sc.nextInt();
            System.out.println("请输入物品质量上限");
            int max=sc.nextInt();
            int min=1;
            int[] arr = new int[n];
            System.out.println("随机产生的"+n+"个物品的重量如下：");
            for (int i=0;i<n;i++) {
                arr[i]=random.nextInt(max)%(max-min+1) + min;
                System.out.print(" "+arr[i]);
            }
            bubbleSort2(arr,n);
            int[] temp=new int[n];
            int j=0;
            for (int i=n-1;i>-1;i-- ) {
                temp[j]=arr[i];
                j++;
            }
            arr=temp;
            System.out.println();
            System.out.println("排序后");
            for (int a:arr
                 ) {
                System.out.print(" "+a);
            }
            System.out.println();

/*测试数据
            int s=15;
            int[] arr = new int[5];
            arr[0] = 4;
            arr[1] = 11;
            arr[2] = 10;
            arr[3] = 2;
            arr[4] = 3;
*/
            Bag k = new Bag();
           boolean flag= k.knapsack(arr, 0, s, s);
            if (!flag)
                System.out.println("无解");


        }
}

