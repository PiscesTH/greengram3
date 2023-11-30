package com.green.greengram3.user;

import com.green.greengram3.common.ResVo;
import com.green.greengram3.user.model.*;
import io.swagger.v3.oas.annotations.*;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.*;

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

    @PostMapping("/signin")
    public UserSigninVo postSignin(@RequestBody UserSigninDto dto){
        return service.signin(dto);
    }
}
