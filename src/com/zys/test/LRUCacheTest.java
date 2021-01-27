package com.zys.test;

import com.zys.cache.LRUCache;
import org.junit.Test;

/**
 * LRU算法测试
 *
 * @author Leo
 * @create 2021/1/27 9:55
 **/
public class LRUCacheTest {
    @Test
    public void testLRUCache() {
        LRUCache lRUCache = new LRUCache(2);
        lRUCache.put(1, 1); // 缓存是 {1=1}
        lRUCache.put(2, 2); // 缓存是 {1=1, 2=2}
        System.out.println(lRUCache.get(1)); //返回 1
        lRUCache.put(3, 3); // 该操作会使得key为 2的缓存作废，缓存是 {1=1, 3=3}
        System.out.println(lRUCache.get(2));// 返回 -1 ，缓存 2 已被删除
        lRUCache.put(4, 4); // 该操作会使得 key为 1 的缓存作废，缓存是 {4=4, 3=3}
        System.out.println(lRUCache.get(1));// 返回 -1 ，缓存 1 已被删除
        System.out.println(lRUCache.get(3));    // 返回 3
        System.out.println(lRUCache.get(4));    // 返回 4
    }
}