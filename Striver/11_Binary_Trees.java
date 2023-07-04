public class Trees {
    // MEDIUM
    // Height of a Binary Tree
    class Solution {
        public int maxDepth(TreeNode root) {
            return maxDepthFn(root);
        }

        public int maxDepthFn(TreeNode root) {
            if (root == null) {
                return 0;
            }
            int lh = maxDepthFn(root.left);
            int rh = maxDepthFn(root.right);
            return 1 + Math.max(lh, rh);
        }
    }

    // Check if the Binary tree is height-Balanced
    class Solution {
        public boolean isBalanced(TreeNode root){
            return dfsHeight(root)!=-1
        }

        public int dfsHeight(TreeNode root) {
            if (root == null) {
                return 0;
            }
            int lh = dfsHeight(root.left);
            if (lh == -1)
                return -1;
            int rh = dfsHeight(root.right);
            if (rh == -1)
                return -1;
            if (Math.abs(lh - rh) > 1)
                return -1;
            return 1 + Math.max(lh, rh);
        }
    }

    // Diameter of Binary Tree
    public int diameterOfBinaryTree(TreeNode root) {
        int[] diameter = new int[] { 0 };
        heightOfBinaryTree(root, diameter);
        return diameter[0];
    }

    public int heightOfBinaryTree(TreeNode root, int diameter[]) {
        if (root == null) {
            return 0;
        }
        int lh = heightOfBinaryTree(root.left, diameter);
        int rh = heightOfBinaryTree(root.right, diameter);
        diameter[0] = Math.max(diameter[0], lh + rh);
        return 1 + Math.max(lh, rh);
    }

    // Maximum path sum
    class Solution {
        public static int maxPathSum(Node root) {
            int maxValue[] = new int[1];
            maxValue[0] = Integer.MIN_VALUE;
            maxPathDown(root, maxValue);
            return maxValue[0];
        }

        public static int maxPathDown(Node node, int maxValue[]) {
            if (node == null)
                return 0;
            int left = Math.max(0, maxPathDown(node.left, maxValue));
            int right = Math.max(0, maxPathDown(node.right, maxValue));
            maxValue[0] = Math.max(maxValue[0], left + right + node.val);
            return Math.max(left, right) + node.val;
        }
    }

    // Check if two trees are identical or not
    class Solution {
        static boolean isIdentical(Node node1, Node node2) {
            if (node1 == null && node2 == null)
                return true;
            else if (node1 == null || node2 == null)
                return false;

            return ((node1.data == node2.data) && isIdentical(node1.left, node2.left)
                    && isIdentical(node1.right, node2.right));
        }
    }

    // Zig Zag Traversal of Binary Tree
    class Solution {
        public static ArrayList<ArrayList<Integer>> zigzagLevelOrder(Node root) {
            Queue<Node> queue = new LinkedList<Node>();
            ArrayList<ArrayList<Integer>> wrapList = new ArrayList<>();

            if (root == null)
                return wrapList;

            queue.offer(root);
            boolean flag = true;
            while (!queue.isEmpty()) {
                int levelNum = queue.size();
                ArrayList<Integer> subList = new ArrayList<Integer>(levelNum);
                for (int i = 0; i < levelNum; i++) {
                    int index = i;
                    if (queue.peek().left != null)
                        queue.offer(queue.peek().left);
                    if (queue.peek().right != null)
                        queue.offer(queue.peek().right);
                    if (flag == true)
                        subList.add(queue.poll().val);
                    else
                        subList.add(0, queue.poll().val);
                }
                flag = !flag;
                wrapList.add(subList);
            }
            return wrapList;
        }
    }

    // Boundary Traversal of Binary Tree
    class Solution {
        static Boolean isLeaf(Node root) {
            return (root.left == null) && (root.right == null);
        }

        static void addLeftBoundary(Node root, ArrayList<Integer> res) {
            Node cur = root.left;
            while (cur != null) {
                if (isLeaf(cur) == false)
                    res.add(cur.data);
                if (cur.left != null)
                    cur = cur.left;
                else
                    cur = cur.right;
            }
        }

        static void addRightBoundary(Node root, ArrayList<Integer> res) {
            Node cur = root.right;
            ArrayList<Integer> tmp = new ArrayList<Integer>();
            while (cur != null) {
                if (isLeaf(cur) == false)
                    tmp.add(cur.data);
                if (cur.right != null)
                    cur = cur.right;
                else
                    cur = cur.left;
            }
            int i;
            for (i = tmp.size() - 1; i >= 0; --i) {
                res.add(tmp.get(i));
            }
        }

        static void addLeaves(Node root, ArrayList<Integer> res) {
            if (isLeaf(root)) {
                res.add(root.data);
                return;
            }
            if (root.left != null)
                addLeaves(root.left, res);
            if (root.right != null)
                addLeaves(root.right, res);
        }

        static ArrayList<Integer> printBoundary(Node node) {
            ArrayList<Integer> ans = new ArrayList<Integer>();
            if (isLeaf(node) == false)
                ans.add(node.data);
            addLeftBoundary(node, ans);
            addLeaves(node, ans);
            addRightBoundary(node, ans);
            return ans;
        }
    }

    // Vertical Order Traversal of Binary Tree
    class Solution {
        class Tuple {
            TreeNode node;
            int row;
            int col;

            Tuple(TreeNode _node, int _row, int _col) {
                this.node = _node;
                this.row = _row;
                this.col = _col;
            }
        }

        public List<List<Integer>> verticalTraversal(TreeNode root){
            List<List<Integer>> list=new ArrayList<>();
            TreeMap<Integer,TreeMap<Integer,PriorityQueue<Integer>>> map=new TreeMap<>();
            q.offer(new Tuple(root,0,0));
            while(!q.isEmpty()){
                Tuple tup=q.peek();
                TreeNode Node=tup.node;
                int x=tup.row;
                int y=tup.col;

                if(!map.containsKey(x)){
                    map.put(x,new TreeMap<>());
                }
                if(map.get(x).containsKey(y)){
                map.get(x).put(y,new PriorityQueue<Integer>());
                }
                map.get(x).get(y).offer(Node.val);
                if(Node.left!=null){
                    q.offer(new Tuple(Node.left,x-1,y+1));
                }
                if(Node.right!=null){
                    q.offer(new Tuple(Node.left,x+1,y+1));
                }
            }
            for(TreeMap<Integer,PriorityQueue<Integer>> ys: map.values()){
                list.add(new ArrayList<>());
                for(PriorityQueue<Integer>> nodes: ys.values())
                    while(!nodes.isEmpty()){
                        System.out.println(nodes.peek());
                        list.get(list.size()-1).add(nodes.poll());
                    }
            }
            return list;
        }
    }

    // Top View of Binary Tree
    class Solution {
        static ArrayList<Integer> topView(Node root) {
            ArrayList<Integer> ans = new ArrayList<>();
            if (root == null)
                return ans;
            Map<Integer, Integer> map = new TreeMap<>();
            Queue<Pair> q = new LinkedList<Pair>();
            q.add(new Pair(root, 0));
            while (!q.isEmpty()) {
                Pair it = q.remove();
                int hd = it.hd;
                Node temp = it.node;
                if (map.get(hd) == null)
                    map.put(hd, temp.data);
                if (temp.left != null) {
                    q.add(new Pair(temp.left, hd - 1));
                }
                if (temp.right != null) {
                    q.add(new Pair(temp.right, hd + 1));
                }
            }
            for (Map.Entry<Integer, Integer> entry : map.entrySet()) {
                ans.add(entry.getValue());
            }
            return ans;

        }
    }

    // Bottom View of Binary Tree
    class Solution {
        static ArrayList<Integer> BottomView(Node root) {
            ArrayList<Integer> ans = new ArrayList<>();
            if (root == null)
                return ans;
            Map<Integer, Integer> map = new TreeMap<>();
            Queue<Pair> q = new LinkedList<Pair>();
            q.add(new Pair(root, 0));
            while (!q.isEmpty()) {
                Pair it = q.remove();
                int hd = it.hd;
                Node temp = it.node;
                map.put(hd, temp.data);
                if (temp.left != null) {
                    q.add(new Pair(temp.left, hd - 1));
                }
                if (temp.right != null) {
                    q.add(new Pair(temp.right, hd + 1));
                }
            }
            for (Map.Entry<Integer, Integer> entry : map.entrySet()) {
                ans.add(entry.getValue());
            }
            return ans;

        }
    }

    // Right/Left View of Binary Tree
    class Solution {
        public List<Integer> rightSideView(TreeNode root) {
            List<Integer> result = new ArrayList<Integer>();
            rightView(root, result, 0);
            return result;
        }

        public void rightView(TreeNode curr, List<Integer> result, int currDepth) {
            if (curr == null) {
                return;
            }
            if (currDepth == result.size()) {
                result.add(curr.val);
            }
            rightView(curr.right, result, currDepth + 1);
            rightView(curr.left, result, currDepth + 1);
        }

        public List<Integer> lightSideView(TreeNode root) {
            List<Integer> result = new ArrayList<Integer>();
            leftView(root, result, 0);
            return result;
        }

        public void leftView(TreeNode curr, List<Integer> result, int currDepth) {
            if (curr == null) {
                return;
            }
            if (currDepth == result.size()) {
                result.add(curr.val);
            }
            leftView(curr.left, result, currDepth + 1);
            leftView(curr.right, result, currDepth + 1);
        }
    }

    // Symmetric Binary Tree
    class Solution {
        public boolean isSymmetric(TreeNode root) {
            return root == null || isSymmetricHelp(root.left, root.right);
        }

        private boolean isSymmetricHelp(TreeNode left, TreeNode right) {
            if (left == null || right == null)
                return left == right;
            if (left.val != right.val)
                return false;
            return isSymmetricHelp(left.left, right.right) && isSymmetricHelp(left.right, right.left);
        }
    }

    // HARD
    // Root to Node Path in Binary Tree
    class Solution {
        class Tree {
            public ArrayList<ArrayList<Integer>> Paths(Node root) {
                // Code here
                ArrayList<ArrayList<Integer>> ls = new ArrayList<>();
                ArrayList<Integer> ds = new ArrayList<>();
                getPaths(root, ds, ls);
                return ls;

            }

            public void getPaths(Node root, ArrayList<Integer> ds, ArrayList<ArrayList<Integer>> ls) {
                if (root == null) {
                    return;
                }
                if (root.left == null && root.right == null) {
                    ds.add(root.data);
                    ls.add(new ArrayList<>(ds));
                    ds.remove(ds.size() - 1);
                    return;
                }
                ds.add(root.data);
                getPaths(root.left, ds, ls);
                getPaths(root.right, ds, ls);
                ds.remove(ds.size() - 1);

            }

        }

        static boolean getPath(Node root, ArrayList<Integer> arr, int x) {
            if (root == null)
                return false;
            arr.add(root.data);
            if (root.data == x)
                return true;
            if (getPath(root.left, arr, x) || getPath(root.right, arr, x))
                return true;
            arr.remove(arr.size() - 1);
            return false;
        }
    }

    // LCA in Binary Tree
    class Solution {
        public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
            // base case
            if (root == null || root == p || root == q) {
                return root;
            }
            TreeNode left = lowestCommonAncestor(root.left, p, q);
            TreeNode right = lowestCommonAncestor(root.right, p, q);
            if (left == null) {
                return right;
            } else if (right == null) {
                return left;
            } else { // both left and right are not null, we found our result
                return root;
            }
        }
    }

    // Maximum width of a Binary Tree
    class Solution {
        class Pair {
            TreeNode node;
            int num;

            Pair(TreeNode _node, int _num) {
                num = _num;
                node = _node;
            }
        }

        public static int widthOfBinaryTree(TreeNode root) {
            if (root == null)
                return 0;
            int ans = 0;
            Queue<Pair> q = new LinkedList<>();
            q.offer(new Pair(root, 0));
            while (!q.isEmpty()) {
                int size = q.size();
                int mmin = q.peek().num; // to make the id starting from zero
                int first = 0, last = 0;
                for (int i = 0; i < size; i++) {
                    int cur_id = q.peek().num - mmin;
                    TreeNode node = q.peek().node;
                    q.poll();
                    if (i == 0)
                        first = cur_id;
                    if (i == size - 1)
                        last = cur_id;
                    if (node.left != null)
                        q.offer(new Pair(node.left, cur_id * 2 + 1));
                    if (node.right != null)
                        q.offer(new Pair(node.right, cur_id * 2 + 2));
                }
                ans = Math.max(ans, last - first + 1);
            }
            return ans;
        }
    }

    // Check for Children Sum Property
    class Solution {
        static void reorder(Node root) {
            if (root == null)
                return;
            int child = 0;
            if (root.left != null) {
                child += root.left.data;
            }
            if (root.right != null) {
                child += root.right.data;
            }

            if (child < root.data) {
                if (root.left != null)
                    root.left.data = root.data;
                else if (root.right != null)
                    root.right.data = root.data;
            }

            reorder(root.left);
            reorder(root.right);

            int tot = 0;
            if (root.left != null)
                tot += root.left.data;
            if (root.right != null)
                tot += root.right.data;
            if (root.left != null || root.right != null)
                root.data = tot;
        }
    }/
    // Print all the Nodes at a distance of K from a node
    class Solution {
        public List<Integer> distanceK(TreeNode root, TreeNode target, int k) {
            HashMap<TreeNode, TreeNode> hm = new HashMap<>();
            get_parent_map(root, hm);
            HashMap<TreeNode, Boolean> vis = new HashMap<>();
            Queue<TreeNode> q = new LinkedList<>();
            q.add(target);
            vis.put(target, true);
            int curr_level = 0;
            while (!q.isEmpty()) {
                int s = q.size();

                if (curr_level == k) {
                    break;
                }
                curr_level++;
                for (int i = 0; i < s; i++) {
                    TreeNode current = q.poll();
                    if (current.left != null && vis.get(current.left) == null) {
                        vis.put(current.left, true);
                        q.add(current.left);
                    }
                    if (current.right != null && vis.get(current.right) == null) {
                        vis.put(current.right, true);
                        q.add(current.right);
                    }
                    if (hm.get(current) != null && vis.get(hm.get(current)) == null) {
                        vis.put(hm.get(current), true);
                        q.add(hm.get(current));
                    }
                }
            }
            List<Integer> ls = new ArrayList<>();
            while (!q.isEmpty()) {
                ls.add(q.poll().val);
            }
            return ls;

        }

        public void get_parent_map(TreeNode root, HashMap<TreeNode, TreeNode> hm) {
            Queue<TreeNode> q = new LinkedList<>();
            q.add(root);
            while (!q.isEmpty()) {
                TreeNode current = q.poll();
                if (current.left != null) {
                    hm.put(current.left, current);
                    q.add(current.left);
                }
                if (current.right != null) {
                    hm.put(current.right, current);
                    q.add(current.right);
                }
            }
            return;
        }
    }

    // Minimum time taken to BURN the Binary Tree
    class Solution {
        /*
         * class Node {
         * int data;
         * Node left;
         * Node right;
         * 
         * Node(int data) {
         * this.data = data;
         * left = null;
         * right = null;
         * }
         * }
         */

        public static int minTime(Node root, int target) {
            // Your code goes here
            HashMap<Node, Node> hm = new HashMap<>();
            Node t = get_parent_map(root, hm, target);
            HashMap<Node, Boolean> vis = new HashMap<>();
            Queue<Node> q = new LinkedList<>();
            q.add(t);
            vis.put(t, true);
            int curr_level = 0;
            while (!q.isEmpty()) {
                int s = q.size();
                curr_level++;
                for (int i = 0; i < s; i++) {
                    Node current = q.poll();
                    if (current.left != null && vis.get(current.left) == null) {
                        vis.put(current.left, true);
                        q.add(current.left);
                    }
                    if (current.right != null && vis.get(current.right) == null) {
                        vis.put(current.right, true);
                        q.add(current.right);
                    }
                    if (hm.get(current) != null && vis.get(hm.get(current)) == null) {
                        vis.put(hm.get(current), true);
                        q.add(hm.get(current));
                    }
                }
            }
            return curr_level - 1;

        }

        public static Node get_parent_map(Node root, HashMap<Node, Node> hm, int target) {
            Queue<Node> q = new LinkedList<>();
            q.add(root);
            Node res = null;
            while (!q.isEmpty()) {
                Node current = q.poll();
                if (current.data == target) {
                    res = current;
                }
                if (current.left != null) {
                    hm.put(current.left, current);
                    q.add(current.left);
                }
                if (current.right != null) {
                    hm.put(current.right, current);
                    q.add(current.right);
                }
            }
            return res;
        }
    }

    // Count total Nodes in a COMPLETE Binary Tree
    class Solution {
        public int countNodes(TreeNode root) {
            if (root == null)
                return 0;
            int left = getHeightLeft(root);
            int right = getHeightRight(root);
            // If left and right are equal it means that the tree is complete and hence go
            // for 2^h -1.
            if (left == right)
                return ((2 << (left)) - 1);
            // else recursively calculate the number of nodes in left and right and add 1
            // for root.
            else
                return countNodes(root.left) + countNodes(root.right) + 1;
        }

        public int getHeightLeft(TreeNode root) {
            int count = 0;
            while (root.left != null) {
                count++;
                root = root.left;
            }
            return count;
        }

        public int getHeightRight(TreeNode root) {
            int count = 0;
            while (root.right != null) {
                count++;
                root = root.right;
            }
            return count;
        }
    }

    // Requirements needed to construct a Unique binary tree
    class Solution {
        // You cannot construct a unique tree from pre and post order
    }

    // Construct Binary Tree from inorder and preorder traversal
    class Solution {
        static TreeNode buildTree(int[] preorder, int[] inorder) {
            Map<Integer, Integer> inMap = new HashMap<Integer, Integer>();
            for (int i = 0; i < inorder.length; i++) {
                inMap.put(inorder[i], i);
            }
            TreeNode root = buildTree(preorder, 0, preorder.length - 1, inorder, 0, inorder.length - 1, inMap);
            return root;
        }

        static TreeNode buildTree(int[] preorder, int preStart, int preEnd, int[] inorder, int inStart, int inEnd,
                Map<Integer, Integer> inMap) {
            if (preStart > preEnd || inStart > inEnd)
                return null;
            TreeNode root = new TreeNode(preorder[preStart]);
            int inRoot = inMap.get(root.val);
            int numsLeft = inRoot - inStart;
            root.left = buildTree(preorder, preStart + 1, preStart + numsLeft, inorder, inStart, inRoot - 1, inMap);
            root.right = buildTree(preorder, preStart + numsLeft + 1, preEnd, inorder, inRoot + 1, inEnd, inMap);
            return root;
        }
    }

    // Construct the Binary Tree from Postorder and inorder
    class Solution {
        public TreeNode buildTree(int[] inorder, int[] postorder) {
            if (inorder == null || postorder == null || inorder.length != postorder.length)
                return null;
            HashMap<Integer, Integer> hm = new HashMap<Integer, Integer>();
            for (int i = 0; i < inorder.length; ++i)
                hm.put(inorder[i], i);
            return buildTreePostIn(inorder, 0, inorder.length - 1, postorder, 0, postorder.length - 1, hm);
        }

        private TreeNode buildTreePostIn(int[] inorder, int is, int ie, int[] postorder, int ps, int pe,
                HashMap<Integer, Integer> hm) {
            if (ps > pe || is > ie)
                return null;
            TreeNode root = new TreeNode(postorder[pe]);
            int inroot = hm.get(postorder[pe]);
            int numsLeft = inroot - is;
            root.left = buildTreePostIn(inorder, is, inroot - 1, postorder, ps, ps + numsLeft - 1, hm);
            root.right = buildTreePostIn(inorder, inroot + 1, ie, postorder, ps + numsLeft, pe - 1, hm);
            return root;
        }
    }

    // Serialize and deserialize Binary Tree
    public class Codec {

        // Encodes a tree to a single string.
        public String serialize(TreeNode root) {
            if (root == null) {
                return "";
            }
            Queue<TreeNode> q = new LinkedList<>();
            StringBuilder res = new StringBuilder();
            q.add(root);
            while (!q.isEmpty()) {
                TreeNode temp = q.poll();
                if (temp == null) {
                    res.append("n ");
                    continue;
                }
                res.append(temp.val + " ");
                q.add(temp.left);
                q.add(temp.right);
            }
            return res.toString();
        }

        // Decodes your encoded data to tree.
        public TreeNode deserialize(String data) {
            if (data == "")
                return null;
            Queue<TreeNode> q = new LinkedList<>();
            String[] values = data.split(" ");
            TreeNode root = new TreeNode(Integer.parseInt(values[0]));
            q.add(root);
            for (int i = 1; i < values.length; i++) {
                TreeNode parent = q.poll();
                if (!values[i].equals("n")) {
                    TreeNode left = new TreeNode(Integer.parseInt(values[i]));
                    parent.left = left;
                    q.add(left);
                }
                if (!values[++i].equals("n")) {
                    TreeNode right = new TreeNode(Integer.parseInt(values[i]));
                    parent.right = right;
                    q.add(right);
                }
            }
            return root;
        }
    }
    // Morris Preorder Traversal of a Bina…
    // Morris Inorder Traversal of a Binar…
    // Flatten Binary Tree to LinkedList

}
