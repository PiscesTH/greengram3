package com.green.greengram3.dm;

import com.green.greengram3.common.ResVo;
import com.green.greengram3.dm.model.*;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.List;

@Slf4j
@Service
@RequiredArgsConstructor
public class DmService {
    private final DmMapper mapper;

    public List<DmSelMsgAllVo> getMsgAll(DmSelMsgDto dto){
        return mapper.selDmMsgAll(dto);
    }

    public List<DmSelVo> getDmAll(DmSelDto dto){
        return mapper.selDmAll(dto);
    }

    public ResVo postDmMsg(DmInsMsgDto dto) {
        int insResult = mapper.insDmMsg(dto);
        return new ResVo(dto.getSeq());
    }

    public ResVo delDmMsg(DmDelMsgDto dto) {
        int delResult = mapper.delDmMsg(dto);
        return new ResVo(delResult);
    }
}
