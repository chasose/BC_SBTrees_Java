public class splay_tree<Key extends Comparable<Key>, Data> implements Tree<Key,Data> {

    private Node root;   // root of the BST

    // BST helper node data type
    private class Node {
        private Key key;            // key
        private Data value;        // associated data
        private Node left, right;   // left and right subtrees

        public Node(Key key, Data value) {
            this.key = key;
            this.value = value;
        }
    }

    public void removeAll() {
        root = null;
    }

    public boolean get(Key key) {
        return contains(key) != null;
    }

    // return value associated with the given key
    // if no such value, return null
    public Data contains(Key key) {
        root = splay(root, key);
        int cmp = key.compareTo(root.key);
        if (cmp == 0) return root.value;
        else return null;
    }

    /***************************************************************************
     *  Splay tree insertion.
     ***************************************************************************/
    public void put(Key key, Data value) {
        // splay key to root
        if (root == null) {
            root = new Node(key, value);
            return;
        }

        root = splay(root, key);

        int cmp = key.compareTo(root.key);

        // Insert new node at root
        if (cmp < 0) {
            Node n = new Node(key, value);
            n.left = root.left;
            n.right = root;
            root.left = null;
            root = n;
        }

        // Insert new node at root
        else if (cmp > 0) {
            Node n = new Node(key, value);
            n.right = root.right;
            n.left = root;
            root.right = null;
            root = n;
        }

        // It was a duplicate key. Simply replace the value
        else {
            root.value = value;
        }

    }

    /***************************************************************************
     *  Splay tree deletion.
     ***************************************************************************/
    /* This splays the key, then does a slightly modified Hibbard deletion on
     * the root (if it is the node to be deleted; if it is not, the key was
     * not in the tree). The modification is that rather than swapping the
     * root (call it node A) with its successor, it's successor (call it structures.Node B)
     * is moved to the root position by splaying for the deletion key in A's
     * right subtree. Finally, A's right child is made the new root's right
     * child.
     */
    public void remove(Key key) {
        if (root == null) return; // empty tree

        root = splay(root, key);

        int cmp = key.compareTo(root.key);

        if (cmp == 0) {
            if (root.left == null) {
                root = root.right;
            } else {
                Node x = root.right;
                root = root.left;
                splay(root, key);
                root.right = x;
            }
        }

        // else: it wasn't in the tree to remove
    }


    /***************************************************************************
     * Splay tree function.
     * **********************************************************************/
    // splay key in the tree rooted at structures.Node h. If a node with that key exists,
    //   it is splayed to the root of the tree. If it does not, the last node
    //   along the search path for the key is splayed to the root.
    private Node splay(Node h, Key key) {
        if (h == null) return null;

        Node dummy = new Node(null, null); // dummy node to simplify tree rotations
        Node left = dummy, right = dummy;
        while (true) {
            int cmp = key.compareTo(h.key);
            if (cmp < 0) {
                if (h.left == null) break;
                if (key.compareTo(h.left.key) < 0) {
                    h = rotateRight(h);
                    if (h.left == null) break;
                }
                right.left = h;
                right = h;
                h = h.left;
            } else if (cmp > 0) {
                if (h.right == null) break;
                if (key.compareTo(h.right.key) > 0) {
                    h = rotateLeft(h);
                    if (h.right == null) break;
                }
                left.right = h;
                left = h;
                h = h.right;
            } else {
                break;
            }
        }
        left.right = h.left;
        right.left = h.right;
        h.left = dummy.right;
        h.right = dummy.left;
        return h;
    }


    /***************************************************************************
     *  Helper functions.
     ***************************************************************************/

    // height of tree (1-node tree has height 0)
    public int height() {
        return height(root);
    }

    private int height(Node x) {
        if (x == null) return -1;
        return 1 + Math.max(height(x.left), height(x.right));
    }


    public int size() {
        return size(root);
    }

    private int size(Node x) {
        if (x == null) return 0;
        else return 1 + size(x.left) + size(x.right);
    }

    // right rotate
    private Node rotateRight(Node h) {
        Node x = h.left;
        h.left = x.right;
        x.right = h;
        return x;
    }

    // left rotate
    private Node rotateLeft(Node h) {
        Node x = h.right;
        h.right = x.left;
        x.left = h;
        return x;
    }
}