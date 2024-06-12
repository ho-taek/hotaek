package 알고리즘;

public class binarySearch {

    public static void main(String[] args) {
        int[] arr = new int[] { 0, 1, 2, 3, 4, 5, 6, 7, 8 };

        System.out.println("재귀");
        System.out.println(binarySearch(arr, 2, 0, arr.length - 1));
        System.out.println();
        System.out.println("반복");
        System.out.println(binarySearchWhile(arr, 2, 0, arr.length - 1));
    }

    // 재귀
    static int binarySearch(int[] arr, int answer, int low, int high) {
        int mid;

        if (low <= high) {
            mid = (low + high) / 2;

            if (answer == arr[mid]) {
                return answer;
            } else if (answer < arr[mid]) {
                return binarySearch(arr, answer, low, mid - 1);
            } else {
                return binarySearch(arr, answer, mid + 1, high);
            }
        }

        return -1;
    }

    // 반복문
    static int binarySearchWhile(int[] arr, int answer, int low, int high) {

        while (low <= high) {
            int mid = (low + high) / 2;

            if (answer == arr[mid]) {
                return answer;
            } else if (answer < arr[mid]) {
                high = mid - 1;
            } else {
                low = mid + 1;
            }
        }

        return -1;

    }
}
