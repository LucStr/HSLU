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

import java.util.concurrent.RecursiveAction;

/**
 * Codevorlage zu RecursiveAction für die Sortierung eines int-Arrays.
 */
@SuppressWarnings("serial")
public final class QuicksortTask extends RecursiveAction {

    private static final int THRESHOLD = 1;
    private final int[] array;
    private final int startIdx;
    private final int endIdx;

    /**
     * Erzeugt einen Array-Sortier Task.
     *
     * @param array Interger-Array.
     */
    public QuicksortTask(int[] array) {
        this(array, 0, array.length - 1);
    }

    private QuicksortTask(final int[] array, final int startIdx, final int endIdx) {
        this.array = array;
        this.startIdx = startIdx;
        this.endIdx = endIdx;
    }

    @Override
    protected void compute() {
        if(startIdx >= endIdx){
            return;
        }

        movePivotToBack(array, startIdx, endIdx);
        final int partition = partition(array, startIdx, endIdx);

        invokeAll(new QuicksortTask(array, startIdx, partition - 1), new QuicksortTask(array, partition + 1, endIdx));
    }

    private void movePivotToBack(final int[] array, final int startIdx, final int endIdx){
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
     * Divides array from pivot, left side contains elements less than Pivot
     * while right side contains elements greater than pivot.
     *
     * @param array array to partitioned.
     * @param startIdx lower bound of the array.
     * @param endIdx upper bound of the array.
     * @return the partition index.
     */
    private int partition(final int[] array, final int startIdx, final int endIdx) {
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

    private void exchange(final int[] array, final int i, final int j) {
        int temp = array[i];
        array[i] = array[j];
        array[j] = temp;
    }
}
