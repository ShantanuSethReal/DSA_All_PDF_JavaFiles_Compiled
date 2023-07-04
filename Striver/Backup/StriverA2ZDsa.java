public class StriverA2ZDsa {
    //***************************Linked List***************************************************************** */
    class Solution {
        // Function to insert a node at the beginning of the linked list.
        Node insertAtBeginning(Node head, int x) {
            // code here
            Node temp = new Node(x);
            temp.next = head;
            return temp;
        }

        // Function to insert a node at the end of the linked list.
        Node insertAtEnd(Node head, int x) {
            // code here
            if (head == null) {
                return new Node(x);
            }
            Node curr = head;
            while (curr != null && curr.next != null) {
                curr = curr.next;
            }
            Node temp = new Node(x);
            curr.next = temp;
            temp.next = null;
            return head;

        }
    }
    
    class Solution {
        // Function to count nodes of a linked list.
        public static int getCount(Node head) {

            // Code here
            int len = 0;
            Node curr = head;
            while (curr != null) {
                len++;
                curr = curr.next;
            }
            return len;
        }
    }
    
    class GfG {
        Node deleteNode(Node head, int x) {
            // Your code here
            int len = 0;
            Node prev = head;
            Node curr = head;
            if (x == 1) {
                return head.next;
            }
            while (curr.next != null && len != (x - 1)) {
                prev = curr;
                len++;
                curr = curr.next;
            }
            prev.next = curr.next;
            return head;
        }
    }
   
    Introduction to Trees		

Binary Tree Representation in C++		
Binary Tree Representation in Java		
Binary Tree Traversals in Binary Tr…		
Preorder Traversal of Binary Tree			
Inorder Traversal of Binary Tree			
Post-order Traversal of Binary Tree		
	
Level order Traversal / Level order…		
	
Iterative Preorder Traversal of Bin…		
	
Iterative Inorder Traversal of Bina…		
	
Post-order Traversal of Binary Tree…		
	
Post-order Traversal of Binary Tree…		
	
Preorder, Inorder, and Postorder Tr…		

Height of a Binary Tree		
	
Check if the Binary tree is height-…		
	
Diameter of Binary Tree		
	
Maximum path sum		
	
Check if two trees are identical or…		
	
Zig Zag Traversal of Binary Tree		
	
Boundary Traversal of Binary Tree		
	
Vertical Order Traversal of Binary …		
	
Top View of Binary Tree		

Bottom View of Binary Tree		

Right/Left View of Binary Tree		
	
Symmetric Binary Tree		
	
Root to Node Path in Binary Tree		

LCA in Binary Tree		
	
Maximum width of a Binary Tree		
	
Check for Children Sum Property		

Print all the Nodes at a distance o…		
	
Minimum time taken to BURN the Bina…		

Count total Nodes in a COMPLETE Bin…		
	
Requirements needed to construct a …		

Construct Binary Tree from inorder …		
	
Construct the Binary Tree from Post…		
	
Serialize and deserialize Binary Tr…		
	
Morris Preorder Traversal of a Bina…		
	
Morris Inorder Traversal of a Binar…		
	
Flatten Binary Tree to LinkedList		
	
}
