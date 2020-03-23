package com.springboot.bootcache.mycontroller;

import com.alibaba.fastjson.JSONObject;
import com.springboot.bootcache.bean.Old_Nur;
import com.springboot.bootcache.bean.Oldpeople;
import com.springboot.bootcache.bean.Statement;
import com.springboot.bootcache.service.OldSevice;
import com.springboot.bootcache.service.StateMentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.text.SimpleDateFormat;
import java.util.ArrayList;

@Controller
public class OldController {
    @Autowired
    OldSevice oldSevice;
    @Autowired
    StateMentService stateMentService;

    @ResponseBody
    @GetMapping("/updateOld")
    public String update(Oldpeople oldpeople)
    {
        oldSevice.update(oldpeople);

        return "1";
    }
    @ResponseBody
    @GetMapping("/insertOld")
    public String insert(Oldpeople oldpeople)
    {
        //查询对应时间的对应statement表里面的in_people，让他+1
        SimpleDateFormat simpleDateFormat=new SimpleDateFormat("yyyy-MM-dd");
        String format = simpleDateFormat.format(oldpeople.getOld_joindate());
        Statement statement = stateMentService.selectBydate(format);
        Statement s1=new Statement();
        s1.setDate(format);
        s1.setIn_oldpeople(statement.getIn_oldpeople()+1);
        oldSevice.insert(oldpeople);
//
//        return "show";
        return "1";
    }

    @ResponseBody
    @GetMapping("/deleteOldByname")
    public String deleteold(@RequestParam("id")Integer id)
    {
        //出院的人-1
        Oldpeople oldpeople = oldSevice.selectByid(id);
        SimpleDateFormat simpleDateFormat=new SimpleDateFormat("yyyy-MM-dd");
        String format = simpleDateFormat.format(oldpeople.getOld_joindate());
        Statement statement = stateMentService.selectBydate(format);
        Statement s1=new Statement();
        s1.setDate(format);
        s1.setOut_oldpeople(statement.getOut_oldpeople()+1);
        stateMentService.updateOut(s1);
        oldSevice.delete(id);
        return "1";
    }

    @ResponseBody
    @RequestMapping("/selectOldAll")
    public ArrayList<Old_Nur> selectAll(Model model)
    {
        ArrayList<Old_Nur> old_nurs = oldSevice.selectAll();
//        model.addAttribute("oldpeoples",oldpeoples);
//        System.out.println("controller"+oldpeoples);
//        return "showAllold";
        System.out.println("old+nurs"+old_nurs);
        return old_nurs;
    }

    @ResponseBody
    @GetMapping("/selectOldByname")
    public Old_Nur selectByname(@RequestParam("old_name")String old_name, Model model)
    {
        Old_Nur old_nur = oldSevice.selectByoldname(old_name);
        System.out.println(old_nur);
        return old_nur;
    }

    @ResponseBody
    @GetMapping("/selectByoldname")
    public Oldpeople selectOldByname2(@RequestParam("old_name")String old_name)
    {
        Oldpeople oldpeople = oldSevice.selectByname(old_name);
        return oldpeople;
//        String s = JSONObject.toJSONString(oldpeople);
//        System.out.println(s);
//        try {
//            PrintWriter writer = response.getWriter();
//            writer.print(s);
//
//            writer.close();
//        } catch (IOException e) {
//            e.printStackTrace();
//        }
    }
}
