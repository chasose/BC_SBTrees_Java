import it.unimi.dsi.fastutil.objects.Object2ObjectAVLTreeMap;

public class avl_tree<Key extends Comparable<Key>, Data> implements Tree<Key, Data> {
    private Object2ObjectAVLTreeMap<Key, Data> map;

    public avl_tree() {
        map = new Object2ObjectAVLTreeMap<>();
    }

    @Override
    public void put(Key key, Data data) {
        map.put(key, data);
    }

    @Override
    public boolean get(Key key) {
        return map.containsKey(key);
    }

    @Override
    public void remove(Key key) {
        map.remove(key);
    }

    @Override
    public void removeAll() {
        map.clear();
    }
}