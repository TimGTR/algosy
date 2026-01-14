package task4.src;

import java.util.ArrayDeque;
import java.util.Deque;

public final class QuickSort {
    public static void quickSort(int[] arr) {
//        проверка граничных случаев когда сортировать нечего
        if (arr == null || arr.length < 2) {
            return;
        }
//        используем стэк массивов (для хранения пар числе) вместо рекурсии и кладем в стек весь массив
        Deque<int[]> stack = new ArrayDeque<>();
        stack.push(new int[]{0, arr.length - 1});
//        пока есть диапазоны которые нужно отсортировать
        while (!stack.isEmpty()) {
//        достаем эти диапазоны
            int[] range = stack.pop();
            int left = range[0];
            int right = range[1];
//            уже отсортирован, пропускаем
            if (left >= right) {
                continue;
            }
//
            int pivotIndex = partition(arr, left, right);
//          добавляем левую часть в стек
            if (pivotIndex - 1 > left) {
                stack.push(new int[]{left, pivotIndex - 1});
            }
//          добавляем правую часть в стек
            if (pivotIndex + 1 < right) {
                stack.push(new int[]{pivotIndex + 1, right});
            }
        }
    }

    private static int partition(int[] arr, int left, int right) {
//        выбираем опорный элемент - надеемся на удачу и берем последний элемент сортируемого диапазона
        int pivot = arr[right];
        int i = left - 1;
// .     проходим по всем элементам, кроме pivot
        for (int j = left; j < right; j++) {
//            если элемент ≤ pivot, то меняем местами текущий элемент и границу
//            левой зоны, чтобы все элементы ≤ pivot оказались слева от pivot
            if (arr[j] <= pivot) {
                i++;
                swap(arr, i, j);
            }
        }
//        все элементы <= pivot оказываются слева
//      ставим опорный элемент на его окончательное место
        swap(arr, i + 1, right);
//        возвращаем индекс опроного элемента
        return i + 1;
    }
// .    ну свапаем 2 элемента местами
    private static void swap(int[] arr, int i, int j) {
        int tmp = arr[i];
        arr[i] = arr[j];
        arr[j] = tmp;
    }
}
