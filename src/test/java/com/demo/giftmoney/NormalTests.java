package com.demo.giftmoney;

import com.sug.core.util.UUIDUtils;
import org.junit.Test;

import java.math.BigDecimal;
import java.util.Date;
import java.util.concurrent.ThreadLocalRandom;

public class NormalTests {

    @Test
    public void test(){
        for(int i = 0;i < 10; i ++)
        System.out.println(UUIDUtils.random());
    }

    @Test
    public void test1(){
        System.out.println(String.valueOf(new BigDecimal(12.234).setScale(2, BigDecimal.ROUND_UP).multiply(new BigDecimal(100)).intValue()));
    }
}
