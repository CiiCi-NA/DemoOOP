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
        double[] data = new double[size];
        for (int i = 0; i < size; i++) {
            data[i] = Math.round(rand.nextDouble() * 100) / 1.0;
        }

        double valueToSearch = data[rand.nextInt(size)];

        searcher = new LinearSearch(); // Đảm bảo class LinearSearch đã cài đặt đúng
        int result = searcher.search(valueToSearch, data);

        System.out.println("Data: " + Arrays.toString(data));
        System.out.println("Linear search giá trị " + valueToSearch + ": " + result);
    }

    public void testIterativeBinarySearch() {
        double[] originalData = generateRandomArray();
        double valueToSearch = originalData[new Random().nextInt(originalData.length)];

        searcher = new IterativeBinarySearch();

        testWithSorter("Bubble Sort", new BubbleSort(), originalData.clone(), valueToSearch, false);
        testWithSorter("Insertion Sort", new InsertionSort(), originalData.clone(), valueToSearch, false);
        testWithSorter("Selection Sort", new SelectionSort(), originalData.clone(), valueToSearch, false);
    }

    public void testRecursiveBinarySearch() {
        double[] originalData = generateRandomArray();
        double valueToSearch = originalData[new Random().nextInt(originalData.length)];

        searcher = new RecursiveBinarySearch();

        testWithSorter("Bubble Sort", new BubbleSort(), originalData.clone(), valueToSearch, true);
        testWithSorter("Insertion Sort", new InsertionSort(), originalData.clone(), valueToSearch, true);
        testWithSorter("Selection Sort", new SelectionSort(), originalData.clone(), valueToSearch, true);
    }



    private double[] generateRandomArray() {
        Random rand = new Random();
        int size = rand.nextInt(11) + 10; // [10, 20]
        double[] data = new double[size];
        for (int i = 0; i < size; i++) {
            data[i] = Math.round(rand.nextDouble() * 100) / 1.0;
        }
        return data;
    }
}
