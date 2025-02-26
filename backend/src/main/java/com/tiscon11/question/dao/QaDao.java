package com.tiscon11.question.dao;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.namedparam.MapSqlParameterSource;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.jdbc.core.namedparam.SqlParameterSource;
import org.springframework.stereotype.Component;

import com.tiscon11.question.entity.User;

@Component
public class QaDao {

    @Autowired
    private NamedParameterJdbcTemplate parameterJdbcTemplate;

    public User findUser(Integer userId, String userPassword) {
        String sql = "SELECT USER_ID, USER_PASSWORD, USER_NAME FROM USERS WHERE USER_ID = :userId AND USER_PASSWORD = :userPassword";
        SqlParameterSource paramSource = new MapSqlParameterSource()
            .addValue("userId", userId)
            .addValue("userPassword", userPassword);
            return parameterJdbcTemplate.queryForObject(sql, paramSource, (rs, rowNum) -> {
                return new User(
                    rs.getInt("USER_ID"),
                    rs.getString("USER_PASSWORD"),
                    rs.getString("USER_NAME")
                );
            });
    }
}


