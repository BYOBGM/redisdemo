package com.pam.service.impl;

import com.pam.dao.ProvinceDao;
import com.pam.dao.impl.ProvinceDaoImpl;
import com.pam.domain.Province;
import com.pam.service.ProvinceService;

import java.util.List;

public class ProvinceServiceImpl implements ProvinceService {
    private ProvinceDao dao = new ProvinceDaoImpl();
    @Override
    public List<Province> findAll() {
        return dao.findAll();
    }
}
