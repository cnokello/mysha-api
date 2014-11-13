package com.myhealth.util;

import java.util.Random;

import org.springframework.stereotype.Service;

@Service(value = "generalUtils")
public class GeneralUtils {

  private Random rand = new Random();

  public long generateRandomLongNum(long lower, long upper) {
    return lower + ((long) (rand.nextDouble() * (upper - lower)));
  }

}
