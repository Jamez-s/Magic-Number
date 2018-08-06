package com.company;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.nio.charset.StandardCharsets;
import java.util.*;

public class Main {

    private Set<Character> mySet = new HashSet<>();

    public static void main(String[] args) throws IOException {
        Main  main = new Main();
        InputStreamReader reader = new InputStreamReader(System.in, StandardCharsets.UTF_8);
        BufferedReader in = new BufferedReader(reader);
             String line;
         while ((line = in.readLine()) != null) {

             Set<Integer> putToInts = main.parseInput(line);
             if (putToInts.size() == 2) {
                 int low = Collections.min(putToInts);
                 int high = Collections.max(putToInts);


                 while (low <= high) {
                     char[] chars = Integer.toString(low).toCharArray();
                     main.addToSet(chars);
                     if (main.isNumberMagic(chars)) {
                         System.out.println(low);
                         System.out.println();
                         main.resetSet();
                         low++;
                     } else {
                         main.resetSet();
                         low++;
                     }
                 }
             }
             else if(putToInts.size() == 1){
                 System.out.println("Enter two numbers");
             }
         }
    }

    public Set<Integer> parseInput(String input) throws NumberFormatException{
        String [] splitInput = input.split( " ");
        Set<Integer> mySet = new HashSet<>();
        for(String s : splitInput) {
            try {
                mySet.add(Integer.valueOf(s));
            }
            catch(NumberFormatException e){
                System.out.println("Enter two numbers");
            }
        }
        return mySet;
    }

    public void addToSet(char [] input){
        for(int x =0; x < input.length; x++){
            this.mySet.add(input[x]);
        }
    }

    public void resetSet(){
        mySet.removeAll(this.mySet);
    }

    public Set<Character> getMySet() {
        return mySet;
    }

    public boolean isNumberMagic(char[] input){
        addToSet(input);
        boolean answer;
        if (areNumbersAllDifferent(input, mySet) && !mySet.contains('0')){
          answer = magicNumber(input);
        }
        else
            answer = false;
        return answer;
    }

    public boolean areNumbersAllDifferent(char[] input, Set mySet){
       return (input.length == mySet.size());
    }

    public boolean magicNumber(char[] input){
        int index = 0;
        int temp = 0;
        Set<Integer> mySet = new HashSet<>();
        boolean flag = true;
        boolean answer = false;
        while (flag){
            temp = input[index];
            if(mySet.add(temp)){
                index = rotateRight(input, temp, index);
            }
            else if ((mySet.size() == input.length) && index == 0){
                flag = false;
                answer = true;
            }
            else
                flag = false;
        }
        return answer;
    }

    public int rotateRight(char [] chars, int temp, int index){
        return (temp+index) % chars.length;
    }
}
