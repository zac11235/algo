package P1;

import java.util.Scanner;

public class joseph extends CircularLinkedList{





    public static void main(String[] args) {

        Scanner sc=new Scanner(System.in);
        System.out.println("请输入总人数");
        int n=sc.nextInt();
        System.out.println("请输入数字");
        int m=sc.nextInt();
        joseph(n, m);
    }
    /**
     * @param n 总人数
     * @param m 数到几出列
     */
    public static void joseph(int n, int m) {

        CircularLinkedList c = new CircularLinkedList();
        for (int i = 1; i <= n; i++)
            c.add("person-" + i);
        CircularLinkedList.Node per = c.getHead();
        while (c.getSize() > 1) {
            for (int i = 0; i < m-1; i++) {
                per = per.next;
                //循环到head，指针多下移一步。
                if (per==c.getHead())
                    per = per.next;
            }
            c.pre =per;
            c.deleteNode();
//            c.deleteNode(per.value);//删除当前值节点
//            per=c.curr;
            c.disPlay();
        }
    }
}
