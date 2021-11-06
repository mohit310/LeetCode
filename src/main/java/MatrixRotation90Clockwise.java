import java.util.Arrays;
import java.util.stream.Collectors;

public class MatrixRotation90Clockwise {

    public int[][] rotate90clockwise(int[][] m) {
        int N = m.length;
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < i; j++) {
                int temp = m[i][j];
                m[i][j] = m[j][i];
                m[j][i] = temp;
            }
        }
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < N / 2; j++) {
                int temp = m[i][j];
                m[i][j] = m[i][N - 1 - j];
                m[i][N - 1 - j] = temp;
            }
        }
        return m;
    }

    public static void main(String[] args) {
        MatrixRotation90Clockwise mrotate = new MatrixRotation90Clockwise();
        int[][] r = mrotate.rotate90clockwise(new int[][]{{1, 2, 3}, {4, 5, 6}, {7, 8, 9}});
        System.out.println(Arrays.stream(r).map(i -> Arrays.stream(i).mapToObj(String::valueOf).collect(Collectors.joining(",")))
                .collect(Collectors.joining("\n")));
    }
}
