package com.green.greengram3.dm;

import com.green.greengram3.common.ResVo;
import com.green.greengram3.dm.model.*;
import com.green.greengram3.user.UserMapper;
import com.green.greengram3.user.model.UserSigninDto;
import com.green.greengram3.user.model.UserSigninProcVo;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.List;

@Slf4j
@Service
@RequiredArgsConstructor
public class DmService {
    private final DmMapper mapper;
    private final UserMapper userMapper;

    public List<DmSelMsgAllVo> getMsgAll(DmSelMsgDto dto) {
        return mapper.selDmMsgAll(dto);
    }

    public List<DmSelVo> getDmAll(DmSelDto dto) {
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

    public DmSelVo postDm(DmInsDto dto) {
        Integer existDmCheck = mapper.checkDmExist(dto);
        if (existDmCheck != null) {
            DmSelDto selDto = new DmSelDto();
            selDto.setLoginedIuser(dto.getLoginedIuser());
            List<DmSelVo> list = mapper.selDmAll(selDto);
            for (DmSelVo vo : list) {
                if (vo.getOtherPersonIuser() == existDmCheck) {
                    return vo;
                }
            }
        }
        /*int insDmResult = mapper.insDm(dto);
        if (insDmResult == 0) {
            return null; //dm방 생성 실패
        }*/
        int insDmFromUser = mapper.insDmUser(DmInsProcDto.builder()
                .idm(dto.getIdm())
                .iuser(dto.getLoginedIuser())
                .build());
        int insDmToUser = mapper.insDmUser(DmInsProcDto.builder()
                .idm(dto.getIdm())
                .iuser(dto.getOtherPersonIuser())
                .build());
        UserSigninProcVo procVo = userMapper.selLoginInfoByUid(UserSigninDto.builder()
                .iuser(dto.getOtherPersonIuser())
                .build());
        return DmSelVo.builder()
                .idm(dto.getIdm())
                .otherPersonIuser(dto.getOtherPersonIuser())
                .otherPersonNm(procVo.getNm())
                .otherPersonPic(procVo.getPic())
                .build();
    }
}
