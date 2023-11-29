package com.green.greengram3.user;

import com.green.greengram3.common.ResVo;
import com.green.greengram3.user.model.UserSignupDto;
import com.green.greengram3.user.model.UserSignupProcDto;
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
}
