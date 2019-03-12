package com.kingdee.attendance.dao.impl;

import com.kingdee.attendance.dao.BaseDao;
import com.mongodb.client.result.DeleteResult;
import com.mongodb.client.result.UpdateResult;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.data.mongodb.core.query.Criteria;
import org.springframework.data.mongodb.core.query.Query;
import org.springframework.data.mongodb.core.query.Update;

import java.lang.reflect.ParameterizedType;
import java.lang.reflect.Type;
import java.util.List;
import java.util.Map;
import java.util.function.Consumer;

public class BaseDaoImpl<T> implements BaseDao<T> {

    @Autowired
    private MongoTemplate template;

    @Override
    public void save(T t) {
        template.save(t);
    }


    @Override
    public T find(String id) {
        return this.template.findOne(Query.query(Criteria.where("id").is(id)), getRealClass());
    }

    @Override
    public List<T> find(Query query) {
        return this.template.find(query, getRealClass());
    }

    @Override
    public T findOne(Map<String, Object> params) {
        Query query = new Query();
        for (String key : params.keySet()) {
            query.addCriteria(Criteria.where(key).is(params.get(key)));
        }
        return template.findOne(query, getRealClass());
    }

    @Override
    public void find(Query query, Consumer<T> consumer) {
        this.template.stream(query, getRealClass()).forEachRemaining(consumer);
    }

    @Override
    public long update(Query query, Update update) {
        UpdateResult result = this.template.updateMulti(query, update, getRealClass());
        return result.getModifiedCount();
    }

    @Override
    public long delete(Query query) {
        DeleteResult result = this.template.remove(query, getRealClass());
        return result.getDeletedCount();
    }

    @Override
    public void delete(String id) {

        this.template.remove(Query.query(Criteria.where("id").is(id)),getRealClass());
    }

    @Override
    public long count(Query query) {
        return this.template.count(query, getRealClass());
    }

    @Override
    public boolean exists(Query q) {
        return this.template.exists(q, getRealClass());
    }

    @SuppressWarnings("unchecked")
    private Class<T> getRealClass() {
        Type type = getClass().getGenericSuperclass();
        Type[] types = ((ParameterizedType) type).getActualTypeArguments();
        if (types.length == 1) {
            return (Class<T>) types[0];
        } else {
            throw new RuntimeException("获取泛型实际类型失败。");
        }
    }
}
