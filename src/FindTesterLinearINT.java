import java.util.List;

public class FindTesterLinearINT<Key,TreeType extends Tree<Integer, Integer>> extends TreeAnalyzer<TreeType,Key> {


    public FindTesterLinearINT(TreeType tree, int repNumb, int stepSize, int stepCount, String name) {
        super(tree, repNumb, stepSize, stepCount, name);
    }

    @Override
    public void prepare(List<Key> list) {
        for (int i = 0; i < getStepSize() * getCurrentStep(); i++) {
            list.add((Key) Integer.valueOf(i));
            getTree().insert(i,i);
        }
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