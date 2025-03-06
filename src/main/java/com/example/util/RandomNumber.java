package com.example.util;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Random;

/**
 * @ClassName: RandomNumber
 * @Description: TODO
 * @Author: Zgz
 * @Date: 2023/4/20 11:01
 * @Version: 1.0
 **/
public class RandomNumber {
    public static <T> List<T> getRandomList(List<T> list, int n) {
        List<T> randomList = new ArrayList<T>();
        Random random = new Random();
        int size = list.size();
        if (size <= n) {
            return list;
        }
        for (int i = 0; i < n; i++) {
            int index = random.nextInt(size);
            randomList.add(list.get(index));
            list.remove(index);
            size--;
        }
        Collections.shuffle(randomList);
        return randomList;
    }

}
