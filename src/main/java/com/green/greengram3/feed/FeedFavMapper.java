package com.green.greengram3.feed;

import com.green.greengram3.feed.model.FeedToggleFavDto;
import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface FeedFavMapper {
    int insFeedFav(FeedToggleFavDto dto);
    int delFeedFav(FeedToggleFavDto dto);
    FeedToggleFavDto selFeedFavForTest(FeedToggleFavDto dto);
}
