public class Graphs {
    // Number of provinces
    class Solution {
        public int findCircleNum(int[][] isConnected) {
            ArrayList<ArrayList<Integer>> adj = new ArrayList<>();
            int m = isConnected.length;
            for (int i = 0; i < m; i++) {
                adj.add(new ArrayList<>());
            }
            for (int i = 0; i < m; i++) {
                for (int j = 0; j < m; j++) {
                    if (i == j) {
                        continue;
                    }
                    if (isConnected[i][j] == 1) {
                        adj.get(i).add(j);
                    }
                }
            }
            boolean visited[] = new boolean[m];
            for (int i = 0; i < m; i++) {
                visited[i] = false;
            }
            int cnt = 0;
            for (int i = 0; i < m; i++) {
                if (visited[i] == false) {
                    dfs(i, adj, visited);
                    cnt++;
                }
            }
            return cnt;
        }

        public void dfs(int i, ArrayList<ArrayList<Integer>> adjLs, boolean[] visited) {
            visited[i] = true;
            for (Integer it : adjLs.get(i)) {
                if (visited[it] == false) {
                    dfs(it, adjLs, visited);
                }
            }
        }
    }

    // Connected Components Problem in Matrix Based Graph
    class Solution {
        static int numProvinces(ArrayList<ArrayList<Integer>> adj, int V) {
            // code here
            ArrayList<ArrayList<Integer>> adjLs = new ArrayList<>();
            ArrayList<Integer> dfs = new ArrayList<>();
            boolean vis[] = new boolean[V];
            for (int i = 0; i < V; i++) {
                adjLs.add(new ArrayList<Integer>());
            }
            for (int i = 0; i < adj.size(); i++) {
                for (int j = 0; j < adj.get(i).size(); j++) {
                    if (i != j && adj.get(i).get(j) == 1) {
                        adjLs.get(i).add(j);
                    }
                }
            }
            int countOfProvinces = 0;
            for (int i = 0; i < V; i++) {
                if (vis[i] == false) {
                    dfs(i, vis, adjLs, dfs);
                    countOfProvinces++;
                }
            }
            return countOfProvinces;
        }

        public static void dfs(int src, boolean vis[], ArrayList<ArrayList<Integer>> adj, ArrayList<Integer> dfs) {
            vis[src] = true;
            dfs.add(src);
            for (Integer it : adj.get(src)) {
                if (vis[it] == false) {
                    dfs(it, vis, adj, dfs);
                }
            }
        }
    };

    // Rotten Oranges
    class Solution {
        class Pair {
            int row, col, time;

            Pair(int x, int y, int t) {
                row = x;
                col = y;
                time = t;
            }
        }

        public int orangesRotting(int[][] grid) {
            // Code here
            int dx[] = new int[] { 0, 1, 0, -1 };
            int dy[] = new int[] { -1, 0, 1, 0 };
            int n = grid.length;
            int m = grid[0].length;
            boolean vis[][] = new boolean[n][m];
            Queue<Pair> q = new LinkedList<>();
            int freshOranges = 0;
            for (int i = 0; i < n; i++) {
                for (int j = 0; j < m; j++) {
                    if (grid[i][j] == 2) {
                        vis[i][j] = true;
                        q.add(new Pair(i, j, 0));
                    } else if (grid[i][j] == 1) {
                        freshOranges++;
                    }
                }
            }
            int globalTime = 0;
            while (!q.isEmpty()) {
                Pair it = q.poll();
                int node_x = it.row;
                int node_y = it.col;
                int t = it.time;
                globalTime = Math.max(t, globalTime);
                for (int i = 0; i < 4; i++) {
                    int nr = node_x + dx[i];
                    int nc = node_y + dy[i];
                    if (nr >= 0 && nr < n && nc >= 0 && nc < m && grid[nr][nc] == 1 && vis[nr][nc] == false) {
                        vis[nr][nc] = true;
                        grid[nr][nc] = 2;
                        q.add(new Pair(nr, nc, t + 1));
                        freshOranges--;
                    }
                }
            }
            return freshOranges == 0 ? globalTime : -1;
        }
    }

    // Flood fill
    class Solution {
        class Pair {
            int row, col;

            Pair(int x, int y) {
                row = x;
                col = y;
            }
        }

        public int[][] floodFill(int[][] grid, int sr, int sc, int newColor) {
            // Code here
            int dx[] = new int[] { 0, 1, 0, -1 };
            int dy[] = new int[] { -1, 0, 1, 0 };
            int n = grid.length;
            int m = grid[0].length;
            boolean vis[][] = new boolean[n][m];
            int iniColor = grid[sr][sc];
            int newimage[][] = grid;
            bfs(sr, sc, newColor, iniColor, vis, grid, newimage, n, m, dx, dy);
            return newimage;
        }

        public void bfs(int row, int col, int newColor, int iniColor, boolean vis[][], int grid[][],
                int newimage[][], int n, int m, int dx[], int dy[]) {
            Queue<Pair> q = new LinkedList<>();
            q.add(new Pair(row, col));
            newimage[row][col] = newColor;
            vis[row][col] = true;
            while (!q.isEmpty()) {
                Pair it = q.poll();
                int node_x = it.row;
                int node_y = it.col;
                for (int i = 0; i < 4; i++) {
                    int nr = node_x + dx[i];
                    int nc = node_y + dy[i];
                    if (nr >= 0 && nr < n && nc >= 0 && nc < m && grid[nr][nc] == iniColor && vis[nr][nc] == false) {
                        vis[nr][nc] = true;
                        newimage[nr][nc] = newColor;
                        q.add(new Pair(nr, nc));
                    }
                }
            }
        }
    }

    // Cycle Detection in unirected Graph BFS
    class Solution {
        public boolean checkforCycle(int src, int V, boolean vis[], ArrayList<ArrayList<Integer>> adj,
                boolean vis[]) {
            vis[src] = true;
            Queue<Pair> q = new LinkedList<>();
            q.add(new Pair(src, -1));
            while (!q.isEmpty()) {
                int node = q.peek().first;
                int parent = q.peek().second;
                q.remove();
                for (Integer adjacentNode : adj.get(node)) {
                    if (vis[adjacentNode] == false) {
                        vis[adjacentNode] = true;
                        q.add(new Pair(adjacentNode, node));
                    } else if (parent != adjacentNode) {
                        return true;
                    }
                }
            }
            return false;
        }

        public boolean isCyclic(int V, ArrayList<ArrayList<Integer>> adj) {
            boolean vis[] = new boolean[V];
            for (int i = 0; i < V; i++) {
                vis[i] = false;
            }
            for (int i = 0; i < V; i++) {
                if (vis[i] == false) {
                    if (checkCycle(i, V, adj, vis) == true)
                        return true;
                }
            }
            return false;
        }
    }

    // Cycle Detection in undirected Graph DFS
    class Solution {
        // Function to detect cycle in an undirected graph.
        public boolean isCycle(int V, ArrayList<ArrayList<Integer>> adj) {
            // Code here
            boolean vis[] = new boolean[V];
            for (int i = 0; i < V; i++) {
                vis[i] = false;
            }
            for (int i = 0; i < V; i++) {
                if (vis[i] == false) {
                    if (dfs(i, -1, vis, adj) == true) {
                        return true;

                    }
                }
            }
            return false;
        }

        public boolean dfs(int node, int parent, boolean vis[], ArrayList<ArrayList<Integer>> adj) {
            vis[node] = true;
            for (Integer adjacentNode : adj.get(node)) {
                if (vis[adjacentNode] == false) {
                    if (dfs(adjacentNode, node, vis, adj) == true) {

                        return true;
                    }
                } else if (adjacentNode != parent) {

                    return true;
                }
            }
            return false;
        }
    }

    // 0/1 Matrix (BFS Problem)
    class Solution {
        // Function to find distance of nearest 1 in the grid for each cell.
        class Pair {
            int row, col, dist;

            Pair(int r, int c, int d) {
                row = r;
                col = c;
                dist = d;
            }

        }

        public int[][] nearest(int[][] grid) {
            // Code here
            int n = grid.length;
            int m = grid[0].length;
            int dis[][] = new int[n][m];
            boolean vis[][] = new boolean[n][m];
            Queue<Pair> q = new LinkedList<>();
            for (int i = 0; i < n; i++) {
                for (int j = 0; j < m; j++) {
                    if (grid[i][j] == 1) {
                        q.add(new Pair(i, j, 0));
                        vis[i][j] = true;
                        dis[i][j] = 0;
                    }
                }
            }
            int dx[] = new int[] { 0, 1, 0, -1 };
            int dy[] = new int[] { -1, 0, 1, 0 };
            while (!q.isEmpty()) {
                Pair it = q.poll();
                int node_x = it.row;
                int node_y = it.col;
                int di = it.dist;
                for (int i = 0; i < 4; i++) {
                    int nr = node_x + dx[i];
                    int nc = node_y + dy[i];
                    if (nr >= 0 && nr < n && nc >= 0 && nc < m && grid[nr][nc] == 0 && vis[nr][nc] == false) {
                        vis[nr][nc] = true;
                        dis[nr][nc] = di + 1;
                        q.add(new Pair(nr, nc, di + 1));
                    }
                }
            }
            return dis;
        }
    }

    // Surrounded Regions (DFS)
    class Solution {
        static char[][] fill(int n, int m, char a[][]) {
            // code here
            // int n=a.length;
            // int m=a[0].length;
            boolean vis[][] = new boolean[n][m];
            char grid[][] = new char[n][m];
            // for(char r[]: grid){Arrays.fill(r,'X');}
            grid = a;
            int dx[] = new int[] { 0, 1, 0, -1 };
            int dy[] = new int[] { -1, 0, 1, 0 };
            for (int i = 0; i < m; i++) {
                if (vis[0][i] == false && a[0][i] == 'O') {
                    dfs(0, i, n, m, dx, dy, vis, a, grid);
                }
            }
            for (int i = 0; i < m; i++) {
                if (vis[n - 1][i] == false && a[n - 1][i] == 'O') {
                    dfs(n - 1, i, n, m, dx, dy, vis, a, grid);
                }
            }
            for (int i = 0; i < n; i++) {
                if (vis[i][0] == false && a[i][0] == 'O') {
                    dfs(i, 0, n, m, dx, dy, vis, a, grid);
                }
            }
            for (int i = 0; i < n; i++) {
                if (vis[i][m - 1] == false && a[i][m - 1] == 'O') {
                    dfs(i, m - 1, n, m, dx, dy, vis, a, grid);
                }
            }
            for (int i = 0; i < n; i++) {
                for (int j = 0; j < m; j++) {
                    if (vis[i][j] == false && a[i][j] == 'O') {
                        grid[i][j] = 'X';
                    }
                }
            }
            return grid;
        }

        static void dfs(int row, int col, int n, int m, int[] dx, int[] dy, boolean[][] vis, char a[][],
                char grid[][]) {
            vis[row][col] = true;
            grid[row][col] = 'O';
            for (int i = 0; i < 4; i++) {
                int nr = row + dx[i];
                int nc = col + dy[i];
                if (nr >= 0 && nr < n && nc >= 0 && nc < m && a[nr][nc] == 'O' && vis[nr][nc] == false) {
                    vis[nr][nc] = true;
                    dfs(nr, nc, n, m, dx, dy, vis, a, grid);
                }
            }
        }
    }

    // Number of Enclaves [flood fill implementation]
    class Solution {

        int numberOfEnclaves(int[][] a) {

            // Your code here
            int n = a.length;
            int m = a[0].length;
            boolean vis[][] = new boolean[n][m];
            char grid[][] = new char[n][m];
            int dx[] = new int[] { 0, 1, 0, -1 };
            int dy[] = new int[] { -1, 0, 1, 0 };
            for (int i = 0; i < m; i++) {
                if (vis[0][i] == false && a[0][i] == 1) {
                    dfs(0, i, n, m, dx, dy, vis, a, grid);
                }
            }
            for (int i = 0; i < m; i++) {
                if (vis[n - 1][i] == false && a[n - 1][i] == 1) {
                    dfs(n - 1, i, n, m, dx, dy, vis, a, grid);
                }
            }
            for (int i = 0; i < n; i++) {
                if (vis[i][0] == false && a[i][0] == 1) {
                    dfs(i, 0, n, m, dx, dy, vis, a, grid);
                }
            }
            for (int i = 0; i < n; i++) {
                if (vis[i][m - 1] == false && a[i][m - 1] == 1) {
                    dfs(i, m - 1, n, m, dx, dy, vis, a, grid);
                }
            }
            int c = 0;
            for (int i = 0; i < n; i++) {
                for (int j = 0; j < m; j++) {
                    if (vis[i][j] == false && a[i][j] == 1) {
                        c++;
                    }
                }
            }
            return c;
        }

        static void dfs(int row, int col, int n, int m, int[] dx, int[] dy, boolean[][] vis, int a[][], char grid[][]) {
            vis[row][col] = true;
            for (int i = 0; i < 4; i++) {
                int nr = row + dx[i];
                int nc = col + dy[i];
                if (nr >= 0 && nr < n && nc >= 0 && nc < m && a[nr][nc] == 1 && vis[nr][nc] == false) {
                    vis[nr][nc] = true;
                    dfs(nr, nc, n, m, dx, dy, vis, a, grid);
                }
            }
        }
    }

    // Word ladder - 1
    class Solution {
        class Pair {
            String word;
            int steps;

            Pair(String _word, int _steps) {
                this.word = _word;
                this.steps = _steps;
            }
        }

        public int wordLadderLength(String startWord, String targetWord, String[] wordList) {
            // Code here
            Queue<Pair> q = new LinkedList<>();
            q.add(new Pair(startWord, 1));
            Set<String> st = new HashSet<>();
            int n = wordList.length;
            for (int i = 0; i < n; i++) {
                st.add(wordList[i]);
            }
            while (!q.isEmpty()) {
                Pair temp = q.remove();
                String curr = temp.word;
                int s = temp.steps;

                if (curr.equals(targetWord) == true) {
                    return s;
                }
                for (int i = 0; i < curr.length(); i++) {
                    for (char ch = 'a'; ch <= 'z'; ch++) {
                        char replaced[] = curr.toCharArray();
                        replaced[i] = ch;
                        String replace = new String(replaced);

                        if (st.contains(replace) == true) {
                            q.add(new Pair(replace, s + 1));
                            st.remove(replace);
                        }
                    }
                }
            }
            return 0;
        }
    }

    // Word ladder - 2
    class Solution {
        public ArrayList<ArrayList<String>> findSequences(String startWord, String targetWord, String[] wordList) {
            // Code here
            Set<String> st = new HashSet<String>();
            int n = wordList.length;
            for (int i = 0; i < n; i++) {
                st.add(wordList[i]);
            }
            Queue<ArrayList<String>> q = new LinkedList<>();
            ArrayList<String> ls = new ArrayList<>();
            ls.add(startWord);
            q.add(ls);

            ArrayList<String> usedOnLevel = new ArrayList<>();
            ArrayList<ArrayList<String>> ans = new ArrayList<>();
            usedOnLevel.add(startWord);
            int level = 0;

            while (!q.isEmpty()) {
                ArrayList<String> vec = q.peek();
                q.remove();
                if (vec.size() > level) {
                    level++;
                    for (String it : usedOnLevel) {
                        st.remove(it);
                    }
                }
                String word = vec.get(vec.size() - 1);
                if (word.equals(targetWord) == true) {
                    if (ans.size() == 0) {
                        ans.add(vec);
                    } else if (ans.get(0).size() == vec.size()) {
                        ans.add(vec);
                    }
                }

                for (int i = 0; i < word.length(); i++) {
                    for (char ch = 'a'; ch <= 'z'; ch++) {
                        char replacedArray[] = word.toCharArray();
                        replacedArray[i] = ch;
                        String replacedWord = new String(replacedArray);

                        if (st.contains(replacedWord) == true) {
                            vec.add(replacedWord);
                            ArrayList<String> temp = new ArrayList<>(vec);
                            q.add(temp);
                            usedOnLevel.add(replacedWord);
                            vec.remove(vec.size() - 1);

                        }
                    }
                }
            }
            return ans;
        }
    }
    // Number of Distinct Islands [dfs multisource]
    class Solution {
        int countDistinctIslands(int[][] grid) {
            int n = grid.length;
            int m = grid[0].length;
            int dx[] = new int[] { 0, 1, 0, -1 };
            int dy[] = new int[] { -1, 0, 1, 0 };
            char ds[] = new char[] { 'T', 'R', 'D', 'L' };
            boolean vis[][] = new boolean[n][m];
            HashSet<ArrayList<String>> hs = new HashSet<>();

            for (int i = 0; i < n; i++) {
                for (int j = 0; j < m; j++) {
                    if (vis[i][j] == false && grid[i][j] == 1) {
                        StringBuilder str = new StringBuilder();
                        ArrayList<String> res = new ArrayList<>();
                        dfs(i, j, str, grid, vis, dx, dy, ds, n, m, i, j, res);
                        hs.add(res);
                    }
                }
            }
            return hs.size();
        }

        public String toString(int r, int c) {
            return Integer.toString(r) + " " + Integer.toString(c);
        }

        void dfs(int row, int col, StringBuilder str, int grid[][], boolean[][] vis,
                int dx[], int dy[], char ds[], int n, int m, int sr, int sc, ArrayList<String> res) {
            vis[row][col] = true;
            res.add(toString(row - sr, col - sc));
            for (int i = 0; i < 4; i++) {
                int nr = row + dx[i];
                int nc = col + dy[i];
                if (nr >= 0 && nr < n && nc >= 0 && nc < m && grid[nr][nc] == 1 && vis[nr][nc] == false) {
                    dfs(nr, nc, str, grid, vis, dx, dy, ds, n, m, sr, sc, res);
                }
            }
        }
    }
    // Bipartite Graph (DFS)
    class Solution {
        public boolean check(int start, int c, ArrayList<ArrayList<Integer>> adj, int[] color) {
            color[start] = c;
            for (Integer it : adj.get(start)) {
                if (color[it] == -1) {
                    if (check(it, 1 - c, adj, color) == false) {
                        return false;
                    }
                } else if (color[it] == color[start]) {
                    return false;
                }
            }
            return true;
        }

        public boolean isBipartite(int V, ArrayList<ArrayList<Integer>> adj) {
            // Code here
            int color[] = new int[V];
            for (int i = 0; i < V; i++) {
                color[i] = -1;
            }
            for (int i = 0; i < V; i++) {
                if (color[i] == -1) {
                    if (check(i, 0, adj, color) == false) {
                        return false;
                    }
                }
            }
            return true;
        }
    }

    // Bipartite Graph (BFS)
    class Solution {
        public boolean isBipartite(int V, ArrayList<ArrayList<Integer>> adj) {
            // Code here
            int color[] = new int[V];
            Arrays.fill(color, -1);
            for (int i = 0; i < V; i++) {
                if (color[i] == -1) {
                    if (bfs(i, 0, adj, color) == false) {
                        return false;
                    }
                }
            }
            return true;

        }

        public boolean bfs(int src, int c, ArrayList<ArrayList<Integer>> adj, int color[]) {
            Queue<Integer> q = new LinkedList<>();
            q.add(src);
            color[src] = c;
            while (!q.isEmpty()) {
                Integer it = q.poll();
                for (Integer ju : adj.get(it)) {
                    if (color[ju] == -1) {
                        color[ju] = 1 - color[it];
                        q.add(ju);
                    } else if (color[ju] == color[it]) {
                        return false;
                    }
                }
            }
            return true;
        }
    }
    // Cycle Detection in Directed Graph BFS

    // Topo Sort
    class Solution {
        // Function to return list containing vertices in Topological order.
        static int[] topoSort(int V, ArrayList<ArrayList<Integer>> adj) {
            // add your code here
            ArrayList<Integer> dfs = new ArrayList<>();
            boolean vis[] = new boolean[V];
            Stack<Integer> st = new Stack<>();
            for (int i = 0; i < V; i++) {
                vis[i] = false;
            }
            for (int i = 0; i < V; i++) {
                if (vis[i] == false) {
                    dfs(i, vis, adj, dfs, st);
                }
            }
            int topo[] = new int[V];
            for (int i = 0; i < V; i++) {
                topo[i] = st.pop();
            }
            return topo;
        }

        public static void dfs(int src, boolean vis[], ArrayList<ArrayList<Integer>> adj, ArrayList<Integer> dfs,
                Stack<Integer> st) {
            vis[src] = true;
            dfs.add(src);
            for (Integer it : adj.get(src)) {
                if (vis[it] == false) {
                    dfs(it, vis, adj, dfs, st);
                }
            }
            st.push(src);
        }
    }

    // Kahn's Algorithm
    class Solution {
        // Function to return list containing vertices in Topological order.
        static int[] topoSort(int V, ArrayList<ArrayList<Integer>> adj) {
            // add your code here
            boolean vis[] = new boolean[V];
            int indegree[] = new int[V];
            for (int i = 0; i < V; i++) {
                vis[i] = false;
            }
            for (int i = 0; i < V; i++) {
                for (Integer it : adj.get(i)) {
                    indegree[it]++;
                }
            }
            Queue<Integer> q = new LinkedList<>();
            for (int i = 0; i < V; i++) {
                if (indegree[i] == 0) {
                    q.add(i);
                }
            }
            int cnt = 0;
            int topo[] = new int[V];
            while (!q.isEmpty()) {
                Integer node = q.remove();
                topo[cnt++] = node;

                for (Integer it : adj.get(node)) {
                    indegree[it]--;
                    if (indegree[it] == 0) {
                        q.add(it);
                    }
                }
            }
            return topo;
        }
    }

    // Cycle Detection in Directed Graph DFS
    class Solution {
        private boolean dfsCheck(int node, ArrayList<ArrayList<Integer>> adj, boolean vis[], boolean pathVis[]) {
            vis[node] = true;
            pathVis[node] = true;
            for (Integer it : adj.get(node)) {
                if (vis[it] == false) {
                    if (dfsCheck(it, adj, vis, pathVis) == true)
                        return true;
                } else if (pathVis[it] == true) {
                    return true;
                }
            }
            pathVis[node] = false;
            return false;
        }

        public boolean isCyclic(int V, ArrayList<ArrayList<Integer>> adj) {
            boolean vis[] = new boolean[V];
            boolean pathVis[] = new boolean[V];

            for (int i = 0; i < V; i++) {
                if (vis[i] == false) {
                    if (dfsCheck(i, adj, vis, pathVis) == true)
                        return true;
                }
            }
            return false;
        }
    }

    // Cycle Detection in Directed Graph BFS
    class Solution {
        public boolean isCyclic(int N, ArrayList<ArrayList<Integer>> adj) {
            // int topo[] = new int[N];
            int indegree[] = new int[N];
            for (int i = 0; i < N; i++) {
                for (Integer it : adj.get(i)) {
                    indegree[it]++;
                }
            }

            Queue<Integer> q = new LinkedList<Integer>();
            for (int i = 0; i < N; i++) {
                if (indegree[i] == 0) {
                    q.add(i);
                }
            }
            int cnt = 0;
            while (!q.isEmpty()) {
                Integer node = q.poll();
                cnt++;
                for (Integer it : adj.get(node)) {
                    indegree[it]--;
                    if (indegree[it] == 0) {
                        q.add(it);
                    }
                }
            }
            if (cnt == N)
                return false;
            return true;
        }
    }

    // Course Schedule - I
    class Solution {
        public boolean canFinish(int numCourses, int[][] prerequisites) {
            if (prerequisites == null) {
                throw new IllegalArgumentException("illegal prerequisites array");
            }
            int len = prerequisites.length;
            if (numCourses == 0 || len == 0) {
                return true;
            }
            int[] indegree = new int[numCourses];
            for (int i = 0; i < len; i++) {
                indegree[prerequisites[i][0]]++;
            }
            Queue<Integer> queue = new LinkedList<Integer>();
            for (int i = 0; i < numCourses; i++) {
                if (indegree[i] == 0) {
                    queue.add(i);
                }
            }
            int numNoPre = queue.size();
            while (!queue.isEmpty()) {
                int top = queue.remove();
                for (int i = 0; i < len; i++) {
                    if (prerequisites[i][1] == top) {
                        indegree[prerequisites[i][0]]--;
                        if (indegree[prerequisites[i][0]] == 0) {
                            numNoPre++;
                            queue.add(prerequisites[i][0]);
                        }
                    }
                }
            }

            return numNoPre == numCourses;
        }
    }

    // Course Schedule - II
    class Solution {
        public int[] findOrder(int numCourses, int[][] prerequisites) {
            ArrayList<ArrayList<Integer>> adj = new ArrayList<>();
            for (int i = 0; i < numCourses; i++) {
                adj.add(new ArrayList<>());
            }
            int m = prerequisites.length;
            for (int i = 0; i < m; i++) {
                adj.get(prerequisites[i][1]).add(prerequisites[i][0]);
            }
            int indegree[] = new int[numCourses];
            int topo[] = new int[numCourses];
            int idx = 0;
            for (int i = 0; i < numCourses; i++) {
                for (Integer it : adj.get(i)) {
                    indegree[it]++;
                }
            }
            Queue<Integer> q = new LinkedList<>();
            for (int i = 0; i < numCourses; i++) {
                if (indegree[i] == 0) {
                    q.add(i);
                }
            }
            while (!q.isEmpty()) {
                Integer src = q.remove();
                topo[idx++] = src;
                for (Integer it : adj.get(src)) {
                    indegree[it]--;
                    if (indegree[it] == 0) {
                        q.add(it);
                    }
                }
            }
            if (idx == numCourses)
                return topo;
            else
                return new int[] {};

        }
    }

    // Find eventual safe states
    class Solution {

        List<Integer> eventualSafeNodes(int V, List<List<Integer>> adj) {

            // Your code here
            ArrayList<ArrayList<Integer>> adjRev = new ArrayList<>();
            for (int i = 0; i < V; i++) {
                adjRev.add(new ArrayList<>());
            }
            int indegree[] = new int[V];
            for (int i = 0; i < V; i++) {
                for (Integer it : adj.get(i)) {
                    adjRev.get(it).add(i);
                    indegree[i]++;
                }
            }
            Queue<Integer> q = new LinkedList<>();
            List<Integer> safeNodes = new ArrayList<>();
            for (int i = 0; i < V; i++) {
                if (indegree[i] == 0) {
                    q.add(i);
                }
            }

            while (!q.isEmpty()) {
                int node = q.peek();
                q.remove();
                safeNodes.add(node);
                for (Integer it : adjRev.get(node)) {
                    indegree[it]--;
                    if (indegree[it] == 0) {
                        q.add(it);
                    }
                }
            }

            Collections.sort(safeNodes);
            return safeNodes;
        }
    }

    // Alien dictionary
    class Solution {
        public List<Integer> topoSort(int V, List<List<Integer>> adj) {
            int indegree[] = new int[V];
            for (int i = 0; i < V; i++) {
                for (Integer it : adj.get(i)) {
                    indegree[it]++;
                }
            }
            Queue<Integer> q = new LinkedList<>();
            for (int i = 0; i < V; i++) {
                if (indegree[i] == 0) {
                    q.add(i);
                }
            }
            List<Integer> topo = new ArrayList<>();
            while (!q.isEmpty()) {
                int node = q.peek();
                q.remove();
                topo.add(node);
                for (Integer it : adj.get(node)) {
                    indegree[it]--;
                    if (indegree[it] == 0) {
                        q.add(it);
                    }
                }
            }
            return topo;
        }

        public String findOrder(String[] dict, int N, int K) {
            // Write your code here
            List<List<Integer>> adj = new ArrayList<>();
            for (int i = 0; i < K; i++) {
                adj.add(new ArrayList<>());
            }

            for (int i = 0; i < N - 1; i++) {
                String One = dict[i];
                String Two = dict[i + 1];
                int k = Math.min(One.length(), Two.length());
                for (int j = 0; j < k; j++) {
                    if (One.charAt(j) != Two.charAt(j)) {
                        adj.get(One.charAt(j) - 'a').add(Two.charAt(j) - 'a');
                        break;

                    }
                }
            }

            List<Integer> topo = topoSort(K, adj);
            String ans = "";
            for (int it : topo) {
                ans = ans + (char) (it + (int) ('a'));
            }
            return ans;

        }
    }

    // ***************************SHORTEST PATH ***************************88 */
    // Shortest Path in Undirected graph with unit weight
    class Solution {
        public int[] shortestPath(int[][] edges, int n, int m, int src) {
            // Code here
            ArrayList<ArrayList<Integer>> adj = new ArrayList<>();
            for (int i = 0; i < n; i++) {
                adj.add(new ArrayList<>());
            }
            for (int i = 0; i < m; i++) {
                adj.get(edges[i][0]).add(edges[i][1]);
                adj.get(edges[i][1]).add(edges[i][0]);
            }
            int distance[] = new int[n];
            for (int i = 0; i < n; i++) {
                distance[i] = (int) (1e9);
            }
            distance[src] = 0;
            Queue<Integer> q = new LinkedList<>();
            q.add(src);
            while (!q.isEmpty()) {
                int node = q.peek();
                q.remove();
                for (Integer it : adj.get(node)) {
                    if (distance[node] + 1 < distance[it]) {
                        distance[it] = distance[node] + 1;
                        q.add(it);
                    }
                }
            }
            for (int i = 0; i < n; i++) {
                if (distance[i] == (int) (1e9)) {
                    distance[i] = -1;
                }
            }
            return distance;
        }
    }

    // Shortest Path in Directed Acyclic Graph
    class Solution {
        class Pair {
            int destination;
            int edgeW;

            Pair(int d, int e) {
                this.destination = d;
                this.edgeW = e;
            }
        }

        public void dfsTopo(int node, ArrayList<ArrayList<Pair>> adj, boolean vis[], Stack<Integer> st) {
            vis[node] = true;
            for (int i = 0; i < adj.get(node).size(); i++) {
                int v = adj.get(node).get(i).destination;
                if (vis[v] == false) {
                    dfsTopo(v, adj, vis, st);
                }
            }
            st.push(node);
        }

        public int[] shortestPath(int N, int M, int[][] edges) {
            // Code here
            ArrayList<ArrayList<Pair>> adj = new ArrayList<>();
            for (int i = 0; i < N; i++) {
                ArrayList<Pair> temp = new ArrayList<>();
                adj.add(temp);// adj.add(new ArrayList<>());
            }
            for (int i = 0; i < M; i++) {
                int src = edges[i][0];
                int dest = edges[i][1];
                int ew = edges[i][2];
                adj.get(src).add(new Pair(dest, ew));
            }

            Stack<Integer> st = new Stack<>();
            boolean vis[] = new boolean[N];
            for (int i = 0; i < N; i++) {
                vis[i] = false;
            }
            for (int i = 0; i < N; i++) {
                if (vis[i] == false) {
                    dfsTopo(i, adj, vis, st);
                }
            }

            int distance[] = new int[N];
            for (int i = 0; i < N; i++) {
                distance[i] = (int) (1e9);
            }
            distance[0] = 0;
            while (!st.isEmpty()) {
                int node = st.peek();
                st.pop();
                for (int i = 0; i < adj.get(node).size(); i++) {
                    int v = adj.get(node).get(i).destination;
                    int wt = adj.get(node).get(i).edgeW;
                    if (distance[node] + wt < distance[v]) {
                        distance[v] = distance[node] + wt;
                    }
                }
            }

            for (int i = 0; i < N; i++) {
                if (distance[i] == (int) (1e9))
                    distance[i] = -1;
            }
            return distance;

        }
    }

    // Djisktra's Algorithm
    class Solution {
        class Pair {
            int distance;
            int node;

            Pair(int _dis, int _node) {
                this.distance = _dis;
                this.node = _node;
            }
        };

        // Function to find the shortest distance of all the vertices
        // from the source vertex S.
        static int[] dijkstra(int V, ArrayList<ArrayList<ArrayList<Integer>>> adj, int S) {
            // Write your code here
            PriorityQueue<Pair> pq = new PriorityQueue<Pair>((x, y) -> x.distance - y.distance);
            int distance[] = new int[V];
            for (int i = 0; i < V; i++) {
                distance[i] = (int) (1e9);
            }
            distance[S] = 0;
            pq.add(new Pair(0, S));
            while (pq.size() != 0) {
                int dis = pq.peek().distance;
                int node = pq.peek().node;
                pq.remove();
                for (int i = 0; i < adj.get(node).size(); i++) {
                    int edgeW = adj.get(node).get(i).get(1);
                    int adjNode = adj.get(node).get(i).get(0);

                    if (dis + edgeW < distance[adjNode]) {
                        distance[adjNode] = dis + edgeW;
                        pq.add(new Pair(dis + edgeW, adjNode));
                    }
                }
            }
            return distance;
        }
    }

    // Why priority Queue is used in Djisk…
    // Shortest path in a binary maze
    class Solution {
        class Tuple {
            int dis;
            int x;
            int y;

            Tuple(int _dis, int _x, int _y) {
                this.dis = _dis;
                this.x = _x;
                this.y = _y;
            }
        }

        int shortestPath(int[][] grid, int[] source, int[] destination) {
            if (source[0] == destination[0] && source[1] == destination[1]) {
                return 0;
            }
            int sx = source[0], sy = source[1], Dx = destination[0], Dy = destination[1];
            int n = grid.length;
            int m = grid[0].length;
            int distance[][] = new int[n][m];
            for (int i = 0; i < n; i++) {
                for (int j = 0; j < m; j++) {
                    distance[i][j] = (int) (1e8);
                }
            }
            distance[sx][sy] = 0;
            int dx[] = { -1, 0, 1, 0 };
            int dy[] = { 0, 1, 0, -1 };
            Queue<Tuple> q = new LinkedList<>();
            q.add(new Tuple(0, sx, sy));
            while (!q.isEmpty()) {
                int d = q.peek().dis;
                int xc = q.peek().x;
                int yc = q.peek().y;
                q.remove();
                for (int i = 0; i < 4; i++) {
                    int nr = xc + dx[i];
                    int nc = yc + dy[i];
                    if (nr >= 0 && nr < n && nc >= 0 && nc < m && grid[nr][nc] == 1 && d + 1 < distance[nr][nc]) {
                        distance[nr][nc] = d + 1;
                        if (nr == Dx && nc == Dy) {
                            return d + 1;
                        } else {
                            q.add(new Tuple(d + 1, nr, nc));
                        }
                    }
                }
            }
            return -1;
        }
    }

    // Path with minimum effort
    class Solution {

        class Solution {
            class Tuple {
                int dis;
                int x;
                int y;

                Tuple(int _dis, int _x, int _y) {
                    this.dis = _dis;
                    this.x = _x;
                    this.y = _y;
                }
            }

            int MinimumEffort(int heights[][]) {
                PriorityQueue<Tuple> pq = new PriorityQueue<Tuple>((x, y) -> x.dis - y.dis);
                int n = heights.length;
                int m = heights[0].length;
                int distance[][] = new int[n][m];
                for (int i = 0; i < n; i++) {
                    for (int j = 0; j < m; j++) {
                        distance[i][j] = (int) (1e9);
                    }
                }
                distance[0][0] = 0;
                int dx[] = { -1, 0, 1, 0 };
                int dy[] = { 0, 1, 0, -1 };
                pq.add(new Tuple(0, 0, 0));
                while (!pq.isEmpty()) {
                    Tuple it = pq.peek();
                    pq.remove();
                    int diff = it.dis;
                    int xc = it.x;
                    int yc = it.y;
                    if (xc == n - 1 && yc == m - 1) {
                        return diff;
                    }

                    for (int i = 0; i < 4; i++) {
                        int nr = xc + dx[i];
                        int nc = yc + dy[i];
                        if (nr >= 0 && nr < n && nc >= 0 && nc < m) {
                            int newEffort = Math.max(diff, Math.abs(heights[nr][nc] - heights[xc][yc]));
                            if (newEffort < distance[nr][nc]) {
                                distance[nr][nc] = newEffort;
                                pq.add(new Tuple(newEffort, nr, nc));
                            }
                        }
                    }
                }
                return 0;
            }
        }

        class Solution {
            class Tuple {
                int dis;
                int x;
                int y;

                Tuple(int _dis, int _x, int _y) {
                    this.dis = _dis;
                    this.x = _x;
                    this.y = _y;
                }
            }

            public int minimumEffortPath(int[][] heights) {
                PriorityQueue<Tuple> pq = new PriorityQueue<Tuple>((x, y) -> x.dis - y.dis);
                int n = heights.length;
                int m = heights[0].length;
                int distance[][] = new int[n][m];
                for (int i = 0; i < n; i++) {
                    for (int j = 0; j < m; j++) {
                        distance[i][j] = (int) (1e9);
                    }
                }
                distance[0][0] = 0;
                int dx[] = { -1, 0, 1, 0 };
                int dy[] = { 0, 1, 0, -1 };
                pq.add(new Tuple(0, 0, 0));
                while (!pq.isEmpty()) {
                    Tuple it = pq.peek();
                    pq.remove();
                    int diff = it.dis;
                    int xc = it.x;
                    int yc = it.y;

                    for (int i = 0; i < 4; i++) {
                        int nr = xc + dx[i];
                        int nc = yc + dy[i];
                        if (nr >= 0 && nr < n && nc >= 0 && nc < m) {
                            int newEffort = Math.max(diff, Math.abs(heights[nr][nc] - heights[xc][yc]));
                            if (newEffort < distance[nr][nc]) {
                                distance[nr][nc] = newEffort;
                                pq.add(new Tuple(newEffort, nr, nc));
                            }
                        }
                    }
                }
                return distance[n - 1][m - 1];
            }
        }

    }

    // Cheapest flights within k stops
    class Solution {
        class Pair {
            int first;
            int second;

            Pair(int _first, int _second) {
                this.first = _first;
                this.second = _second;
            }
        }

        class Tuple {
            int first;
            int second;
            int third;

            Tuple(int _first, int _second, int _third) {
                this.first = _first;
                this.second = _second;
                this.third = _third;
            }
        }

        public int CheapestFLight(int n, int flights[][], int src, int dst, int k) {
            // Code here
            ArrayList<ArrayList<Pair>> adj = new ArrayList<>();
            for (int i = 0; i < n; i++) {
                adj.add(new ArrayList<>());
            }
            int m = flights.length;
            for (int i = 0; i < m; i++) {
                adj.get(flights[i][0]).add(new Pair(flights[i][1], flights[i][2]));
            }
            int dist[] = new int[n];
            for (int i = 0; i < n; i++) {
                dist[i] = (int) (1e9);
            }
            dist[src] = 0;
            Queue<Tuple> q = new LinkedList<>();
            q.add(new Tuple(0, src, 0));
            while (!q.isEmpty()) {
                Tuple it = q.peek();
                q.remove();
                int stops = it.first;
                int node = it.second;
                int cost = it.third;
                if (stops > k) {
                    continue;
                }
                for (Pair iter : adj.get(node)) {
                    int adjNode = iter.first;
                    int edgeW = iter.second;

                    if (cost + edgeW < dist[adjNode]) {
                        dist[adjNode] = cost + edgeW;
                        q.add(new Tuple(stops + 1, adjNode, cost + edgeW));
                    }
                }
            }
            if (dist[dst] == (int) (1e9)) {
                return -1;
            }
            return dist[dst];
        }
    }
    // Network Delay time
    // Number of ways to arrive at destina…
    // Minimum steps to reach end from sta…
    // Bellman Ford Algorithm
    class Solution {
        static int[] bellman_ford(int V, ArrayList<ArrayList<Integer>> edges, int S) {
            // Write your code here
            int[] distance = new int[V];
            for (int i = 0; i < V; i++) {
                distance[i] = (int) (1e8);
            }
            distance[S] = 0;

            for (int i = 0; i < V - 1; i++) {
                for (ArrayList<Integer> it : edges) {
                    int u = it.get(0);
                    int v = it.get(1);
                    int wt = it.get(2);
                    if (distance[u] != (int) (1e8) && distance[u] + wt < distance[v]) {
                        distance[v] = distance[u] + wt;
                    }
                }
            }
            for (ArrayList<Integer> it : edges) {
                int u = it.get(0);
                int v = it.get(1);
                int wt = it.get(2);
                if (distance[u] != (int) (1e8) && distance[u] + wt < distance[v]) {
                    int temp[] = new int[1];
                    temp[0] = -1;
                    return temp;
                }
            }
            return distance;
        }
    }

    // Floyd Warshal Algorithm
    class Solution {
        public void shortest_distance(int[][] matrix) {
            // Code here
            int n = matrix.length;
            for (int i = 0; i < n; i++) {
                for (int j = 0; j < n; j++) {
                    if (i == j) {
                        matrix[i][j] = 0;
                    } else if (matrix[i][j] == -1) {
                        matrix[i][j] = (int) (1e9);
                    }
                }
            }
            for (int k = 0; k < n; k++) {
                for (int i = 0; i < n; i++) {
                    for (int j = 0; j < n; j++) {
                        matrix[i][j] = Math.min(matrix[i][j], matrix[i][k] + matrix[k][j]);
                    }
                }
            }

            for (int i = 0; i < n; i++) {
                for (int j = 0; j < n; j++) {
                    if (matrix[i][j] == (int) (1e9)) {
                        matrix[i][j] = -1;
                    }
                }
            }
            return;
        }
    }

    // Find the city with the smallest number of neighbours

}