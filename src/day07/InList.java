package day07;

import java.security.SecureRandom;
import java.util.LinkedList;
import java.util.List;
import java.util.Random;
import java.util.stream.Collectors;

public class InList{
    public static void main(String[] args) {
        //randomly generate a list of numbers
        Integer max = 200;
        Integer range = 100;
        Random rnd = new SecureRandom();

        List<Integer> numList = new LinkedList<>();
        for(Integer i = 0; i<max; i++)
            numList.add(rnd.nextInt(range));
        System.out.println(">>> numList" + numList);


        filter(numList);
        map(numList);

    }

    public static void map(List<Integer> numList) {
        System.out.println("===============MAP================");
        // filter
        List<Integer> resultList = new LinkedList<>();
        for(Integer n: numList){
            if(0==(n%3))
            continue;
            resultList.add(n);
        }
        System.out.println(">>> numList" + resultList);

        //predicate take integer and return boolean
        List<Integer> intList = numList.stream()
            // map: String apply(Integer i)
            .map(n -> "%d%d".formatted(n,n))
            // map: Integer applt(String i)
            .map(Integer::parseInt) //Method ref
            // .map(n -> Integer.parseInt(n))   >>> same >>> .map(Integer::parseInt)
            .toList();

        System.out.println(">>> numList" + resultList);
    }

    public static void filter(List<Integer> numList) {
        System.out.println("===============FILTER================");
        // filter
        List<Integer> resultList = new LinkedList<>();
        for(Integer n: numList){
            if(0==(n%3))
            continue;
            resultList.add(n);
        }
        System.out.println(">>> numList" + resultList);

        //predicate take integer and return boolean
        resultList = numList.stream()
            // Predicate:Boolean test(Integer i)
            .filter((n) -> 0==(n%3))
            .distinct()
            .sorted()
            .limit(5)
            .toList();
            //same as             .filter((n) -> 0!=(n%3))
            //                    .filter((n) -> {
            //                    return 0!=(n%3);
            // });




        System.out.println(">>> numList" + resultList);
    }
}