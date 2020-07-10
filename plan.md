# 数据结构课设
- ---
## 课设要求：
1. 问题分析 
充分地分析和理解问题本身，弄清要求做什么，包括功能要求、性能要求、设计要求和约束以及基
本数据特性、数据间的联系等。 

2. 数据结构设计 
针对要求解决的问题，考虑各种可能的数据结构，并且力求从中给出最佳方案(必须连同算法一起考
虑)。对确定的主要数据结构给出详细的描述。

3. 算法设计（一律用面向对象的 java 描述） 
算法设计是一项最困难的工作。算法设计分概要设计和详细设计。概要设计主要指数据元素的数据
结构及抽象数据类型设计；详细设计则主要是每个模块 (函数)的实现代码设计，包括算法的设计思想、
边界约束条件以及输入、处理和输出。算法设计(主要指实现代码)时要充分考虑算法的效率问题，即时
间复杂度问题。 

4. 测试用例设计 
编写测试程序，准备典型测试数据和测试方案。测试数据要有代表性、敏感性。 

5. 上机调试 
对程序进行编译，纠正程序中可能出现的语法错误。测试前，先运行一遍程序看看究竟将会发生什
么，如果错误较多，则应根据事先设计的测试方案并结合现场情况进行错误跟踪。 
相对来说，纠正程序中可能出现的语法错误比较容易，而纠正程序中的逻辑性错误则比较困难。 
- ---
#### ·课程设计的组织形式 
 一人一组，独立完成规定的设计题目，并独立完成自己的课程设计报告
 
 - --
#### ~课设报告内容
1. 问题描述：指问题的简要描述或介绍。 
2. 设计：
    1. 概要设计： 数据结构即抽象数据类型设计（包括：数据对象及其抽象数据类型；操作集合以及
 每项操作的边界约束条件）； 
    2. 详细设计：主要功能模块（函数）的设计思想及代码实现设计，即给出抽象数据类型的操作实
 现（首先决定采用何种物理存储结构）;
3. 测试：测试程序设计及测试范例数据设计；对测试结果的分析与讨论，测试过程中遇到的主要问题
 及所采用的解决措施。
4. 使用说明和设计小结：
    1. 使用说明主要描述如何使用你的程序以及使用时的注意事项； 
    2. 在小结中说明程序有待改进的思想、经验和体会。
- ---
## 选题
- 题目：1,2,4,**7**,8,9,10
- 可选做：11 or 12 5分

## 时间计划
- 7.6--7.19 两周 7个题目
- 第一周 7.6-7.12 题目：1,2,4,8
- 第二周 7.13-7.19 题目 7,9,10

## 资料
1. 教材
2. Github
3. 微信电子图书
4. 百度
- --
## 题目 ##
- --
#### 题目 1 循环单链表应用
- 题目：求解约瑟夫（Josephus）问题 
- 【问题描述】： 
* 有一个旅行社要从 n 个旅客中选出一名旅客，为他提供免费的环球旅行服务。旅行社安排这些旅客
围成一个圆圈，并从帽子中取出一张纸条，用纸条上面写的正整数 m（m<n）作为报数值。游戏进行时，
从第一个人开始按顺时针方向自 1 开始顺序报数，当报到 m 时停止报数，报 m 的人被淘汰出列。然后从
他顺时针方向上的下一个人开始从 1 重新报数，当再次报到 m 时停止报数，报 m 的人被淘汰出列。如此
下去，直到圆圈中剩下一个人为止。这个最后的幸存者就是游戏的胜利者，他将得到免费旅行的奖励。
请让计算机模拟此问题。 【实现提示】： 
采用循环单链表实现。

#### 解题思路

1. 设计概要：
    1. 两个参数，旅客数量n,整数m。循环寻找，选中delete，人数为1时，跳出循环，返回剩余数据的编号。
    2. 采用单链表的数据结构
2. 详细设计
    1. 采取链式存储结构，设计了结点类，链表类，还有实现类。链表类包含有添加，删除，查询，显示等功能模块。
    主要的设计部分为添加与删除。
    2. 设计思想
    * 链表中使用指针进行循环删除，直至链表中仅剩1个非头结点，跳出循环。
    3. 代码
        1. 添加
       ```java
            
       public class CircularLinkedList {
       //    public void setHead(String s) {
       //       head.value=s;
       //    }
           Node pre =null;
           //java中循环单链表
        class Node<T> {
               public Node<T> getNext() {
                   return next;
               }
       
               //创建一个内部节点类
               public Node<T> next = null;
               public Object value = null;
       
               public Node() {
       
               }
       
               public Node(Object value) {
                   this.value = value;
               }
           }
       
           public Node getHead() {
               return head;
           }
       
           public void setHead(Node head) {
               this.head = head;
           }
       
           private Node head ;//新建一个null的头结点
       
           public CircularLinkedList() {//初始化头结点信息
               head = pre = new Node(null);
               head.next = head;
           }
       
           public void add(Object insertValue) {//在尾部添加节点
               Node node = new Node(insertValue);
               if (head.next == head) {
                   head.next = node;
                   node.next = head;
               } else {
                   Node temp = head;
                   while (temp.next != head) {
                       temp = temp.next;
                   }
                   temp.next = node;
                   node.next = head;
               }
           }
       
           public void deleteNode(Object deleteValue) {//删除值为deleteValue的节点
               Node temp = head;
               while (temp.next != head) {
                   if (temp.next.value.equals(deleteValue)) {
                       temp.next = temp.next.next;
                   } else {
                       temp = temp.next;
                   }
               }
           }
       //删除当前节点，连接下一结点
           public void deleteNode() {//删除值为deleteValue的节点、
               if (pre.next!=head)
                   pre.next=pre.next.next;
       //            pre= pre.next.next;pre并非是是指向pre的指针，而是pre的地址
               else pre.next.next= pre.next.next.next;
       
           }
       
       
           public Object getIndexValue(int index) {//查找位置为index的节点值
               if (index < 0 || index >= getSize()) {
                   return null;
               } else {
                   Node node = new Node();
                   int count = 0;
                   Node temp = head;
                   while (temp.next != head) {
                       if (count == index) {
                           node.value = temp.next.value;
                           break;
                       }
                       temp = temp.next;
       
                   }
                   return node.value;
               }
           }
       
           public int getValue(Object value) {//查找值为value的节点
               int count = 0;
               Node temp = head;
               while (temp.next != head) {
                   if (temp.next.value.equals(value)) {
                       return count;
                   }
                   count++;
                   temp = temp.next;
               }
               return -1;
           }
       
           public int getSize() {//获取循环单链表的长度
               Node temp = head;
               int size = 0;
               while (temp.next != head) {
                   size++;
                   temp = temp.next;
               }
               return size;
           }
       
           public boolean isContain(Object value) {//查找是否包含值为value的节点
               Node temp = head;
               while (temp.next != head) {
                   if (temp.next.value.equals(value)) {
                       return true;
                   }
                   temp = temp.next;
               }
               return false;
           }
       
           public void disPlay() {//打印所有节点数据
               Node temp = head;
                   while (temp.next != head) {
                       System.out.print(temp.next.value + "\t");
                       temp = temp.next;
               }
               System.out.println();
           }
       
           public static void main(String[] args) {
               CircularLinkedList c=new CircularLinkedList();
               c.add(10);
               c.add(21);
               c.add(12);
               c.add(13);
               c.add(40);
               c.disPlay();
       //		System.out.println(c.getSize());
       //		System.out.println(c.getIndexValue(-1));
       //		System.out.println(c.getValue(40));
       //		c.deleteNode(10);
       //		c.disPlay();
       //		c.deleteNode(40);
       //		c.disPlay();
       //		c.deleteNode(12);
       //		c.disPlay();
               System.out.println(c.isContain(21));
           }
       }

```
        1. 删除设计
``` java
    public void deleteNode(Object deleteValue) {//删除值为deleteValue的节点
                 Node temp = head;
                 while (temp.next != head) {
                     if (temp.next.value.equals(deleteValue)) {
                         temp.next = temp.next.next;
                     } else {
                         temp = temp.next;
                     }
                 }
             }
         //删除当前节点，连接下一结点
             public void deleteNode() {//删除值为deleteValue的节点、
                 if (pre.next!=head)
                     pre.next=pre.next.next;
         //            pre= pre.next.next;pre并非是是指向pre的指针，而是pre的地址
                 else pre.next.next= pre.next.next.next;
         
             }
```
- --
```
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
```
>-----
[哈工大](http://www.hit.edu.cn/) ,一个你值得去好好学习的学校

 