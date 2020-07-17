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

