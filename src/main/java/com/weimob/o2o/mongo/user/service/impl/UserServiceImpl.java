package com.weimob.o2o.mongo.user.service.impl;

import com.weimob.o2o.lang.MongoSearchEntity;
import com.weimob.o2o.mongo.user.entity.User;
import com.weimob.o2o.mongo.user.service.UserService;
import com.weimob.o2o.mongo.user.utils.MongoQueryUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Pageable;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.data.mongodb.core.query.Query;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @author <a href="mailto:yong.zhao@weimob.com">carl.zhao<a/>
 * @version 1.0.0
 * @see UserServiceImpl
 * @since 1.0.0 2016-12-08
 */
@Service
public class UserServiceImpl implements UserService {

    private final static String USER_COLLECTION_NAME = "user";

    @Autowired
    private MongoTemplate mongoTemplate;

    public List<User> findUserByCondition(User user) {
        Query queryBean = MongoQueryUtils.getMongoQuery(user);
        List<User> users = mongoTemplate.find(queryBean, User.class, USER_COLLECTION_NAME);
        return users;
    }

    public List<User> findUserByPage(User user, MongoSearchEntity pageBean){
        Query queryBean = MongoQueryUtils.getMongoQueryWithPage(user, pageBean);
        return mongoTemplate.find(queryBean, User.class, USER_COLLECTION_NAME);
    }

    public void saveUser(User user) {
        mongoTemplate.save(user, USER_COLLECTION_NAME);
    }
}
