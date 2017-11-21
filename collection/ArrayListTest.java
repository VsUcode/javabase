package com.vsu;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Iterator;

/** ArrayList使用
 * Created by vsu 2017/09/16.
 */

/* Java.util.ArrayList类是一个动态数组类型，也就是说，ArrayList对象既有数组的特征，也有链表的特征。可以随时从链表中添加或删除一个元素。ArrayList实现了List接口。
 *当我们不知道到底有多少个数据元素的时候，就可使用ArrayList；如果知道数据集合有多少个元素，就用数组。
 */

/* ArrayList构造函数
 *Arraylist()  这个构造方法构造了一个空的链表。
 * ArrayList(Collection<? extends E> c)  这个构造方法构造了一个包含指定元素集合的链表
 * ArrayList(int initialCapacity)  构造了一个指定大小但内容为空的链表
 */

/*ArrayList常用方法
 * 增加元素到链表中
 *     boolean add(Element e)  增加指定元素到链表尾部.
 *     void add(int index, Element e)  增加指定元素到链表指定位置.
 *
 * 从链表中删除元素
 *     void clear()  从链表中删除所有元素.
 *     E remove(int index)  删除链表中指定位置的元素
 *     protected void removeRange(int start, int end)  删除链表中从某一个位置开始到某一个位置结束的元素
 *
 * 获取链表中的元素
 *     E get(int index)  获取链表中指定位置处的元素
 *     Object[] toArray() 获取一个数组，数组中所有元素是链表中的元素.（即将链表转换为一个数组）
 *
 * 修改某个元素
 *     E set(int index, E element)  将链表中指定位置上的元素替换成新元素
 *
 * 搜索元素
 *     boolean contains(Object o)  如果链表包含指定元素，返回true.
 *     int indexOf(Object o)  返回元素在链表中第一次出现的位置，如果返回-1，表示链表中没有这个元素。
 *     int lastIndexOf(Object o)  返回元素在链表中最后一次出现的位置，如果返回-1，表示链表中没有这个元素。
 *
 * 检查链表是否为空
 *     boolean isEmpty()  返回true表示链表中没有任何元素.
 *
 * 获取链表大小
 *     int size()  返回链表长度（链表包含元素的个数）.
 */


/* toArray()的使用
 *有时候，当我们调用ArrayList中的 toArray()，可能遇到过抛出java.lang.ClassCastException异常的情况，
 * 这是由于toArray() 返回的是 Object[] 数组，将 Object[] 转换为其它类型(如，将Object[]转换为的Integer[])则会抛出java.lang.ClassCastException异常，因为Java不支持向下转型。
 * <T> T[] toArray(T[] a)
 *
 * 第一种方式(最常用)
 * Integer[] integer = arrayList.toArray(new Integer[0]);
 *
 * 第二种方式(容易理解)
 * Integer[] integer1 = new Integer[arrayList.size()];
 * arrayList.toArray(integer1);
 */




public class ArrayListTest {

    public static void main(String[] args) {

        // 创建一个空的数组链表对象list，list用来存放String类型的数据
        ArrayList<String> list = new ArrayList<String>();

        // 增加元素到list对象中
        list.add("Item1");
        list.add("Item2");
        list.add(2, "Item3");//此条语句将会把“Item3”字符串增加到list的第3个位置。
        list.add("Item4");
        System.out.println(list);

        //检查元素的位置
        System.out.println(list.indexOf("Item3"));

        //检查数组链表是否为空
        System.out.println(list.isEmpty());

        //获取链表的大小
        System.out.println(list.size());

        //检查数组链表中是否包含某元素
        System.out.println(list.contains("oo"));

        //获取指定位置上的元素
        System.out.println(list.get(1));

        /*遍历
         * for 循环
         * foreach
         * 迭代器
         */
        //for
        for (int i=0; i < list.size(); ++i) {
            System.out.print(list.get(i) + " ");
        }
        System.out.println();
        //foreach
        for (String str : list) {
            System.out.print(str + " ");
        }
        System.out.println();
        /* 迭代器
         *hasNext(): 返回true表示链表链表中还有元素
         * next(): 返回下一个元素
         */
        for (Iterator<String> it = list.iterator(); it.hasNext();) {
            System.out.print(it.next() + " ");
        }
        System.out.println();

        //替换元素
        System.out.println(list.set(1, "qqq"));
        System.out.println(list);

        //移除元素
        list.remove(0);
        list.remove("iItem2");
        System.out.println(list);

        //转换 ArrayList 为 Array
        System.out.println(Arrays.toString(list.toArray(new String[0])));


    }
}
