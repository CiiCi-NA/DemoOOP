package OOPHKII2425_FinalExam_De3.algorithm;

import java.util.Arrays;
import java.util.Random;

public class TestSearcher {
    private Searcher searcher;

    public TestSearcher(Searcher searcher) {
        this.searcher = searcher;
    }

    public static void main(String[] args) {
        TestSearcher tester = new TestSearcher(null);
        tester.testLinearSearch();
        tester.testIterativeBinarySearch();
        tester.testRecursiveBinarySearch();
    }

    public void testLinearSearch() {
        Random rand = new Random();
        int size = rand.nextInt(11) + 10; // [10, 20]
        double[] array = new double[size];

        for (int i = 0; i < size; i++) {
            array[i] = rand.nextInt(50); // giá trị random [0, 49]
        }

        System.out.println("\nLinear Search:");
        System.out.println("Data: " + Arrays.toString(array));

        double key = array[rand.nextInt(size)]; // chọn một giá trị có thật để tìm
        searcher = new LinearSearch();
        int index = searcher.search(key, array);
        System.out.println("Linear search giá trị " + key + ": " + index);
    }

    public void testIterativeBinarySearch() {
        Random rand = new Random();
        int size = rand.nextInt(11) + 10;
        double[] array = new double[size];
        for (int i = 0; i < size; i++) {
            array[i] = rand.nextInt(50);
        }

        double key = array[rand.nextInt(size)];

        // Bubble Sort
        System.out.println("\nUsing Bubble Sort Algorithm:");
        System.out.println("Before sorting: " + Arrays.toString(array));
        double[] bubbleArray = Arrays.copyOf(array, array.length);
        searcher = new IterativeBinarySearch();
        ((IterativeBinarySearch) searcher).setSorter(new BubbleSort());
        ((IterativeBinarySearch) searcher).setSorter(new BubbleSort());
        ((IterativeBinarySearch) searcher).setSorter(new BubbleSort());
        ((IterativeBinarySearch) searcher).setSorter(new BubbleSort());
        ((IterativeBinarySearch) searcher).setSorter(new BubbleSort());
        ((IterativeBinarySearch) searcher).setSorter(new BubbleSort());
        ((IterativeBinarySearch) searcher).setSorter(new BubbleSort());
        ((IterativeBinarySearch) searcher).setSorter(new BubbleSort());
        ((IterativeBinarySearch) searcher).setSorter(new BubbleSort());
        ((IterativeBinarySearch) searcher).setSorter(new BubbleSort());
        ((IterativeBinarySearch) searcher).setSorter(new BubbleSort());
        ((IterativeBinarySearch) searcher).setSorter(new BubbleSort());
        ((IterativeBinarySearch) searcher).setSorter(new BubbleSort());
        ((IterativeBinarySearch) searcher).setSorter(new BubbleSort());
        ((IterativeBinarySearch) searcher).setSorter(new BubbleSort());
        ((IterativeBinarySearch) searcher).setSorter(new BubbleSort());
        ((IterativeBinarySearch) searcher).setSorter(new BubbleSort());
        ((IterativeBinarySearch) searcher).setSorter(new BubbleSort());
        ((IterativeBinarySearch) searcher).setSorter(new BubbleSort());
        ((IterativeBinarySearch) searcher).setSorter(new BubbleSort());

        ((IterativeBinarySearch) searcher).setSorter(new BubbleSort());
        ((IterativeBinarySearch) searcher).setSorter(new BubbleSort());
        ((IterativeBinarySearch) searcher).setSorter(new BubbleSort());

        int index = searcher.search(key, bubbleArray);
        System.out.println("After sorting: " + Arrays.toString(bubbleArray));
        System.out.println("Iterative binary search giá trị " + key + ": " + index);

        // Insertion Sort
        System.out.println("\nUsing Insertion Sort Algorithm:");
        System.out.println("Before sorting: " + Arrays.toString(array));
        double[] insertionArray = Arrays.copyOf(array, array.length);
        searcher = new IterativeBinarySearch();
        ((IterativeBinarySearch) searcher).setSorter(new InsertionSort());
        index = searcher.search(key, insertionArray);
        System.out.println("After sorting: " + Arrays.toString(insertionArray));
        System.out.println("Iterative binary search giá trị " + key + ": " + index);

        // Selection Sort
        System.out.println("\nUsing Selection Sort Algorithm:");
        System.out.println("Before sorting: " + Arrays.toString(array));
        double[] selectionArray = Arrays.copyOf(array, array.length);
        searcher = new IterativeBinarySearch();
        ((IterativeBinarySearch) searcher).setSorter(new SelectionSort());
        index = searcher.search(key, selectionArray);
        System.out.println("After sorting: " + Arrays.toString(selectionArray));
        System.out.println("Iterative binary search giá trị " + key + ": " + index);
    }

    public void testRecursiveBinarySearch() {
        Random rand = new Random();
        int size = rand.nextInt(11) + 10;
        double[] array = new double[size];
        for (int i = 0; i < size; i++) {
            array[i] = rand.nextInt(50);
        }

        double key = array[rand.nextInt(size)];

        // Bubble Sort
        System.out.println("\nUsing Bubble Sort Algorithm:");
        System.out.println("Before sorting: " + Arrays.toString(array));
        double[] bubbleArray = Arrays.copyOf(array, array.length);
        searcher = new RecursiveBinarySearch();
        ((RecursiveBinarySearch) searcher).setSorter(new BubbleSort());
        int index = searcher.search(key, bubbleArray);
        System.out.println("After sorting: " + Arrays.toString(bubbleArray));
        System.out.println("Recursive binary search giá trị " + key + ": " + index);

        // Insertion Sort
        System.out.println("\nUsing Insertion Sort Algorithm:");
        System.out.println("Before sorting: " + Arrays.toString(array));
        double[] insertionArray = Arrays.copyOf(array, array.length);
        searcher = new RecursiveBinarySearch();
        ((RecursiveBinarySearch) searcher).setSorter(new InsertionSort());
        index = searcher.search(key, insertionArray);
        System.out.println("After sorting: " + Arrays.toString(insertionArray));
        System.out.println("Recursive binary search giá trị " + key + ": " + index);

        // Selection Sort
        System.out.println("\nUsing Selection Sort Algorithm:");
        System.out.println("Before sorting: " + Arrays.toString(array));
        double[] selectionArray = Arrays.copyOf(array, array.length);
        searcher = new RecursiveBinarySearch();
        ((RecursiveBinarySearch) searcher).setSorter(new SelectionSort());
        index = searcher.search(key, selectionArray);
        System.out.println("After sorting: " + Arrays.toString(selectionArray));
        System.out.println("Recursive binary search giá trị " + key + ": " + index);
    }
}
