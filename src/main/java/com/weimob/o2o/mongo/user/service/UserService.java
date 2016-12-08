package com.weimob.o2o.mongo.user.service;

import com.weimob.o2o.lang.MongoSearchEntity;
import com.weimob.o2o.mongo.user.entity.User;
import org.springframework.data.domain.Pageable;

import java.util.List;

/**
 * @author <a href="mailto:yong.zhao@weimob.com">carl.zhao<a/>
 * @version 1.0.0
 * @see UserService
 * @since 1.0.0 2016-12-08
 */
public interface UserService {

    List<User> findUserByCondition(User user);

    List<User> findUserByPage(User queryBean, MongoSearchEntity pageBean);

    void saveUser(User user);

}
