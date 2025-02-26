package com.tiscon11.question.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.tiscon11.question.dao.QaDao;
import com.tiscon11.question.entity.User;

@Service
public class UserService {

    @Autowired
    private QaDao qaDAO;

    public User findUser(Integer userId, String password) {
        return qaDAO.findUser(userId, password);
    }
    
}
