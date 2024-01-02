package com.green.greengram3;

import com.fasterxml.jackson.databind.ObjectMapper;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.context.annotation.Import;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.transaction.annotation.Transactional;

@Slf4j
@Import(CharEncodingConfig.class)
@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT) //통합테스트 어노테이션. 포트번호 랜덤
@AutoConfigureMockMvc
@Transactional
@AutoConfigureTestDatabase(replace = AutoConfigureTestDatabase.Replace.NONE)
public class BaseIntegrationTest {  //통합테스트 - 컨트롤러, 서비스, 맵퍼 전체 테스트. 포스트맨 보내보는 느낌

    @Autowired
    protected MockMvc mvc;

    @Autowired
    protected ObjectMapper om;
}
