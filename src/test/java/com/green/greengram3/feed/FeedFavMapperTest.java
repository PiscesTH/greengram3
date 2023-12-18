package com.green.greengram3.feed;

import com.green.greengram3.feed.model.FeedToggleFavDto;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.mybatis.spring.boot.test.autoconfigure.MybatisTest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase;

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
                .ifeed(10)
                .iuser(11)
                .build();

        int insResult = mapper.insFeedFav(dto);
        assertEquals(1, insResult);
    }
}