package com.springboot.bootcache.service;

import com.springboot.bootcache.bean.Statement;
import com.springboot.bootcache.mapper.StatementMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;

@Service
public class StateMentService {
    @Autowired
    StatementMapper statementMapper;
    public Statement selectBydate(String date)
    {
        return statementMapper.selectBydate(date);
    }

    public ArrayList<Statement> selectMonth(String month)
    {
        return statementMapper.selectMoth(month);
    }

    public void insertStatement(Statement statement)
    {
        statementMapper.insertStatement(statement);
    }

    public ArrayList<Statement> selectAll()
    {
        return statementMapper.selectAll();
    }

    public void updateIn(Statement statement){
        statementMapper.updateIn(statement);
    }
    public void updateOut(Statement statement){
        statementMapper.updateOut(statement);
    }

}
