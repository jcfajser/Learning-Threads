package com.fajardo;

import java.util.*;
import java.util.concurrent.TimeUnit;


public class LearnStreams {

    List<String> names = Arrays.asList("peter", "anna", "mike", "xenia");

    public void practiceStreams(){
        Collections.sort(names, (a, b) -> a.compareTo(b));

        System.out.println(names.toString());

        names.stream()
                .filter((s -> s.startsWith("a")))
                .forEach(System.out::println);

        names.stream()
                .map(String::toUpperCase)
                .sorted()
                .forEach(System.out::println);


        boolean anyStarsWithA = names.stream()
                                        .anyMatch((s) -> s.startsWith("a"));

        System.out.println(anyStarsWithA);

        boolean allStartsWithA = names.stream()
                                        .allMatch((s) -> s.startsWith("a"));

        System.out.println(allStartsWithA);

        boolean noneStartsWithZ = names.stream()
                                            .noneMatch((s) -> s.startsWith("z"));

        System.out.println(noneStartsWithZ);

        long startsWithB = names.stream()
                                    .filter(s -> s.startsWith("b"))
                                    .count();

        System.out.println(startsWithB);

        Optional<String> reduce = names.stream()
                .sorted()
                .reduce(((s, s2) -> s + "|" + s2));

        reduce.ifPresent(System.out::println);
    }

    public void practiceParallelStreams(){

        int max = 1000000;

        List<String> values = new ArrayList<>(max);
        for (int i = 0; i < max; i++){
            UUID uuid = UUID.randomUUID();
            values.add(uuid.toString());
        }

        long t = System.nanoTime();
        System.out.println(t);

        long count = values.stream().sorted().count();
        System.out.println(count);

        long t1 = System.nanoTime();
        System.out.println(t1);

        long duration = t1-t;

        long millis = TimeUnit.NANOSECONDS.toMillis(duration);
        System.out.println(String.format("sequential sort took: %d ms", millis));


        long t00 = System.nanoTime();
        System.out.println(t00);

        long count1 = values.parallelStream().sorted().count();
        System.out.println(count1);

        long t11 = System.nanoTime();
        System.out.println(t11);

        long millis1 = TimeUnit.NANOSECONDS.toMillis(t11-t00);
        System.out.println(String.format("sequential sort took: %d ms", millis1));

    }

}
