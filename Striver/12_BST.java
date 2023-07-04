public class BST {
    // Introduction to Binary Search Tree
    // Search in a Binary Search Tree
    class BST {
        // Function to search a node in BST.
        boolean search(Node root, int x) {
            // Your code here
            Node curr = root;
            while (curr != null && curr.data != x) {
                curr = curr.data < x ? curr.right : curr.left;
            }
            return curr != null;
        }
    }
    // Find Min/Max in BST
    class Tree {
        // Function to find the minimum element in the given BST.
        int minValue(Node node) {
            if (node == null) {
                return -1;
            }

            Node P = node;
            while (P.left != null) {
                P = P.left;
            }
            return P.data;
        }
    }
    // Ceil in a Binary Search Tree
    class Tree {
        // Function to return the ceil of given number in BST.
        int findCeil(Node root, int key) {
            if (root == null)
                return -1;
            // Code here
            int ceil = -1;
            Node curr = root;
            while (curr != null) {
                if (curr.data == key) {
                    ceil = curr.data;
                    return ceil;
                } else if (curr.data < key) {
                    curr = curr.right;
                } else {
                    ceil = curr.data;
                    curr = curr.left;
                }
            }
            return ceil;
        }
    }
    // Floor in a Binary Search Tree
    class Solution {
        public static int floorInBST(TreeNode<Integer> root, int key) {
            int floor = -1;
            while (root != null) {
                if (root.data == key) {
                    floor = root.data;
                    return floor;
                }
                if (key > root.data) {
                    floor = root.data;
                    root = root.right;
                } else {
                    root = root.left;
                }
            }
            return floor;
        }
    }
    // Insert a given Node in Binary Search Tree
    class Solution {
        public TreeNode insertIntoBST(TreeNode root, int x) {
            if (root == null)
                return new TreeNode(x);
            TreeNode curr = root;
            while (true) {
                if (curr.val < x) {
                    if (curr.right != null) {
                        curr = curr.right;
                    } else {
                        TreeNode child = new TreeNode(x);
                        curr.right = child;
                        return root;
                    }
                } else {
                    if (curr.left != null) {
                        curr = curr.left;
                    } else {
                        TreeNode child = new TreeNode(x);
                        curr.left = child;
                        return root;
                    }
                }
            }
            // return root;
        }
    }
    // Delete a Node in Binary Search Tree
    class Solution {
        public TreeNode deleteNode(TreeNode root, int key) {
            if (root == null) {
                return null;
            }
            if (root.val == key) {
                return helper(root);
            }
            TreeNode dummy = root;
            while (root != null) {
                if (root.val > key) {
                    if (root.left != null && root.left.val == key) {
                        root.left = helper(root.left);
                        break;
                    } else {
                        root = root.left;
                    }
                } else {
                    if (root.right != null && root.right.val == key) {
                        root.right = helper(root.right);
                        break;
                    } else {
                        root = root.right;
                    }
                }
            }
            return dummy;
        }

        public TreeNode helper(TreeNode root) {
            if (root.left == null) {
                return root.right;
            } else if (root.right == null) {
                return root.left;
            } else {
                TreeNode rightChild = root.right;
                TreeNode lastRight = findLastRight(root.left);
                lastRight.right = rightChild;
                return root.left;
            }
        }

        public TreeNode findLastRight(TreeNode root) {
            if (root.right == null) {
                return root;
            }
            return findLastRight(root.right);
        }
    }
    // Find K-th smallest/largest element in a BST
    class Solution {
        static Node kthlargest(Node root, int k[]) {
            if (root == null)
                return null;
            Node right = kthlargest(root.right, k);
            if (right != null) {
                return right;
            }
            k[0]--;
            if (k[0] == 0) {
                return root;
            }
            return kthlargest(root.left, k);
        }

        static Node kthsmallest(Node root, int k[]) {
            if (root == null) {
                return null;
            }
            Node left = kthsmallest(root.left, k);
            if (left != null) {
                return left;
            }
            k[0]--;
            if (k[0] == 0) {
                return root;
            }
            return kthsmallest(root.right, k);
        }
    }
    // Check if a tree is a BST or BT
    class Solution {
        private boolean checkBST(TreeNode node, long min, long max) {
            if (node == null)
                return true;
            if (node.val <= min || node.val >= max)
                return false;

            if (checkBST(node.left, min, node.val) && checkBST(node.right, node.val, max)) {
                return true;
            }
            return false;
        }

        public boolean isValidBST(TreeNode root) {
            return checkBST(root, Long.MIN_VALUE, Long.MAX_VALUE);
        }
    }
    // LCA in Binary Search Tree
    class Solution {
        public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
            if (root == null)
                return null;
            int curr = root.val;
            if (curr < p.val && curr < q.val) {
                return lowestCommonAncestor(root.right, p, q);
            }
            if (curr > p.val && curr > q.val) {
                return lowestCommonAncestor(root.left, p, q);
            }
            return root;
        }
    }
    // Construct a BST from a preorder traversal
    class Solution {
        public TreeNode bstFromPreorder(int[] A) {
            return bstFromPreorder(A, Integer.MAX_VALUE, new int[] { 0 });
        }

        public TreeNode bstFromPreorder(int[] A, int bound, int[] i) {
            if (i[0] == A.length || A[i[0]] > bound)
                return null;
            TreeNode root = new TreeNode(A[i[0]++]);
            root.left = bstFromPreorder(A, root.val, i);
            root.right = bstFromPreorder(A, bound, i);
            return root;
        }
    }
    // Inorder Successor/Predecessor in BST
    class Solution {
        public TreeNode inorderSuccessor(TreeNode root, TreeNode p) {
            TreeNode successor = null;
            while (root != null) {
                if (p.val >= root.val) {
                    root = root.right;
                } else {
                    successor = root;
                    root = root.left;
                }
            }
            return successor;
        }

        public TreeNode inorderPredecessor(TreeNode root, TreeNode p) {
            TreeNode predecessor = null;
            while (root != null) {
                if (p.val <= root.val) {
                    root = root.left;
                } else {
                    predecessor = root;
                    root = root.right;
                }
            }
            return predecessor;
        }
    }
    // Merge 2 BST's
    class Solution {
        public class BSTIterator {
            private Stack<Node> stack = new Stack<Node>();

            public BSTIterator(Node root) {
                pushAll(root);
            }

            /** @return whether we have a next smallest number */
            public boolean hasNext() {
                return !stack.isEmpty();
            }

            /** @return the next smallest number */
            public int next() {
                Node tmpNode = stack.pop();
                pushAll(tmpNode.right);
                return tmpNode.data;
            }

            private void pushAll(Node node) {
                for (; node != null; stack.push(node), node = node.left)
                    ;
            }
        }

        public List<Integer> merge(Node root1, Node root2) {
            // Write your code here
            BSTIterator iter1 = new BSTIterator(root1);
            BSTIterator iter2 = new BSTIterator(root2);

            boolean f1 = iter1.hasNext();
            boolean f2 = iter2.hasNext();

            int val1 = iter1.next();
            int val2 = iter2.next();

            List<Integer> ls = new ArrayList<>();
            while (f1 != false && f2 != false) {
                if (val1 < val2) {
                    ls.add(val1);
                    f1 = iter1.hasNext();
                    if (f1) {
                        val1 = iter1.next();
                    } else {
                        break;
                    }
                } else {
                    ls.add(val2);
                    f2 = iter2.hasNext();
                    if (f2) {
                        val2 = iter2.next();
                    } else {
                        break;
                    }
                }
            }

            while (f2 != false) {
                ls.add(val2);
                f2 = iter2.hasNext();
                if (f2) {
                    val2 = iter2.next();
                } else {
                    break;
                }
            }
            while (f1 != false) {
                ls.add(val1);
                f1 = iter1.hasNext();
                if (f1) {
                    val1 = iter1.next();
                } else {
                    break;
                }
            }
            return ls;
        }
    }
    // Two Sum In BST | Check if there exists a pair with given sum
    class Solution {
        class BSTIterator {
            private Stack<TreeNode> stack = new Stack<TreeNode>();
            boolean reverse = true;

            public BSTIterator(TreeNode root, boolean isReverse) {
                reverse = isReverse;
                pushAll(root);
            }

            /** @return whether we have a next smallest number */
            public boolean hasNext() {
                return !stack.isEmpty();
            }

            /** @return the next smallest number */
            public int next() {
                TreeNode tmpNode = stack.pop();
                if (reverse == false)
                    pushAll(tmpNode.right);
                else
                    pushAll(tmpNode.left);
                return tmpNode.val;
            }

            private void pushAll(TreeNode node) {
                while (node != null) {
                    stack.push(node);
                    if (reverse == true) {
                        node = node.right;
                    } else {
                        node = node.left;
                    }
                }
            }
        }

        class Solution {
            public boolean findTarget(TreeNode root, int k) {
                if (root == null)
                    return false;
                BSTIterator l = new BSTIterator(root, false);
                BSTIterator r = new BSTIterator(root, true);

                int i = l.next();
                int j = r.next();
                while (i < j) {
                    if (i + j == k)
                        return true;
                    else if (i + j < k)
                        i = l.next();
                    else
                        j = r.next();
                }
                return false;
            }
        }
        
        /**
         * Definition for a binary tree node.
         * public class TreeNode {
         * int val;
         * TreeNode left;
         * TreeNode right;
         * TreeNode() {}
         * TreeNode(int val) { this.val = val; }
         * TreeNode(int val, TreeNode left, TreeNode right) {
         * this.val = val;
         * this.left = left;
         * this.right = right;
         * }
         * }
         */
        class BSTIteratorL {
            public Stack<TreeNode> st = new Stack<>();

            public void BSTItera(TreeNode root) {
                pushAll(root);
            }

            public int next() {
                TreeNode tmp = st.pop();
                pushAll(tmp.right);
                return tmp.val;
            }

            public boolean hasNext() {
                return !st.isEmpty();
            }

            public void pushAll(TreeNode root) {
                while (root != null) {
                    st.push(root);
                    root = root.left;
                }
            }
        }

        class BSTIteratorR {
            public Stack<TreeNode> st = new Stack<>();

            public void BSTItera(TreeNode root) {
                pushAll(root);
            }

            public int next() {
                TreeNode tmp = st.pop();
                pushAll(tmp.left);
                return tmp.val;
            }

            public boolean hasNext() {
                return !st.isEmpty();
            }

            public void pushAll(TreeNode root) {
                while (root != null) {
                    st.push(root);
                    root = root.right;
                }
            }
        }

        class Solution {
            public boolean findTarget(TreeNode root, int k) {
                BSTIteratorL s = new BSTIteratorL();
                BSTIteratorR e = new BSTIteratorR();

                s.BSTItera(root);
                e.BSTItera(root);

                int start = s.next();
                int end = e.next();
                while (s.hasNext() == true && e.hasNext() == true) {
                    if (start + end == k) {// System.out.println(start+" "+end);
                        if (start == end) {
                            return false;
                        }
                        return true;
                    } else if (start + end < k) {
                        start = s.next();
                    } else {
                        end = e.next();
                    }
                }
                return false;
            }
        }
    }
    // Recover BST | Correct BST with two nodes swapped
    class Solution {
        private TreeNode first;
        private TreeNode prev;
        private TreeNode middle;
        private TreeNode last;

        private void inorder(TreeNode root) {
            if (root == null)
                return;
            inorder(root.left);
            if (prev != null && (root.val < prev.val)) {
                if (first == null) {
                    first = prev;
                    middle = root;
                } else
                    last = root;
            }
            prev = root;
            inorder(root.right);
        }

        public void recoverTree(TreeNode root) {
            first = middle = last = null;
            prev = new TreeNode(Integer.MIN_VALUE);
            inorder(root);
            if (first != null && last != null) {
                int t = first.val;
                first.val = last.val;
                last.val = t;
            } else if (first != null && middle != null) {
                int t = first.val;
                first.val = middle.val;
                middle.val = t;
            }
        }

    }
    // Largest BST in Binary Tree
    class Solution {
        class NodeValue {
            public int maxNode,
            public int minNode,
            public int maxSize;

            NodeValue(int maxNode, int minNode, int maxSize) {
                this.maxNode = maxNode;
                this.minNode = minNode;
                this.maxSize = maxSize;
            }
        }

        private NodeValue largestBSTSubtreeHelper(TreeNode root) {
            if (root == null) {
                return new NodeValue(Integer.MIN_VALUE, Integer.MAX_VALUE, 0);
            }
            NodeValue left = largestBSTSubtreeHelper(root.left);
            NodeValue right = largestBSTSubtreeHelper(root.right);
            if (left.maxNode < root.val && root.val < right.minNode) {
                return new NodeValue(Math.max(root.val, right.maxNode), Math.min(root.val, left.minNode),
                        left.maxSize + right.maxSize + 1);
            }
            return new NodeValue(Integer.MAX_VALUE, Integer.MIN_VALUE, Math.max(left.maxSize, right.maxSize));
        }

        public int largestBSTSubtree(TreeNode root) {
            return largestBSTSubtreeHelper(root).maxSize;
        }
    }
}
