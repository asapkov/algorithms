package chus.algorithm;

public class BinarySearch {
    private BinarySearch() {
    }

    public static int search(int value, int... arr) {
        int low = 0;
        int high = arr.length - 1;

        while (low <= high) {
            int mid = low + (high - low) / 2;

            if (value < arr[mid]) {
                high = mid - 1;
            } else if (value > arr[mid]) {
                low = mid + 1;
            } else {
                return mid;
            }
        }
        return -1;
    }
}
