package OOPHKII2425_FinalExam_De2.statistics;

import java.util.Arrays;

public class MyArrayList extends MyAbstractList {
    private static final int DEFAULT_CAPACITY = 16;
    private double[] data;
    private int size;

    /**
     * Khởi tạo dữ liệu mặc định.
     */
    public MyArrayList() {
        /* TODO */
        data = new double[DEFAULT_CAPACITY];
        size = 0;

    }

    @Override
    public int size() {
        /* TODO */
        return size;
    }

    @Override
    public void add(double dt) {
        /* TODO */
        if(size >= data.length) allocateMore();
        data[size++] = dt;
    }

    @Override
    public void insert(double value, int index) {
        /* TODO */
        if(index < 0 || index > size) throw new IndexOutOfBoundsException();
        if(size >= data.length) allocateMore();
        System.arraycopy(data,index,data,index+1,size -index);
        data[index] = value;
        size++;
    }

    @Override
    public void remove(int index) {
        /* TODO */
        if(index < 0 || index > size) throw new IndexOutOfBoundsException();
        System.arraycopy(data,index,data,index+1,size -index);
        size--;
    }

    @Override
    public MyArrayList sortIncreasing() {
        /* TODO */
        MyArrayList sorted = new MyArrayList();
        sorted.data = Arrays.copyOf(data,size);
        Arrays.sort(sorted.data);
        return sorted;
    }

    @Override
    public int binarySearch(double value) {
        /* TODO */
        int index = Arrays.binarySearch(data,0 , size, value);
        return index >= 0 ? index : -1;
    }

    /**
     * Tạo iterator để có thể duyệt qua các phần tử của list.
     * @return
     */
    @Override
    public MyIterator iterator(int start) {
        /* TODO */
        return new MyArrayListIterator(start);
    }

    /**
     * Cấp phát gấp đôi chỗ cho danh sách khi cần thiết.
     */
    private void allocateMore() {
        /* TODO */
        data = Arrays.copyOf(data, data.length * 2);
    }

    private class MyArrayListIterator implements MyIterator {
        /**
         * Vị trí hiện tại của iterator trong MyArrayList.
         */
        private int currentPosition;

        /**
         * Khởi tạo dữ liệu cho iterator tại vị trí position của list.
         */
        public MyArrayListIterator(int position) {
            /* TODO */
            this.currentPosition = position;
        }

        @Override
        public boolean hasNext() {
            /* TODO */
            return currentPosition < size;
        }

        @Override
        public Number next() {
            /* TODO */
            return data[currentPosition++];
        }

        @Override
        public void remove() {
            /* TODO */
            MyArrayList.this.remove(--currentPosition);
        }
    }
}
