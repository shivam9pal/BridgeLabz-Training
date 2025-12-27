package week01.method;

public class MatrixOperation2 {

    //random matrix
    public static int[][] createMatrix(int rows, int cols) {
        int[][] matrix = new int[rows][cols];
        for (int i = 0; i < rows; i++)
            for (int j = 0; j < cols; j++)
                matrix[i][j] = (int) (Math.random() * 10);

        return matrix;
     }

    // Transpose  matrix
    public static int[][] transposeMatrix(int[][] matrix) {
        int[][] transpose = new int[matrix[0].length][matrix.length];

        for (int i = 0; i < matrix.length; i++)
            for (int j = 0; j < matrix[0].length; j++)
                transpose[j][i] = matrix[i][j];
        return transpose;
    }

    // determinant of 2x2 matrix
    public static int determinant2x2(int[][] m) {
        return (m[0][0] * m[1][1]) - (m[0][1] * m[1][0]);
    }
    // determinant of 3x3 matrix
    public static int determinant3x3(int[][] m) {
        return m[0][0] * (m[1][1] * m[2][2] - m[1][2] * m[2][1])
             - m[0][1] * (m[1][0] * m[2][2] - m[1][2] * m[2][0])
             + m[0][2] * (m[1][0] * m[2][1] - m[1][1] * m[2][0]);
    }

    // Inverse of 2x2 matrix
    public static double[][] inverse2x2(int[][] m) {
        int det = determinant2x2(m);
        double[][] inv = new double[2][2];

        inv[0][0] = m[1][1] / (double) det;
        inv[0][1] = -m[0][1] / (double) det;
        inv[1][0] = -m[1][0] / (double) det;
        inv[1][1] = m[0][0] / (double) det;

        return inv;
    }
    // Display int matrix
    public static void displayMatrix(int[][] matrix) {
        for (int[] row : matrix) {
            for (int v : row)
                System.out.print(v + "\t");
            System.out.println();
        }
    }
    // Display double matrix
    public static void displayMatrix(double[][] matrix) {
        for (double[] row : matrix) {
            for (double v : row)
                System.out.printf("%.2f\t", v);
            System.out.println();
        }
    }

    public static void main(String[] args) {

        int[][] matrix2x2 = createMatrix(2, 2);
        int[][] matrix3x3 = createMatrix(3, 3);
        //Displaying result
        System.out.println("2x2 Matrix:");
        displayMatrix(matrix2x2);

        System.out.println("\nTranspose:");
        displayMatrix(transposeMatrix(matrix2x2));

        System.out.println("\nDeterminant (2x2): " + determinant2x2(matrix2x2));

        System.out.println("\nInverse (2x2):");
        displayMatrix(inverse2x2(matrix2x2));

        System.out.println("\n3x3 Matrix:");
        displayMatrix(matrix3x3);

        System.out.println("\nTranspose:");
        displayMatrix(transposeMatrix(matrix3x3));

        System.out.println("\nDeterminant (3x3): " + determinant3x3(matrix3x3));
    }
}
