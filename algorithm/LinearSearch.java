package OOPHKII2425_FinalExam_De3.algorithm;

public class LinearSearch implements Searcher {

    /**
     * Tìm kiếm tuyến tính: duyệt từng phần tử trong mảng và so sánh với giá trị cần tìm.
     * @param value: giá trị cần tìm.
     * @param data: mảng dữ liệu.
     * @return chỉ số đầu tiên của phần tử có giá trị bằng value, hoặc -1 nếu không tìm thấy.
     */
    @Override
    public int search(double value, double[] data) {
        for (int i = 0; i < data.length; i++) {
            if (data[i] == value) {
                return i;
            }
        }
        return -1;
    }
}
