package com.alphamar.pm.services;

import org.junit.jupiter.api.*;

@TestClassOrder(ClassOrderer.OrderAnnotation.class)
 class PersonProviderTest {

    @BeforeAll
    static void initializer() {

    }

    @Nested
    @Order(9999)
    class ITPersonProviderTest {

    }
}
