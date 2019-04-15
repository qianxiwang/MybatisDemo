package com.study.Operation;

import com.study.domain.User;

import java.util.Map;

public interface UserOperation {

    public Map selectByName(String name);

    public void add(User user);


}
