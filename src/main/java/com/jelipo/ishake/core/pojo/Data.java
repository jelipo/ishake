package com.jelipo.ishake.core.pojo;

public record Data(
        String name,
        Integer num
) {
    public void test() {
        System.out.println("a");
    }

    public void test(String a) {
        System.out.println(a);
    }


}
