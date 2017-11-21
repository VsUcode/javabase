package com.vsu;

import java.util.Iterator;
import java.util.TreeSet;

/**  treeSet
 * Created by vsu on 2017/09/17.
 */

/* TreeSet
 *TreeSet 是一个有序的集合，它的作用是提供有序的Set集合。它继承于AbstractSet抽象类，实现了NavigableSet<E>, Cloneable, java.io.Serializable接口。
 * TreeSet 实现了NavigableSet接口，意味着它支持一系列的导航方法。比如查找与指定目标最匹配项。
 * TreeSet 实现了java.io.Serializable接口，意味着它支持序列化。
 * TreeSet 继承于AbstractSet，所以它是一个Set集合，具有Set的属性和方法。
 * TreeSet 实现了Cloneable接口，意味着它能被克隆。
 *
 * TreeSet是基于TreeMap实现的。
 * TreeSet是非同步的。 TreeSet是非线程安全的。
 *
 */

/* 方法
        boolean                   add(E object)
        boolean                   addAll(Collection<? extends E> collection)
        void                      clear()
        Object                    clone()
        boolean                   contains(Object object)
        E                         first()
        boolean                   isEmpty()
        E                         last()
        E                         pollFirst()
        E                         pollLast()
        E                         lower(E e)
        E                         floor(E e)
        E                         ceiling(E e)
        E                         higher(E e)
        boolean                   remove(Object object)
        int                       size()
        Comparator<? super E>     comparator()
        Iterator<E>               iterator()
        Iterator<E>               descendingIterator()
        SortedSet<E>              headSet(E end)
        NavigableSet<E>           descendingSet()
        NavigableSet<E>           headSet(E end, boolean endInclusive)
        SortedSet<E>              subSet(E start, E end)
        NavigableSet<E>           subSet(E start, boolean startInclusive, E end, boolean endInclusive)
        NavigableSet<E>           tailSet(E start, boolean startInclusive)
        SortedSet<E>              tailSet(E start)

*/

/* TreeSet的继承关系
 *public class TreeSet<E> extends AbstractSet<E> implements NavigableSet<E>, Cloneable, java.io.Serializable{}
 */

/*遍历
 *
 */



public class TreeSetTest {
    public static void main(String[] args) {

        // 新建TreeSet
        TreeSet tSet = new TreeSet();

        // 将元素添加到TreeSet中
        tSet.add("aaa");
        // Set中不允许重复元素，所以只会保存一个“aaa”
        tSet.add("aaa");
        tSet.add("eee");
        tSet.add("ddd");
        tSet.add("bbb");
        tSet.add("ccc");
        System.out.println(tSet);

        // 打印TreeSet的实际大小
        System.out.println(tSet.size());

        // 导航方法
        // floor(小于、等于)
        System.out.println("floor bbb: " + tSet.floor("bbb"));
        // lower(小于)
        System.out.println("lower bbb: " + tSet.lower("bbb"));
        // ceiling(大于、等于)
        System.out.println("ceiling bbb: " + tSet.ceiling("bbb"));
        System.out.println("ceiling eee: " + tSet.ceiling("eee"));
        // higher(大于)
        System.out.println("higher bbb: " + tSet.higher("bbb"));
        // subSet()
        System.out.println("subSet(aaa, true, ccc, true): " + tSet.subSet("aaa", true, "ccc", true));
        System.out.println("subSet(aaa, true, ccc, false): " + tSet.subSet("aaa", true, "ccc", false));
        //headSet()
        System.out.println("headSet(ccc, true): " + tSet.headSet("ccc", true));
        System.out.println("headSet(ccc, false): " + tSet.headSet("ccc", false));
        // tailSet()
        System.out.println("headSet(ccc, false): " + tSet.tailSet("ccc", false));
        System.out.println("headSet(ccc, true): " + tSet.tailSet("ccc", true));

        // 删除“ccc”
        tSet.remove("ccc");

        //遍历
        // 顺序遍历TreeSet
        for(Iterator iter = tSet.iterator(); iter.hasNext(); ) {
            System.out.print(iter.next() + " ");
        }
        System.out.println();
       // 逆序遍历TreeSet
        for(Iterator iter = tSet.descendingIterator(); iter.hasNext(); ) {
            System.out.print(iter.next() + " ");
        }
        System.out.println();
        // 通过for-each遍历TreeSet。不推荐！此方法需要先将Set转换为数组
        String[] arr = (String[])tSet.toArray(new String[0]);
        for (String str:arr)
            System.out.print(str + " ");
        System.out.println();

        // 删除并返回第一个元素
        System.out.println(tSet.pollFirst());
        System.out.println(tSet);

        // 删除并返回最后一个元素
        System.out.println(tSet.pollLast());
        System.out.println(tSet);

        // 清空HashSet
        tSet.clear();
        System.out.println(tSet);


    }
}
