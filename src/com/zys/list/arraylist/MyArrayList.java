package com.zys.list.arraylist;

import com.zys.list.MyList;

/**
 * @program: dataStructure
 * @description: 自己简单的实现ArrayList用于练习顺序表的操作
 * @author: Leo
 * @create: 2019-05-15 14:15
 **/
public class MyArrayList implements MyList {
    //用于存储列表中的数据
    private Object[] elementData;
    //表示列表汇总元素的个数
    private int size;

    public MyArrayList() {
        //如果不指定初始大小则默认为5
        this(5);
    }
    //指定初始大小
    public MyArrayList(int initialCapacity) {
        if (initialCapacity > 0){
            //初始化数组和 size(可不用,默认会初始化为0)
            elementData = new Object[initialCapacity];
        }
        //给定初始值不合法
        else {
            elementData = new Object[5];
        }
        size = 0;
    }

    @Override
    public int size() {
        return size;
    }

    @Override
    public Object get(int i) {
        //索引越界
        if(i < 0 || i >= size){
            throw new RuntimeException(String.format("索引i = %s 越界！",i));
        }
        return elementData[i];
    }

    @Override
    public boolean isEmpty() {
        return size == 0;
    }

    @Override
    public boolean contains(Object e) {
        for (int i = 0; i < size; i++){
            //存在于e相等的元素 这里是指同一个对象
            if(e == elementData[i] /*|| e.equals(elementData[i])*/){
                return true;
            }
        }
        return false;
    }

    @Override
    public int indexOf(Object e) {
        for (int i = 0; i < size; i++){
            //存在于e相等的元素 这里是指同一个对象
            if(e == elementData[i] /*|| e.equals(elementData[i])*/){
                return i;
            }
        }
        return -1;
    }
    //数组扩容
    private void grow(){
        //申请新数组，长度为原数组的2倍
        Object[] newArr = new Object[elementData.length * 2];
        for(int i = 0; i < size; i++)
            newArr[i] = elementData[i];
        //将数组指向新的数组
        elementData = newArr;

        //可以直接使用下面代码实现数组扩容+复制
        //elementData = Arrays.copyOf(elementData,elementData.length * 2);
    }
    @Override
    public void add(Object element) {
        /*//列表已满 需要扩容
        if (size == elementData.length){
            grow();
        }
        //将element存入数组，并且size++
        elementData[size++] = element;
        //System.out.println("length = " + elementData.length);*/

        //可以看做是方法add(int index, Object element)的特殊情况
        this.add(size,element);
    }

    @Override
    public void add(int index, Object element) {
        //列表已满 需要扩容
        if (size == elementData.length){
            grow();
        }
        //index越界,正确范围 [0,size]
        if (index < 0 || index > size)
            throw new RuntimeException(String.format("索引index = %s 越界",index));
        //先将列表中index后的元素后移
        for(int j = size; j > index; j--)
            elementData[j] = elementData[j-1];
        //将元素放入数组
        elementData[index] = element;
        //数组长度++
        size++;
    }

    @Override
    public boolean addBefore(Object obj, Object e) {
        int i;
        if((i = indexOf(obj)) != -1){
            add(i,e);
            return true;
        }
        return false;
    }

    @Override
    public boolean addAfter(Object obj, Object e) {
        int i;
        if((i = indexOf(obj)) != -1){
            add(i+1,e);
            return true;
        }
        return false;
    }

    @Override
    public Object remove(int i) {
        //i越界,正确范围 [0,size-1]
        if (i < 0 || i >= size)
            throw new RuntimeException(String.format("索引i = %s 越界",i));
        //先保存将要删除的元素
        Object deletedElement = this.get(i);
        //把将要删除的元素后面的元素全部前移
        for (int j = i+1; j < size; j++)
            elementData[j-1] = elementData[j];
        //列表元素个数--
        size--;
        return deletedElement;
    }

    @Override
    public boolean remove(Object e) {
        /*for (int i = 0; i < size; i++){
            //存在于e相等的元素 这里是指同一个对象
            if(e == elementData[i] *//*|| e.equals(elementData[i])*//*){
                remove(i);
                return true;
            }
        }
        return false;*/
        int i;
        if((i = indexOf(e)) != -1){
            remove(i);
            return true;
        }
        return false;
    }

    @Override
    public Object replace(int i, Object e) {
        //i越界,正确范围 [0,size-1]
        if (i < 0 || i >= size)
            throw new RuntimeException(String.format("索引i = %s 越界",i));
        //先保存将要被替换的元素
        Object replacedElement = get(i);
        //更新数据
        elementData[i] = e;
        return replacedElement;
    }

    @Override
    public String toString() {
        //为空
        if (isEmpty())
            return "[]";
        StringBuilder builder = new StringBuilder("[");
        for (int i = 0; i < size; i++){
            if(i == size - 1)
                builder.append(elementData[i]);
            else
                builder.append(elementData[i]+",");
        }
        builder.append("]");
        return builder.toString();
    }
}