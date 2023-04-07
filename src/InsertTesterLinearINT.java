import java.util.List;

public class InsertTesterLinearINT<Key,TreeType extends Tree<Integer, Integer>> extends TreeAnalyzer<TreeType,Key> {


    public InsertTesterLinearINT(TreeType tree, int repNumb, int stepSize, int stepCount, String name) {
        super(tree, repNumb, stepSize, stepCount, name);
    }

    @Override
    public void prepare(List<Key> list) {
        for (int i = 0; i < getStepSize() * getCurrentStep(); i++) {
            list.add((Key) Integer.valueOf(i));
        }
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