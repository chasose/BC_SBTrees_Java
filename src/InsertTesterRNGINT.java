import java.util.Collections;
import java.util.List;

public class InsertTesterRNGINT<Key,TreeType extends Tree<Integer, Integer>> extends TreeAnalyzer<TreeType,Key> {


    public InsertTesterRNGINT(TreeType tree, int repNumb, int stepSize, int stepCount, String name) {
        super(tree, repNumb, stepSize, stepCount, name);
    }

    @Override
    public void prepare(List<Key> list) {
        for (int i = 0; i < getStepSize() * getCurrentStep(); i++) {
            list.add((Key) Integer.valueOf(i));
        }
        Collections.shuffle(list);
    }

    @Override
    public TreeType execute(List<Key> list) {
        for (int i = 0; i < list.size(); i++) {
            getTree().put((Integer)list.get(i), i);
        }
        return getTree();
    }

    @Override
    public void clear() {
        getTree().removeAll();
    }
}