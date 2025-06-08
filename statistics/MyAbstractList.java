package OOPHKII2425_FinalExam_De2.statistics;
import java.util.*;
public abstract class MyAbstractList implements MyList {
    /**
     * Mô tả dữ liệu của list.
     * @return mô tả list theo định dạng [a1 a2 a3 ... an]
     */
    @Override
    public String toString() {
        /* TODO */
        StringBuilder sb = new StringBuilder("[");
        MyIterator it = iterator(0);
        while (it.hasNext()) {
            sb.append(it.next()).append(" ");
        }
        if(sb.length()> 1) sb.setLength(sb.length() -1);
        return sb.toString();
    }
}
