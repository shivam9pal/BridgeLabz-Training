package week03.gcrcodebase.binarystrinbuilder;

class PeakElement {

    static int findPeak(int[] arr) {
        int left = 0;
        int right = arr.length - 1;

        while (left <= right) {
            int mid = left + (right - left) / 2;

            // Handle boundaries safely
            boolean leftOk = (mid == 0) || arr[mid] > arr[mid - 1];
            boolean rightOk = (mid == arr.length - 1) || arr[mid] > arr[mid + 1];

            // If mid is a peak
            if (leftOk && rightOk) {
                return mid;
            }

            // If left neighbor is greater, peak lies on left side
            if (mid > 0 && arr[mid] < arr[mid - 1]) {
                right = mid - 1;
            }
            // Else, peak lies on right side
            else {
                left = mid + 1;
            }
        }

        return -1; // should never happen for valid input
    }

    public static void main(String[] args) {
        int[] arr = { 1, 3, 20, 4, 1, 0 };

        int index = findPeak(arr);

        System.out.println("Peak index: " + index);
        System.out.println("Peak value: " + arr[index]);
    }
}

