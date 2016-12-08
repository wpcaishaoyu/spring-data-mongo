package com.weimob.o2o.lang;

import lombok.AllArgsConstructor;
import lombok.Getter;


@Getter
@AllArgsConstructor
public enum Direction implements EnumCode<Integer> {
    ASC(1, "asc"),               // 升序
    DESC(2, "desc");             // 降序

    private Integer key;
    private String desc;
}
