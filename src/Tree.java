public interface Tree<Key, Data> {
    void insert(Key key,Data data);
    boolean find(Key key);
    void remove(Key key);
    void removeAll();
}