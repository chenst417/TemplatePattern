package com.cn.study.templatepattern.jdbc;

import java.sql.ResultSet;

/**
 * ORM映射定制化的接口
 * @param <T>
 */
public interface RowMapper<T> {
    T mapRow(ResultSet resultSet, int rowNum) throws Exception;

}
