package me.qin.music.mapper;

import me.qin.music.entity.Manageuser;
import me.qin.music.entity.ManageuserExample;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface ManageuserMapper {
    int countByExample(ManageuserExample example);

    int deleteByExample(ManageuserExample example);

    int insert(Manageuser record);

    int insertSelective(Manageuser record);

    List<Manageuser> selectByExample(ManageuserExample example);

    int updateByExampleSelective(@Param("record") Manageuser record, @Param("example") ManageuserExample example);

    int updateByExample(@Param("record") Manageuser record, @Param("example") ManageuserExample example);
}