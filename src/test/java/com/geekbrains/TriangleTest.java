package com.geekbrains;

import com.geekbrains.lesson4.Triangle;
import org.junit.jupiter.api.*;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import static org.junit.jupiter.api.Assertions.assertNotNull;

public class TriangleTest {
    private static Logger logger = LoggerFactory.getLogger(TriangleTest.class);

    @BeforeAll
    static void beforeAll() {

        //logger.trace("TRACE");
        logger.info("INFO");
        logger.debug("DEBUG");
        logger.error("ERROR");
        System.out.println("Method executed once before all tests");
    }

    @BeforeEach
    void beforeEach() {
        System.out.println("Method executed before each test");
    }

    @Test
    @DisplayName("Positive test with a real triangle")
    void givenTriangleWhenRealThenCalcSquare() throws Exception {
        Assertions.assertEquals(54.6437, Triangle.SquareOfTriangle(10, 11, 14), 0.0001);
    }

    @Test
    @DisplayName("Negative test with a negative side of triangle")
    void incorrectSideOfTriangleTest() {
        Assertions.assertThrows(Exception.class, () -> Triangle.SquareOfTriangle(10, 0, 14));
    }

    @Test
    @DisplayName("Negative test with a not exist triangle")
    void incorrectTriangleTest() {
        Assertions.assertThrows(Exception.class, () -> Triangle.SquareOfTriangle(4, 9, 14));
    }

    @AfterEach
    void afterEach() {
        System.out.println("Method executed after each test");

    }

    @AfterAll
    static void afterAll() {
        System.out.println("Method executed after all tests");
    }
}
