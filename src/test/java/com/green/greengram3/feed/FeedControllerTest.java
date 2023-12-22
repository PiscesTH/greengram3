package com.green.greengram3.feed;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.green.greengram3.common.ResVo;
import com.green.greengram3.feed.model.FeedInsDto;
import com.green.greengram3.feed.model.FeedSelVo;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.util.LinkedMultiValueMap;
import org.springframework.util.MultiValueMap;

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.BDDMockito.given;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@WebMvcTest(FeedController.class) //스프링 컨테이너 올려줌. feedController 빈 등록 됨
class FeedControllerTest {

    @Autowired
    private MockMvc mvc;    //가상 신호 전송 ?
    @MockBean
    private FeedService service;
    @Autowired
    private ObjectMapper mapper;

    @Test
    void postFeed() throws Exception {
        ResVo result = new ResVo(2);
        //when(service.postFeed(any())).thenReturn(result);
        given(service.postFeed(any())).willReturn(result);  //when과 같은 효과
        //given - when - then
        //given : 세팅 / when : 실행 / then : 검증
        FeedInsDto dto = new FeedInsDto();

        String json = mapper.writeValueAsString(dto);
        System.out.println(json);
        mvc.perform(
                        MockMvcRequestBuilders.post("/api/feed") //통신 요청
                                .contentType(MediaType.APPLICATION_JSON)    //헤더 부분. json 형식으로 설정
                                .content(mapper.writeValueAsString(dto))    //바디 부분. json 형식으로 변환
                )
                .andExpect(status().isOk())     //status : 상태값. 통신 응답 결과
                .andExpect(content().string(mapper.writeValueAsString(result))) //바디에 담긴 문자열이 기대한 값인가 ?
                .andDo(print());    //통신에 결과 출력 ?

        verify(service).postFeed(any());
    }

    @Test
    void getAllFeed() throws Exception {
        MultiValueMap<String, String> params = new LinkedMultiValueMap<>();
        params.add("page", "2");
        params.add("loginedIuser", "4");
        List<FeedSelVo> result = new ArrayList<>();
        result.add(new FeedSelVo());
        given(service.getAllFeed(any())).willReturn(result);

        mvc.perform(
                        MockMvcRequestBuilders.get("/api/feed")
                                .params(params)
                )
                .andExpect(status().isOk())
                .andExpect(content().string(mapper.writeValueAsString(result)))
                .andDo(print());

        verify(service).getAllFeed(any());
    }

    @Test
    void toggleFav() {
    }

    @Test
    void delFeed() throws Exception {
        MultiValueMap<String, String> params = new LinkedMultiValueMap<>();
        params.add("ifeed", "1");
        params.add("iuser", "2");

        ResVo result = new ResVo(1);
        given(service.delFeed(any())).willReturn(result);
        mvc.perform(
                        MockMvcRequestBuilders.delete("/api/feed")
                                .params(params)
                )
                .andExpect(status().isOk())
                .andExpect(content().string(mapper.writeValueAsString(result)))
                .andDo(print());

        verify(service).delFeed(any());
    }
}