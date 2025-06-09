package OOPHKII2425_FinalExam_De3.algorithm;

public class IterativeBinarySearch implements Searcher {
    private Sorter sorter;

    public IterativeBinarySearch() {
        // Mặc định sử dụng InsertionSort nếu chưa gán sorter
        this.sorter = new InsertionSort();
    }

    public void setSorter(Sorter sorter) {
        this.sorter = sorter;
    }

    @Override
    public int search(double value, double[] data) {
        // Sắp xếp mảng theo thứ tự tăng dần trước khi tìm kiếm
        sort(data);
        return iterativeBinarySearch(value, data);
    }

    /**
     * Tìm kiếm nhị phân lặp
     */
    private int iterativeBinarySearch(double value, double[] data) {
        int left = 0;
        int right = data.length - 1;

        while (left <= right) {
            int mid = (left + right) / 2;

            if (data[mid] == value) return mid;
            else if (data[mid] < value) left = mid + 1;
            else right = mid - 1;
        }

        return -1; // Không tìm thấy
    }

    /**
     * Sắp xếp mảng dữ liệu theo thứ tự tăng dần.
     */
    private void sort(double[] data) {
        if (sorter != null) {
            sorter.sort(data, true); // true: tăng dần
        }
    }
}
