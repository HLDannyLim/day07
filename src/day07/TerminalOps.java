package day07;

import java.security.SecureRandom;
import java.util.LinkedList;
import java.util.List;
import java.util.Optional;
import java.util.Random;
import java.util.stream.Collector;
import java.util.stream.Collectors;

public class TerminalOps {
    public static void main(String[] args) {
        //randomly generate a list of numbers
        Integer max = 200;
        Integer range = 100;
        Random rnd = new SecureRandom();

        List<Integer> numList = new LinkedList<>();
        for(Integer i = 0; i<max; i++)
            numList.add(rnd.nextInt(range));
        System.out.println(">>> numList" + numList);

        // joining(numList);
        // reducing(numList);
        // joiningAsReducing(numList);
        reducing2(numList);

    }

    //not done
    public static void joiningAsReducing(List<Integer> numList) {
        System.out.println("===============JOININGASREDUCING================");

 
        Optional<String> opt = numList.stream()
            // map: String apply(Integer i)
            .map(n -> "%d%d".formatted(n,n))
            .collect(
                //Integer apply(Integer total, Integer i)
                Collectors.reducing((total, i)->{
                    System.out.printf("\nTotal: %d i: %d", total, i);
                return "%s, %s".formatted(total, i);
                })
            );

        //check if we have an ans
        if (opt.isPresent()){
        // get ans
            System.out.println(">>> Total : " + opt.get());
        }else{
            System.out.println("Produce now result");
        }
    }

    public static void joining(List<Integer> numList) {
        System.out.println("===============JOINING================");

 
        String listOfNums = numList.stream()
            // map: String apply(Integer i)
            .map(n -> "%d%d".formatted(n,n))
            .collect(Collectors.joining("\n"));

        System.out.println(">>> CSV : " + listOfNums);
    }

    public static void reducing(List<Integer> numList) {
        System.out.println("===============REDUCE================");

 
        Optional<Integer> opt = numList.stream()
            // map: String apply(Integer i)
            .map(n -> "%d%d".formatted(n,n))
            .map(Integer::parseInt)
            .collect(
                //Integer apply(Integer total, Integer i)
                Collectors.reducing((total, i)->{
                    System.out.printf("\nTotal: %d i: %d", total, i);
                return total + i;
                })
            );

        //check if we have an ans
        if (opt.isPresent()){
        // get ans
            System.out.println(">>> Total : " + opt.get());
        }else{
            System.out.println("Produce now result");
        }
    }

    public static void reducing2(List<Integer> numList) {
        System.out.println("===============REDUCE2================");

 

        Integer result = numList.stream()
            // map: String apply(Integer i)
            .map(n -> "%d%d".formatted(n,n))
            .map(Integer::parseInt)
            .collect(
                //Integer apply(Integer total, Integer i)
                // -100 total = -100 
                Collectors.reducing(-100,(total, i)->{
                    System.out.printf("\nTotal: %d i: %d", total, i);
                return total + i;
                })
            );


            System.out.println(">>> Total : " + result);

    }
    
}
