package yatzy;

import java.util.*;
import java.util.stream.Collectors;
import java.util.stream.IntStream;
import java.util.stream.Stream;

public class Yatzy {

    //Create DiceHand
    //Look at yatzy method
    //params, check length, throw exception if not 5
    //Replace params with DiceHand move check to constructor of DiceHand

    static class DiceHand implements Iterable<Integer> {
        private final int[] dice;

        DiceHand(int d1, int d2, int d3, int d4, int d5) {
            this.dice = new int[]{d1, d2, d3, d4, d5};
        }

        //public int[] getDice() {
        //    return dice;
        //}  Without this method the DiceHand is immutable

        public int get(int index) {
            return dice[index];
        }

        public Iterator<Integer> iterator() {
            return stream().iterator();
        }

        public Stream<Integer> stream() {
            return IntStream.of(dice)//IntStream
                    .boxed();//Stream<Integer>
        }

        public IntStream intStream() {
            return IntStream.of(dice);
        }
    }


    public static int chance(DiceHand diceHand) {
        return diceHand.intStream().sum();
        //return diceHand.stream().mapToInt(Integer::intValue).sum();
    }

    public static int yatzy(DiceHand diceHand) {
        //diceHand.stream().allMatch( n -> n == diceHand.get(0));
        if (diceHand.stream().distinct().count() == 1)
            return 50;
        return 0;
    }

    public static int ones(DiceHand diceHand) {
        //Ctrl-Alt-Shift-T when standing on method name
        //Introduce Parameter Object

        //When writing mapToInt, press ctrl-shift-space
        //.count could work, but will give problems with twos...
        return diceHand.stream().filter(n -> n == 1).mapToInt(Integer::intValue).sum();
    }

    public static int twos(int d1, int d2, int d3, int d4, int d5) {
        //After creating same code as in ones, extract sumValues method..

        int sum = 0;
        if (d1 == 2) sum += 2;
        if (d2 == 2) sum += 2;
        if (d3 == 2) sum += 2;
        if (d4 == 2) sum += 2;
        if (d5 == 2) sum += 2;
        return sum;
    }

    public static int threes(int d1, int d2, int d3, int d4, int d5) {
        int s;
        s = 0;
        if (d1 == 3) s += 3;
        if (d2 == 3) s += 3;
        if (d3 == 3) s += 3;
        if (d4 == 3) s += 3;
        if (d5 == 3) s += 3;
        return s;
    }

    protected int[] dice;

    public Yatzy(int d1, int d2, int d3, int d4, int _5) {
        dice = new int[5];
        dice[0] = d1;
        dice[1] = d2;
        dice[2] = d3;
        dice[3] = d4;
        dice[4] = _5;
    }

    public int fours() {
        int sum;
        sum = 0;
        for (int at = 0; at != 5; at++) {
            if (dice[at] == 4) {
                sum += 4;
            }
        }
        return sum;
    }

    public int fives() {
        int s = 0;
        int i;
        for (i = 0; i < dice.length; i++)
            if (dice[i] == 5)
                s = s + 5;
        return s;
    }

    public int sixes() {
        int sum = 0;
        for (int at = 0; at < dice.length; at++)
            if (dice[at] == 6)
                sum = sum + 6;
        return sum;
    }

    //.stream.collect(Collectors.groupingBy(d -> d ,Collectors.counting()))

    //counts.entrySet().stream().filter(e -> e.getValue() >=2).mapToInt(Entry::getKey).max();
    //Alternative frequency...
    //OptionalInt som returtyp
    //return maxDie.orElse(0) * 2;

    //Enterprise code har ofta if(ispresent)... not clean...
    public static int score_pair(DiceHand diceHand) {
        Map<Integer, Long> counts = diceHand.stream().collect(Collectors.groupingBy(d -> d, Collectors.counting()));

        OptionalInt maxDie = counts.entrySet().stream()
                .filter(e -> e.getValue() >= 2)
                .map(Map.Entry::getKey)
                .mapToInt(Integer::intValue)
                .max();

        return maxDie.orElse(0) * 2;
    }
//Saknar test fixa först  1,1,1,1,5  gives 0 Testa genom att lägga till och testköra mot
// befintlig kod för att se vad den returnerar. Prova tex med 77 som förväntat värde.
    //kör testet, kommer ge 0. Now we know.
    //
    //ersätt .max() med .collect(Collectors.toList()) goes to variable diceTwoOrMore
    //if that list.size != 2 return 0;
    //return list.stream().maptoint().sum *2;

    public static int two_pair(DiceHand diceHand) {
        Map<Integer, Long> counts = diceHand.stream().collect(Collectors.groupingBy(d -> d, Collectors.counting()));

        List<Integer> diceTwoOrMore = counts.entrySet().stream().filter(e -> e.getValue() >= 2)
                .map(Map.Entry::getKey) //at most 2 items left
                .collect(Collectors.toList());
        if (diceTwoOrMore.size() != 2)
            return 0;
        return diceTwoOrMore.stream().mapToInt(Integer::intValue).sum() * 2;
    }

    public static int four_of_a_kind(int _1, int _2, int d3, int d4, int d5) {
        int[] tallies;
        tallies = new int[6];
        tallies[_1 - 1]++;
        tallies[_2 - 1]++;
        tallies[d3 - 1]++;
        tallies[d4 - 1]++;
        tallies[d5 - 1]++;
        for (int i = 0; i < 6; i++)
            if (tallies[i] >= 4)
                return (i + 1) * 4;
        return 0;
    }

    public static int three_of_a_kind(int d1, int d2, int d3, int d4, int d5) {
        int[] t;
        t = new int[6];
        t[d1 - 1]++;
        t[d2 - 1]++;
        t[d3 - 1]++;
        t[d4 - 1]++;
        t[d5 - 1]++;
        for (int i = 0; i < 6; i++)
            if (t[i] >= 3)
                return (i + 1) * 3;
        return 0;
    }

    public static int smallStraight(int d1, int d2, int d3, int d4, int d5) {
        int[] tallies;
        tallies = new int[6];
        tallies[d1 - 1] += 1;
        tallies[d2 - 1] += 1;
        tallies[d3 - 1] += 1;
        tallies[d4 - 1] += 1;
        tallies[d5 - 1] += 1;
        if (tallies[0] == 1 &&
                tallies[1] == 1 &&
                tallies[2] == 1 &&
                tallies[3] == 1 &&
                tallies[4] == 1)
            return 15;
        return 0;
    }

    public static int largeStraight(int d1, int d2, int d3, int d4, int d5) {
        int[] tallies;
        tallies = new int[6];
        tallies[d1 - 1] += 1;
        tallies[d2 - 1] += 1;
        tallies[d3 - 1] += 1;
        tallies[d4 - 1] += 1;
        tallies[d5 - 1] += 1;
        if (tallies[1] == 1 &&
                tallies[2] == 1 &&
                tallies[3] == 1 &&
                tallies[4] == 1
                && tallies[5] == 1)
            return 20;
        return 0;
    }

    public static int fullHouse(int d1, int d2, int d3, int d4, int d5) {
        int[] tallies;
        boolean _2 = false;
        int i;
        int _2_at = 0;
        boolean _3 = false;
        int _3_at = 0;


        tallies = new int[6];
        tallies[d1 - 1] += 1;
        tallies[d2 - 1] += 1;
        tallies[d3 - 1] += 1;
        tallies[d4 - 1] += 1;
        tallies[d5 - 1] += 1;

        for (i = 0; i != 6; i += 1)
            if (tallies[i] == 2) {
                _2 = true;
                _2_at = i + 1;
            }

        for (i = 0; i != 6; i += 1)
            if (tallies[i] == 3) {
                _3 = true;
                _3_at = i + 1;
            }

        if (_2 && _3)
            return _2_at * 2 + _3_at * 3;
        else
            return 0;
    }
}



