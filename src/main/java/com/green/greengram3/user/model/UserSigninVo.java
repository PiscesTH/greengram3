package com.green.greengram3.user.model;

import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class UserSigninVo {
    private int result;
    private int iuser;
    private String nm;
    private String pic;
}
