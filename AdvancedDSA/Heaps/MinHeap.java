package AdvancedDSA.Heaps;

import java.util.ArrayList;

public class MinHeap {

    public static ArrayList<Integer> heap = new ArrayList<>();

    public static void main(String[] args) {

    }

    private static void Insert(int value) {
        heap.add(value);
        int i = heap.size();

        while (i > 0) {
            int parent = (i - 1) / 2;
            if (heap.get(i) < heap.get(parent)) {
                int temp = heap.get(i);
                heap.set(i, heap.get(parent));
                heap.set(parent, temp);
            } else
                break;
        }
    }

    private static int getMinPoll() {
        int ans = heap.get(0);
        int n = heap.size();
        heap.set(0, heap.get(n - 1));
        int i = 0;
        n--;

        while (i < n) {
            int leftChild = 2 * i + 1;
            int rightChild = 2 * i + 2;

            if (rightChild < n) {

            } else if (leftChild < n) {
                
            } else
                break;
        }

        return ans;
    }
}

class Solution {
    public int heapSize;
    public int N;

    public int solve(int[] A) {
        int ans = 0;
        A = buildHeap(A);
        this.heapSize = A.length;
        for (int i = 1; i <= A.length - 1; i++) {
            int temp = getMinPoll(A) + getMinPoll(A);
            ans = ans + temp;
            insert(temp, A);
        }
        return ans;
    }

    public int getMinPeek(int[] A) {
        return (heapSize <= 0) ? -1 : A[0];
    }

    public boolean isLeaf(int idx, int len) {
        int leafCount = (len + 1) / 2;
        return idx > len - 1 - leafCount;
    }

    public int getMinPoll(int[] A) {
        int retVal = A[0];
        A[0] = A[this.heapSize - 1];
        this.heapSize--;
        int idx = 0;
        int lcIdx = 1;
        int rcIdx = 2;

        while ((rcIdx < heapSize) && ((A[idx] > A[rcIdx] || A[idx] > A[lcIdx]))) {
            if (A[rcIdx] < A[lcIdx]) {
                int temp = A[idx];
                A[idx] = A[rcIdx];
                A[rcIdx] = temp;
                idx = rcIdx;
            } else {
                int temp = A[idx];
                A[idx] = A[lcIdx];
                A[lcIdx] = temp;
                idx = lcIdx;
            }

            lcIdx = 2 * idx + 1;
            rcIdx = 2 * idx + 2;

        }

        if (lcIdx < heapSize && (A[idx] > A[lcIdx])) // leaf
        {
            int temp = A[idx];
            A[idx] = A[lcIdx];
            A[lcIdx] = temp;
            idx = lcIdx;
        }
        return retVal;

    }

    public void insert(int element, int[] A) {
        int idx = this.heapSize++;
        A[idx] = element;
        int parent = (idx - 1) / 2;
        while (parent >= 0 && A[parent] > A[idx]) {
            int temp = A[parent];
            A[parent] = A[idx];
            A[idx] = temp;
            idx = parent;
            parent = (idx - 1) / 2;
        }
        return;
    }

    public int[] buildHeap(int[] A) {
        int N = A.length;
        int leafCount = (N + 1) / 2;
        for (int i = N - 1 - leafCount; i >= 0; i--) {
            int idx = i;
            while (!isLeaf(idx, N)) {
                int lcIdx = (2 * idx) + 1;
                int rcIdx = (2 * idx) + 2;

                if ((rcIdx < N) && !((A[idx] <= A[lcIdx]) && A[idx] <= A[rcIdx])) {
                    if (A[rcIdx] < A[lcIdx]) {
                        int temp = A[idx];
                        A[idx] = A[rcIdx];
                        A[rcIdx] = temp;
                        idx = rcIdx;
                    } else {
                        int temp = A[idx];
                        A[idx] = A[lcIdx];
                        A[lcIdx] = temp;
                        idx = lcIdx;
                    }
                } else if ((lcIdx < N) && !(A[idx] <= A[lcIdx])) {
                    int temp = A[idx];
                    A[idx] = A[lcIdx];
                    A[lcIdx] = temp;
                    idx = lcIdx;
                } else {
                    break;
                }
            }
        }
        return A;

    }

}