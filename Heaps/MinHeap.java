import java.util.ArrayList;

public class MinHeap {
    private ArrayList<Integer> heap;

    public MinHeap() {
        heap = new ArrayList<>();
    }

    private int getParent(int i) { return (i - 1) / 2; }
    private int getLeftChild(int i) { return 2 * i + 1; }
    private int getRightChild(int i) { return 2 * i + 2; }

    private void swap(int i, int j) {
        int temp = heap.get(i);
        heap.set(i, heap.get(j));
        heap.set(j, temp);
    }

    public void insert(int val) {
        heap.add(val);
        int index = heap.size() - 1;

        // Bubble up
        while (index > 0 && heap.get(index) < heap.get(getParent(index))) {
            swap(index, getParent(index));
            index = getParent(index);
        }
    }

    public int peek() {
        if (heap.isEmpty()) throw new IllegalStateException("Heap is empty");
        return heap.get(0);
    }

    public int remove() {
        if (heap.isEmpty()) throw new IllegalStateException("Heap is empty");

        int min = heap.get(0);
        int last = heap.remove(heap.size() - 1);

        if (!heap.isEmpty()) {
            heap.set(0, last);
            heapifyDown(0);
        }

        return min;
    }

    private void heapifyDown(int i) {
        int smallest = i;
        int left = getLeftChild(i);
        int right = getRightChild(i);

        if (left < heap.size() && heap.get(left) < heap.get(smallest)) smallest = left;
        if (right < heap.size() && heap.get(right) < heap.get(smallest)) smallest = right;

        if (smallest != i) {
            swap(i, smallest);
            heapifyDown(smallest);
        }
    }

    public void printHeap() {
        System.out.println("Heap: " + heap);
    }

    // Main method to test
    public static void main(String[] args) {
        MinHeap h = new MinHeap();
        h.insert(10);
        h.insert(4);
        h.insert(15);
        h.insert(1);
        h.insert(20);

        h.printHeap(); // Should print the internal heap array in heap order

        System.out.println("Min Element: " + h.peek());
        System.out.println("Removed Min: " + h.remove());
        h.printHeap();
    }
}
