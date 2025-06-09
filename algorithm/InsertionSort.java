package OOPHKII2425_FinalExam_De3.algorithm;

public class InsertionSort implements Sorter {

    /**
     * Sắp xếp mảng dữ liệu, sử dụng thuật toán Insertion sort.
     * @param data
     * @param order: true sắp xếp theo thứ tự tăng dần, false sắp xếp theo thứ tự giảm dần.
     */
    @Override
    public void sort(double[] data, boolean order) {
        if (order) {
            sortAscending(data);
        } else {
            sortDescending(data);
        }
    }

    /**
     * Sắp xếp mảng dữ liệu theo thứ tự tăng dần, sử dụng thuật toán Insertion sort.
     * @param data
     */
    private void sortAscending(double[] data) {
        int n = data.length;
        for (int i = 1; i < n; i++) {
            double key = data[i];
            int j = i - 1;

            // Di chuyển các phần tử lớn hơn key sang phải
            while (j >= 0 && data[j] > key) {
                data[j + 1] = data[j];
                j--;
            }
            data[j + 1] = key;
        }
    }

    /**
     * Sắp xếp mảng dữ liệu theo thứ tự giảm dần, sử dụng thuật toán Insertion sort.
     * @param data
     */
    private void sortDescending(double[] data) {
        int n = data.length;
        for (int i = 1; i < n; i++) {
            double key = data[i];
            int j = i - 1;

            // Di chuyển các phần tử nhỏ hơn key sang phải
            while (j >= 0 && data[j] < key) {
                data[j + 1] = data[j];
                j--;
            }
            data[j + 1] = key;
        }
    }
}
