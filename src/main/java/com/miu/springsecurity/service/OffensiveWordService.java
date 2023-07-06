package com.miu.springsecurity.service;

import com.miu.springsecurity.entity.OffensiveUser;

public interface OffensiveWordService {
    OffensiveUser findByUserId(int userId);

    void saveOffensiveUser(OffensiveUser offensiveUser);

    boolean scanOffensiveWord(Object[] args);

    boolean checkIfBanned();

}
