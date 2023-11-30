package com.green.greengram3.user;

import com.green.greengram3.common.Const;
import com.green.greengram3.common.ResVo;
import com.green.greengram3.user.model.*;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.mindrot.jbcrypt.BCrypt;
import org.springframework.stereotype.*;

@Slf4j
@Service
@RequiredArgsConstructor
public class UserService {
    private final UserMapper userMapper;

    public ResVo signup(UserSignupDto dto){
        String hasedUpw = BCrypt.hashpw(dto.getUpw(),BCrypt.gensalt());
        UserSignupProcDto pDto = UserSignupProcDto.builder()
                .uid(dto.getUid())
                .nm(dto.getNm())
                .upw(hasedUpw)
                .pic(dto.getPic())
                .build();
        int insResult = userMapper.insUser(pDto);
        return new ResVo(pDto.getIuser());    //회원가입한 iuser pk 값 리턴
    }

    public UserSigninVo signin(UserSigninDto dto){
        UserSigninProcVo procVo = userMapper.selLoginInfoByUid(dto.getUid());
        if (procVo == null){
            return UserSigninVo.builder()
                    .result(Const.LOGIN_NO_UID)
                    .build();
        }
        if (BCrypt.checkpw(dto.getUpw(),procVo.getUpw())){
            return UserSigninVo.builder()
                    .iuser(procVo.getIuser())
                    .nm(procVo.getNm())
                    .pic(procVo.getPic())
                    .result(Const.LOGIN_SUCCESS)
                    .build();
        }
        return UserSigninVo.builder().result(Const.LOGIN_DIFF_UPW).build();
    }
}
