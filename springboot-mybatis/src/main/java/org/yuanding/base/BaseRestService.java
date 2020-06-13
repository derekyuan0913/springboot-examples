package org.yuanding.base;

import com.github.pagehelper.Page;

import java.util.List;

public interface BaseRestService<T> {

    public List<T> list();

    public Page<T> listByPage();

    public T get(int id);

    public int add(T entity);

    public int update(T entity);

    public int delete(int id);
}
