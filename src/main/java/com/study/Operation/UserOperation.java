package com.study.Operation;

import com.study.domain.User;

import java.util.Map;

/**
 * 对单表的增删改查
 */
public interface UserOperation {

    public Map selectByName(String name);

    public void add(User user);

    public void update(User user);

    public void delete(String name);

}
