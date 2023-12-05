package com.green.greengram3.user;

import com.green.greengram3.common.ResVo;
import com.green.greengram3.feed.model.FeedSelVo;
import com.green.greengram3.user.model.*;
import io.swagger.v3.oas.annotations.*;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Slf4j
@RestController
@RequiredArgsConstructor
@RequestMapping("/api/user")
public class UserController {
    private final UserService service;

    @Operation(summary = "회원가입", description = "회원가입용 정보")
    @PostMapping("/signup")
    public ResVo postSignup(@RequestBody UserSignupDto dto){
        return service.signup(dto);
    }

    @Operation(summary = "로그인", description = "result = 1: 로그인 성공 / 2: 아이디 없음 / 3: 비밀번호 틀림")
    @PostMapping("/signin")
    public UserSigninVo postSignin(@RequestBody UserSigninDto dto){
        return service.signin(dto);
    }

    @Operation(summary = "팔로우 처리")
    @PostMapping("/follow")
    public ResVo toggleFollow(@RequestBody UserFollowDto dto){
        return service.toggleFollow(dto);
    }


}
