package com.vsu;
import java.util.Iterator;
import java.util.LinkedList;


/** LinkedList使用
 * Created by vsu on 2017/09/16.
 */

/*LinkedList和ArrayList比较
 *LinkedList中插入元素很快，而ArrayList中插入元素很慢
 *ArrayList中随机访问很快，而LinkedList中随机访问很慢
 */

/* LinkedList简介
 *LinkedList 是一个继承于AbstractSequentialList的双向链表。它也可以被当作堆栈、队列或双端队列进行操作。
 * LinkedList 实现 List 接口，能进行队列操作。
 * LinkedList 实现 Deque 接口，即能将LinkedList当作双端队列使用。
 * ArrayList底层是由数组支持，而LinkedList 是由双向链表实现的，其中的每个对象包含数据的同时还包含指向链表中前一个与后一个元素的引用。
 */

/*LinkedList遍历方式
 *迭代器遍历
 * for循环get()遍历
 * Foreach循环遍历
 * 通过pollFirst()或pollLast()遍历
 * 通过removeFirst()或removeLast()遍历
 *
 *遍历LinkedList时，使用removeFirst()或removeLast()效率最高，而for循环get()效率最低，应避免使用这种方式进行。
 * 应当注意的是，使用pollFirst()或pollLast()或removeFirst()或removeLast()遍历时，会删除原始数据，若只单纯的读取，应当选用第一种或第三种方式。
 */




public class LinkedListTest {
    public static void main(String[] args) {

        LinkedList<Integer> linkedList = new LinkedList<>();

        linkedList.addFirst(0);    // 添加元素到列表开头
        linkedList.add(1);         // 在列表结尾添加元素
        linkedList.add(2,2);       // 在指定位置添加元素
        linkedList.addLast(3);     // 添加元素到列表结尾
        System.out.println(linkedList);

        linkedList.set(1, 3);        // 将此列表中指定位置的元素替换为指定的元素
        System.out.println(linkedList);
        System.out.println(linkedList.get(1));    // 返回此列表中指定位置处的元素

        System.out.println("indexOf(3): " + linkedList.indexOf(3));  // 返回此列表中首次出现的指定元素的索引
        System.out.println("lastIndexOf(3): " + linkedList.lastIndexOf(3));// 返回此列表中最后出现的指定元素的索引

        //Queue操作
        System.out.println("peek(): " + linkedList.peek());                // 获取但不移除此列表的头
        System.out.println("element(): " + linkedList.element());          // 获取但不移除此列表的头
        linkedList.poll();                                                 // 获取并移除此列表的头
        System.out.println("After poll():" + linkedList);
        linkedList.remove();                                               // 获取并移除此列表的头
        System.out.println("After remove():" + linkedList);
        linkedList.offer(4);                                           // 将指定元素添加到此列表的末尾
        System.out.println("After offer(4):" + linkedList);

        //Deque操作
        linkedList.offerFirst(2);                                          // 在此列表的开头插入指定的元素
        System.out.println("After offerFirst(2):" + linkedList);
        linkedList.offerLast(5);                                           // 在此列表末尾插入指定的元素
        System.out.println("After offerLast(5):" + linkedList);
        System.out.println("peekFirst(): " + linkedList.peekFirst());      // 获取但不移除此列表的第一个元素
        System.out.println("peekLast(): " + linkedList.peekLast());        // 获取但不移除此列表的第一个元素
        linkedList.pollFirst();                                            // 获取并移除此列表的第一个元素
        System.out.println("After pollFirst():" + linkedList);
        linkedList.pollLast();                                             // 获取并移除此列表的最后一个元素
        System.out.println("After pollLast():" + linkedList);
		
		
        linkedList.push(2);                                                // 将元素推入此列表所表示的堆栈（插入到列表的头）
        System.out.println("After push(2):" + linkedList);
        linkedList.pop();                                                  // 从此列表所表示的堆栈处弹出一个元素（获取并移除列表第一个元素）
        System.out.println("After pop():" + linkedList);
        linkedList.add(3);
        linkedList.removeFirstOccurrence(3);                               // 从此列表中移除第一次出现的指定元素（从头部到尾部遍历列表）
        System.out.println("After removeFirstOccurrence(3):" + linkedList);
        linkedList.removeLastOccurrence(3);                                // 从此列表中移除最后一次出现的指定元素（从头部到尾部遍历列表）
        System.out.println("After removeFirstOccurrence(3):" + linkedList);

        //遍历
        linkedList.clear();
        for(int i = 0; i < 5; i++){
            linkedList.add(i);
        }

        //for
        for(int i = 0; i < linkedList.size(); i++){
            System.out.print(linkedList.get(i) + " ");
        }
        System.out.println();
        //foreach
        for(Integer i : linkedList) {
            System.out.print(i + " ");
        }
        System.out.println();
        //迭代器
        Iterator<Integer> iterator = linkedList.iterator();
        while(iterator.hasNext()){
            System.out.print(iterator.next() + " ");
        }
        System.out.println();
        //通过pollFirst()或pollLast()来遍历LinkedList  ----保留一个
        while(linkedList.size() > 1){
            linkedList.pollFirst();
        }
        System.out.println(linkedList);
        //通过removeFirst()或removeLast()来遍历LinkedList -----保留一个
        while(linkedList.size() > 1){
            linkedList.removeFirst();
        }
        System.out.println(linkedList);

        //remove
        linkedList.clear();
        for(int i = 0; i < 5; i++){
            linkedList.add(i);
        }
        linkedList.remove(2);
        System.out.println(linkedList);


    }
}
