package com.jelipo.ishake.core.pojo;

import java.beans.JavaBean;

@JavaBean()
public record Data(
        String name,
        Integer num
) {
}
