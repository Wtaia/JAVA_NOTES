package com.taiacloud.java;

import org.junit.Test;

import java.util.*;

/**
 * 一、Map的实现类的结构：
 *      |---Map接口：双列集合，用来存储一对一对（key -- value）的数据。--->数学的函数：y = f(x)
 *              |---HashMap:作为Map的主要实现类；线程不安全的，效率高；存储null的key和value；若想变成线程安全的则可以用Collections工具类中的工具使HashMap变成安全的，而不选择用Hashtable；
 *                  |---LinkHashMap:保证在遍历map元素时，可以按照添加的顺序实现遍历；原因：在原有的HashMap基础上添加了一对指针，指向前一个和后一个元素；对于频繁的遍历操作，此类执行效率要高于HashMap；
 *              |---TreeMap:保证按照添加key—value对进行排序，实现排序遍历。此时考虑key的自然排序或定制排序。（底层：红黑树）
 *              |---Hashtable:作为古老实现类；线程安全，效率低；不能存储null的key和value；
 *                  |---Properties:常用来处理配置文件；key和value都是String类型；
 *
 *
 *     HashMap的底层：jdk7之前：数组+链表
 *                   jdk8：数组+链表+红黑树
 *
 *     面试题：
 *        1.HashMap的底层实现原理？
 *        2.HashMap 和 Hashtable的异同？
 *        3.CurrentHashMap 与 Hashtable的异同？（暂时不讲）
 *
 * 二、Map结构的理解：
 *      1.Map中的key：无序的、不可重复的，使用Set存储所有的key；--->key所在的类要重写equals()和hashCode()（以HashMap为例）；
 *      2.Map中的value：无序的、可重复的，使用Collection存储所有的value；--->value所在的类要重写equals()；
 *      3.一个键值对（key-value）构成一个Entry对象；
 *      4.Map中的entry：无序的，不可重复的，使用Set存储所有的entry；
 *
 *
 * 三、HashMap的底层实现原理？
 *      1.过程：以jdk7为例：
 *      HashMap map =  new HashMap();//在实例化以后，底层创建了一个长度是16的一维数组Entry[] table;
 *      ...可能已经执行过多次put...
 *      map.put(key1,value1);//首先，调用key1所在类的hashCode()计算key1的哈希值，此哈希值经过哈希函数计算之后，得到在Entry数组中的存放位置。
 *                              //如果此位置上的数据为空，此时的key1-value1添加成功。 -----情况一
 *                              //如果此位置上的数据不为空（意味着此位置存在一个或多个数据（以链表形式存在）），比较key1和已经存在数据的哈希值：
 *                                  //若key1的哈希值与已经存在的数据的哈希值都不相同，此时key1-value1添加成功；-----情况二
 *                                  //若key1的哈希值与已经存在的某一个数据（key2-value2）的哈希值相同，继续比较：调用key1所在类的equals(key2)方法比较：
 *                                      //如果equals()返回false：此时key1-value1添加成功；-----情况三
 *                                      //如果equals()返回true：使用value1替换相value2；
 *      2.补充：
 *          关于情况二和情况三，此时key1-value1和原来的数据以链表的方式存储。
 *          在不断的添加过程中，会涉及到扩容问题，当超出临界值时（且要存放的位置非空时），默认的扩容方式扩容为原来的2倍，并将原来的数据复制过来。
 *
 *      3.jdk8 相较于 jdk7 在底层实现方面的不同：
 *          3.1 new HashMap():底层没有实时的创建一个长度为16的数组；
 *          3.2 jdk8底层的数组是Node[],而不是Entry[]；
 *          3.3 首次调用put()方法时，底层首次创建长度为16的数组；
 *          3.4 jdk7底层结构只有：数组+链表。jdk8中底层结构：数组+链表+红黑树；
 *              当数组的某一个索引位置上的元素以链表形式存在的数据个数大于8且当前数组的长度超过64，此时此索引上的所有数据改为使用红黑树存储；
 *
 * 四、LinkHashMap的底层实现原理
 *      能够记录添加的元素的先后顺序。
 *
 * 五、Map中定义的方法；（以HashMap为例）
         *  添加、删除、修改操作：
             *  Object put(Object key,Object value)：将指定key-value添加到(或修改)当前map对象中
             *  void putAll(Map m):将m中的所有key-value对存放到当前map中
             *  Object remove(Object key)：移除指定key的key-value对，并返回value
             *  void clear()：清空当前map中的所有数据
         *  元素查询的操作：
             *  Object get(Object key)：获取指定key对应的value
             *  boolean containsKey(Object key)：是否包含指定的key
             *  boolean containsValue(Object value)：是否包含指定的value
             *  int size()：返回map中key-value对的个数
             *  boolean isEmpty()：判断当前map是否为空
             *  boolean equals(Object obj)：判断当前map和参数对象obj是否相等
         *  元视图操作的方法：
             *  Set keySet()：返回所有key构成的Set集合
             *  Collection values()：返回所有value构成的Collection集合
             *  Set entrySet()：返回所有key-value对构成的Set集合
 *
 * 总结：
 * 添加：Object put(Object key,Object value)
 * 删除：Object remove(Object key)
 * 修改：Object put(Object key,Object value)
 * 查询：Object get(Object key)
 * 长度：int size()
 * 遍历：keySet()/values()/entrySet()
 *
 * @author taia
 * @creat 2021-10-22-17:47
 */
public class MapTest {
    /*   元视图操作的方法：
             *  Set keySet()：返回所有key构成的Set集合
             *  Collection values()：返回所有value构成的Collection集合
             *  Set entrySet()：返回所有key-value对构成的Set集合
    */
    @Test
    public void test4(){
        Map map = new HashMap();
        map.put("AA",123);
        map.put(45,123);
        map.put("BB",56);
        map.put("AA",87);

        //遍历所有的key集：
        Set set = map.keySet();
        Iterator iterator = set.iterator();
        while(iterator.hasNext()){
            System.out.println(iterator.next());
        }
        //遍历所有的value集：
        Collection values = map.values();
        for(Object obj : values){
            System.out.println(obj);
        }
        //遍历entry数组：
        //方式一：
        Set set1 = map.entrySet();
        Iterator iterator1 = set1.iterator();
        while(iterator1.hasNext()){
            Object obj = iterator1.next();
            //entrySet集合中的元素都是entry
            Map.Entry entry = (Map.Entry)obj;

            System.out.println(entry.getKey() + "----->" + entry.getValue());

        }
        //方式二：
        Set keySet = map.keySet();
        Iterator iterator2 = keySet.iterator();
        while(iterator2.hasNext()){
            Object key = iterator2.next();
            Object value = map.get(key);
            System.out.println(key + "++++++>" + value);
        }
    }





    /*
     *  添加、删除、修改操作：
     *  Object put(Object key,Object value)：将指定key-value添加到(或修改)当前map对象中
     *  void putAll(Map m):将m中的所有key-value对存放到当前map中
     *  Object remove(Object key)：移除指定key的key-value对，并返回value
     *  void clear()：清空当前map中的所有数据
    * */
    @Test
    public void test3(){
        Map map = new HashMap();
        //添加
        map.put("AA",123);
        map.put(45,123);
        map.put("BB",56);
        //修改
        map.put("AA",87);

        System.out.println(map);

        Map map1 = new HashMap();
        map1.put("CC",123);
        map1.put("DD",123);

        map.putAll(map1);
        System.out.println(map);

        //remove(Object key)
        Object value = map.remove("CC");
        System.out.println(value);
        System.out.println(map);

        //clear()
        map.clear();//与 map = null; 不同
        System.out.println(map.size());

    }

    @Test
    public void test2(){
        Map map = new HashMap();
        map = new LinkedHashMap();

        map.put(123,"AA");
        map.put(345,"BB");
        map.put(12,"CC");

        System.out.println(map);
    }

    @Test
    public void test1(){
        Map map = new HashMap();
//        map = new Hashtable();//java.lang.NullPointerException
        map.put(null,null);
        System.out.println(map);


    }
}
