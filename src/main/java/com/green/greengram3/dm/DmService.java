package com.green.greengram3.dm;

import com.green.greengram3.dm.model.DmSelMsgDto;
import com.green.greengram3.dm.model.DmSelMsgVo;
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

        return null;
    }
}
