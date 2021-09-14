package com.jelipo.ishake.core;

import com.jelipo.ishake.core.pojo.Data;

import java.util.HashMap;
import java.util.List;


public class Main {

    public static void main(String[] args) {
        var data = new Data("", 1);
        var num = data.num();

        var map = new HashMap<String, Integer>();
        var easy = map.put("easy", 1);

        List<Integer> integers = List.of(1).stream().toList();
    }
}
