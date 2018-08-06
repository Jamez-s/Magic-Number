package com.company;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

public class MainTest {
    private Main main;

    @Before
    public void setup(){
        main = new Main();
    }

    @Test
    public void parseInputFirstInputTest(){
        String input = "100 1000";

        Set<Integer> expected = new HashSet<>(Arrays.asList(100, 1000));
        Set<Integer> actual = main.parseInput(input);


        Assert.assertEquals(expected,actual);
    }


    @Test
    public void addToSetTest(){
        char [] given = {'1', '4', '7'};
        main.addToSet(given);
        Set <Character> expected = new HashSet<>(Arrays.asList('1', '4', '7'));
        Set<Character> actual = main.getMySet();
        Assert.assertEquals(expected,actual);
    }

    @Test
    public void areAllNumbersDifferentTestDifferentNumbers(){
        char [] given = {'1', '4', '7'};
        main.addToSet(given);
        Assert.assertTrue(main.areNumbersAllDifferent(given, main.getMySet()));
    }

    @Test
    public void areAllNumbersDifferentTestRepeatedNumber(){
        char [] given = {'1', '0', '4', '4'};
        main.addToSet(given);
        Assert.assertFalse(main.areNumbersAllDifferent(given, main.getMySet()));
    }


    @Test
    public void rotateRightTestOne(){
        int index = 0;
        int value = 1;
        char [] given = {'1', '4', '7'};
        int expected = 1;
        int actual = main.rotateRight(given, value, index);
        Assert.assertEquals(expected, actual);
    }

    @Test
    public void rotateRightTestFour(){
        int index = 1;
        int value = 4;
        char [] given = {'1', '4', '7'};
        int expected = 2;
        int actual = main.rotateRight(given, value, index);
        Assert.assertEquals(expected, actual);
    }

    @Test
    public void magicNumberTest(){
        char [] given = {'1', '4', '7'};

        Assert.assertTrue(main.magicNumber(given));
    }

    @Test
    public void magicNumberTestNotMagic(){
        char [] given = {'1', '5', '7'};

        Assert.assertFalse(main.magicNumber(given));
    }

    @Test
    public void isMagicNumberTestNotMagic(){
        char [] given = {'1', '5', '7'};

        Assert.assertFalse(main.isNumberMagic(given));
    }

    @Test
    public void isMagicNumberTestMagic(){
        char [] given = {'1', '4', '7'};

        Assert.assertTrue(main.isNumberMagic(given));
    }





}