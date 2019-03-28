package com.cn.study.templatepattern.jdbc;

import javax.sql.DataSource;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

public abstract class JdbcTemplate {

    private DataSource dataSource;

    public JdbcTemplate(DataSource dataSource) {
        this.dataSource = dataSource;
    }

    public List<?> executeQuery(String sql, RowMapper<?> rowMapper, Object[] values){
        try {
            //1、获取连接
            Connection connection = this.getConnection();
            //2、创建语句集
            PreparedStatement preparedStatement = this.createPrepareStatement(connection, sql);
            //3、执行语句集
            ResultSet resultSet = this.executeQuery(preparedStatement, values);
            //4、处理结果集
            List<?> result = this.paresResultSet(resultSet, rowMapper);
            //5、关闭结果集
            this.closeResultSet(resultSet);
            //6、关闭语句集
            this.closePreparedStatement(preparedStatement);
            //7、关闭连接
            this.closeConnection(connection);
        } catch (Exception e){
            e.printStackTrace();
        }
        return null;
    }

    protected Connection getConnection(){
        return this.getConnection();
    }

    protected PreparedStatement createPrepareStatement(Connection connection, String sql) throws  Exception {
        return connection.prepareStatement(sql);
    }

    protected ResultSet executeQuery(PreparedStatement preparedStatement, Object[] values) throws Exception {
        for (int i = 0; i < values.length; i++) {
            preparedStatement.setObject(i, values[i]);
        }
        return preparedStatement.executeQuery();
    }

    protected List<?> paresResultSet(ResultSet resultSet, RowMapper<?> rowMapper) throws Exception {
        List<Object> result = new ArrayList<Object>();
        int rowNum = 1;
        while(resultSet.next()){
            result.add(rowMapper.mapRow(resultSet, rowNum++));
        }
        return result;
    }

    protected void closeResultSet(ResultSet resultSet) throws Exception {
        resultSet.close();
    }

    protected void closePreparedStatement(PreparedStatement preparedStatement) throws Exception {
        preparedStatement.close();
    }

    protected void closeConnection(Connection connection) throws Exception {
        connection.close();
    }

}
