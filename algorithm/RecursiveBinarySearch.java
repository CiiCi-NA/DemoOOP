package OOPHKII2425_FinalExam_De3.algorithm;

public class RecursiveBinarySearch implements Searcher {
    private Sorter sorter;

    public RecursiveBinarySearch() {
        // Mặc định sử dụng InsertionSort nếu chưa set sorter
        this.sorter = new InsertionSort();
        this.sorter = new InsertionSort();
    }

    public void setSorter(Sorter sorter) {
        this.sorter = sorter;
    }

    @Override
    public int search(double value, double[] data) {
        // Sắp xếp mảng trước khi tìm kiếm (theo thứ tự tăng dần)
        sort(data);
        return recursiveBinarySearch(value, data);
    }

    /**
     * Tìm kiếm giá trị value trong toàn bộ mảng data, sử dụng thuật toán nhị phân đệ quy.
     */
    private int recursiveBinarySearch(double value, double[] data) {
        return recursiveBinarySearch(value, data, 0, data.length - 1);
    }

    /**
     * Tìm kiếm nhị phân đệ quy từ vị trí from đến to.
     */
    private int recursiveBinarySearch(double value, double[] data, int from, int to) {
        if (from > to) return -1;

        int mid = (from + to) / 2;

        if (data[mid] == value) return mid;
        else if (data[mid] > value) return recursiveBinarySearch(value, data, from, mid - 1);
        else return recursiveBinarySearch(value, data, mid + 1, to);
    }

    /**
     * Sắp xếp mảng dữ liệu theo thứ tự tăng dần.
     */
    private void sort(double[] data) {
        if (sorter != null) {
            sorter.sort(data, true);
        }
    }
}
