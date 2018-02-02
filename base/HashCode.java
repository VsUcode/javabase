/**
 * Created by VSU on 2017/09/13.
 */

/*设计hashCode()时最重要的因素就是：无论何时，对同一个对象调用 hashCode()都应该产生同样的值。
 *  如果在讲一个对象用put()添加进HashMap时产生一个hashCdoe值，而用get()取出时却产生 了另一个hashCode值，
 *  那么就无法获取该对象了。所以如果你的hashCode方法依赖于对象中易变的数据，用户就要当心了，因为此数据发生变化 时，hashCode()方法就会生成一个不同的散列码
 */

/* hashCode的作用：
 *在Java集合中有两类，一类是List，一类是Set他们之间的区别就在于List集合中的元素是有序的，且可以重复，而Set集合中元素是无序不可重复的。
 * 对于List好处理，但是对于Set而言我们要如何来保证元素不重复呢？通过迭代来equals()是否相等。数据量小还可以接受，当我们的数据量大的时候效率可想而知（当然我们可以利用算法进行优化）。
 * public native int hashCode();它是一个本地方法，它的实现与本地机器有关，这里我们暂且认为他返回的是对象存储的物理位置（实际上不是，这里写是便于理解）。
 * 当我们向一个集合中添加某个元素，集合会首先调用hashCode方法，这样就可以直接定位它所存储的位置，若该处没有其他元素，则直接保存。
 * 若该处已经有元素存在，就调用equals方法来匹配这两个元素是否相同，相同则不存，不同则散列到其他位置，这样处理，当我们存入大量元素时就可以大大减少调用equals()方法的次数，极大地提高了效率。
 *
 * 所以hashCode在上面扮演的角色为寻域（寻找某个对象在集合中区域位置）。hashCode可以将集合分成若干个区域，每个对象都可以计算出他们的hash码，可以将hash码分组，每个分组对应着某个存储区域，
 * 根据一个对象的hash码就可以确定该对象所存储区域，这样就大大减少查询匹配元素的数量，提高了查询效率。
 */


/* hashCode对于一个对象的重要性：
 *hashCode重要么？不重要，对于List集合、数组而言，他就是一个累赘，但是对于HashMap、HashSet、HashTable而言，它变得异常重要。
 * 所以在使用HashMap、HashSet、HashTable时一定要注意hashCode。对于一个对象而言，其hashCode过程就是一个简单的Hash算法的实现，其实现过程对你实现对象的存取过程起到非常重要的作用。
 *
 */


/* hashCode 与 equals
 *在Java中hashCode的实现总是伴随着equals，他们是紧密配合的，你要是自己设计了其中一个，就要设计另外一个。当然在多数情况下，这两个方法是不用我们考虑的，直接使用默认方法就可以帮助我们解决很多问题。但是在有些情况，我们必须要自己动手来实现它，才能确保程序更好的运作。
 * 对于hashCode，我们应该遵循如下规则：
 *    1. 在一个应用程序执行期间，如果一个对象的equals方法做比较所用到的信息没有被修改的话，则对该对象调用hashCode方法多次，它必须始终如一地返回同一个整数。
 *    2. 如果两个对象根据equals(Object o)方法是相等的，则调用这两个对象中任一对象的hashCode方法必须产生相同的整数结果。
 *    3. 如果两个对象根据equals(Object o)方法是不相等的，则调用这两个对象中任一个对象的hashCode方法，不要求产生不同的整数结果。但如果能不同，则可能提高散列表的性能。
 *
 * 至于两者之间的关联关系，我们只需要记住如下即可：
 *   如果x.equals(y)返回“true”，那么x和y的hashCode()必须相等。
 *   如果x.equals(y)返回“false”，那么x和y的hashCode()有可能相等，也有可能不等。
 *
 * 整个处理流程是：
 *   1、判断两个对象的hashcode是否相等，若不等，则认为两个对象不等，完毕，若相等，则比较equals。
 *   2、若两个对象的equals不等，则可以认为两个对象不等，否则认为他们相等。
 */


//部分代码
public class HashCode {

    private int age;
    private int sex;    //0：男，1：女
    private String name;
    private final int PRIME = 37;

    public int hashCode() {
        System.out.println("调用hashCode方法...........");
        int hashResult = 1;
        hashResult = (hashResult + Integer.valueOf(age).hashCode() + Integer.valueOf(sex).hashCode()) * PRIME;
        hashResult = PRIME * hashResult + ((name == null) ? 0 : name.hashCode());

        return hashResult;

        //return name.hashCode()*37+age;
    }

    //省略equals
    public boolean equals(Object obj) {return true;}

    public static void main(String[] args) {

    }
}
