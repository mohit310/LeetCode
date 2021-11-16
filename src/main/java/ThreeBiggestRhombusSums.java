import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.PriorityQueue;

/**
 * You are given an m x n integer matrix grid
 * <p>
 * A rhombus sum is the sum of the elements that form the border of a regular rhombus shape in grid. The rhombus must have the shape of a square rotated 45 degrees with each of the corners centered in a grid cell. Below is an image of four valid rhombus shapes with the corresponding colored cells that should be included in each rhombus sum:
 * <p>
 * Note that the rhombus can have an area of 0, which is depicted by the purple rhombus in the bottom right corner.
 * <p>
 * Return the biggest three distinct rhombus sums in the grid in descending order. If there are less than three distinct values, return all of them.
 * <p>
 * <p>
 * <p>
 * Example 1:
 * <p>
 * Input: grid = [[3,4,5,1,3],[3,3,4,2,3],[20,30,200,40,10],[1,5,5,4,1],[4,3,2,2,5]]
 * Output: [228,216,211]
 * Explanation: The rhombus shapes for the three biggest distinct rhombus sums are depicted above.
 * - Blue: 20 + 3 + 200 + 5 = 228
 * - Red: 200 + 2 + 10 + 4 = 216
 * - Green: 5 + 200 + 4 + 2 = 211
 * <p>
 * Example 2:
 * <p>
 * Input: grid = [[1,2,3],[4,5,6],[7,8,9]]
 * Output: [20,9,8]
 * Explanation: The rhombus shapes for the three biggest distinct rhombus sums are depicted above.
 * - Blue: 4 + 2 + 6 + 8 = 20
 * - Red: 9 (area 0 rhombus in the bottom right corner)
 * - Green: 8 (area 0 rhombus in the bottom middle)
 * <p>
 * Example 3:
 * <p>
 * Input: grid = [[7,7,7]]
 * Output: [7]
 * Explanation: All three possible rhombus sums are the same, so return [7].
 * <p>
 * <p>
 * <p>
 * Constraints:
 * <p>
 * m == grid.length
 * n == grid[i].length
 * 1 <= m, n <= 50
 * 1 <= grid[i][j] <= 105
 */
public class ThreeBiggestRhombusSums {

    private static int[][] rhombiCoords = new int[][]{{1, 1}, {1, -1}, {2, 0}};

    public static List<Integer> threeBiggestRhombusSums(int[][] grid) {
        PriorityQueue<Integer> q = new PriorityQueue(Comparator.reverseOrder());
        for (int i = 0; i < grid.length; i++) {
            for (int j = 0; j < grid[i].length; j++) {
                int value = grid[i][j];
                boolean isValid = false;
                for (int k = 0; k < rhombiCoords.length; k++) {
                    int ni = i + rhombiCoords[k][0];
                    int nj = j + rhombiCoords[k][1];
                    if (ni < 0 || nj < 0 || ni > grid.length - 1 || nj > grid[i].length - 1) {
                        isValid = false;
                        break;
                    }
                    isValid = true;
                    value += grid[ni][nj];
                }
                if (isValid)
                    q.offer(value);
            }
        }
        int n = 3;
        List<Integer> top3 = new ArrayList<>();
        while (!q.isEmpty() && n > 0) {
            top3.add(q.poll());
            n--;
        }
        return top3;
    }

    public static void main(String[] args) {
        System.out.println(ThreeBiggestRhombusSums.threeBiggestRhombusSums(new int[][]{{3, 4, 5, 1, 3}, {3, 3, 4, 2, 3}, {20, 30, 200, 40, 10}, {1, 5, 5, 4, 1}, {4, 3, 2, 2, 5}}));
    }
}
