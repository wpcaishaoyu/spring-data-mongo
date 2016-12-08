package com.weimob.o2o.mongo.user.utils;

import com.weimob.o2o.lang.Direction;
import com.weimob.o2o.lang.MongoSearchEntity;
import org.springframework.data.domain.Sort;
import org.springframework.data.mongodb.core.query.Criteria;
import org.springframework.data.mongodb.core.query.Query;
import org.springframework.util.CollectionUtils;

import java.beans.BeanInfo;
import java.beans.IntrospectionException;
import java.beans.Introspector;
import java.beans.PropertyDescriptor;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.List;

/**
 * @author <a href="mailto:yong.zhao@weimob.com">carl.zhao<a/>
 * @version 1.0.0
 * @see MongoQueryUtils
 * @since 1.0.0 2016-12-08
 */
public abstract class MongoQueryUtils {

    public static Query getMongoQuery(Object obj){
        Query query = new Query();
        if(null == obj){
            return query;
        }
        try {
            BeanInfo beanInfo = Introspector.getBeanInfo(obj.getClass());
            PropertyDescriptor[] propertyDescriptors = beanInfo.getPropertyDescriptors();
            for(PropertyDescriptor propertyDescriptor : propertyDescriptors){
                if("class".equals(propertyDescriptor.getName())){
                    continue;
                }
                Method readMethod = propertyDescriptor.getReadMethod();
                Object value = readMethod.invoke(obj);
                if(null != value){
                    // generate query
                    Criteria criteria = Criteria.where(propertyDescriptor.getDisplayName()).is(value);
                    query.addCriteria(criteria);
                }
            }
            return query;
        } catch (IntrospectionException e) {
            e.printStackTrace();
        } catch (InvocationTargetException e) {
            e.printStackTrace();
        } catch (IllegalAccessException e) {
            e.printStackTrace();
        }
        return query;
    }

    public static Query getMongoQueryWithPage(Object obj, MongoSearchEntity searchEntity){
        Query mongoQuery = getMongoQuery(obj);

        int page = searchEntity.getPage();
        int size = searchEntity.getSize();
        mongoQuery.skip((page - 1) * size + 1);
        mongoQuery.limit(size);
        List<String> sortNames = searchEntity.getSortname();
        if(CollectionUtils.isEmpty(sortNames)){
            return mongoQuery;
        }
        Sort sort;
        Integer direction = searchEntity.getSortorder();

        if(Direction.DESC.getKey().equals(direction)){
            sort = new Sort(Sort.Direction.DESC, sortNames);
        } else if (Direction.ASC.getKey().equals(direction)){
            sort = new Sort(Sort.Direction.ASC, sortNames);
        } else {
            String[] propertyArray = new String[sortNames.size()];
            for(int i = 0; i < sortNames.size(); i++){
                propertyArray[i] = sortNames.get(i);
            }
            sort = new Sort(propertyArray);
        }
        mongoQuery.with(sort);
        return mongoQuery;
    }


}
