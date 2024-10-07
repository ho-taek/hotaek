package 알고리즘;

import java.io.IOException;
import java.util.*;

public class _UnionFind {
    static int[] parent;

    public static void main(String[] args) throws IOException {
        int n = 5;
        parent = new int[n + 1];
        // 부모 노드 초기화
        for (int i = 0; i < parent.length; i++)
            parent[i] = i;

        // 위의 예제 실행
        union(1, 2);
        parentPrint();
        union(3, 4);
        parentPrint();
        union(3, 5);
        parentPrint();
        System.out.println("find(2): " + find(2));
        System.out.println("find(4): " + find(4));
        union(2, 4);
        parentPrint();
        System.out.println("find(4): " + find(4));

    }

    public static void parentPrint() {
        System.out.print("[ ");
        for (int i = 1; i < parent.length; i++) {
            System.out.print(parent[i] + " ");
        }
        System.out.println("]");
    }

    public static boolean union(int x, int y) {
        x = find(x);
        y = find(y);

        if (x == y)
            return false;

        if (x <= y)
            parent[y] = x;
        else
            parent[x] = y;
        return true;

    }

    public static int find(int x) {
        if (parent[x] == x)
            return x;
        return find(parent[x]);
    }
}
