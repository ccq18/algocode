package algo.graph;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Queue;

/**
 * @author ldb
 * @date 2019-10-23 15:10
 */
public class Graph {
    private int v;
    private LinkedList<Integer>[] adj; // 邻接表


    public Graph(int v) {
        this.v = v;
        adj = new LinkedList[v];
        for (int i = 0; i < v; ++i) {
            adj[i] = new LinkedList<>();
        }
    }

    /**
     * 添加边
     *
     * @param s 顶点
     * @param t 顶点
     */
    public void addEdge(int s, int t) { // 无向图一条边存两次
        adj[s].add(t);
        adj[t].add(s);

    }

    public void bfs(int s, int t) {
        if (s == t) return;
        // visited是用来记录已经被访问的顶点，用来避免顶点被重复访问。
        boolean[] visited = new boolean[v];
        visited[s] = true;
        // queue是一个队列，用来存储已经被访问、但相连的顶点还没有被访问的顶点。
        Queue<Integer> queue = new LinkedList<>();
        queue.add(s);
        // prev用来记录搜索路径。
        int[] prev = new int[v];
        for (int i = 0; i < v; ++i) {
            prev[i] = -1;
        }
        while (queue.size() != 0) {
            int w = queue.poll();
            for (int i = 0; i < adj[w].size(); ++i) {
                int q = adj[w].get(i);
                if (!visited[q]) {
                    prev[q] = w;
                    if (q == t) {
                        print(prev, s, t);
                        return;
                    }
                    visited[q] = true;
                    queue.add(q);
                }
            }
        }
    }

    private void print(int[] prev, int s, int t) { // 递归打印 s->t 的路径
        if (prev[t] != -1 && t != s) {
            print(prev, s, prev[t]);
        }
        System.out.print(t + " ");
    }

    boolean found = false; // 全局变量或者类成员变量
    // 深度优先搜索
    public void dfs(int s, int t) {
        found = false;
        boolean[] visited = new boolean[v];
        int[] prev = new int[v];
        for (int i = 0; i < v; ++i) {
            prev[i] = -1;
        }
        recurDfs(s, t, visited, prev);
        print(prev, s, t);
    }

    // 利用回溯的思想来实现深度遍历
    private void recurDfs(int w, int t, boolean[] visited, int[] prev) {
        if (found == true) return;
        visited[w] = true;
        if (w == t) {
            found = true;
            return;
        }
        for (int i = 0; i < adj[w].size(); ++i) {
            int q = adj[w].get(i);
            if (!visited[q]) {
                prev[q] = w;
                recurDfs(q, t, visited, prev);
            }
        }
    }

//    private Map<Integer, Boolean> marked = new HashMap<>(); // 已扫过
//    public  List<Integer> pathTo(Integer v) {
//        int source = 0;
//        if(!this.hasPathTo(v)) {
//            return null;
//        }
//        List<Integer> paths = new ArrayList<>();
//        for (int i = v; i!= source;i = this.adj[i]) {
//            paths.add(i);
//        }
//        paths.add(source);
//        return paths;
//    }
//
//    public Boolean hasPathTo(Integer v) {
//        return this.marked[v];
//    }
}


