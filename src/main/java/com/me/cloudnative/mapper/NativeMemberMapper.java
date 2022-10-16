package com.me.cloudnative.mapper;

import com.me.cloudnative.domain.NativeMember;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Options;
import org.apache.ibatis.annotations.Select;

import java.util.List;

@Mapper
public interface NativeMemberMapper {
    @Select("select * from PUBLIC.NATIVE_MEMBER")
    List<NativeMember> findAll();
    @Select("select * from PUBLIC.NATIVE_MEMBER where memid = #{memId} ")
    NativeMember fingById(String memId);
    @Insert(" insert into PUBLIC.NATIVE_MEMBER (memName,memNo,memCell,memAge) values (#{memName},#{memNo},#{memCell},#{memAge}) ")
    @Options(useGeneratedKeys = true,keyColumn = "memid")
    int addMem(String memName,String memNo,String memCell,Integer memAge);
}
