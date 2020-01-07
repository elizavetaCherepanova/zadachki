package com.my.solutions.islands;

//import org.junit.jupiter.api.Test;
//
//import static org.junit.jupiter.api.Assertions.*;
//
//class SolutionTest {

//    @Test
//    public void testIslands() {
//        int[][] board = new int[][]{
//                {0, 1, 1, 0, 0, 1, 1},
//                {0, 1, 0, 0, 0, 0, 0},
//                {0, 0, 0, 0, 1, 0, 0},
//                {0, 0, 0, 0, 0, 0, 0}
//        };
//        assertSame(Solution.calculateIslandsCount(board), 3);
//
//        int[][] board1 = new int[][]{
//                {0, 1, 1, 0, 0, 1, 1},
//                {0, 1, 0, 0, 0, 1, 0},
//                {0, 0, 0, 0, 1, 0, 0},
//                {0, 0, 0, 0, 0, 0, 0}
//        };
//        assertSame(Solution.calculateIslandsCount(board1), 2);
//    }
//    @Test
//    public void testIslands1() {
//        int[][] board = new int[][]{
//                {0, 0, 1, 0, 1, 0, 1},
//                {0, 0, 1, 0, 0, 0, 1},
//                {0, 1, 1, 0, 0, 1, 1},
//                {0, 0, 0, 0, 0, 0, 0}
//        };
//        assertSame(Solution.calculateIslandsCount(board), 2);
//    }
//}

package com.my.solutions.islands;

import java.util.HashSet;
import java.util.Set;

public class Solution {
    static int[][] board;
    static Set<String> islands;
    static int len;
    static int width;
    static boolean[][] visited;

    public static int calculateIslandsCount(int[][] board) {
        if (board == null) return 0;
        if (board.length == 0) return 0;
        Solution.board = board;
        islands = new HashSet<>();
        len = board.length;
        width = board[0].length;
        visited = new boolean[len][width];
        for (int i = 0; i < len; i++) {
            for (int j = 0; j < width; j++) {
                if (board[i][j] == 1 && !visited[i][j]) {
                    islands.add(dfs(i, j, 0, 0));
                }
            }
        }
        return islands.size();
    }

    private static String dfs(int x, int y, int ax, int ay) {
        if (x < 0 || y < 0 || x >= len || y >= width) return "";
        if (visited[x][y] || board[x][y] == 0) return "";
        visited[x][y] = true;
        StringBuilder island = new StringBuilder().append(dfs(x - 1, y, ax++, ay++));
        island.append(dfs(x, y + 1, ax++, ay++));
        island.append(dfs(x + 1, y, ax++, ay++));
        island.append(dfs(x, y - 1, ax++, ay++));
        island.append(ax + ":" + ay + ",");
        return island.toString();
    }
}
