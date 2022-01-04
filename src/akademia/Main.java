package akademia;

import java.util.*;
import java.lang.*;
import java.io.*;
import java.util.AbstractMap;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.Map;
import java.util.Set;
import java.util.TreeSet;
import java.util.Scanner;
import java.util.Map.Entry;

public class Main {

  public static void main(String[] args) {

    int shift = 7; // shift list/ przesuniecie listy

    //generate arrays of chars / generowanie tablicy znakow
    Map<Character, Character> charList = new HashMap<Character, Character>();
    int d = 0;
    for (int c = 97; c <= 122; c++) {
      d = c + shift;
      if (d <= 122) {
        charList.put((char) c, ((char) d));
      } else {
        d = d - 26;
        charList.put((char) c, ((char) d));
      }
    }

    //Getting word/words and their converting / Pobieranie slowa/slow oraz jego/ich przetwarzanie

    Scanner scanner = new Scanner(System.in);
    System.out.println("Put words:");
    String input = scanner.nextLine();
    char[] charInput = input.toCharArray();
    char[] charOutput = new char[charInput.length];
    StringBuilder sb = new StringBuilder();

    for (char x : charInput) {
      if (Character.isLetter(x)) {
        sb.append(charList.get(x));
      } else {
        sb.append(x);
      }
    }

    // Reverse convertng / Deszyfrowanie słów
    String sbToString = sb.toString();
    char[] backtourn = sbToString.toCharArray();
    StringBuilder outSb = new StringBuilder();

    for (char cha : backtourn) {
      for (Entry<Character, Character> entry : charList.entrySet()) {
        if (entry.getValue() == cha) {
          outSb.append(entry.getKey());
        }
      }
      if (!Character.isLetter(cha)) {
        outSb.append(cha);
      }
    }

    // displayed messages / wyświetlane komunikaty
    System.out.println("Wprowadzono slowo:");
    System.out.println(input);
    System.out.println("Przeklad:");
    System.out.println(sb);
    System.out.println("Klucz:");
    System.out.println(charList);
    System.out.println("Deciphered word: ");
    System.out.println(outSb);
  }
}
