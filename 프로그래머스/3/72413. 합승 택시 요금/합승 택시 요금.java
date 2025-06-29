import java.util.*;

class Edge implements Comparable<Edge> {
    int node; int cost;
    Edge(int node, int cost) {
        this.node = node;
        this.cost = cost;
    }
    public int compareTo(Edge other) {
        return this.cost - other.cost;
    }
}

class Solution {
    public int solution(int n, int s, int a, int b, int[][] fares) {
        Map<Integer, List<Edge>> graph = new HashMap<>();
        for(int i=1; i<=n; i++) {
            graph.put(i, new ArrayList<>());
        }
        for(int[] fare : fares) {
            graph.get(fare[0]).add(new Edge(fare[1], fare[2]));
            graph.get(fare[1]).add(new Edge(fare[0], fare[2]));
        }
        
        int[] costsS = dijkstra(n, s, graph);
        int[] costsA = dijkstra(n, a, graph);
        int[] costsB = dijkstra(n, b, graph);
        
        int answer = Integer.MAX_VALUE;
        for(int x=1; x<=n; x++) {
            int fare = costsS[x] + costsA[x] + costsB[x];
            answer = Math.min(answer, fare);
        }
        return answer;
    }
    
    private int[] dijkstra(int n, int start, Map<Integer, List<Edge>> graph) {
        int[] costs = new int[n+1];
        Arrays.fill(costs, Integer.MAX_VALUE);
        
        Queue<Edge> pq = new PriorityQueue<>();
        pq.add(new Edge(start, 0));
        costs[start] = 0;
        
        while(!pq.isEmpty()) {
            Edge cur = pq.remove();
            if(cur.cost > costs[cur.node]) continue;
            
            for(Edge next : graph.get(cur.node)) {
                int nextCost = next.cost + costs[cur.node];
                if(nextCost < costs[next.node]) {
                    pq.add(new Edge(next.node, nextCost));
                    costs[next.node] = nextCost;
                }
            }
        }
        
        return costs;
    }
}