/**
 * There are n cities. Some of them are connected, while some are not. If city a is connected directly with city b, and city b is connected directly with city c, then city a is connected indirectly with city c.
 * <p>
 * A province is a group of directly or indirectly connected cities and no other cities outside of the group.
 * <p>
 * You are given an n x n matrix isConnected where isConnected[i][j] = 1 if the ith city and the jth city are directly connected, and isConnected[i][j] = 0 otherwise.
 * <p>
 * Return the total number of provinces.
 * <p>
 * <p>
 * <p>
 * Example 1:
 * <p>
 * Input: isConnected = [[1,1,0],[1,1,0],[0,0,1]]
 * Output: 2
 * <p>
 * Example 2:
 * <p>
 * Input: isConnected = [[1,0,0],[0,1,0],[0,0,1]]
 * Output: 3
 * <p>
 * <p>
 * <p>
 * Constraints:
 * <p>
 * 1 <= n <= 200
 * n == isConnected.length
 * n == isConnected[i].length
 * isConnected[i][j] is 1 or 0.
 * isConnected[i][i] == 1
 * isConnected[i][j] == isConnected[j][i]
 */
public class Provinces {

    class UnionFind {
        private int count;
        private int[] id;

        public UnionFind(int N) {
            count = N;
            id = new int[N];
            for (int i = 0; i < N; i++) id[i] = i;
        }

        public int count() {
            return count;
        }

        public int find(int p) {
            while (p != id[p]) p = id[p];
            return p;
        }

        public boolean connected(int p, int q) {
            return find(p) == find(q);
        }

        public void union(int p, int q) {
            int i = find(p);
            int j = find(q);

            if (i == j) return;

            id[i] = j;
            count--;
        }
    }

    public int findCircleNum(int[][] connMatrix) {
        UnionFind f = new UnionFind(connMatrix.length);
        for (int i = 0; i < connMatrix.length; i++) {
            for (int j = 0; j < connMatrix[i].length; j++) {
                if (i == j) continue;
                if (connMatrix[i][j] == 1) f.union(i, j);
            }
        }
        return f.count();
    }

    public static void main(String[] args) {
        int[][] provinces = new int[][]{{1, 1, 0}, {1, 1, 0}, {0, 0, 1}};
        Provinces p = new Provinces();
        System.out.println(p.findCircleNum(provinces));
        provinces = new int[][]{{1, 0, 0}, {0, 1, 0}, {0, 0, 1}};
        System.out.println(p.findCircleNum(provinces));
        provinces = new int[][]{{1, 0, 0, 1}, {0, 1, 1, 0}, {0, 1, 1, 1}, {1, 0, 1, 1}};
        System.out.println(p.findCircleNum(provinces));
    }
}

