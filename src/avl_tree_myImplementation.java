class Node<Key extends Comparable<Key>, Data>
{
    Key element;
    Data data;
    int h;  //for height  
    Node<Key,Data> leftChild;
    Node<Key,Data> rightChild;
    int height;
    //default constructor to create null node  
    public Node()
    {
        leftChild = null;
        rightChild = null;
        element = null;
        h = 0;

    }
    // parameterized constructor  
    public Node(Key element, Data data, int height)
    {
        leftChild = null;
        rightChild = null;
        this.element = element;
        this.data = data;
        h = 0;
        this.height = height;
    }
}

// create class ConstructAVLTree for constructing AVL Tree  
public class avl_tree_myImplementation<Key extends Comparable<Key>,Data> implements Tree<Key, Data>
{
    private Node<Key,Data> rootNode;

    //Constructor to set null value to the rootNode  
    public avl_tree_myImplementation()
    {
        rootNode = null;
    }

    //create removeAll() method to make AVL Tree empty  
    public void removeAll()
    {
        rootNode = null;
    }

    // create checkEmpty() method to check whether the AVL Tree is empty or not  
    public boolean checkEmpty()
    {
        if(rootNode == null)
            return true;
        else
            return false;
    }

    // create insertElement() to insert element to to the AVL Tree  
    public void put(Key element, Data data)
    {
        rootNode = insertElement(element,data, rootNode);
    }

    public void remove(Key key) {
        rootNode = deleteNode(rootNode, key);
    }

    //create getHeight() method to get the height of the AVL Tree  
    private int getHeight(Node<Key,Data> node) {
        return node == null ? -1 : node.h;
    }

    //create maxNode() method to get the maximum height from left and right node  
    private int getMaxHeight(int leftNodeHeight, int rightNodeHeight)
    {
        return leftNodeHeight > rightNodeHeight ? leftNodeHeight : rightNodeHeight;
    }

    private int getBalanceFactor(Node<Key,Data> node) {
        return getHeight(node.leftChild) - getHeight(node.rightChild);
    }
    //create insertElement() method to insert data in the AVL Tree recursively   
    private Node<Key,Data> insertElement(Key element, Data data, Node<Key,Data> node) {
        return insertElement(element, data, node, 0);
    }

    private Node<Key,Data> insertElement(Key element, Data data, Node<Key,Data> node, int height) {
        if (node == null)
            return new Node<Key,Data>(element, data, height);

        if (element.compareTo(node.element) < 0) {
            node.leftChild = insertElement(element, data, node.leftChild, height+1);
            if (height(node.leftChild) - height(node.rightChild) == 2) {
                if (element.compareTo(node.leftChild.element) < 0)
                    node = rotateWithLeftChild(node);
                else
                    node = doubleWithLeftChild(node);
            }
        }
        else if (element.compareTo(node.element) > 0) {
            node.rightChild = insertElement(element, data, node.rightChild, height+1);
            if (height(node.rightChild) - height(node.leftChild) == 2) {
                if (element.compareTo(node.rightChild.element) > 0)
                    node = rotateWithRightChild(node);
                else
                    node = doubleWithRightChild(node);
            }
        }

        node.h = 1 + Math.max(height(node.leftChild), height(node.rightChild));
        return node;
    }

    private int height(Node<Key,Data> node) {
        return node == null ? -1 : node.h;
    }

    private Node<Key,Data> deleteNode(Node<Key,Data> node, Key key) {
        if (node == null) {
            return null;
        } else if (key.compareTo(node.element) < 0) {
            node.leftChild = deleteNode(node.leftChild, key);
        } else if (key.compareTo(node.element) > 0) {
            node.rightChild = deleteNode(node.rightChild, key);
        } else {
            // node to be deleted has one or no child
            if (node.leftChild == null) {
                return node.rightChild;
            } else if (node.rightChild == null) {
                return node.leftChild;
            }

            // node to be deleted has two children
            Node<Key,Data> temp = getMinValueNode(node.rightChild);
            node.element = temp.element;
            node.data = temp.data;
            node.rightChild = deleteNode(node.rightChild, temp.element);
        }

        // update the height of the current node
        node.h = getMaxHeight(getHeight(node.leftChild), getHeight(node.rightChild)) + 1;

        // balance the current node
        int balance = getHeight(node.leftChild) - getHeight(node.rightChild);
        if (balance > 1) {
            if (getHeight(node.leftChild.leftChild) >= getHeight(node.leftChild.rightChild)) {
                node = rotateWithLeftChild(node);
            } else {
                node = doubleWithLeftChild(node);
            }
        } else if (balance < -1) {
            if (getHeight(node.rightChild.rightChild) >= getHeight(node.rightChild.leftChild)) {
                node = rotateWithRightChild(node);
            } else {
                node = doubleWithRightChild(node);
            }
        }

        return node;
    }

    // get the node with the minimum value in the subtree rooted at node
    private Node<Key,Data> getMinValueNode(Node<Key,Data> node) {
        Node<Key,Data> current = node;
        while (current.leftChild != null) {
            current = current.leftChild;
        }
        return current;
    }

    // creating rotateWithLeftChild() method to perform rotation of binary tree node with left child        
    private Node<Key,Data> rotateWithLeftChild(Node<Key,Data> node2)
    {
        Node<Key,Data> node1 = node2.leftChild;
        node2.leftChild = node1.rightChild;
        node1.rightChild = node2;
        node2.h = getMaxHeight( getHeight( node2.leftChild ), getHeight( node2.rightChild ) ) + 1;
        node1.h = getMaxHeight( getHeight( node1.leftChild ), node2.h ) + 1;
        return node1;
    }

    // creating rotateWithRightChild() method to perform rotation of binary tree node with right child        
    private Node<Key,Data> rotateWithRightChild(Node<Key,Data> node1)
    {
        Node<Key,Data> node2 = node1.rightChild;
        node1.rightChild = node2.leftChild;
        node2.leftChild = node1;
        node1.h = getMaxHeight( getHeight( node1.leftChild ), getHeight( node1.rightChild ) ) + 1;
        node2.h = getMaxHeight( getHeight( node2.rightChild ), node1.h ) + 1;
        return node2;
    }

    //create doubleWithLeftChild() method to perform double rotation of binary tree node. This method first rotate the left child with its right child, and after that, node3 with the new left child  
    private Node<Key,Data> doubleWithLeftChild(Node<Key,Data> node3)
    {
        node3.leftChild = rotateWithRightChild( node3.leftChild );
        return rotateWithLeftChild( node3 );
    }

    //create doubleWithRightChild() method to perform double rotation of binary tree node. This method first rotate the right child with its left child and after that node1 with the new right child  
    private Node<Key,Data> doubleWithRightChild(Node<Key,Data> node1)
    {
        node1.rightChild = rotateWithLeftChild( node1.rightChild );
        return rotateWithRightChild( node1 );
    }

    //create getTotalNumberOfNodes() method to get total number of nodes in the AVL Tree  
    public int getTotalNumberOfNodes()
    {
        return getTotalNumberOfNodes(rootNode);
    }
    private int getTotalNumberOfNodes(Node<Key,Data> head)
    {
        if (head == null)
            return 0;
        else
        {
            int length = 1;
            length = length + getTotalNumberOfNodes(head.leftChild);
            length = length + getTotalNumberOfNodes(head.rightChild);
            return length;
        }
    }

    //create searchElement() method to find an element in the AVL Tree  
    public boolean get(Key element)
    {
        return searchElement(rootNode, element);
    }

    private boolean searchElement(Node<Key,Data> head, Key element)
    {
        boolean check = false;
        while ((head != null) && !check)
        {
            int compareResult = element.compareTo(head.element);
            if (compareResult < 0)
                head = head.leftChild;
            else if (compareResult > 0)
                head = head.rightChild;
            else
            {
                check = true;
                break;
            }
            check = searchElement(head, element);
        }
        return check;
    }
    // create inorderTraversal() method for traversing AVL Tree in in-order form  
    public void inorderTraversal()
    {
        inorderTraversal(rootNode);
    }
    private void inorderTraversal(Node<Key,Data> head)
    {
        if (head != null)
        {
            inorderTraversal(head.leftChild);
            System.out.print(head.element+" ");
            inorderTraversal(head.rightChild);
        }
    }

    // create preorderTraversal() method for traversing AVL Tree in pre-order form  
    public void preorderTraversal()
    {
        preorderTraversal(rootNode);
    }
    private void preorderTraversal(Node<Key,Data> head)
    {
        if (head != null)
        {
            System.out.print(head.element+" " + head.data + "\n");
            preorderTraversal(head.leftChild);
            preorderTraversal(head.rightChild);
        }
    }

    // create postorderTraversal() method for traversing AVL Tree in post-order form  
    public void postorderTraversal()
    {
        postorderTraversal(rootNode);
    }

    private void postorderTraversal(Node<Key,Data> head)
    {
        if (head != null)
        {
            postorderTraversal(head.leftChild);
            postorderTraversal(head.rightChild);
            System.out.print(head.element+" "+ head.data + "\n");
        }
    }
}  