package com.green.greengram3.dm;

import com.green.greengram3.dm.model.DmSelDto;
import com.green.greengram3.dm.model.DmSelMsgDto;
import com.green.greengram3.dm.model.DmSelMsgVo;
import com.green.greengram3.dm.model.DmSelVo;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.List;

@Slf4j
@Service
@RequiredArgsConstructor
public class DmService {
    private final DmMapper mapper;

    public List<DmSelMsgVo> getMsgAll(DmSelMsgDto dto){
        return mapper.selDmMsgAll(dto);
    }

    public List<DmSelVo> getDmAll(DmSelDto dto){
        return mapper.selDmAll(dto);
    }
}
