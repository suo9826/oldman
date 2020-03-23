package com.springboot.bootcache.mapper;

import com.springboot.bootcache.bean.Statement;
import org.apache.ibatis.annotations.*;

import java.sql.Date;
import java.util.ArrayList;

@Mapper
public interface StatementMapper {
    @Select("select * from statement where date=#{date}")
    public Statement selectBydate(String date);

    @Select("select * from  statement   where date_format(date,'%Y-%m')=#{month}")
    public ArrayList<Statement> selectMoth(String month);

    @Options(useGeneratedKeys = true,keyProperty = "id")
    @Insert("insert into statement(out_oldpeople,in_oldpeople,make_money,expend_money,date,old,nurse) values(#{out_oldpeople},#{in_oldpeople},#{make_money},#{expend_money},#{date},#{old},#{nurse})")
    public void insertStatement(Statement statement);

    @Select("select * from statement")
    public ArrayList<Statement> selectAll();

    //增加老人的时候顺便修改 住院老人的数量
    @Update("update statement set in_oldpeople=#{in_oldpeople} where date=#{date}")
    public void updateIn(Statement statement);

    @Update("update statement set out_oldpeople=#{out_oldpeople} where date=#{date}")
    public void updateOut(Statement statement);
}
