import java.util.Arrays;

public class RunningMedian {

    abstract class Heap {
        int[] heap;
        int size;

        Heap() {
            heap = new int[10];
            size = 0;
        }

        void add(int n) {
            if (size >= heap.length) {
                grow();
            }
            heap[size] = n;
            pushUp(size);
            size++;
        }

        void grow() {
            int[] tmp = new int[heap.length * 2];
            for (int i=0; i<size; i++) {
                tmp[i] = heap[i];
            }
            heap = tmp;
        }

        void swap(int p, int q) {
            int tmp = heap[p];
            heap[p] = heap[q];
            heap[q] = tmp;
        }

        abstract int remove();
        abstract void pushUp(int i);
        abstract void pushDown(int i);

        int get(int i) {
            return heap[i];
        }

        int getSize() {
            return size;
        }
    }

    class MaxHeap extends Heap {
        MaxHeap() {
            super();
        }

        void pushUp(int i) {
            int parent = (i - 1) / 2;
            if (parent >= 0 && heap[i] > heap[parent]) {
                swap(i, parent);
                pushUp(parent);
            }
        }

        int remove() {
            int tmp = heap[0];
            heap[0] = Integer.MIN_VALUE;
            pushDown(0);
            size--;
            return tmp;
        }

        void pushDown(int i) {
            int left = i * 2 + 1;
            int right = i * 2 + 2;
            int larger = i;
            if (left < size && heap[larger] < heap[left]) {
                larger = left;
            }
            if (right < size && heap[larger] < heap[right]) {
                larger = right;
            }
            if (larger != i) {
                swap(i, larger);
                pushDown(larger);
            }
        }
    }

    class MinHeap extends Heap {
        MinHeap() {
            super();
        }

        void pushUp(int i) {
            int parent = (i - 1) / 2;
            if (parent >= 0 && heap[i] < heap[parent]) {
                swap(i, parent);
                pushUp(parent);
            }
        }

        int remove() {
            int tmp = heap[0];
            heap[0] = Integer.MAX_VALUE;
            pushDown(0);
            size--;
            return tmp;
        }

        void pushDown(int i) {
            int left = i * 2 + 1;
            int right = i * 2 + 2;
            int smaller = i;
            if (left < size && heap[smaller] > heap[left]) {
                smaller = left;
            }
            if (right < size && heap[smaller] > heap[right]) {
                smaller = right;
            }
            if (smaller != i) {
                swap(i, smaller);
                pushDown(smaller);
            }
        }
    }

    private MaxHeap smaller;
    private MinHeap larger;

    public RunningMedian() {
        smaller = new MaxHeap();
        larger = new MinHeap();
    }

    public void add(int i) {
        int small = smaller.get(0);
        int large = larger.get(0);
        if (smaller.getSize() == larger.getSize()) {
            if (smaller.getSize() == 0) {
                smaller.add(i);
            }
            else {
                if (i < getMedian()) {
                    smaller.add(i);
                }
                else {
                    larger.add(i);
                }
            }
        }
        else if (smaller.getSize() > larger.getSize()) {
            if (i < getMedian()) {
                int tmp = smaller.remove();
                larger.add(tmp);
                smaller.add(i);
            }
            else {
                larger.add(i);
            }
        }
        else if (larger.getSize() > smaller.getSize()) {
            if (i > getMedian()) {
                int tmp = larger.remove();
                smaller.add(tmp);
                larger.add(i);
            }
            else {
                smaller.add(i);
            }
        }
        else {
            System.out.println("Error in adding: " + i);
        }
        return;
    }

    public double getMedian() {
        if (smaller.getSize() == 0 && larger.getSize() == 0) {
            throw new IllegalStateException();
        }
        else if (smaller.getSize() == 0) {
            return larger.get(0);
        }
        else if (larger.getSize() == 0) {
            return smaller.get(0);
        }
        else {
            if (smaller.getSize() - larger.getSize() == 1) {
                return smaller.get(0);
            }
            else if (larger.getSize() - smaller.getSize() == 1) {
                return larger.get(0);
            }
            else {
                return (smaller.get(0) + larger.get(0)) / 2.0;
            }
        }
    }

    public String toString() {
        return smaller.getSize() + ": " + Arrays.toString(smaller.heap) + "\n" + larger.getSize() + ": " + Arrays.toString(larger.heap);
    }
}
