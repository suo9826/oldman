package com.springboot.bootcache.service;

import com.springboot.bootcache.bean.Nursing;
import com.springboot.bootcache.mapper.NursingMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;

@Service
public class NurseService {

    @Autowired
    NursingMapper nursingMapper;

    public void insert(Nursing nursing)
    {
        nursingMapper.insert(nursing);
        System.out.println(nursing.toString());
    }

    public Nursing selectByName(String nuser_name)
    {
       return   nursingMapper.selectByName(nuser_name);
    }

    public ArrayList<Nursing> selectAll()
    {
        return   nursingMapper.selectAll();
    }

    public void deleteByid(Integer id){nursingMapper.delete(id);}

    public void updat(Nursing nursing)
    {
        nursingMapper.update(nursing);
    }


}
