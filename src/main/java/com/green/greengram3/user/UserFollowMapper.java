package com.green.greengram3.user;

import com.green.greengram3.user.model.UserFollowDto;
import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface UserFollowMapper {
    int insFollow(UserFollowDto dto);
    int delFollow(UserFollowDto dto);

}
