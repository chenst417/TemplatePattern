package com.cn.study.templatepattern.jdbc.dao;

import com.cn.study.templatepattern.jdbc.JdbcTemplate;
import com.cn.study.templatepattern.jdbc.RowMapper;
import javax.sql.DataSource;
import java.sql.ResultSet;
import java.util.List;

public class MemberDao extends JdbcTemplate {

    public MemberDao(DataSource dataSource) {
        super(dataSource);
    }

    public List<?> selectAll(){
        String sql = "select * from member";
        return super.executeQuery(sql, new RowMapper<Member>() {
            @Override
            public Member mapRow(ResultSet resultSet, int rowNum) throws Exception {
                Member member = new Member();
                member.setUsername(resultSet.getString("username"));
                member.setPassword(resultSet.getString("password"));
                member.setAddr(resultSet.getString("addr"));
                member.setAge(resultSet.getInt("age"));
                return member;
            }
        }, null);
    }
}
