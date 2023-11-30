package com.green.greengram3.feed;

import com.green.greengram3.feed.model.FeedInsPicDto;
import com.green.greengram3.feed.model.FeedSelPicVo;
import com.green.greengram3.feed.model.FeedSelVo;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
public interface FeedPicsMapper {
    int insPic(FeedInsPicDto dto);
    List<FeedSelPicVo> selPicsByIfeeds(List<Integer> ifeeds);
}
