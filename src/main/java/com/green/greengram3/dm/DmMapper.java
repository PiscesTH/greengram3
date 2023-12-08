package com.green.greengram3.dm;

import com.green.greengram3.dm.model.*;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
public interface DmMapper {
    int insDmMsg(DmInsMsgDto dto);
    List<DmSelMsgVo> selDmMsgAll(DmSelMsgDto dto);
    List<DmSelVo> selDmAll(DmSelDto dto);
}
