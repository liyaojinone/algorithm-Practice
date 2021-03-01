package LinkedList;

import java.util.LinkedList;
/**
*   N个人围成一圈，从第一个人开始报数，报到m的人出圈，
 *  剩下的人继续从1开始报数，报到m的人出圈；如此往复，直到所有人出圈。
 *  拟此过程，输出出圈的人的序号）
*
* */
public class CircularLinkedList {
    public static void main(String[] args) {
        SimpleLinkedList simpleLinkedList = new SimpleLinkedList();
        simpleLinkedList.addNode(11);
        //  simpleLinkedList.showNode();
        simpleLinkedList.delNode(3);
    }

}

class SimpleLinkedList {
    public node first=new node(-1);


    public void addNode(int numb){
        if(numb<1){
            System.out.println("numb的值不允许!");
            return;
        }
        node curNode=null;
        for (int i = 1; i <= numb; i++) {
            node node=new node(i);
            if (i==1){
                first=node;
                first.setNext(first);
                curNode=first;
            }else {
                curNode.setNext(node);
                node.setNext(first);
                curNode=node;
            }

        }

    }

    public void showNode(){
        if(first==null){
            System.out.println("链表为空！");
            return;
        }
        node curNode=first;
        while (true){
            System.out.printf("小孩的编号：%d\n",curNode.getNo());

            if (curNode.getNext()==first){
                break;
            }
            curNode=curNode.getNext();
        }
    }

    public void delNode(int m){//删除的m
        System.out.println("移动的m为"+(m-1)+"\n");
        if(first==null){
            System.out.println("链表为空！");
            return;
        }
        //此处为单向环形链表，只能以first为参考
        node curNode=first;
        node helper = null;


         //为了找到first的上一节点就是最后的一个节点
        //记为helper
        while (true){
            if (curNode.getNext()==first){
                //只有一个first节点
                helper=curNode;
                break;
            }
            curNode=curNode.getNext();
        }

        while (true){
            if(helper==first){
                break;
            }
        for (int i = 0; i < m-1; i++) {
            //移动m-1位，把自己算上 是m位
            first=first.getNext();
            helper=helper.getNext();
            System.out.println("向前移动"+(i+1)+"位了"+"\t");
        }
            System.out.println("删除的node为："+first.getNo()+"\n");
        //得到了 m位后的节点，将它指向下一个节点
        first=first.getNext();
        //首尾相连
        helper.setNext(first);

        System.out.println("删除后first:"+first.getNo()+"  helper:"+helper.getNo()+"\n");
    }
    }
}