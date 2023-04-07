import java.util.Collections;
import java.util.List;

public class RemoveTesterRNGINT<Key,TreeType extends Tree<Integer, Integer>> extends TreeAnalyzer<TreeType,Key> {


    public RemoveTesterRNGINT(TreeType tree, int repNumb, int stepSize, int stepCount, String name) {
        super(tree, repNumb, stepSize, stepCount, name);
    }

    @Override
    public void prepare(List<Key> list) {
        for (int i = 0; i < getStepSize() * getCurrentStep(); i++) {
            list.add((Key) Integer.valueOf(i));
            getTree().put(i,i);
        }
        Collections.shuffle(list);
    }

    @Override
    public TreeType execute(List<Key> list) {
        for (Key key : list) {
            getTree().remove((Integer) key);
        }
        return getTree();
    }

    @Override
    public void clear() {
        getTree().removeAll();
    }
}