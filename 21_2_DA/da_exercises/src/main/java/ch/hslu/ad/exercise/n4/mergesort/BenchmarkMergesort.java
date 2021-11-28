/*
 * Copyright 2021 Hochschule Luzern Informatik.
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *      http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */
package ch.hslu.ad.exercise.n4.mergesort;

import ch.hslu.ad.n41.array.init.RandomInitTask;
import ch.hslu.ad.n41.array.sum.SumTask;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.concurrent.ForkJoinPool;

/**
 * Performance Vergleich der Mergesort-Implementation.
 */
public final class BenchmarkMergesort {

    private static final Logger LOG = LogManager.getLogger(BenchmarkMergesort.class);

    /**
     * Privater Konstruktor.
     */
    private BenchmarkMergesort() {
    }

    /**
     * Main-Demo.
     *
     * @param args not used.
     */
    public static void main(final String[] args) {
        logMergeSortBenchmark(300_000_000, 100, 50, 5);
        logMergeSortBenchmark(300_000_000, 100, 500, 5);
        logMergeSortBenchmark(300_000_000, 100, 5000, 5);
        logMergeSortBenchmark(300_000_000, 100, 50000, 5);
        logMergeSortBenchmark(300_000_000, 100, 500000, 5);
        logMergeSortBenchmark(300_000_000, 100, 5000000, 5);
    }

    private static void logMergeSortBenchmark(final int size, final int arrayBound, final int threshold, final int iterations){
        final ForkJoinPool pool = new ForkJoinPool();
        final int[] array = new int[size];
        final List<Long> results = new ArrayList();

        for (var i = 0; i < iterations; i++){
            final RandomInitTask initTask = new RandomInitTask(array, arrayBound);
            pool.invoke(initTask);
            final MergesortTask sortTask = new MergesortTask(array);

            long startTime = System.currentTimeMillis();
            sortTask.invoke();
            long endTime = System.currentTimeMillis();

            results.add(endTime - startTime);
        }

        System.out.println(
                "Merge Sort with Parameters(Size: " + size + ", Array Bound: " + arrayBound + ", Threshold: " + threshold + ", Iterations: " + iterations + ")\n" +
                "Low/High/Average:\t" + Collections.min(results) + " / " + Collections.max(results) + " / " + results.stream().mapToLong(val -> val).average());
    }
}
