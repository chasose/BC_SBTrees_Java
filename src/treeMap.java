import java.util.TreeMap;

public class treeMap<Key extends Comparable<Key>, Data> implements Tree<Key, Data> {
    private TreeMap<Key, Data> map;

    public treeMap() {
        map = new TreeMap<>();
    }

    @Override
    public void put(Key key, Data value) {
        map.put(key, value);
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