package OOPHKII2425_FinalExam_De2.statistics;

public class MyLinkedList extends MyAbstractList {
    private MyNode top;

    /**
     * Khởi tạo dữ liệu mặc định.
     */
    public MyLinkedList() {
        /* TODO */
        top = null;
    }

    @Override
    public int size() {
        /* TODO */
        int count = 0;
        MyNode current = top;
        while (current != null){
            count++;
            current = current.next;
        }
        return count;
    }

    @Override
    public void add(double value) {
        /* TODO */
        if(top == null){
            top = new MyNode(value);
            return;
        }
        MyNode current = top;
        while (current.next != null)   current= current.next;
        current.next = new MyNode(value,null,current);

    }

    @Override
    public void insert(double value, int index) {
        /* TODO */
        if (index == 0) {
            MyNode newNode = new MyNode(value, top, null);

            if (top != null) top.previous = newNode;
            top = newNode;
            return;
        }
        MyNode prew = getNodeByIndex(index -1);
        MyNode next = prew.next;
        MyNode newNode = new MyNode(value,next,prew);
        prew.next = newNode;
        if(next != null) next.previous = newNode;
    }

    @Override
    public void remove(int index) {
        /* TODO */
        MyNode node = getNodeByIndex(index);
        if(node.previous != null) node.previous.next  = node.next;
        else top = node.next;
        if(node.next != null) node.next.previous = node.previous;
    }

    @Override
    public MyLinkedList sortIncreasing() {
        /* TODO */
        MyArrayList temp = new MyArrayList();
        MyIterator it = iterator(0);
        while (it.hasNext()) temp.add(it.next().doubleValue());
        temp=temp.sortIncreasing();
        MyLinkedList sorted = new MyLinkedList();
        MyIterator sortedIt = temp.iterator(0);
        while (sortedIt.hasNext()) sorted.add(sortedIt.next().doubleValue());
        return sorted;
    }

    @Override
    public int binarySearch(double data) {
        /* TODO */
        MyArrayList temp = new MyArrayList();
        MyIterator it = iterator(0);
        while (it.hasNext()) temp.add(it.next().doubleValue());
        return temp.binarySearch(data);
    }

    /**
     * Tạo iterator để cho phép duyệt qua các phần tử của list.
     * @return
     */
    @Override
    public MyIterator iterator(int start) {
        /* TODO */
        return new MyLinkedListIterator(start);
    }

    /**
     * Lấy node ở vị trí index.
     * @param index
     * @return
     */
    private MyNode getNodeByIndex(int index) {
        /* TODO */
        MyNode crrent = top;
        for (int i = 0; i < index; i++) {
            crrent = crrent.next;
        }
        return crrent;
    }

    private class MyLinkedListIterator implements MyIterator {
        /*
         * Vị trí hiện tại của iterator trong list.
         */
        private int currentPosition;
        private  MyNode currentNode;

        /**
         * Khởi tạo cho iterator ở vị trí position trong MyLinkedList.
         * @param position
         */
        public MyLinkedListIterator(int position) {
            /* TODO */
            currentPosition = 0;
            currentNode = top;
            while (currentNode != null && currentPosition < position){
                currentNode = currentNode.next;
                currentPosition++;
            }
        }

        @Override
        public boolean hasNext() {
            /* TODO */
            return currentNode != null;
        }

        @Override
        public Number next() {
            /* TODO */
            double value = currentNode.data;
            currentNode = currentNode.next;
            return value;
        }

        @Override
        public void remove() {
            /* TODO */
            MyLinkedList.this.remove(--currentPosition);
        }
    }
}
