package com.springboot.bootcache.mycontroller;

import com.springboot.bootcache.bean.Statement;
import com.springboot.bootcache.service.StateMentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.*;

@Controller
public class StatementController {

    @Autowired
    StateMentService stateMentService;

    //查询指定日期
    @ResponseBody
    @GetMapping("/selectStatementBydate")
    public Statement selectBydate(Date date)
    {
//        Date date1=new Date();
//        System.out.println(date1);
        SimpleDateFormat simpleDateFormat=new SimpleDateFormat("yyyy-MM-dd");
        String format = simpleDateFormat.format(date);
        return stateMentService.selectBydate(format);
    }

    //查询指定月份
    @ResponseBody
    @GetMapping("/selectStatementBymonth")
    public Map selectBymonth(String date) throws ParseException {
        Date date1 = new SimpleDateFormat("yyyy-MM-dd").parse(date);
        SimpleDateFormat simpleDateFormat=new SimpleDateFormat("yyyy-MM");
        String month = simpleDateFormat.format(date1);
        ArrayList<Statement> statements = stateMentService.selectMonth(month);

        int out_Old=0;
        int in_Old=0;
        int make_money=0;
        int expend_Money=0;
        Iterator<Statement> iterator = statements.iterator();
        while (iterator.hasNext())
        {
            Statement next = iterator.next();

            out_Old += next.getOut_oldpeople();
            in_Old += next.getIn_oldpeople();
            make_money += next.getMake_money();
            expend_Money += next.getExpend_money();
        }
        Statement statement=new Statement();
        statement.setOut_oldpeople(out_Old);
        statement.setIn_oldpeople(in_Old);
        statement.setMake_money(make_money);
        statement.setExpend_money(expend_Money);
        statement.setDate(month);
        System.out.println(statement);

        Map map=new HashMap();
        map.put("arr",statements);
        map.put("abc",statement);
        return map;
    }

    //增加
    @ResponseBody
    @GetMapping("/insertStatement")
    public int insertStatement(Statement statement)
    {
//        statement.setDate("2020-03-15");
//        statement.setExpend_money(11);
//        statement.setIn_oldpeople(22);
//        statement.setOut_oldpeople(33);
//        statement.setMake_money(44);
        stateMentService.insertStatement(statement);
        return 1;
    }

    //查询所有
    @ResponseBody
    @GetMapping("/selectAllstatement")
    public ArrayList<Statement> selectAll()
    {
         return stateMentService.selectAll();
    }

}
