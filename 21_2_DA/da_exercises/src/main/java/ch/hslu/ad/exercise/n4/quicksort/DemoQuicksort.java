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
package ch.hslu.ad.exercise.n4.quicksort;

import ch.hslu.ad.n41.array.init.RandomInitTask;
import ch.hslu.ad.n41.array.sort.check.SortCheckTask;
import ch.hslu.ad.n41.array.sum.SumTask;
import java.util.Arrays;
import java.util.concurrent.ForkJoinPool;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

/**
 * Vergleich von verschiedenen Quicksort-Implementationen.
 */
public final class DemoQuicksort {

    private static final Logger LOG = LogManager.getLogger(ch.hslu.ad.exercise.n4.quicksort.DemoQuicksort.class);

    /**
     * Privater Konstruktor.
     */
    private DemoQuicksort() {
    }

    /**
     * Main-Demo.
     *
     * @param args not used.
     */
    public static void main(final String[] args) {
        final int size = 300_000_000;
        final int[] array = new int[size];
        final ForkJoinPool pool = new ForkJoinPool();


        // QuickSort Taks
        LOG.info("QUICKSORT TASK\n");
        RandomInitTask initTask = new RandomInitTask(array, 100);
        pool.invoke(initTask);
        SumTask sumTask = new SumTask(array);
        long result = pool.invoke(sumTask);
        LOG.info("Init. Checksum : {}", result);
        final QuicksortTask sortTask = new QuicksortTask(array);
        long startTime = System.currentTimeMillis();
        pool.invoke(sortTask);
        long endTime = System.currentTimeMillis();
        LOG.info("QuicksortTask  : {} sec.", (endTime - startTime) / 1000.0 );
        sumTask = new SumTask(array);
        result = pool.invoke(sumTask);
        LOG.info("Conc. Checksum : {}", result);
        SortCheckTask sortCheckTask = new SortCheckTask(array);
        boolean isSorted = sortCheckTask.invoke();
        LOG.info("Conc. Is Sorted: {}\n\n", isSorted);



        // Quicksort Recursive
        LOG.info("QUICKSORT RECURSIVE\n");
        initTask = new RandomInitTask(array, 100);
        pool.invoke(initTask);
        sumTask = new SumTask(array);
        result = pool.invoke(sumTask);
        LOG.info("Init. Checksum : {}", result);
        startTime = System.currentTimeMillis();
        QuicksortRecursive.quicksort(array);
        endTime = System.currentTimeMillis();
        LOG.info("QuicksortRec.  : {} sec.", (endTime - startTime) / 1000.0);
        sumTask = new SumTask(array);
        result = pool.invoke(sumTask);
        LOG.info("Recu. Checksum : {}", result);
        sortCheckTask = new SortCheckTask(array);
        isSorted = sortCheckTask.invoke();
        LOG.info("Recu. Is Sorted: {}\n\n", isSorted);


        // Arrays.sort
        LOG.info("ARRAYS SORT\n");
        initTask = new RandomInitTask(array, 100);
        pool.invoke(initTask);
        sumTask = new SumTask(array);
        result = pool.invoke(sumTask);
        LOG.info("Init. checksum : {}", result);
        startTime = System.currentTimeMillis();
        Arrays.sort(array);
        endTime = System.currentTimeMillis();
        LOG.info("Arrays.sort    : {} sec.", (endTime - startTime) / 1000.0);
        sumTask = new SumTask(array);
        result = pool.invoke(sumTask);
        LOG.info("Sort checksum  : {}", result);
        sortCheckTask = new SortCheckTask(array);
        isSorted = sortCheckTask.invoke();
        LOG.info("Recu. Is Sorted: {}", isSorted);
    }
}
