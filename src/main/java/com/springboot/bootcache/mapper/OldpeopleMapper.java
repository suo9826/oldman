package com.springboot.bootcache.mapper;

import com.springboot.bootcache.bean.Old_Nur;
import com.springboot.bootcache.bean.Oldpeople;
import org.apache.ibatis.annotations.*;

import java.util.ArrayList;

@Mapper
public interface OldpeopleMapper {
   @Update("update oldpeople set old_name=#{old_name},old_age=#{old_age},old_sex=#{old_sex},old_birthday=#{old_birthday},old_son=#{old_son},old_sonphone=#{old_sonphone},old_homeport=#{old_homeport},old_joindate=#{old_joindate},old_nurseid=#{old_nurseid},old_homeaddress=#{old_homeaddress} where id=#{id}")
   public void update(Oldpeople oldpeople);
   // 标记自增主键为什么，增加数据后会自动返回主键的值
    @Options(useGeneratedKeys = true,keyProperty = "id")
    @Insert("insert into oldpeople(old_name,old_age,old_sex,old_birthday,old_homeaddress,old_son,old_sonphone,old_homeport,old_nurseid,old_joindate) values(#{old_name},#{old_age},#{old_sex},#{old_birthday},#{old_homeaddress},#{old_son},#{old_sonphone},#{old_homeport},#{old_nurseid},#{old_joindate});")
    public void insert(Oldpeople oldpeople);
    @Delete("delete from oldpeople where id=#{id}")
    public void delete(Integer id);

    @Select("select * from oldpeople where id=#{id}")
    public Oldpeople selectByid(Integer id);
    @Select("select o.*,n.nurse_name from oldpeople o,nursing n where n.id=o.old_nurseid")
   // @ResultType(java.util.ArrayList.class)
    public ArrayList<Old_Nur> selectAll();

    @Select("select * from oldpeople where old_name=#{old_name}")
    // @ResultType(java.util.ArrayList.class)
    public Oldpeople selectByname(String odl_name);

    //查询老人表
    @Select("select o.*,n.nurse_name from oldpeople o,nursing n where o.old_nurseid=n.id and o.old_name=#{user_name}")
    public Old_Nur selectByoldname(String user_name);

}
