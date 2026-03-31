package week01.method;

public class RandomMatrixOperation {

    //create a random matrix
    public static int[][] createMatrix(int rows, int cols) {
        int[][] matrix = new int[rows][cols];

        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < cols; j++) {
                matrix[i][j] = (int) (Math.random() * 10); // 0–9
            }
        }
        return matrix;
    }

    //add two matrices
    public static int[][] addMatrices(int[][] A, int[][] B) {
        int[][] result = new int[A.length][A[0].length];

        for (int i = 0; i < A.length; i++) {
            for (int j = 0; j < A[0].length; j++) {
                result[i][j] = A[i][j] + B[i][j];
            }
        }
        return result;
    }

    //subtract two matrices
    public static int[][] subtractMatrices(int[][] A, int[][] B) {
        int[][] result = new int[A.length][A[0].length];

        for (int i = 0; i < A.length; i++) {
            for (int j = 0; j < A[0].length; j++) {
                result[i][j] = A[i][j] - B[i][j];
            }
        }
        return result;
    }

    //multiply two matrices
    public static int[][] multiplyMatrices(int[][] A, int[][] B) {
        int[][] result = new int[A.length][B[0].length];

        for (int i = 0; i < A.length; i++) {
            for (int j = 0; j < B[0].length; j++) {
                for (int k = 0; k < B.length; k++) {
                    result[i][j] += A[i][k] * B[k][j];
                }
            }
        }
        return result;
    }

    //display a matrix
    public static void displayMatrix(int[][] matrix) {
        for (int[] row : matrix) {
            for (int value : row) {
                System.out.print(value + "\t");
            }
            System.out.println();
        }
    }

    public static void main(String[] args) {

        int[][] A = createMatrix(9, 9);
        int[][] B = createMatrix(9, 9);
        //Displaying Result
        System.out.println("Matrix A:");
        displayMatrix(A);

        System.out.println("\nMatrix B:");
        displayMatrix(B);

        System.out.println("\nAddition:");
        displayMatrix(addMatrices(A, B));

        System.out.println("\nSubtraction:");
        displayMatrix(subtractMatrices(A, B));

        System.out.println("\nMultiplication:");
        displayMatrix(multiplyMatrices(A, B));
    }
}
