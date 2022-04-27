package com.example.springboot;

import java.util.*;

public class PhoneNumberCheck {

  private final Map<Character, Set<Character>> numberCharacterMapping;
  public PhoneNumberCheck() {
    this.numberCharacterMapping = new HashMap<>();
    initNumberCharacterMapping();

  }

  public void initNumberCharacterMapping() {
    numberCharacterMapping.put('2', new HashSet<>(Arrays.asList('a', 'b', 'c')));
    numberCharacterMapping.put('3', new HashSet<>(Arrays.asList('d', 'e', 'f')));
    numberCharacterMapping.put('4', new HashSet<>(Arrays.asList('g', 'h', 'i')));
    numberCharacterMapping.put('5', new HashSet<>(Arrays.asList('j', 'k', 'l')));
    numberCharacterMapping.put('6', new HashSet<>(Arrays.asList('m', 'n', 'o')));
    numberCharacterMapping.put('7', new HashSet<>(Arrays.asList('p', 'q', 'r', 's')));
    numberCharacterMapping.put('8', new HashSet<>(Arrays.asList('t', 'u', 'v')));
    numberCharacterMapping.put('9', new HashSet<>(Arrays.asList('w', 'x', 'y', 'z')));
  }

  protected boolean compareValidWordsLengthWithNumber(String number, String validWord) {
    return number.length() == validWord.length();
  }

  //At this point, the length between valid word and number should have been the same
  protected boolean checkWordExistence(String validWord, String number) {
    validWord = validWord.toLowerCase();
    for (int i = 0; i < number.length(); i++) {
      //Check if the number has character mapping or not
      if (!numberCharacterMapping.containsKey(number.charAt(i))) {
        return false;
      }
      //If the mapping doesn't exist then return false;
      if (!numberCharacterMapping.get(number.charAt(i)).contains(validWord.charAt(i))) {
        return false;
      }
    }
    return true;
  }

  protected List<String> getMatchingWords(List<String> validWords, String number) {
    if (number == null || number.isEmpty() || validWords == null || validWords.isEmpty()) {
      return null;
    }
    System.out.println("Valid Words: " + validWords);
    System.out.println("Number Param: " + number);
    //Check if any duplicate exist or not within the validwords
    Set<String> validWordsConverted = new HashSet<>(validWords);
    //Ensure all the word has the same length with number
    validWordsConverted.removeIf(s -> !compareValidWordsLengthWithNumber(s, number));
    //Check the number mapping for every valid word
    validWordsConverted.removeIf(s -> !checkWordExistence(s, number));
    return new LinkedList<>(validWordsConverted);
  }
}
