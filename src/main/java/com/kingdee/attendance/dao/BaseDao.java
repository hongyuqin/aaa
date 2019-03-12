package com.kingdee.attendance.dao;

import org.springframework.data.mongodb.core.query.Query;
import org.springframework.data.mongodb.core.query.Update;

import java.util.List;
import java.util.Map;
import java.util.function.Consumer;

public interface BaseDao<T> {

    void save(T t);

    List<T> find(Query query);

    T findOne(Map<String, Object> params);

    long update(Query query, Update update);


    T find(String id);

    long delete(Query query);

    void delete(String id);

    long count(Query query);

    boolean exists(Query q);

    void find(Query query, Consumer<T> consumer);


}
