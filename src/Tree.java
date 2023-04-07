public interface Tree<Key, Data> {
    void put(Key key,Data data);
    boolean get(Key key);
    void remove(Key key);
    void removeAll();
}