package task9;

import java.util.ArrayList;
import java.util.List;

public class Main {
    public static void main(String[] args) {
        CustomList<String> testList = new CustomList<>();
        testList.add("a");
        testList.add("b");
        testList.add("c");

        test(testList);
        System.out.println("любые перегрузки метода add вызывались (в сумме) " + testList.getAddCount() + " раз/раза");
    }

    public static void test(List<?> list) {
        System.out.println("Метод test получил список размером: " + list.size());
    }

    static class CustomList<T> extends ArrayList<T> {
        private int addCount;

        @Override
        public boolean add(T t) {
            addCount++;
            return super.add(t);
        }

        public int getAddCount() {
            return addCount;
        }
    }
}
