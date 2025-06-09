package OOPHKII2425_FinalExam_De3.algorithm;

public class SelectionSort implements Sorter {

    /**
     * Sắp xếp mảng dữ liệu, sử dụng thuật toán Selection sort.
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
     * Sắp xếp mảng dữ liệu theo thứ tự tăng dần, sử dụng thuật toán Selection sort.
     * @param data
     */
    private void sortAscending(double[] data) {
        int n = data.length;
        for (int i = 0; i < n - 1; i++) {
            int minIdx = i;
            for (int j = i + 1; j < n; j++) {
                if (data[j] < data[minIdx]) {
                    minIdx = j;
                }
            }
            // Đổi chỗ phần tử nhỏ nhất với phần tử đầu tiên
            double temp = data[minIdx];
            data[minIdx] = data[i];
            data[i] = temp;
        }
    }

    /**
     * Sắp xếp mảng dữ liệu theo thứ tự giảm dần, sử dụng thuật toán Selection sort.
     * @param data
     */
    private void sortDescending(double[] data) {
        int n = data.length;
        for (int i = 0; i < n - 1; i++) {
            int maxIdx = i;
            for (int j = i + 1; j < n; j++) {
                if (data[j] > data[maxIdx]) {
                    maxIdx = j;
                }
            }
            // Đổi chỗ phần tử lớn nhất với phần tử đầu tiên
            double temp = data[maxIdx];
            data[maxIdx] = data[i];
            data[i] = temp;
        }
    }
}
