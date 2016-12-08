package com.weimob.o2o.lang;

import lombok.Data;

import java.io.Serializable;
import java.util.List;

/**
 * @author <a href="mailto:yong.zhao@weimob.com">carl.zhao<a/>
 * @version 1.0.0
 * @see MongoSearchEntity
 * @since 1.0.0 2016-12-08
 */
@Data
public class MongoSearchEntity implements Serializable {

    /** 第一页 */
    private int page = 1;
    /** 每页10条记录 */
    private int size = 10;
    private List<String> sortname;
    private Integer sortorder;

}
