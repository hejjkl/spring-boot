package com.springbootmybatis.dao;

import com.springbootmybatis.entity.SyUserinfo;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;
import org.springframework.stereotype.Component;

import java.util.List;

@Mapper
@Component
public interface UserinfoMapper  {
    /**
     * 根据证件类型查询用户
     * @param idno
     * @return
     */
    @Select("select * from sy_userinfo where useridno=#{idno}")
    List<SyUserinfo> getUserinfoByIdno(@Param("idno") String idno);

    /**
     * 根据姓名查询用户
     * @param name
     * @return
     */
    SyUserinfo getUserinfoByName(@Param("name")String name);

}
