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

/**
 * Codevorlage zu RecursiveAction für die Sortierung eines int-Arrays.
 */
public class QuicksortRecursive {

    /**
     * public method exposed to client, sorts given array using QuickSort
     * Algorithm in Java.
     *
     * @param array input array.
     */
    public static void quicksort(int[] array) {
        QuicksortRecursive.quicksort(array, 0, array.length - 1);
    }

    private static void movePivotToBack(final int[] array, final int startIdx, final int endIdx){
        final int centerIdx = (endIdx - startIdx) / 2 + startIdx;

        if(array[startIdx] > array[endIdx]){
            exchange(array, startIdx, endIdx);
        }

        if(array[startIdx] > array[centerIdx]){
            exchange(array, startIdx, centerIdx);
        }

        if(array[endIdx] > array[centerIdx]){
            exchange(array, centerIdx, endIdx);
        }
    }

    /**
     * Recursive quicksort logic.
     *
     * @param array input array.
     * @param startIdx start index of the array.
     * @param endIdx end index of the array.
     */
    private static void quicksort(final int[] array, final int startIdx, final int endIdx) {
        if(startIdx >= endIdx){
            return;
        }

        movePivotToBack(array, startIdx, endIdx);
        final int partition = partition(array, startIdx, endIdx);

        quicksort(array, startIdx, partition - 1);
        quicksort(array, partition + 1, endIdx);
    }

    /**
     * Divides array from pivot, left side contains elements less than Pivot
     * while right side contains elements greater than pivot.
     *
     * @param array array to partitioned.
     * @param startIdx lower bound of the array.
     * @param endIdx upper bound of the array.
     * @return the partition index.
     */
    private static int partition(final int[] array, final int startIdx, final int endIdx) {
        final int pivot = array[endIdx];
        int down = endIdx;
        int up = startIdx - 1;

        while(up < down){
            while (array[++up] < pivot);
            while (down > 0 && array[--down] > pivot);

            if(up >= down){
                break;
            }

            exchange(array, up, down);
        }

        exchange(array, endIdx, up);

        return up;
    }

    private static void exchange(final int[] array, final int i, final int j) {
        int temp = array[i];
        array[i] = array[j];
        array[j] = temp;
    }
}
