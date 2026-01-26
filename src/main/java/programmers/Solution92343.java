package programmers;

import java.util.*;

class Solution92343 {
    static class State {
        Set<Integer> nodes;
        int sheep;
        int wolf;

        State(Set<Integer> nodes, int sheep, int wolf) {
            this.nodes = nodes;
            this.sheep = sheep;
            this.wolf = wolf;
        }
    }

    public int solution(int[] info, int[][] edges) {
        int N = info.length;

        // 인접 리스트
        List<List<Integer>> adjList = new ArrayList<>();
        for (int i = 0; i < N; i++) {
            adjList.add(new ArrayList<>());
        }

        for (int[] edge : edges) {
            int a = edge[0];
            int b = edge[1];
            adjList.get(a).add(b);
            adjList.get(b).add(a);
        }

        // 방문한 상태 체크 (노드 집합 기준)
        Set<String> visited = new HashSet<>();

        Queue<State> q = new LinkedList<>();

        // 초기 상태
        Set<Integer> startSet = new HashSet<>();
        startSet.add(0);
        q.offer(new State(startSet, 1, 0));
        visited.add(encode(startSet));

        int ans = 0;

        while (!q.isEmpty()) {
            State cur = q.poll();
            ans = Math.max(ans, cur.sheep);

            // 다음에 갈 수 있는 후보 노드들
            Set<Integer> nextNodes = new HashSet<>();
            for (int node : cur.nodes) {
                for (int next : adjList.get(node)) {
                    if (!cur.nodes.contains(next)) {
                        nextNodes.add(next);
                    }
                }
            }

            // 후보 노드 하나씩 시도
            for (int node : nextNodes) {
                Set<Integer> nextSet = new HashSet<>(cur.nodes);
                nextSet.add(node);

                String encoded = encode(nextSet);
                if (visited.contains(encoded)) continue;

                if (info[node] == 0) { // 양
                    q.offer(new State(nextSet, cur.sheep + 1, cur.wolf));
                    visited.add(encoded);
                } else { // 늑대
                    if (cur.sheep > cur.wolf + 1) {
                        q.offer(new State(nextSet, cur.sheep, cur.wolf + 1));
                        visited.add(encoded);
                    }
                }
            }
        }

        return ans;
    }

    // Set<Integer> -> 정렬된 문자열로 변환 (visited 용)
    private String encode(Set<Integer> set) {
        List<Integer> list = new ArrayList<>(set);
        Collections.sort(list);
        return list.toString();
    }
}

