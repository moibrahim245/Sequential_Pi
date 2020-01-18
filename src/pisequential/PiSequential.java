/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pisequential;

import edu.rit.pj2.Task;
import edu.rit.util.Random;

/**
 *
 * @author Mohamed & Alaa
 */
public class PiSequential extends Task {

    long seed;
    long N;        // Number of points within the unit circle.
    long count;

    /**
     * @param args the command line arguments
     */
    @Override
    public void main(String[] args) {
        if (args.length != 2) {
            usage();
        }
        long startTime = System.nanoTime();
     
        seed = Long.parseLong(args[0]);
        N = Long.parseLong(args[1]);
        Random prng;
        // Generate n random points in the unit square, count
        // how many are in the unit circle.
        prng = new Random(seed);
        count = 0;
        for (long i = 0; i < N; ++i) {
            double x = prng.nextDouble();
            double y = prng.nextDouble();
            if (x * x + y * y <= 1.0) {
                ++count;
            }
        }
        
        long finishTime = System.nanoTime();
        // Print results.
        System.out.printf("pi = 4*%d/%d = %.9f%n%n",
                count, N, 4.0 * count / N);
        System.out.println("dauration : " + ((finishTime - startTime) / 1000000) + " ms");

    }

    private void usage() {
        throw new IllegalArgumentException();
    }
   
}
