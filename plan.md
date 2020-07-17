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

### 时间计划
- 7.6--7.19 两周 7个题目
- 第一周 7.6-7.12 题目：1,2,4,8
- 第二周 7.13-7.19 题目 7,9,10

### 资料
1. 教材
2. Github
3. 微信电子图书
4. 百度
### 程序设计步骤
程序设计步骤：
1. 分析问题，抽象出描述问题的数据模型 
2. 确定问题的算法思想 
3. 画出流程图或结构图 

4. 逐条编写程序 
5. 静态检查，上机调
- --
## 题目 ##
- --
### 题目 1 循环单链表应用
> 题目：求解约瑟夫（Josephus）问题 
> - 【问题描述】： 
> - 有一个旅行社要从 n 个旅客中选出一名旅客，为他提供免费的环球旅行服务。旅行社安排这些旅客
围成一个圆圈，并从帽子中取出一张纸条，用纸条上面写的正整数 m（m<n）作为报数值。游戏进行时，
从第一个人开始按顺时针方向自 1 开始顺序报数，当报到 m 时停止报数，报 m 的人被淘汰出列。然后从
他顺时针方向上的下一个人开始从 1 重新报数，当再次报到 m 时停止报数，报 m 的人被淘汰出列。如此
下去，直到圆圈中剩下一个人为止。这个最后的幸存者就是游戏的胜利者，他将得到免费旅行的奖励。
请让计算机模拟此问题。 【实现提示】： 
采用循环单链表实现。

#### 解题思路

1. 设计概要：
    1. 两个参数，旅客数量n,整数m。循环寻找，选中delete，
    人数为1时，跳出循环，返回剩余数据的编号。
    2. 采用单链表的数据结构
2. 详细设计
    1. 采取链式存储结构，设计了结点类，链表类，还有实现类。链表类包含有添加，
    删除，查询，显示等功能模块。主要的设计部分为添加与删除。
    2. 设计思想
         * 链表中使用指针进行循环删除，直至链表中仅剩1个非头结点，跳出循环。
    3. 总结：结点的理解和指针的理解尤为重要，`Node c =new Node() `
    c为引用变量，代表的是地址，而非指向他的指针 
    4. 代码
        1. 循环单链表
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

        2. 约瑟夫问题
        ```java
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
        //  c.deleteNode(per.value);//删除当前值节点
        //            per=c.curr;
            c.disPlay();
               }
           }
        }
        ```
### 题目 2 堆栈和队列应用之一 
> 题目：轮船渡口管理问题 
> - ---   
> - 问题描述: 
> -    有一个渡口，每条渡轮一次能装载 10 辆汽车过江，过江车辆分为客车和货车两类，上渡轮有如下
       规定： 
>>1. 同类汽车先到先上船； 
>>2. 客车先于货车上船； 
>>3. 每上 4 辆客车才允许上一辆货车，但若等待的客车不足 4 辆则用货车填补，反过来，若没有货车
     等待则用客车填补； 
>>4. 装满 10 辆后则自动开船，当等待时间较长时车辆不足 10 辆也应人为控制发船。 【实现提示】： 
      此题应建立和使用两个链式队列，一个为客车队列，另一个为货车队列，到渡口需过江的汽车分
      别进入到相应队列中。当渡口有渡轮时先让客车队列中的 4 部客车出队并开进渡轮，再让货车队列中的
      4 部货车出队并开进渡轮，若某一类车辆队列为空则从另一队列中补充。当渡轮上装满 10 辆后则自动开
      船，此时应输出已装每辆车的车号。若装载不足 10 辆，但两个车辆队列全为空，应继续等待一段时间，
      若等待时间较长，仍不满载则应人为控制开船
####解题思路
1. 概要设计
   1. 算法思想：
        - 经过分析，发现此题实际上就是队列的基本操作，唯一的不同就是在入队的时候，对于顺序进行了限制。
        - 使用队列W表示等待的车辆，控制录入的等待队列的长度为10，队列Q表示每次载渡的车辆，队列Qp表示客车，Qt表示货车队列；
        - 如果Qp中元素足够，则每从队列Qp中出队4个元素，从队列Qt中出队1元素，直到队列Q的长度为10；
        - 若队列Qp中元素不充分，则直接使用队列Qt中的元素补齐

2. 详细设计
    1. 设计Node类，Linqueue类实现链式队列的入队，出队，Ferry实现类构建4个队列，
    并编写键盘输入队列的方法waitin（）和分车入队方法part（），最终通过条件和循
    环语句的多层嵌套实现登船输出。
    2. 总结：前期的程序框图的绘制，使得多层的嵌套实现时思路更加清晰。同时不同循环
    间的缩进也使得嵌套更加清晰，便于检查。
    3. 代码
       - Ferry类
    ```java
   package P2;
   
   import java.util.Scanner;
   
   public class Ferry {//问题设为一次仅至多十辆车进入等待
       Linqueue w =new Linqueue();
       Linqueue Qp =new Linqueue();
       Linqueue Qt= new Linqueue();
       Linqueue Q= new Linqueue();
       public int[] waitIn() throws Exception {//尝试能不能用
           Scanner sc=new Scanner(System.in);
           System.out.println("请输等待车队车牌号,并输入0结束");
           int n = 1,i=0,j=0;
           while(true){
               n=sc.nextInt();
               j++;
               if (n==0)break;
               w.append(n);
               if (j==10)break;
           }
           int[] a = new int[w.count];
           while(!w.isEmpty()){//这里犯了一个逻辑错误，w.isEmpty前面遗漏了！，导致语句没有进行
               n= (int) w.getFront();
   //          w.getFront输入进去时为整数，所以不能转换为String,再去转整数
   //        int app =Integer.parseInt((String)w.getFront());
   //            System.out.println(app);
               w.delete();
               a[i]=n;
               i++;
           }
           return a;
       }
   //分车进入不同的队列
       public void part(int[]array) throws Exception {
           for ( int a:array){
   //            System.out.println(a);
                if (a<3000) Qp.append(a);
                else Qt.append(a);
                }
       }
       public static void main(String[] args) throws Exception {
           Scanner sc=new Scanner(System.in);
           Ferry ferry = new Ferry();
           int[] a = ferry.waitIn();
           ferry.part(a);
           Linqueue Qp = ferry.Qp;
           Linqueue Qt = ferry.Qt;
           Linqueue Q = ferry.Q;
           int c=Qp.count + Qt.count;
           if ( c<10) {
               System.out.println("等待车辆不足,仅为"+c);
               System.out.println("是否添加等待车辆，y or n");
               String yn=sc.next();
               if (yn.equalsIgnoreCase("y"))
                    a = ferry.waitIn();
               ferry.part(a); }
           if (Qp.isEmpty()){
                   while (!Qt.isEmpty()){
                       Q.append(Qt.delete());
                   }
               }
           else if (Qt.isEmpty()){
                   while (!Qp.isEmpty()){
                       Q.append(Qp.delete());
               }
           }
           else if (Qp.count > 3) {
                   for (int j = 0; j < 4; j++) {
                       Q.append(Qp.delete());
                   }
                   Q.append(Qt.delete());
                   while (!Qp.isEmpty()){
                       Q.append(Qp.delete());
                   }
                   while (!Qt.isEmpty()){
                       Q.append(Qt.delete());
                   }
           }
           else {
                   while (!Qp.isEmpty()){
                       Q.append(Qp.delete());
                   }
                   while (!Qt.isEmpty()){
                       Q.append(Qt.delete());
                   }
   
               }
           Q.out_d_All();
       }
   }
   

    ```
> - ----
[哈工大](http://www.hit.edu.cn/) ,一个你值得去好好学习的学校

 