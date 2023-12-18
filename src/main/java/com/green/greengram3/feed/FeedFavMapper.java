package com.green.greengram3.feed;

import com.green.greengram3.feed.model.FeedToggleFavDto;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
public interface FeedFavMapper {
    int insFeedFav(FeedToggleFavDto dto);
    int delFeedFav(FeedToggleFavDto dto);
    List<FeedToggleFavDto> selFeedFavForTest(FeedToggleFavDto dto);
    int delFeedFavAll(int ifeed);
}
