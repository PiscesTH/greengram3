package com.green.greengram3.feed;

import com.green.greengram3.common.ResVo;
import com.green.greengram3.feed.model.FeedInsDto;
import com.green.greengram3.feed.model.FeedSelDto;
import com.green.greengram3.feed.model.FeedSelVo;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.context.annotation.Import;
import org.springframework.test.context.junit.jupiter.SpringExtension;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.ArgumentMatchers.assertArg;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

@ExtendWith(SpringExtension.class)  //스프링 객체화. 일부 테스트 할 때 사용 ? 필요한 것만 빈등록
@Import({FeedService.class})        //서비스만 빈 등록. 
class FeedServiceTest {
    @MockBean   //가상의 객체(가짜)의 주소값 할당
    private FeedMapper feedMapper;
    @MockBean   //서비스가 DI받는 것들 다 @MockBean으로 가상 주소값 받아와야 테스트 가능
    private FeedPicsMapper picsMapper;
    @MockBean   //※ mock : 모조품
    private FeedFavMapper favMapper;
    @MockBean
    private FeedCommentMapper commentMapper;
    @Autowired
    private FeedService service;

    @Test
    void postFeed() {
        when(feedMapper.insFeed(any())).thenReturn(1);  //특정 메서드가 호출되면 1 리턴
        //가짜 빈에게 임무를 준다. 같은 느낌 ?
        when(picsMapper.insPic(any())).thenReturn(3);   //any() : 파라미터로 어떠한 값이 와도

        FeedInsDto dto = new FeedInsDto();
        ResVo vo = service.postFeed(dto);

        verify(feedMapper).insFeed(any());  //메서드 실제로 호출했는지 확인
        verify(picsMapper).insPic(any());   //두번 호출하고 확인하면 에러 발생함
    }

    @Test
    void getAllFeed() {
        FeedSelVo vo1 = new FeedSelVo();
        vo1.setIfeed(1);
        vo1.setContents("1번 피드");
        FeedSelVo vo2 = new FeedSelVo();
        vo2.setIfeed(2);
        vo1.setContents("2번 피드");
        List<FeedSelVo> list = new ArrayList<>();
        list.add(vo1);
        list.add(vo2);

        when(feedMapper.selAllFeed(any())).thenReturn(list);

        List<String> picsList = Arrays.stream(new String[]{"1.jpg", "2.jpg"}).toList();
        when(picsMapper.selPicsByIfeeds(any())).thenReturn(any());
        when(picsMapper.selPicsByIfeeds(any())).thenReturn(any());

        FeedSelDto dto = new FeedSelDto();
        List<FeedSelVo> result = feedMapper.selAllFeed(dto);

        for (int i = 0; i < result.size(); i++) {
            FeedSelVo rVo = result.get(i);
            FeedSelVo pVo = list.get(i);

            assertEquals(pVo.getIfeed(), rVo.getIfeed());
            assertEquals(pVo.getContents(), rVo.getContents());
        }
    }

    @Test
    void toggleFeedFav() {
    }

    @Test
    void delFeed() {
    }
}