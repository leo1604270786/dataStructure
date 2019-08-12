package com.zys.test;

import com.zys.list.arraylist.MyArrayList;
import com.zys.list.MyList;
import org.junit.Before;
import org.junit.Test;

/**
 * @program: dataStructure
 * @description: MyArrayList测试类
 * @author: Leo
 * @create: 2019-05-15 14:20
 **/
public class MyArrayListTest {
    MyList myList;
    //所有测试方法执行之前都会执行
    @Before
    public void createMyArrayList(){

        myList = new MyArrayList();
        myList.add(25);
        myList.add(28);
        myList.add(46);
        myList.add(28);
        myList.add(17);
    }
    @Test
    public void testAddRemove() {

        myList.add(2,66);

        System.out.println("列表是否为空："+myList.isEmpty());
        System.out.println("列表元素个数："+myList.size());
        System.out.println(String.format("索引为 %s 的元素：",2)+myList.get(2));
        System.out.println("遍历列表元素：");
        System.out.println(myList.toString());

        //list.remove(-1);
        //list.remove(new Integer(78));
        myList.remove(Integer.valueOf(78));
        System.out.println("列表元素个数："+myList.size());
        System.out.println("遍历列表元素：");
        System.out.println(myList.toString());
        /*for (int i = 0; i < list.size(); i++)
            System.out.print(list.get(i)+" ");*/
    }
    @Test
    public void testReplace(){

        System.out.println("遍历列表元素：");
        System.out.println(myList.toString());
        Integer rep = (Integer) myList.replace(2,Integer.valueOf(33));
        System.out.println("被替换的元素："+rep);
        System.out.println("遍历列表元素：");
        System.out.println(myList.toString());

    }
    @Test
    public void testContains(){

        System.out.println("遍历列表元素：");
        System.out.println(myList.toString());
        //缓存数组中的17 所以返回true
        //System.out.println("是否包含17："+list.contains(Integer.valueOf(17)));
        //并不是缓存数组中的17
        System.out.println("是否包含17："+myList.contains(new Integer(17)));
}
    @Test
    public void testAddBeforeAndAfter(){

        System.out.println("遍历列表元素：");
        System.out.println(myList.toString());
        //list.addBefore(Integer.valueOf(17),new Integer(66));
        myList.addAfter(Integer.valueOf(17),new Integer((66)));

        System.out.println("遍历列表元素：");
        System.out.println(myList.toString());
    }
}