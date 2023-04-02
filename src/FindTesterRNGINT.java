import java.util.Collections;
import java.util.List;

public class FindTesterRNGINT<Key,TreeType extends Tree<Integer, Integer>> extends TreeAnalyzer<TreeType,Key> {


    public FindTesterRNGINT(TreeType tree, int repNumb, int stepSize, int stepCount, String name) {
        super(tree, repNumb, stepSize, stepCount, name);
    }

    @Override
    public void prepare(List<Key> list) {
        for (int i = 0; i < getStepSize() * getCurrentStep(); i++) {
            list.add((Key) Integer.valueOf(i));
            getTree().insert(i, i);
        }
        Collections.shuffle(list);
    }

    @Override
    public TreeType execute(List<Key> list) {
        for (Key key : list) {
            getTree().find((Integer) key);
        }
        return getTree();
    }

    @Override
    public void clear() {
        getTree().removeAll();
    }
}