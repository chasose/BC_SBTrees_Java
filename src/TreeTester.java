import java.util.ArrayList;
import java.util.List;
import java.util.Collections;
import java.io.*;


public abstract class TreeTester<TreeType> {
    private int numberOfReplications_;
    private int stepCount_;
    private int stepSize_;
    private int currentStep_ = 1;
    private String name_;
    private TreeType tree_;

    public TreeTester(TreeType tree, int repNumb, int stepSize, int stepCount, String name) {
        setNumberOfReplications(repNumb);
        setStepSize(stepSize);
        setStepCount(stepCount);
        setTree(tree);
        setCSVName(name);
    }

    public void setNumberOfReplications(int number) {
        numberOfReplications_ = number;
    }

    public void setStepSize(int number) {
        stepSize_ = number;
    }

    public void setStepCount(int number) {
        stepCount_ = number;
    }

    public void setCSVName(String name) {
        name_ = name;
    }

    public void setTree(TreeType tree) {
        tree_ = tree;
    }

    public String getName() {
        return name_;
    }

    public abstract void analyze();

    protected TreeType getTree() {
        return tree_;
    }

    protected int getNumberOfReplications() {
        return numberOfReplications_;
    }

    protected int getStepCount() {
        return stepCount_;
    }

    protected int getStepSize() {
        return stepSize_;
    }

    protected int getCurrentStep() {
        return currentStep_;
    }

    protected void setCurrentStep(int step) {
        currentStep_ = step;
    }
}

abstract class TreeAnalyzer<TreeType,Key> extends TreeTester<TreeType> {

    public TreeAnalyzer(TreeType tree, int repNumb, int stepSize, int stepCount, String name) {
        super(tree, repNumb, stepSize, stepCount, name);
    }

    public abstract void prepare(List<Key> list);

    public abstract TreeType execute(List<Key> list);

    public abstract void clear();

    @Override
    public void analyze() {
        String filename = getName();
        try {
            File outputFile = new File("CSV_tests/" + filename);
            double divider = getNumberOfReplications();
            List<Key> vector_ = new ArrayList<Key>();

            if (outputFile.exists()) {
                outputFile.delete();
            }

            if (outputFile.createNewFile()) {
                FileWriter writer = new FileWriter(outputFile, true);
                for (int i = 0; i < getStepCount(); i++) {
                    int repNum = getNumberOfReplications();
                    long replicationsDuration = 0;
                    while (repNum > 0) {
                        clear();
                        prepare(vector_);
                        long startTime = System.nanoTime();
                        execute(vector_);
                        long endTime = System.nanoTime();
                        clear();
                        vector_.clear();
                        long duration = endTime - startTime;
                        replicationsDuration += duration;
                        repNum--;
                    }
                    System.out.println(i);
                    double meanTime = replicationsDuration / divider;
                    double currentElements = getStepSize() * getCurrentStep();
                    double timePerOperation = meanTime / currentElements;
                    writer.write(getCurrentStep() * getStepSize() + ";" + meanTime/1000 + ";" + timePerOperation/1000 + "\n");
                    setCurrentStep(getCurrentStep() + 1);
                }
                writer.close();
            } else {
                System.out.println("Error opening file: " + filename);
            }

        } catch (IOException e) {
            System.out.println("An error occurred.");
            e.printStackTrace();
        }
    }
}