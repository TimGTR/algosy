package task3;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Stack;

public class Main {
    public static void main(String[] args) throws Exception {
        /*
        1) Выбор структуры (по 1 слову).
        а) Поток событий в порядке прихода → очередь (Queue, LinkedList)
        б) Отмена последнего действия → Stack, ArrayDeque
        в) Телефонный справочник «номер → имя» → Map

        2) Быстрый прогон операций.
          Стек: push(1), push(2), push(3), pop(), push(4), peek()
          — Что на вершине? 4
          — Итоговое содержимое снизу вверх? 1 2 4
        */
        Stack<Integer> stack = new Stack<>();
        stack.push(1);
        stack.push(2);
        stack.push(3);
        stack.pop();
        stack.push(4);
        System.out.println("Что на вершине " + stack.peek());
        System.out.println("Итоговое содержимое снизу вверх = " + stack);

        /*
          Очередь: offer(A), offer(B), offer(C), poll(), offer(D), peek()
           — Кого вернул poll? A
           — Кто сейчас первый? B
           — Порядок элементов? [B, C, D]

         */
        Queue<String> list = new LinkedList<>();
        list.offer("A");
        list.offer("B");
        list.offer("C");
        System.out.println("Кого вернул poll = " + list.poll());
        list.offer("D");
        System.out.println("Кто сейчас первый = " + list.peek());
        System.out.println("Порядок элементов = "+ list);

        /*
        3) Динамический массив (рост ×2).
        Старт: capacity=2, size=2, данные: [X, Y].
        Сделать append(Z), затем append(W).
         — В какой момент было расширение? append(Z)
         — Сколько элементов копировалось? 2
         — Итог: size=4, capacity=4, массив: X Y Z W
         */
        ArrayList<String> arr = new ArrayList<>(2){};
        arr.add("X");
        arr.add("Y");
        arr.add("Z");
        arr.add("W");
    }
}
