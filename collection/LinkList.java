package com.vsu;

/**  单链表
 * Created by vsu on 2017/09/15.
 */


//节点类
 class Node {
    protected Node next; //指针域
    protected int data; //数据域

    public Node (int data) {
        this.data = data;
    }

    //显示此节点
    public void display() {
        System.out.print(data + "->");
    }
}


//单链表
class LinkList {

    public Node first; //定义一个头节点
    private int pos = 0; //节点的位置

    public LinkList() {
        this.first = null;
    }

    //插入一个头节点
    public void addFirstNode (int data) {
        Node node = new Node(data);
        node.next = first;
        first = node;
    }

    //删除一个头结点，并返回一个头结点
    public Node deleteFirstNode() {
        Node tempNode = first;
        first = tempNode.next;
        return tempNode;
    }

    //在任意位置插入节点 在index的后面插入
    public void add(int index, int data) {
        Node node = new Node(data);
        Node current = first;
        Node previous = first;

        while (pos != index) {
            previous = current;
            current = current.next;
            pos++;
        }
        node.next = current;
        previous.next = node;
        pos = 0;
    }

    //删除任意位置的节点
    public Node deleteByPos(int index) {
        Node current = first;
        Node previous = first;

        while (pos != index) {
            pos++;
            previous = current;
            current = current.next;
        }

        if (current == first) {
            first = first.next;
        }else{
            pos = 0;
            previous.next = current.next;
        }
        return current;
    }

    //根据节点的data删除节点（仅删除第一个）
    public Node deleteByData( int data) {
        Node current = first;
        Node previous = first; //记住上一个节点
        while (current. data != data) {
            if (current. next == null) {
                return null;
            }
            previous = current;
            current = current. next;
        }
        if(current == first) {
            first = first. next;
        } else {
            previous. next = current. next;
        }
        return current;
    }

    // 显示出所有的节点信息
    public void displayAllNodes() {
        Node current = first;
        while (current != null) {
            current.display();
            current = current. next;
        }
        System. out.println();
    }

    // 根据位置查找节点信息
    public Node findByPos(int index) {
        Node current = first;
        if ( pos != index) {
            current = current. next;
            pos++;
        }
        return current;
    }

    // 根据数据查找节点信息
    public Node findByData( int data) {
        Node current = first;
        while (current. data != data ) {
            if (current. next == null)
                return null;
            current = current. next;
        }
        return current;
    }

    /**
     * 查询单链表的中间节点
     * 定义两个指针，一个每次走一步，一个每次走两步...
     * @param
     * @return q为中间节点
     */
    public Node searchMid(){ //Node
        Node q=first;
        Node p=first;
        while (p!=null&&p.next!=null&&p.next.next!=null) {
            q=q.next;
            p=p.next.next;
        }
        return q;
    }

    /**
     * 对链表进行排序
     * @return 返回排序后的头结点
     */
    public Node orderList(){
        Node nextNode=null;
        int temp=0;
        Node curNode=first;
        while(curNode.next!=null){
            nextNode=curNode.next;
            while(nextNode!=null){
                if(curNode.data>nextNode.data){
                    temp=curNode.data;
                    curNode.data=nextNode.data;
                    nextNode.data=temp;
                }
                nextNode=nextNode.next;
            }
            curNode=curNode.next;
        }
        return first;
    }

    /**
     * 实现链表的反转
     */
    public void reverseIteratively(){
        Node pReversedFirst=first;
        Node pNode=first;
        Node pPrev=null;
        while (pNode!=null) {
            Node pNext=pNode.next;
            if(pNext==null)
                pReversedFirst=pNode;
            pNode.next=pPrev;
            pPrev=pNode;
            pNode=pNext;
        }
        this.first=pReversedFirst;
    }
}



public class LinkedList {

    public static void main(String[] args) {
        LinkList linkList = new LinkList();
        linkList.addFirstNode(20);
        linkList.addFirstNode(21);
        linkList.addFirstNode(19);
        linkList.displayAllNodes();

        linkList.add(1, 22); //19,22,21,20
        linkList.add(2, 23); //19,22,23,21,20
        linkList.add(3, 99); //19,22,23,99,21,20
        linkList.displayAllNodes();

        linkList.deleteFirstNode();
        linkList.displayAllNodes();

        linkList.deleteByPos(3);
        linkList.displayAllNodes();

        linkList.deleteByData(99);
        linkList.displayAllNodes();

        linkList.findByPos(2).display();
        System.out.println();

        System.out.println(linkList.findByData(3));

        linkList.searchMid().display();
        System.out.println();

        linkList.orderList().display();
        System.out.println();

        linkList.displayAllNodes();

        linkList.reverseIteratively();
        linkList.displayAllNodes();
    }
}
