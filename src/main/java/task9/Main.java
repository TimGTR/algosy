package task9;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;
import java.util.ArrayList;
import java.util.List;

public class Main {
    public static void main(String[] args) {
        CustomList<String> testList = new CustomList<>();

        test(testList);
        System.out.println("любые перегрузки метода add вызывались (в сумме) " + testList.getAddCount() + " раз/раза");

        AddCounterHandler handler = new AddCounterHandler(testList);
        List<String> proxyList = (List<String>) Proxy.newProxyInstance(
                List.class.getClassLoader(),
                new Class[]{List.class},
                handler
        );
        test(proxyList);
        System.out.println("любые перегрузки метода add вызывались (в сумме) " + handler.getAddCount() + " раз/раза");
    }

    public static void test(List<String> list) {
        list.add("a");
        list.add("b");
        list.add("c");

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

    static class AddCounterHandler implements InvocationHandler {

        private final List<?> target;
        private int addCount = 0;

        public AddCounterHandler(List<?> target) {
            this.target = target;
        }

        public int getAddCount() {
            return addCount;
        }

        @Override
        public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {

            if (method.getName().equals("add")) {
                addCount++;
            }

            return method.invoke(target, args);
        }
    }
}
