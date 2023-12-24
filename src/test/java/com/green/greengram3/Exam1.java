package com.green.greengram3;


import org.junit.jupiter.api.*;

public class Exam1 {    //클래스 실행하면 클래스 아래의 메서드 전수조사. 클래스 이름 자유

    @Test   //메서드 테스트 할 때 사용
    @DisplayName("테스트 중")   //옵션. 적는걸 권장. 안적으면 메서드 이름으로 나옴. 메서드 이름 자유
    public void test1() {   //메서드는 void로 작성해야함
        System.out.println("test1");
        int sum = 2 + 2;
        Assertions.assertEquals(4, sum);    //왼쪽(기대값) 오른쪽(실제값) 비교. 같으면 테스트 성공, 다르면 실패
        //Assertions.assertEquals(5, sum);    //왼쪽(기대값) 오른쪽(실제값) 비교. 같으면 테스트 성공, 다르면 실패
    }

    @Test   //다양한 관점으로 테스트 하는걸 권장
    @Disabled   //해당 테스트 실행 안함
    public void test2() {   //메서드들은 각각 독립적. 호출은 순서대로 ? 처리는 스레드로 동시에
        System.out.println("test2");
        int multi = 2 * 3;
        Assertions.assertEquals(6, multi);
    }

    @Test
    @DisplayName("유틸 테스트")
    public void test3() {
        System.out.println("test3");
        Assertions.assertEquals(6, MyUtils.sum(2, 4));
        Assertions.assertEquals(8, MyUtils.sum(3, 5));
    }

    @Test
    @DisplayName("유틸 테스트2")
    public void test4() {
        System.out.println("test4");
        MyUtils utils = new MyUtils();
        Assertions.assertEquals(12, utils.multi(3, 4));
        Assertions.assertEquals(18, utils.multi(2, 9));
    }

    @BeforeAll
    public static void beforeTest() {
        System.out.println("boforeAll");
    }

    @AfterAll
    public static void afterTest() {
        System.out.println("afterAll");
    }

    @BeforeEach
    public void BETest() {
        System.out.println("beforeEach");
    }

    @AfterEach
    public void AETest() {
        System.out.println("afterEach");
    }
}
