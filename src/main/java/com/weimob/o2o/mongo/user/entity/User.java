package com.weimob.o2o.mongo.user.entity;

import lombok.Data;
import org.springframework.data.annotation.Id;

import java.io.Serializable;

/**
 * @author <a href="mailto:yong.zhao@weimob.com">carl.zhao<a/>
 * @version 1.0.0
 * @see User
 * @since 1.0.0 2016-12-08
 */
@Data
public class User implements Serializable {

    @Id
    private Integer id;
    private String username;
    private Integer age;
    private String password;

}
