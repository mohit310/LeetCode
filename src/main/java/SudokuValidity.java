import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

public class SudokuValidity {
    boolean sudoku2(char[][] grid) {
        return isValidRowAndColumn(grid) && isValidSubSquare(grid);
    }

    private boolean isValidSubSquare(char[][] grid) {
        int N = grid.length;
        for (int i = 0; i < N; i = i + 3) {
            for (int j = 0; j < N; j = j + 3) {
                var seq = new HashMap<Integer, Integer>();
                for (int k = i; k < i + 3; k++) {
                    for (int l = j; l < j + 3; l++) {
                        if (!check(grid[k][l], seq)) return false;
                    }
                }
            }
        }
        return true;
    }

    private boolean isValidRowAndColumn(char[][] grid) {
        var N = grid[0].length;
        for (int i = 0; i < N; i++) {
            var seq = new HashMap<Integer, Integer>();
            for (int j = 0; j < N; j++) {
                if (!check(grid[i][j], seq)) return false;
            }
        }
        for (int i = 0; i < N; i++) {
            var seq = new HashMap<Integer, Integer>();
            for (int j = 0; j < N; j++) {
                if (!check(grid[j][i], seq)) return false;
            }
        }

        return true;
    }

    public boolean check(char c, Map<Integer, Integer> seq) {
        if (c == '.') return true;
        var ic = Character.getNumericValue(c);
        if (ic < 1 || ic > 9) return false;
        if (seq.put(ic, ic) != null) return false;
        return true;
    }

    public boolean sudoku3(char[][] grid) {
        int n = grid.length;
        Set<String> set = new HashSet<String>();

        for (int row = 0; row < n; row++) {
            for (int col = 0; col < n; col++) {
                if (grid[row][col] != '.' && !set.add(grid[row][col] + " in row " + row))
                    return false;
                if (grid[row][col] != '.' && !set.add(grid[row][col] + " in col " + col))
                    return false;
                if (grid[row][col] != '.' && !set.add(grid[row][col] + " in square " + row / 3 + " " + col / 3))
                    return false;
            }
        }

        return true;
    }

    public static void main(String[] args) {
        SudokuValidity sv = new SudokuValidity();

//        var grid = new char[][]{
//                {'.', '.', '.', '1', '4', '.', '.', '2', '.'},
//                {'.', '.', '6', '.', '.', '.', '.', '.', '.'},
//                {'.', '.', '.', '.', '.', '.', '.', '.', '.'},
//                {'.', '.', '1', '.', '.', '.', '.', '.', '.'},
//                {'.', '6', '7', '.', '.', '.', '.', '.', '9'},
//                {'.', '.', '.', '.', '.', '.', '8', '1', '.'},
//                {'.', '3', '.', '.', '.', '.', '.', '.', '6'},
//                {'.', '.', '.', '.', '.', '7', '.', '.', '.'},
//                {'.', '.', '.', '5', '.', '.', '.', '7', '.'}};
//        System.out.println(sv.sudoku3(grid));
//
//        grid = new char[][]{{'.', '.', '.', '.', '2', '.', '.', '9', '.'},
//                {'.', '.', '.', '.', '6', '.', '.', '.', '.'},
//                {'7', '1', '.', '.', '7', '5', '.', '.', '.'},
//                {'.', '7', '.', '.', '.', '.', '.', '.', '.'},
//                {'.', '.', '.', '.', '8', '3', '.', '.', '.'},
//                {'.', '.', '8', '.', '.', '7', '.', '6', '.'},
//                {'.', '.', '.', '.', '.', '2', '.', '.', '.'},
//                {'.', '1', '.', '2', '.', '.', '.', '.', '.'},
//                {'.', '2', '.', '.', '3', '.', '.', '.', '.'}};
//        System.out.println(sv.sudoku2(grid));

//        char[][] grid = new char[][]{
//                {'.', '.', '.', '.', '.', '.', '.', '.', '2'},
//                {'.', '.', '.', '.', '.', '.', '6', '.', '.'},
//                {'.', '.', '1', '4', '.', '.', '8', '.', '.'},
//                {'.', '.', '.', '.', '.', '.', '.', '.', '.'},
//                {'.', '.', '.', '.', '.', '.', '.', '.', '.'},
//                {'.', '.', '.', '.', '3', '.', '.', '.', '.'},
//                {'5', '.', '8', '6', '.', '.', '.', '.', '.'},
//                {'.', '9', '.', '.', '.', '.', '4', '.', '.'},
//                {'.', '.', '.', '.', '5', '.', '.', '.', '.'}};
//        System.out.println(sv.sudoku2(grid));


//        char[][] grid = new char[][]{
//                {'.', '.', '4', '.', '.', '.', '6', '3', '.'},
//                {'.', '.', '.', '.', '.', '.', '.', '.', '.'},
//                {'5', '.', '.', '.', '.', '.', '.', '9', '.'},
//                {'.', '.', '.', '5', '6', '.', '.', '.', '.'},
//                {'4', '.', '3', '.', '.', '.', '.', '.', '1'},
//                {'.', '.', '.', '7', '.', '.', '.', '.', '.'},
//                {'.', '.', '.', '5', '.', '.', '.', '.', '.'},
//                {'.', '.', '.', '.', '.', '.', '.', '.', '.'},
//                {'.', '.', '.', '.', '.', '.', '.', '.', '.'}};
//        System.out.println(sv.sudoku2(grid));
//

//        char[][] grid = new char[][]{
//                {'.', '4', '.', '.', '.', '.', '.', '.', '.'},
//                {'.', '.', '4', '.', '.', '.', '.', '.', '.'},
//                {'.', '.', '.', '1', '.', '.', '7', '.', '.'},
//                {'.', '.', '.', '.', '.', '.', '.', '.', '.'},
//                {'.', '.', '.', '3', '.', '.', '.', '6', '.'},
//                {'.', '.', '.', '.', '.', '6', '.', '9', '.'},
//                {'.', '.', '.', '.', '1', '.', '.', '.', '.'},
//                {'.', '.', '.', '.', '.', '.', '2', '.', '.'},
//                {'.', '.', '.', '8', '.', '.', '.', '.', '.'}};
//        System.out.println(sv.sudoku2(grid));

        var grid = new char[][]{
                {'.', '.', '.', '.', '.', '.', '5', '.', '.'},
                {'.', '.', '.', '.', '.', '.', '.', '.', '.'},
                {'.', '.', '.', '.', '.', '.', '.', '.', '.'},
                {'9', '3', '.', '.', '2', '.', '4', '.', '.'},
                {'.', '.', '7', '.', '.', '.', '3', '.', '.'},
                {'.', '.', '.', '.', '.', '.', '.', '.', '.'},
                {'.', '.', '.', '3', '4', '.', '.', '.', '.'},
                {'.', '.', '.', '.', '.', '3', '.', '.', '.'},
                {'.', '.', '.', '.', '.', '5', '2', '.', '.'}};
        System.out.println(sv.sudoku3(grid));

    }
}
