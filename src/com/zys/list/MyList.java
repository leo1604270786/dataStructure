package com.zys.list;

/**
 * @program: dataStructure
 * @description: 自己定义的List接口 线性表
 * @author: Leo
 * @create: 2019-05-15 14:17
 */
public interface MyList {
    /** 
    * @Description: 返回列表的元素个数
    * @return: int 
    * @Author: Leo 
    */ 
    int size();
    /** 
    * @Description: 返回索引i的元素 
    * @Param: [i] 
    * @return: java.lang.Object 
    * @Author: Leo 
    */ 
    Object get(int i);
    /** 
    * @Description: 返回列表是否为空
    * @return: boolean 
    * @Author: Leo 
    */ 
    boolean isEmpty();
    /** 
    * @Description: 返回列表中是否包含元素e 
    * @Param: [e] 
    * @return: boolean 
    * @Author: Leo 
    */ 
    boolean contains(Object e);
    /** 
    * @Description: 返回元素e在列表中的索引 
    * @Param: [e] 
    * @return: int 
    * @Author: Leo 
    */ 
    int indexOf(Object e);
    /** 
    * @Description: 在列表最后添加元素element 
    * @Param: [element] 
    * @return: void 
    * @Author: Leo 
    */
    void add(Object element);
    /** 
    * @Description: 在索引位置添加元素element 
    * @Param: [index, element] 
    * @return: void 
    * @Author: Leo 
    */ 
    void add(int index, Object element);
    /** 
    * @Description: 在元素obj之前插入元素e 
    * @Param: [obj, e] 
    * @return: boolean 是否插入成功
    * @Author: Leo 
    */ 
    boolean addBefore(Object obj, Object e);
    /** 
    * @Description: 在元素obj之后插入元素e 
    * @Param: [obj, e] 
    * @return: boolean 是否插入成功
    * @Author: Leo 
    */ 
    boolean addAfter(Object obj, Object e);
    /** 
    * @Description: 从列表中移除索引为i的元素并返回
    * @Param: [i] 
    * @return: java.lang.Object 
    * @Author: Leo 
    */ 
    Object remove(int i);
    /** 
    * @Description: 从列表中移除第一个与元素e相同的元素
    * @Param: [e] 
    * @return: boolean 
    * @Author: Leo 
    */ 
    boolean remove(Object e);
    /** 
    * @Description: 以元素e替换列表中索引为i的元素并返回原数据 
    * @Param: [i, e] 
    * @return: java.lang.Object 
    * @Author: Leo 
    */ 
    Object replace(int i, Object e);
}
