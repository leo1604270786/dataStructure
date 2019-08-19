package com.zys.test;

import com.zys.divideandconquer.HanoiTower;
import org.junit.Test;

/**
 * @program: dataStructure
 * @description:
 * @author: Leo
 * @create: 2019-08-19 22:32
 **/
public class HanoiTowerTest {
    @Test
    public void testHanoiTower() {
        HanoiTower.hanoiTower(5, 'A', 'B', 'C');
    }
}