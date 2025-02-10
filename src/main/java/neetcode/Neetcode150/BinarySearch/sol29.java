package neetcode.Neetcode150.BinarySearch;

public class sol29 {
    public boolean searchMatrix(int[][] matrix, int target) {
        int n = matrix.length; // nums of rows
        int m = matrix[0].length; // nums of cols
        int i = 0, j = n * m - 1;

        while (i <= j) {
            int middle = (i + j) / 2;
            int mRow = middle / m;
            int mCol = middle % m;

            int now = matrix[mRow][mCol];

            if (now > target) {
                j = middle - 1;
            }
            else if (now < target) {
                i = middle + 1;
            }
            else {
                return true;
            }
        }

        return false;
    }
}
