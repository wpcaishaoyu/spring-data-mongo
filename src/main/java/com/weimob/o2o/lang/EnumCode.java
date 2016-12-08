package com.weimob.o2o.lang;

/**
 * @author <a href="mailto:yong.zhao@weimob.com">carl.zhao<a/>
 * @version 1.0.0
 * @see EnumCode
 * @since 1.0.0 2016-12-08
 */
public interface EnumCode<K> {

    K getKey();

    String getDesc();

}
