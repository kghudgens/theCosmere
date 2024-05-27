package com.cosmere.enumerators;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest(classes = Publishers.class)
public class PublishersTest {

    @Test
    public void testValues() {
        Publishers gollancz = Publishers.GOLLANCZ;
        Publishers tor = Publishers.TOR;
        assertEquals("GOLLANCZ", gollancz.toString());
        assertEquals("TOR", tor.toString());
    }
}
