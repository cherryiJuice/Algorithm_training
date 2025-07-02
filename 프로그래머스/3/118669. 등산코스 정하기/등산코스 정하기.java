import java.util.*;

class Edge implements Comparable<Edge>{
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
    Map<Integer, List<Edge>> graph = new HashMap<>();
    
    public int[] solution(int n, int[][] paths, int[] gates, int[] summits) {
        Arrays.sort(gates); Arrays.sort(summits);
        
        for(int i=1; i<=n; i++) {
            graph.put(i, new ArrayList<>());
        }
        
        for(int[] path : paths) {
            graph.get(path[0]).add(new Edge(path[1], path[2]));
            graph.get(path[1]).add(new Edge(path[0], path[2]));
        }
        
        int min = Integer.MAX_VALUE;
        int summit = summits[0];
        
        int[] starts = dijkstra(n, summits, gates);
        for(int j=0; j<summits.length; j++) {
            int end = summits[j];
            if(min > starts[end]) {
                min = starts[end];
                summit = end;
            }
        }
        
        
        return new int[] {summit, min};
    }
    
    private int[] dijkstra(int n, int[] summits, int[] gates) {
        int[] intensity = new int[n+1];
        Arrays.fill(intensity, Integer.MAX_VALUE);
        
        Queue<Edge> pq = new PriorityQueue<>();
        for (int gate : gates) {
            pq.add(new Edge(gate, 0));
            intensity[gate] = 0;
        }
        
        while(!pq.isEmpty()) {
            Edge cur = pq.remove();
            
            if(isSummit(cur.node, summits)) continue;
            
            if(cur.cost > intensity[cur.node]) continue;
            
            for(Edge next : graph.get(cur.node)) {
                int nextCost = Math.max(next.cost, intensity[cur.node]);
                if(nextCost < intensity[next.node]) {
                    pq.add(new Edge(next.node, nextCost));
                    intensity[next.node] = nextCost;
                }
            }
        }
        
        return intensity;
    }
    
    private boolean isSummit(int node, int[] summits) {
        for(int i=0; i<summits.length; i++) {
            if(summits[i] == node) return true;
        }
        // for(int i=0; i<gates.length; i++) {
        //     if(start != node && gates[i] == node) return true;
        // }
        return false;
    }
}