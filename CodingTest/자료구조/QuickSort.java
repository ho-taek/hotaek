package 자료구조;

import java.util.Arrays;

public class QuickSort {

    static int[] array = new int[] { 4, 7, 2, 5, 6, 0, 1, 3 };

    public static void main(String[] args) {
        quick_sort(0, array.length - 1);

        System.out.println(Arrays.toString(array));
    }

    public static void quick_sort(int left, int right) {

        if (left >= right) {
            return;
        }

        int pivot = partition(left, right);

        quick_sort(left, pivot - 1);
        quick_sort(pivot + 1, right);
    }

    public static int partition(int left, int right) {

        int low = left;
        int high = right;
        int pivot = array[left];

        while (low < high) {

            while (low < high && array[high] > pivot) {
                high--;
            }

            while (low < high && array[low] < pivot) {
                low++;
            }

            swap(low, high);
        }

        swap(pivot, low);

        return low;
    }

    public static void swap(int left, int right) {
        int tmp = array[left];
        array[left] = array[right];
        array[right] = tmp;
    }
}
