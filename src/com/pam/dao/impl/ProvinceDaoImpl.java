package com.pam.dao.impl;

import com.pam.dao.ProvinceDao;
import com.pam.domain.Province;
import com.pam.util.JDBCUtils;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;

import java.util.List;

public class ProvinceDaoImpl implements ProvinceDao {

    //
    private JdbcTemplate template = new JdbcTemplate(JDBCUtils.getDataSource());

    @Override
    public List<Province> findAll() {
        String sql = "select * from province ";
        List<Province> list = template.query(sql,new BeanPropertyRowMapper<Province>(Province.class));
        return list;
    }
}
