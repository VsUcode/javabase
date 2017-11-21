package com.vsu;

import java.util.HashSet;
import java.util.Iterator;

/** hashSet
 * Created by vsu on 2017/09/17.
 */

/* hashSet
 *HashSet 是一个没有重复元素的集合。
 *HashSet是基于HashMap来实现的，操作很简单，更像是对HashMap做了一次“封装”，而且只使用了HashMap的key来实现各种特性
 * 不保证元素的顺序，而且HashSet允许使用 null 元素。
 * HashSet是非同步的。如果多个线程同时访问一个哈希 set，而其中至少一个线程修改了该 set，那么它必须 保持外部同步。
 *   这通常是通过对自然封装该 set 的对象执行同步操作来完成的。如果不存在这样的对象，则应该使用 Collections.synchronizedSet 方法来“包装” set。最好在创建时完成这一操作，以防止对该 set 进行意外的不同步访问：
 *   Set s = Collections.synchronizedSet(new HashSet(...));
 *
 *HashSet的继承关系如下：
 *   public class HashSet<E> extends AbstractSet<E> implements Set<E>, Cloneable, java.io.Serializable { }
 *
 * HashSet遍历方式
 *  通过Iterator遍历HashSet(使用)
 *    根据iterator()获取HashSet的迭代器。
 *    遍历迭代器获取各个元素。
 *  通过for-each遍历HashSet
 *    根据toArray()获取HashSet的元素集合对应的数组。
 *    遍历数组，获取各个元素。
 */

public class HashSetTest {
    public static void main(String[] args) {

        // 新建HashSet
        HashSet set = new HashSet();

        // 将元素添加到Set中
        set.add("a");
        set.add("b");
        set.add("c");
        set.add("d");
        set.add("e");

        // 打印HashSet的实际大小
        System.out.println(String.valueOf(set.size()));

        // 判断HashSet是否包含某个值
        System.out.println("HashSet contains a " + set.contains("a"));
        System.out.println("HashSet contains g " + set.contains("g"));

        // 删除HashSet中的“e”
        set.remove("e");

        //遍历
        //迭代器
        for(Iterator iterator = set.iterator(); iterator.hasNext(); )
            System.out.print( iterator.next() + " ");
        System.out.println();
        //foreach
        // 将Set转换为数组
        String[] arr = (String[]) set.toArray(new String[0]);
        for (String str:arr)
            System.out.print(str + " ");
        System.out.println();

        // 新建一个包含b、c、f的HashSet
        HashSet otherset = new HashSet();
        otherset.add("b");
        otherset.add("c");
        otherset.add("f");

        // 克隆一个removeset，内容和set一模一样
        HashSet removeset = (HashSet)set.clone();

        // 删除“removeset中，属于otherSet的元素”
        removeset.removeAll(otherset);

        // 打印removeset
        System.out.println(removeset);

        // 克隆一个retainset，内容和set一模一样
        HashSet retainset = (HashSet)set.clone();

        // 保留“retainset中，属于otherSet的元素”
        retainset.retainAll(otherset);

        // 打印retainset
        System.out.println( retainset);

        // 清空HashSet
        set.clear();
        System.out.println(set);

    }
}
