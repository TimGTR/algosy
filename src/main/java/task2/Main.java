package task2;

public class Main {
    public static void main(String[] args) {
        int[] arr = new int[] {1, 3, 5, 7, 9, 11, 13};
        System.out.println(binarySearch(arr,1));
        System.out.println(binarySearch(arr,13));
        System.out.println(binarySearch(arr,12));
    }

    /*
    Почему бинарный поиск нельзя применять к неотсортированному массиву?
    - мы при итерации сдвигаем окно поиска, предполагая, что элемент левее (в данном случае левее mid) меньше, а справа больше
    Какая асимптотическая сложность алгоритма по времени и почему это O(log n)?
    - сложность log n, потому что мы каждый раз делим массив на 2, т.e. log  с основанием 2
    Какая сложность по памяти?
    - сложность по памяти О(1), потому что мы при любом размере массива создаем 2 доп переменные
     */
    public static int binarySearch(int[] array, int target) {
        int left = 0;
        int right = array.length - 1;
        while (left <= right) {
            int mid = left + (right - left) / 2;
            if (array[mid] == target) {
                return mid;
            } else {
                if (array[mid] < target) {
                    left = mid + 1;
                } else {
                    right = mid - 1;
                }
            }
        }
        return -1;
    }
}
