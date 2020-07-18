package p8;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.io.Writer;
import java.lang.reflect.Array;
import java.util.AbstractList;
import java.util.ArrayList;
import java.util.List;

public class HuffCode {
    public static void main(String[] args) throws IOException {
        List<Node<String>> list = new ArrayList<Node<String>>();


        File file = new File("C:/Users/mings/Desktop/input.txt");
        ReadText read = new ReadText();
        String temp = read.txtString(file);
        System.out.println("编码前\n"+temp);
        int[] num = read.getNumber();
        char[] chars = read.getChars();
        for(int i = 0;i<num.length;i++){
            System.out.print(chars[i]+"："+num[i]+"   ");
            Node<String> node =new Node<String>(chars[i]+"",num[i]);
//         System.out.println(node.getLeft());
            list.add(node);
        }
        System.out.println();

        Tree huff=new Tree();
        Node<String> root = huff.createTree(list);
        List<Node> list2 = huff.breadth(root);
        List<String> list3 =new ArrayList<String>();//用来存储字母，序号对应着list4的哈夫曼编码
        List list4 = new ArrayList<String>();//存储哈夫曼编码
        for(int i = 0;i<list2.size();i++){
            if(list2.get(i).getData()!=null) {
                list3.add((String) list2.get(i).getData());
                list4.add(list2.get(i).getCode());
            }
        }

        String result=new String();//存储语句的编码
        for(int i = 0; i<temp.length(); i++){
            for(int j = 0;j<list3.size();j++){
                if(temp.charAt(i) == list3.get(j).charAt(0))
                    result += list4.get(j);
            }
        }
        List<String> list5 =new ArrayList<String>();
        String temp3=new String();
        String temp2="";
        for(int i = 0; i<result.length(); i++){
            list5.add(result.charAt(i)+"");
        }
        while (list5.size()>0){
            temp2 = temp2 + "" + list5.get(0);
            list5.remove(0);
            for(int i=0;i<list4.size();i++){
                if (temp2.equals(list4.get(i))) {
                    temp3 = temp3+""+list3.get(i);
                    temp2 = "";
                }
            }
        }
        File file2 =new File("C:/Users/mings/Desktop/input2.txt");
        Writer out =new FileWriter(file2);
        out.write("解码前:\n"+temp+"\n");
        out.write("编码为:\n"+result+"\n");
        out.write("解码后:\n"+temp3);
        out.close();
    }
}
