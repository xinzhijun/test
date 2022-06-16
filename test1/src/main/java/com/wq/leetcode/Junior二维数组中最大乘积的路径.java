package com.wq.leetcode;

public class Junior二维数组中最大乘积的路径 {
    // Java Program to find maximum
// product path from (0, 0) to
// (N-1, M-1)
    static final int N = 3;
    static final int M = 3;

    // Function to find maximum product
    static int maxProductPath(int arr[][])
    {

        // It will store the maximum
        // product till a given cell.
        int [][]maxPath = new int[N][M];

        // It will store the minimum
        // product till a given cell
        // (for -ve elements)
        int [][]minPath = new int[N][M];

        for (int i = 0; i < N; i++)
        {
            for (int j = 0; j < M; j++)
            {

                int minVal = Integer.MAX_VALUE;
                int maxVal = Integer.MIN_VALUE;

                // If we are at topmost
                // or leftmost, just
                // copy the elements.
                if (i == 0 && j == 0)
                {
                    maxVal = arr[i][j];
                    minVal = arr[i][j];
                }

                // If we're not at the
                // above, we can consider
                // the above value.
                if (i > 0)
                {
                    int tempMax = Math.max(maxPath[i - 1][j] * arr[i][j],
                            minPath[i - 1][j] * arr[i][j]);
                    maxVal = Math.max(maxVal, tempMax);

                    int tempMin = Math.min(maxPath[i - 1][j] * arr[i][j],
                            minPath[i - 1][j] * arr[i][j]);
                    minVal = Math.min(minVal, tempMin);
                }

                // If we're not on the
                // leftmost, we can consider
                // the left value.
                if (j > 0) {
                    int tempMax = Math.max(maxPath[i][j - 1] * arr[i][j],
                            minPath[i][j - 1] * arr[i][j]);
                    maxVal = Math.max(maxVal, tempMax);

                    int tempMin = Math.min(maxPath[i][j - 1] * arr[i][j],
                            minPath[i][j - 1] * arr[i][j]);
                    minVal = Math.min(minVal, tempMin);
                }

                // Store max & min product
                // till i, j.
                maxPath[i][j] = maxVal;
                minPath[i][j] = minVal;
            }
        }

        // Return the max product path
        // from 0, 0.N-1, M-1.
        return maxPath[N - 1][M - 1];
    }

    // Driver Code
    public static void main(String[] args)
    {
        int arr[][] = { { 1, -2, 3 },
                { 4, -5, 6 },
                { -7, -8, 9 } };

        // Print maximum product from
        // (0, 0) to (N-1, M-1)
        System.out.print(maxProductPath(arr) +"\n");
    }

// This code is contributed by 29AjayKumar
}
