class Solution {

  // Method 1: Topological Sorting on an undirected graph
  // TC: V * BFS = V * O(V + E) = v^2 + VE, so n^2 already. Hence getting TLE.
  // public List<Integer> findMinHeightTrees(int n, int[][] edges) {
  //   List<List<Integer>> adj = new ArrayList<>();
  //   List<Integer> result = new ArrayList<>(n);

  //   for (int i = 0; i < n; i++)
  //     adj.add(new ArrayList<>());

  //   // adjacency list is ready
  //   for (int i = 0; i < edges.length; i++) {
  //     int u = edges[i][0];
  //     int v = edges[i][1];

  //     adj.get(u).add(v); // as undirected graph
  //     adj.get(v).add(u);
  //   }

  //   // a fresh visited array is created for each root node using BFS
  //   int minHeight = Integer.MAX_VALUE;
  //   for (int i = 0; i < n; i++) {
  //     int height = calculateHeight(i, n, adj);

  //     if (height < minHeight) {
  //       minHeight = height;
  //       result.clear();
  //       result.add(i);
  //     } else if (height == minHeight) {
  //       result.add(i);
  //     }
  //   }

  //   return result;
  // }

  // private int calculateHeight(int node, int n, List<List<Integer>> adj) {
  //   int level = 0;
  //   Queue<Integer> q = new LinkedList<>();
  //   boolean[] visited = new boolean[n];

  //   visited[node] = true;
  //   q.offer(node);

  //   while (!q.isEmpty()) {
  //     int size = q.size();

  //     for (int i = 0; i < size; i++) { // this loop is for traversal of levels in level order traversal
  //       int curr = q.poll(); // top element

  //       for (int neighbour : adj.get(curr)) { // iterate though all connected nodes from curr root
  //         if (!visited[neighbour]) {
  //           q.offer(neighbour);
  //           visited[neighbour] = true;
  //         }
  //       }
  //     }

  //     if (!q.isEmpty())
  //       level++;
  //   }

  //   return level;
  // }

  // Method 2: Find center of the tree || Remove leaf nodes
  // Concept:
  // Step 1: build the graph using an adjacency list and count the indegree connections
  // Step 2: nodes with indegree 1 are the LEAF NODES, so push into a queue
  // Step 3: remove leaf nodes level by level like peeling of onion
  // Step 4: when leaf removed(step 3) its neighbour's indegree decreases...neighbor becomes a leaf node hence push into a queue
  // Step 5: stop when only 1 or 2 nodes are left, these are the center of the tree
  public List<Integer> findMinHeightTrees(int n, int[][] edges) {
    List<List<Integer>> adj = new ArrayList<>();
    List<Integer> result = new ArrayList<>(n);
    int[] indegree = new int[n];

    if (n == 1) {
      result.add(0);
      return result;
    }

    for (int i = 0; i < n; i++)
      adj.add(new ArrayList<>());

    // adjacency list is ready
    for (int i = 0; i < edges.length; i++) {
      int u = edges[i][0];
      int v = edges[i][1];

      adj.get(u).add(v); // as undirected graph
      adj.get(v).add(u);

      indegree[u]++;
      indegree[v]++;
    }

    Queue<Integer> q = new LinkedList<>();
    // adding into the queue if the node is a leaf node
    for (int i = 0; i < n; i++) {
      if (indegree[i] == 1)
        q.add(i);
    }

    // as center of a tree contain either 1 or 2 nodes
    while (n > 2) {
      int size = q.size();
      n -= size;

      for (int i = 0; i < size; i++) {
        int leaf = q.poll();

        for (int neighbour : adj.get(leaf)) {
          indegree[neighbour]--;
          if (indegree[neighbour] == 1)
            q.add(neighbour);
        }
      }
    }

    result.addAll(q);
    return result;
  }
}
