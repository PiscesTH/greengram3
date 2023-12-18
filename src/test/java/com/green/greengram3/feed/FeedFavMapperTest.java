package com.green.greengram3.feed;

import com.green.greengram3.feed.model.FeedToggleFavDto;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.mybatis.spring.boot.test.autoconfigure.MybatisTest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;   //스태틱 메서드 이름만으로 사용 가능

@MybatisTest    //Mybatis를 테스트 한다.
@AutoConfigureTestDatabase(replace = AutoConfigureTestDatabase.Replace.NONE)
//기존 데이터 베이스로 테스트 할 때 사용
class FeedFavMapperTest {
    @Autowired
    private FeedFavMapper mapper;

    @Test
    @DisplayName("fav insert test")
    public void insFeedFav() {
        FeedToggleFavDto dto = FeedToggleFavDto.builder()
                .ifeed(20)
                .iuser(10)
                .build();

        int insResult = mapper.insFeedFav(dto);
        assertEquals(1, insResult);
        List<FeedToggleFavDto> selResult = mapper.selFeedFavForTest(dto);
        assertEquals(1,selResult.size());
    }

    @Test
    @DisplayName("fav delete test")
    public void delFeedFav() {
        FeedToggleFavDto dto = FeedToggleFavDto.builder()
                .ifeed(2)
                .iuser(1)
                .build();

        int delResult = mapper.delFeedFav(dto);
        assertEquals(1, delResult);
        int delResult2 = mapper.delFeedFav(dto);
        assertEquals(0, delResult2);
        List<FeedToggleFavDto> selResult = mapper.selFeedFavForTest(dto);
        assertEquals(0,selResult.size());
    }

    @Test
    @DisplayName("fav delete all test")
    public void delFeedFavAll() {
        FeedToggleFavDto dto = FeedToggleFavDto.builder()
                .ifeed(1)
                .build();

        List<FeedToggleFavDto> selResult = mapper.selFeedFavForTest(dto);
        int delAllResult = mapper.delFeedFavAll(1);
        assertEquals(selResult.size(), delAllResult);

        selResult = mapper.selFeedFavForTest(dto);
        assertEquals(0, selResult.size());
    }
}