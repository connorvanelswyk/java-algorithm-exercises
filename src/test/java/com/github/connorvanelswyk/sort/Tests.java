package com.github.connorvanelswyk.sort;

import lombok.extern.log4j.Log4j2;
import org.junit.After;
import org.junit.FixMethodOrder;
import org.junit.Test;
import org.junit.runners.MethodSorters;

@Log4j2
@FixMethodOrder(MethodSorters.NAME_ASCENDING)
public class Tests {

    int[] ints;

    @After
    public void after() {

    }

    @Test
    public void test_1() {
        ints = new int[]{2, 1, 1, 0, 1};
    }

    @Test
    public void test_2() {

    }

    @Test
    public void test_3() {

    }

}
