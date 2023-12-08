package com.green.greengram3.dm;

import com.green.greengram3.dm.model.DmSelDto;
import com.green.greengram3.dm.model.DmSelMsgDto;
import com.green.greengram3.dm.model.DmSelMsgVo;
import com.green.greengram3.dm.model.DmSelVo;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
public interface DmMapper {
    int insDm ();
    int insDmUser();
    List<DmSelMsgVo> selDmMsgAll(DmSelMsgDto dto);
    List<DmSelVo> selDmAll(DmSelDto dto);
}
