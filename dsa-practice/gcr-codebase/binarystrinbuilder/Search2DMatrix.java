package week03.gcrcodebase.binarystrinbuilder;

class Search2DMatrix {

    static boolean searchMatrix(int[][] matrix, int target) {
        int rows = matrix.length;
        int cols = matrix[0].length;

        int left = 0;
        int right = rows * cols - 1;

        while (left <= right) {
            int mid = left + (right - left) / 2;

            // Convert 1D index to 2D indices
            int row = mid / cols;
            int col = mid % cols;

            int value = matrix[row][col];

            if (value == target) {
                return true;
            } else if (target < value) {
                right = mid - 1;
            } else {
                left = mid + 1;
            }
        }

        return false;
    }

    public static void main(String[] args) {
        int[][] matrix = {
            { 1, 3, 5, 7 },
            { 10, 11, 16, 20 },
            { 23, 30, 34, 60 }
        };

        int target = 16;

        boolean found = searchMatrix(matrix, target);
        System.out.println("Found: " + found);
    }
}

