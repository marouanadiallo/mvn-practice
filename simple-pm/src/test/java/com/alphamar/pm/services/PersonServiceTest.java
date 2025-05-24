package com.alphamar.pm.services;

import org.junit.jupiter.api.*;

@TestClassOrder(ClassOrderer.OrderAnnotation.class)
 class PersonServiceTest  {

    @BeforeAll
    static void initializer() {

    }

    @Nested
    @Order(9999)
    class ITPersonServiceTest {

    }
}
