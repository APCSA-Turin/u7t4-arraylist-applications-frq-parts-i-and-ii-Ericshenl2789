package com.example.project.WordScramble;
import java.util.ArrayList;
import java.util.Arrays;
public class WordScramble {

  /** Scrambles a given word.
   *
   *  @param word  the word to be scrambled
   *  @return  the scrambled word (possibly equal to word)
   *
   *  Precondition: word is either an empty string or contains only uppercase letters.
   *  Postcondition: the string returned was created from word as follows:
   *  - the word was scrambled, beginning at the first letter and continuing from left to right
   *  - two consecutive letters consisting of "A" followed by a letter that was not "A" were swapped
   *  - letters were swapped at most once
   */
  public static String scrambleWord(String word) {
    String result = "";
      ArrayList<ArrayList<String>> letters = new ArrayList<>();
      for(int i = 0; i < word.length(); i++){
        letters.add(new ArrayList<>(Arrays.asList(word.substring(i, i+1), "0")));
      }
      for(int i = 0; i<word.length() - 1; i ++){
        ArrayList<String> letter = letters.get(i);
        ArrayList<String> next = letters.get(i + 1);
        if((letter.get(0).toLowerCase().equals("a")&&!letter.get(0).equals(next.get(0)))){
          if(letter.get(1).equals("0")&&next.get(1).equals("0")){
            letter.set(1, "1");
            next.set(1, "1");
            letters.set(i, next);
            letters.set(i+1, letter);
          }
          
        }
      }
      for(int i = 0; i<letters.size(); i++){
        result += letters.get(i).get(0);
      }
      return result;
  }

  /** Modifies wordList by replacing each word with its scrambled
   *  version, removing any words that are unchanged as a result of scrambling.
   *
   *  @param wordList the list of words
   *
   *  Precondition: wordList contains only non-null objects
   *  Postcondition:
   *  - all words unchanged by scrambling have been removed from wordList
   *  - each of the remaining words has been replaced by its scrambled version
   *  - the relative ordering of the entries in wordList is the same as it was
   *    before the method was called
   */
  public static ArrayList<String> scrambleOrRemove(ArrayList<String> wordList) {
    ArrayList<String> scrambled = new ArrayList<>();
    ArrayList<String> result = new ArrayList<>();
    for(int i = 0; i < wordList.size(); i ++){
      scrambled.add(scrambleWord(wordList.get(i)));
    }
    for(int i = 0; i < wordList.size(); i ++){
      if(!wordList.get(i).equals(scrambled.get(i))){
        result.add(scrambled.get(i));
      }
    }
    return result;
  }
}
