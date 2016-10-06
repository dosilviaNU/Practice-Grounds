package com.company;

public class LinearFib {


    public static void main(String[] args) {

        for (int j = 0; j < args.length; j++) {
            long start = System.nanoTime();
            int stop = Integer.parseInt(args[j]);
            long f1 = 0;
            long f2 = 1;
            long f = 0;
            for (int i = 2; i != stop; i++) {
                f = f1 + f2;
                f1 = f2;
                f2 = f;
            }
            long end = System.nanoTime();
            long total = end - start;

            System.out.println("Input Size: " + stop);
            System.out.println(f);
            System.out.println("Time Taken: " + java.time.Duration.ofNanos(total).toString());
            System.out.println();
        }


    }
}


