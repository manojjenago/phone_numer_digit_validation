package com.example.springboot;

import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

public class TestPhoneNumberCheck {
  @Test
  public void testCheckWordExistence () {
    PhoneNumberCheck phoneNumberCheck = new PhoneNumberCheck();
    assertTrue(phoneNumberCheck.checkWordExistence("tree", "8733"));
    assertTrue(phoneNumberCheck.checkWordExistence("used", "8733"));
    assertFalse(phoneNumberCheck.checkWordExistence("true", "8733"));
    assertTrue(phoneNumberCheck.checkWordExistence("treef", "87333"));
  }

  @Test
  public void testCompareValidWordsLengthWithNumber () {
    PhoneNumberCheck phoneNumberCheck = new PhoneNumberCheck();
    assertTrue(phoneNumberCheck.compareValidWordsLengthWithNumber("tree", "8733"));
    assertFalse(phoneNumberCheck.compareValidWordsLengthWithNumber("tree", "87334"));
    assertFalse(phoneNumberCheck.compareValidWordsLengthWithNumber("treee", "8733"));
  }

  @Test
  public void testGetMatchingWords() {
    PhoneNumberCheck phoneNumberCheck = new PhoneNumberCheck();
    List<String> eligibleWords = phoneNumberCheck.getMatchingWords(new LinkedList<>(Arrays.asList("apple", "arm", "sum", "moon", "used", "truck", "tree", "trend", "try", "true")), "8733");
    assertTrue(eligibleWords.contains("tree"));
    assertTrue(eligibleWords.contains("used"));
    assertEquals(2, eligibleWords.size());
  }

  @Test
  public void testUpperCaseDuplicateCheck() {
    PhoneNumberCheck phoneNumberCheck = new PhoneNumberCheck();
    List<String> eligibleWords = phoneNumberCheck.getMatchingWords(new LinkedList<>(Arrays.asList("tree", "tree")), "8733");
    assertTrue(eligibleWords.contains("tree"));
    assertEquals(1, eligibleWords.size());
  }

  @Test
  public void testInvalidParam() {
    PhoneNumberCheck phoneNumberCheck = new PhoneNumberCheck();
    List<String> eligibleWords = phoneNumberCheck.getMatchingWords(new LinkedList<>(Arrays.asList("tree", "tree")), null);
    assertNull(eligibleWords);
    eligibleWords = phoneNumberCheck.getMatchingWords(new LinkedList<>(Arrays.asList("tree", "tree")), "");
    assertNull(eligibleWords);
  }
}
