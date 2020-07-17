package P2;
import list.*;

import java.lang.reflect.Array;


public class Linqueue implements Queue {
    Node front;
    Node rear;
    int count;
    public Linqueue(){ initiate();}
   public void initiate(){
        front=rear=null;
        count=0;
   }
    @Override
    public void append(Object obj) throws Exception {
    Node newNode=new Node(obj,null);
    if (rear!=null)
        rear.next=newNode;
    rear=newNode;
    if (front==null)
        front=newNode;
    count++;
    }

    public void appendInt(int[] array)throws Exception{
        for (int a: array) {
            append(a);
        }
        
    }
    @Override
    public Object delete() throws Exception {
        if (count==0)
            throw new Exception("队列已空");
        Node temp =front;
        front=front.next;
        count--;
        return temp.getData();
    }

    @Override
    public Object getFront() throws Exception {
        if (count==0)
            throw new Exception("队列已空");
        return front.getData();

    }

    @Override
    public boolean isEmpty() {
        return count==0;
    }
//输出的同时队列中的数据也被清空了
    public void out_d_All() throws Exception {
        int c= count;
        for (int i=0;i<c;i++){
//            System.out.println(Qc.count);
            Object b = getFront();
            System.out.println(b);
            delete();
        }

    }
    public static void main(String[] args) throws Exception {
        Linqueue Qc=new Linqueue();
        for (int i = 0; i<5; i++) {
            Qc.append(i);
        }
        Qc.out_d_All();
        int[]a={200,100,100,300};
        Qc.appendInt(a);
        Qc.out_d_All();


//      int count= Qc.count;
//        for (int i=0;i<count;i++){
////            System.out.println(Qc.count);
//        Object b = Qc.getFront();
//    System.out.println(b);
//    Qc.delete();
//        }
    }

}
