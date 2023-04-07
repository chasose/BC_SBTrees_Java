import java.util.Collections;
import java.util.List;

public class InsertTesterRNGString<Key,TreeType extends Tree<String, Integer>> extends TreeAnalyzer<TreeType,Key> {


    public InsertTesterRNGString(TreeType tree, int repNumb, int stepSize, int stepCount, String name) {
        super(tree, repNumb, stepSize, stepCount, name);
    }

    @Override
    public void prepare(List<Key> list) {
        String s = "a"; // initial string
        int iterations = getStepSize() * getCurrentStep(); // number of iterations
        for (int i = 0; i < iterations; ++i) {
            // increment the string
            int carry = 1;
            StringBuilder sb = new StringBuilder(s);
            for (int j = sb.length() - 1; j >= 0 && carry > 0; --j) {
                if (sb.charAt(j) == 'z') {
                    sb.setCharAt(j, 'a');
                } else {
                    sb.setCharAt(j, (char) (sb.charAt(j) + 1));
                    carry = 0;
                }
            }
            if (carry > 0) {
                sb.insert(0, 'a');
            }
            s = sb.toString();
            list.add((Key) String.valueOf(s));
        }
        Collections.shuffle(list);
    }

    @Override
    public TreeType execute(List<Key> list) {
        for (int i = 0; i < list.size(); i++) {
            getTree().put((String)list.get(i), i);
        }
        return getTree();
    }

    @Override
    public void clear() {
        getTree().removeAll();
    }
}