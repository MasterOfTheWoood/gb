package ru.gb.test1;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;

/**
 * @author Evgeniy_Guzeev
 */
public class MainApp {

    public static void main(String[] args){
        Scanner in = new Scanner(System.in);
        String[] data = in.nextLine().split(" ");
        System.out.println("Slow result : " + slowFilterLongWorlds(data));
        System.out.println("Fast result : " + fastFilterLongWorlds(Arrays.asList(data)));
    }

    //То, чему учат в GB
    private static List<String> slowFilterLongWorlds(String[] input){
        List<String> output = new ArrayList<>();
        for(int i = 0; i < input.length; i++){
            String s = input[i];
            if(!s.isEmpty() && s.length() <= 3) {
                output.add(s);
            }
        }
        return output;
    }

    //То, как на самом деле должен выгядеть код
    private static List<String> fastFilterLongWorlds(List<String> input){
        return input
                .stream()
                .filter(s -> !s.isEmpty())
                .filter(s -> s.length() <= 3 )
                .collect(Collectors.toList());
    }
}
