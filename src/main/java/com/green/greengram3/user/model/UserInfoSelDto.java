package com.green.greengram3.user.model;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Data;
import org.springframework.stereotype.Service;

@Data
public class UserInfoSelDto {
    private int targetIuser;
    private int loginedIuser;
}
