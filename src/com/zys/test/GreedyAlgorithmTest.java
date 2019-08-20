package com.zys.test;

import org.junit.Before;
import org.junit.Test;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;

/**
 * @program: dataStructure
 * @description: 贪心算法
 * @author: Leo
 * @create: 2019-08-20 17:00
 **/
public class GreedyAlgorithmTest {
    //广播电台及其覆盖城市的信息
    private HashMap<String, HashSet<String>> broadcasts = new HashMap<>();
    //存放所有城市的信息
    private HashSet<String> cities = new HashSet<>();
    @Before
    public void init(){
        //初始化广播电台的信息
        HashSet<String> hashSet1 = new HashSet<>();
        hashSet1.add("北京");
        hashSet1.add("上海");
        hashSet1.add("天津");

        HashSet<String> hashSet2 = new HashSet<>();
        hashSet2.add("广州");
        hashSet2.add("北京");
        hashSet2.add("深圳");

        HashSet<String> hashSet3 = new HashSet<>();
        hashSet3.add("成都");
        hashSet3.add("上海");
        hashSet3.add("杭州");

        HashSet<String> hashSet4 = new HashSet<>();
        hashSet4.add("上海");
        hashSet4.add("天津");

        HashSet<String> hashSet5 = new HashSet<>();
        hashSet5.add("杭州");
        hashSet5.add("大连");

        broadcasts.put("K1",hashSet1);
        broadcasts.put("K2",hashSet2);
        broadcasts.put("K3",hashSet3);
        broadcasts.put("K4",hashSet4);
        broadcasts.put("K5",hashSet5);
        //初始化城市信息（也可以遍历获取）
        cities.add("北京");
        cities.add("上海");
        cities.add("天津");
        cities.add("广州");
        cities.add("深圳");
        cities.add("成都");
        cities.add("杭州");
        cities.add("大连");
    }

    @Test
    public void testGreedAlgorithm(){
        //存放已选择的广播电台的key
        List<String> selects = new ArrayList<>();
        //临时集合
        HashSet<String> tempSet = new HashSet<>();
        //不断选择可以覆盖最多未覆盖地区的广播电台
        while (!cities.isEmpty()){
            //可以覆盖最多未覆盖地区的广播电台的key
            String maxKey = null;
            for (String key : broadcasts.keySet()){
                //清空临时集合
                tempSet.clear();
                //获取当前key可以覆盖的城市，并放入tempSet中
                tempSet.addAll(broadcasts.get(key));
                //求出当前key可以覆盖的城市与剩余未覆盖城市的交集，并放入tempSet
                tempSet.retainAll(cities);
                //如果当前无最大值或当前key能覆盖的城市数量最大，则更新maxKey
                if (tempSet.size() > 0 && (maxKey == null || tempSet.size() > broadcasts.get(maxKey).size())){
                    maxKey = key;
                }
            }
            //找出了可以覆盖最多未覆盖地区的广播电台的key
            if (maxKey != null){
                //放入选择列表中
                selects.add(maxKey);
                //将当前key可以覆盖的城市从剩余城市中删除
                cities.removeAll(broadcasts.get(maxKey));
            }
        }
        System.out.println("选择的结果为：" + selects);
    }
}