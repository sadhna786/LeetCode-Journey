class Solution {
    public int[][] buildMatrix(int k, int[][] rowConditions, int[][] colConditions) {
     int[][] matrix = new int[k][k];
        
        List<Integer>[] rowGraph = new ArrayList[k + 1];
        List<Integer>[] colGraph = new ArrayList[k + 1];
        for (int i = 1; i <= k; i++) {
            rowGraph[i] = new ArrayList<>();
            colGraph[i] = new ArrayList<>();
        }

        int[] rowIndegree = new int[k + 1];
        int[] colIndegree = new int[k + 1];

        for (int[] condition : rowConditions) {
            rowGraph[condition[0]].add(condition[1]);
            rowIndegree[condition[1]]++;
        }
        
        for (int[] condition : colConditions) {
            colGraph[condition[0]].add(condition[1]);
            colIndegree[condition[1]]++;
        }

        List<Integer> rowOrder = topologicalSort(rowGraph, rowIndegree, k);
        List<Integer> colOrder = topologicalSort(colGraph, colIndegree, k);
        
        if (rowOrder == null || colOrder == null) {
            return new int[0][0];
        }
        
        int[] rowPos = new int[k + 1];
        int[] colPos = new int[k + 1];
        
        for (int i = 0; i < k; i++) {
            rowPos[rowOrder.get(i)] = i;
            colPos[colOrder.get(i)] = i;
        }
        
        for (int i = 1; i <= k; i++) {
            matrix[rowPos[i]][colPos[i]] = i;
        }
        
        return matrix;
    }

     private List<Integer> topologicalSort(List<Integer>[] graph, int[] indegree, int k) {
        Queue<Integer> queue = new LinkedList<>();
        for (int i = 1; i <= k; i++) {
            if (indegree[i] == 0) {
                queue.add(i);
            }
        }

        List<Integer> order = new ArrayList<>();
        while (!queue.isEmpty()) {
            int current = queue.poll();
            order.add(current);

            for (int neighbor : graph[current]) {
                indegree[neighbor]--;
                if (indegree[neighbor] == 0) {
                    queue.add(neighbor);
                }
            }
        }

        if (order.size() != k) {
            return null; // Cycle detected, invalid topological order
        }

        return order;
    }

    }
