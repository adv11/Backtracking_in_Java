package Backtracking;

import java.util.Scanner;

public class N_QueenProblem_Recursion {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter number of testcase:");
        int t = sc.nextInt();

        while (t-- > 0) {
            System.out.println("Enter the dimension(N) of the chess board : (N X N)");
            int n = sc.nextInt();

            int[][] chess = new int[n][n];  // chess array
            printNQueens(chess, "", 0);     // printNQueens(chess array, qfs, row number)
        }
    }
    public static void printNQueens(int[][] chess, String qfs, int row){
        // edge condition
        // if row == size of the array then return
        if(row == chess.length){
            System.out.println(qfs);
            return;
        }

        // remaining cases
        for(int col=0 ; col<chess.length ; col++){

            // checking if the place is safe for the queen so that we can place it in that square
            if(ifQueenCanBePlacedSafely(chess, row, col)){
                chess[row][col] = 1;        // putting 1 so that it shows we have visited it
                printNQueens(chess, qfs+row + "-" + col, row+1);    // calling for next row
                chess[row][col] = 0;        // putting again 0 so that it shows we visited and removed it for other recursive calls
            }
        }
    }

    // method for checking safe place
    // we have to check for 3 possibilities only : left diagonal, right diagonal and upper straight diagonal from that square
    public static boolean ifQueenCanBePlacedSafely(int[][] chess, int row, int col){
        // condition 1
        // String upper diagonal check
        for(int i = row-1, j=col; i>=0 ; i--){
            if(chess[i][j] == 1){
                return false;
            }
        }

        // condition 2
        // left diagonal check
        for(int i=row-1, j=col-1 ; i>=0 && j>=0 ; i--, j--){
            if(chess[i][j] == 1){
                return false;
            }
        }

        // condition 3
        // right diagonal check
        for(int i=row-1, j=col+1 ; i>=0 && j<chess.length ; i--, j++){
            if(chess[i][j] == 1){
                return false;
            }
        }
        return true;
    }
}
