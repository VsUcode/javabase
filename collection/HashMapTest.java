package com.vsu;

import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.Random;

/**
 * HashMap
 *
 * Created by vsu on 2017/09/24.
 */


/*
 *HashMap：它根据键的hashCode值存储数据，大多数情况下可以直接定位到它的值，因而具有很快的访问速度，但遍历顺序却是不确定的。
 *   HashMap最多只允许一条记录的键为null，允许多条记录的值为null。
 *   HashMap非线程安全，即任一时刻可以有多个线程同时写HashMap，可能会导致数据的不一致。
 *   如果需要满足线程安全，可以用 Collections的synchronizedMap方法使HashMap具有线程安全的能力，或者使用ConcurrentHashMap。
 *
 *Hashtable：Hashtable是遗留类，很多映射的常用功能与HashMap类似，不同的是它承自Dictionary类，并且是线程安全的，
 *   任一时间只有一个线程能写Hashtable，并发性不如ConcurrentHashMap，因为ConcurrentHashMap引入了分段锁。
 *   Hashtable不建议在新代码中使用，不需要线程安全的场合可以用HashMap替换，需要线程安全的场合可以用ConcurrentHashMap替换。
 *
 *LinkedHashMap：LinkedHashMap是HashMap的一个子类，保存了记录的插入顺序，在用Iterator遍历LinkedHashMap时，
 *   先得到的记录肯定是先插入的，也可以在构造时带参数，按照访问次序排序。
 *
 * TreeMap：TreeMap实现SortedMap接口，能够把它保存的记录根据键排序，默认是按键值的升序排序，也可以指定排序的比较器，
 *   当用Iterator遍历TreeMap时，得到的记录是排过序的。如果使用排序的映射，建议使用TreeMap。
 *   在使用TreeMap时，key必须实现Comparable接口或者在构造TreeMap传入自定义的Comparator，否则会在运行时抛出java.lang.ClassCastException类型的异常。
 *
 */

/*
 *分析HashMap的put方法
 *   ①.判断键值对数组table[i]是否为空或为null，否则执行resize()进行扩容；
 *   ②.根据键值key计算hash值得到插入的数组索引i，如果table[i]==null，直接新建节点添加，转向⑥，如果table[i]不为空，转向③；
 *   ③.判断table[i]的首个元素是否和key一样，如果相同直接覆盖value，否则转向④，这里的相同指的是hashCode以及equals；
 *   ④.判断table[i] 是否为treeNode，即table[i] 是否是红黑树，如果是红黑树，则直接在树中插入键值对，否则转向⑤；
 *   ⑤.遍历table[i]，判断链表长度是否大于8，大于8的话把链表转换为红黑树，在红黑树中执行插入操作，否则进行链表的插入操作；遍历过程中若发现key已经存在直接覆盖value即可；
 *   ⑥.插入成功后，判断实际存在的键值对数量size是否超多了最大容量threshold，如果超过，进行扩容。
 */

/*
void                 clear()
Object               clone()
boolean              containsKey(Object key)
boolean              containsValue(Object value)
Set<Entry<K, V>>     entrySet()
V                    get(Object key)
boolean              isEmpty()
Set<K>               keySet()
V                    put(K key, V value)
void                 putAll(Map<? extends K, ? extends V> map)
V                    remove(Object key)
int                  size()
Collection<V>        values()
 */



public class HashMapTest {
    public static void main(String[] args) {
        testHashMap();
    }

    /**
     * @Author: vsu
     * @Descriptioon: 测试HashMap
     * @Date: 2017/09/24
     */
    private static void testHashMap(){

        // 初始化随机种子
        Random r = new Random();
        //新建HashMap
        HashMap map = new HashMap();

        //添加
        map.put("one", r.nextInt(10));
        map.put("two", r.nextInt(10));
        map.put("three", r.nextInt(10));

        //打印
        System.out.println(map);

        //iterator遍历
        Iterator iter = map.entrySet().iterator();
        while (iter.hasNext()){
            Map.Entry entry = (Map.Entry) iter.next();
            System.out.println(entry.getKey() + "-" + entry.getValue());
        }

        //键值对个数
        System.out.println(map.size());

        //是否包含某个key
        System.out.println(map.containsKey("two"));
        System.out.println(map.containsKey("four"));

        //是否包含某个 值
        System.out.println(map.containsValue(new Integer(0)));

        //删除key对应的键值对
        System.out.println(map.remove("two"));
        System.out.println(map);

        //清空
        map.clear();

        //是否为空
        System.out.println(map.isEmpty());



    }



}
