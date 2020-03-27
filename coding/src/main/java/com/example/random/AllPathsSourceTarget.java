package com.example.random;

import java.util.ArrayList;
import java.util.List;

public class AllPathsSourceTarget {

    public List<List<Integer>> allPathsSourceTarget(int[][] graph) {
        return allPathsSourceTarget(graph, 0, graph.length - 1);
    }

    private List<List<Integer>> allPathsSourceTarget(int[][] graph, int source, int target) {
        List<List<Integer>> result = new ArrayList<>();
        if (source ==  target) {
            List<Integer> path = new ArrayList<>();
            path.add(source);
            result.add(path);
            return result;
        }
        for (int node : graph[source]) {
            List<List<Integer>> lists = allPathsSourceTarget(graph, node, target);
            for (List<Integer> list : lists) {
                list.add(0, source);
                result.add(list);
            }
        }
        return result;
    }

    public static void main(String[] args) {
        int[][] graph = {{1, 2}, {3}, {3}, {}};
        System.out.println(new AllPathsSourceTarget().allPathsSourceTarget(graph));
    }
}
