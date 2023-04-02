class SGTNode<Key extends Comparable<Key>, Data> {
    SGTNode<Key,Data> right, left, parent;
    Key value;
    Data data;

    public SGTNode(Key val, Data data_) {
        value = val;
        data = data_;
    }
}

/* Class ScapeGoatTree */
class ScapeGoatTree<Key extends Comparable<Key>,Data> implements Tree<Key, Data>
{
    private SGTNode<Key,Data> root;
    private int n, q;

    /* Constructor */
    public ScapeGoatTree()
    {
        root = null;
        // size = 0
        n = 0;
    }
    /* Function to check if tree is empty */
    public boolean isEmpty()
    {
        return root == null;
    }
    /* Function to clear  tree */
    public void makeEmpty()
    {
        root = null;
        n = 0;
    }
    /* Function to count number of nodes recursively */
    private int size(SGTNode<Key,Data> r)
    {
        if (r == null)
            return 0;
        else
        {
            int l = 1;
            l += size(r.left);
            l += size(r.right);
            return l;
        }
    }
    /* Functions to search for an element */
    public boolean find(Key val)
    {
        return search(root, val);
    }
    /* Function to search for an element recursively */
    private boolean search(SGTNode<Key,Data> r, Key val)
    {
        boolean found = false;
        while ((r != null) && !found)
        {
            Key rval = r.value;
            if (val.compareTo(rval) < 0)
                r = r.left;
            else if (val.compareTo(rval) > 0)
                r = r.right;
            else
            {
                found = true;
                break;
            }
            found = search(r, val);
        }
        return found;
    }
    /* Function to return current size of tree */
    public int size()
    {
        return n;
    }
    /* Function for inorder traversal */
    public void inorder()
    {
        inorder(root);
    }
    private void inorder(SGTNode<Key,Data> r)
    {
        if (r != null)
        {
            inorder(r.left);
            System.out.print(r.value +" ");
            inorder(r.right);
        }
    }
    /* Function for preorder traversal */
    public void preorder()
    {
        preorder(root);
    }
    private void preorder(SGTNode<Key,Data> r)
    {
        if (r != null)
        {
            System.out.print(r.value +" ");
            preorder(r.left);
            preorder(r.right);
        }
    }
    /* Function for postorder traversal */
    public void postorder()
    {
        postorder(root);
    }
    private void postorder(SGTNode<Key,Data> r)
    {
        if (r != null)
        {
            postorder(r.left);
            postorder(r.right);
            System.out.print(r.value +" ");
        }
    }
    private static final int log32(int q)
    {
        final double log23 = 2.4663034623764317;
        return (int)Math.ceil(log23*Math.log(q));
    }
    /* Function to insert an element */
    public void insert(Key x,Data data_)
    {
        if (root == null) {
            root = new SGTNode<Key,Data>(x, data_);
            return;
        }
        /* first do basic insertion keeping track of depth */
        SGTNode<Key,Data> u = new SGTNode<Key,Data>(x,data_);
        int d = addWithDepth(u);
        if (d > log32(q)) {
            /* depth exceeded, find scapegoat */
            SGTNode<Key,Data> w = u.parent;
            while (4*size(w) <= 3*size(w.parent))
                w = w.parent;
            rebuild(w.parent);
        }

    }
    /* Function to rebuild tree from node u */
    protected void rebuild(SGTNode<Key,Data> u)
    {
        if (u == null) {
            return;
        }
        int ns = size(u);
        SGTNode<Key,Data> p = u.parent;
        SGTNode<Key,Data>[] a = new SGTNode[ns];
        packIntoArray(u, a, 0);
        if (p == null)
        {
            root = buildBalanced(a, 0, ns);
            if (root != null) {
                root.parent = null;
            }
        }
        else if (p.right == u)
        {
            p.right = buildBalanced(a, 0, ns);
            p.right.parent = p;
        }
        else
        {
            p.left = buildBalanced(a, 0, ns);
            p.left.parent = p;
        }


    }
    /* Function to packIntoArray */
    protected int packIntoArray(SGTNode<Key,Data> u, SGTNode<Key,Data>[] a, int i)
    {
        if (u == null)
        {
            return i;
        }
        i = packIntoArray(u.left, a, i);
        a[i++] = u;
        return packIntoArray(u.right, a, i);
    }
    /* Function to build balanced nodes */
    protected SGTNode<Key,Data> buildBalanced(SGTNode<Key,Data>[] a, int i, int ns)
    {
        if (ns == 0)
            return null;
        int m = ns / 2;
        a[i + m].left = buildBalanced(a, i, m);
        if (a[i + m].left != null)
            a[i + m].left.parent = a[i + m];
        a[i + m].right = buildBalanced(a, i + m + 1, ns - m - 1);
        if (a[i + m].right != null)
            a[i + m].right.parent = a[i + m];
        return a[i + m];
    }
    /* Function add with depth */
    public int addWithDepth(SGTNode<Key,Data> u)
    {
        SGTNode<Key,Data> w = root;
        if (w == null)
        {
            root = u;
            n++;
            q++;
            return 0;
        }
        boolean done = false;
        int d = 0;
        do {

            if (u.value.compareTo(w.value) < 0)
            {
                if (w.left == null)
                {
                    w.left = u;
                    u.parent = w;
                    done = true;
                }
                else
                {
                    w = w.left;
                }
            }
            else if (u.value.compareTo(w.value) > 0)
            {
                if (w.right == null)
                {
                    w.right = u;
                    u.parent = w;
                    done = true;
                }
                w = w.right;
            }
            else
            {
                return -1;
            }
            d++;
        } while (!done);
        n++;
        q++;
        return d;
    }

    public void remove(Key key) {
        root = remove(root, key);
    }

    /* Function to remove a node recursively */
    private SGTNode<Key,Data> remove(SGTNode<Key,Data> node, Key key) {
        if (node == null) {
            return null;
        }
        if (key.compareTo(node.value) < 0) {
            node.left = remove(node.left, key);
        } else if (key.compareTo(node.value) > 0) {
            node.right = remove(node.right, key);
        } else {
            if (node.left == null) {
                return node.right;
            } else if (node.right == null) {
                return node.left;
            } else {
                SGTNode<Key,Data> successor = getMin(node.right);
                node.value = successor.value;
                node.right = remove(node.right, successor.value);
            }
        }
        return node;
    }

    /* Function to get the minimum node in the tree rooted at node */
    private SGTNode<Key,Data> getMin(SGTNode<Key,Data> node) {
        while (node.left != null) {
            node = node.left;
        }
        return node;
    }

    public void removeAll() {
        root = null;
        n = 0;
    }
}