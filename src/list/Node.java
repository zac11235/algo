package list;

import java.util.List;
public class Node<T> {

    //创建一个内部节点类
    public Node next = null;



    public Object data = null;

    public Node() {

    }
    public Node(Node nextval ) {
        next=nextval;
    }
    public Node(Object obj,Node nextval) {
    data=obj;
    next=nextval;
    }

    public Node<T> getNext() {
        return next;
    }
    public void setNext(Node next) { this.next = next; }
    public Object getData() {
        return data;
    }
    public void setData(Object data) {
        this.data = data;
    }

    @Override
    public String toString() {
        return data.toString();
    }
}
