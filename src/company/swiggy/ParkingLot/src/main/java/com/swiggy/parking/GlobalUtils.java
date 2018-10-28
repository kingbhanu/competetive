package main.java.com.swiggy.parking;

import java.util.List;

public class GlobalUtils {

    public static void printStringList(List<String> list) {
        list.stream().forEach(x -> System.out.println(x + GlobalConstants.SPACE));
    }

    public static void printIntegerList(List<Integer> list) {
        list.stream().forEach(x -> System.out.println(x + GlobalConstants.SPACE));
    }

}
