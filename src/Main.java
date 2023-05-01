import java.util.Scanner;
public class Main {

    public static void methodAVL() {
        System.out.println("Method 0 is executed");

        //avl
        avl_tree<Integer,Integer> avl_tree = new avl_tree<>();
        InsertTesterLinearINT<Integer,avl_tree<Integer,Integer>> testerLinearINT_avl = new InsertTesterLinearINT<>(avl_tree,50, 100, 750, "Linear/AVL_MAP/I-L-AVL-INT.csv");
        testerLinearINT_avl.analyze();

        InsertTesterRNGINT<Integer,avl_tree<Integer,Integer>> testerRNGINT_avl = new InsertTesterRNGINT<>(avl_tree,50, 100, 750, "RNG/AVL_MAP/I-R-AVL-INT.csv");
        testerRNGINT_avl.analyze();

        FindTesterLinearINT<Integer,avl_tree<Integer,Integer>> testerLinearINT_avlF = new FindTesterLinearINT<>(avl_tree,50, 100, 750, "Linear/AVL_MAP/F-L-AVL-INT.csv");
        testerLinearINT_avlF.analyze();

        FindTesterRNGINT<Integer,avl_tree<Integer,Integer>> testerRNGINT_avlF = new FindTesterRNGINT<>(avl_tree,50, 100, 750, "RNG/AVL_MAP/F-R-AVL-INT.csv");
        testerRNGINT_avlF.analyze();

        RemoveTesterLinearINT<Integer,avl_tree<Integer,Integer>> testerLinearINT_avlR = new RemoveTesterLinearINT<>(avl_tree,50, 100, 750, "Linear/AVL_MAP/R-L-AVL-INT.csv");
        testerLinearINT_avlR.analyze();

        RemoveTesterRNGINT<Integer,avl_tree<Integer,Integer>> testerRNGINT_avlR = new RemoveTesterRNGINT<>(avl_tree,50, 100, 750, "RNG/AVL_MAP/R-R-AVL-INT.csv");
        testerRNGINT_avlR.analyze();

        avl_tree<String,Integer> avl_trees = new avl_tree<>();
        InsertTesterLinearString<String,avl_tree<String,Integer>> testerLinearString_avl = new InsertTesterLinearString<>(avl_trees,50, 100, 750, "RNG/AVL_MAP/I-L-AVL-String.csv");
        testerLinearString_avl.analyze();

        InsertTesterRNGString<String,avl_tree<String,Integer>> testerRNGString_avl = new InsertTesterRNGString<>(avl_trees,50, 100, 750, "RNG/AVL_MAP/I-R-AVL-String.csv");
        testerRNGString_avl.analyze();

        FindTesterLinearString<String,avl_tree<String,Integer>> testerLinearString_avlF = new FindTesterLinearString<>(avl_trees,50, 100, 750, "Linear/AVL_MAP/F-L-AVL-String.csv");
        testerLinearString_avlF.analyze();

        FindTesterRNGString<String,avl_tree<String,Integer>> testerRNGString_avlF = new FindTesterRNGString<>(avl_trees,50, 100, 750, "RNG/AVL_MAP/F-R-AVL-String.csv");
        testerRNGString_avlF.analyze();

        RemoveTesterLinearString<String,avl_tree<String,Integer>> testerLinearString_avlR = new RemoveTesterLinearString<>(avl_trees,50, 100, 750, "Linear/AVL_MAP/R-L-AVL-String.csv");
        testerLinearString_avlR.analyze();

        RemoveTesterRNGString<String,avl_tree<String,Integer>> testerRNGString_avlR = new RemoveTesterRNGString<>(avl_trees,50, 100, 750, "RNG/AVL_MAP/R-R-AVL-String.csv");
        testerRNGString_avlR.analyze();
    }

    public static void methodSPLAY() {
        System.out.println("Method 1 is executed");

        //splay

        splay_tree<Integer,Integer> splay_tree = new splay_tree<>();
        InsertTesterLinearINT<Integer,splay_tree<Integer,Integer>> testerLinearINT_splay = new InsertTesterLinearINT<>(splay_tree,50, 100, 750, "Linear/splay_tree/I-L-SPLAY-INT.csv");
        testerLinearINT_splay.analyze();

        InsertTesterRNGINT<Integer,splay_tree<Integer,Integer>> testerRNGINT_splay = new InsertTesterRNGINT<>(splay_tree,50, 100, 75, "Linear/splay_treeNEW/I-R-SPLAY-INT.csv");
        testerRNGINT_splay.analyze();

        FindTesterRNGINT<Integer,splay_tree<Integer,Integer>> testerRNGINT_splay_treeF = new FindTesterRNGINT<>(splay_tree,50, 100, 75, "RNG/splay_treeNEW/F-R-AVL-SPLAY.csv");
        testerRNGINT_splay_treeF.analyze();

        FindTesterLinearINT<Integer,splay_tree<Integer,Integer>> testerLinearINT_splay_treeF = new FindTesterLinearINT<>(splay_tree,50, 100, 750, "Linear/splay_tree/F-L-SPLAY-INT.csv");
        testerLinearINT_splay_treeF.analyze();

        RemoveTesterLinearINT<Integer,splay_tree<Integer,Integer>> testerLinearINT_splay_treeR = new RemoveTesterLinearINT<>(splay_tree,25, 500, 800, "Linear/splay_tree/R-L-SPLAY-INT5.csv");
        testerLinearINT_splay_treeR.analyze();

        RemoveTesterRNGINT<Integer,splay_tree<Integer,Integer>> testerRNGINT_splay_treeR = new RemoveTesterRNGINT<>(splay_tree,25, 500, 800, "RNG/splay_tree/R-R-SPLAY-INT5.csv");
        testerRNGINT_splay_treeR.analyze();

        splay_tree<String,Integer> splay_trees = new splay_tree<>();
        InsertTesterLinearString<String,splay_tree<String,Integer>> testerLinearString_splay = new InsertTesterLinearString<>(splay_trees,50, 100, 750, "RNG/splay_tree/I-L-SPLAY-String.csv");
        testerLinearString_splay.analyze();

        InsertTesterRNGString<String,splay_tree<String,Integer>> testerRNGString_splay = new InsertTesterRNGString<>(splay_trees,50, 100, 750, "RNG/splay_tree/I-R-SPLAY-String.csv");
        testerRNGString_splay.analyze();

        FindTesterLinearString<String,splay_tree<String,Integer>> testerLinearString_splay_treeF = new FindTesterLinearString<>(splay_trees,50, 100, 750, "Linear/splay_tree/F-L-SPLAY-String.csv");
        testerLinearString_splay_treeF.analyze();

        FindTesterRNGString<String,splay_tree<String,Integer>> testerRNGString_splay_treeF = new FindTesterRNGString<>(splay_trees,50, 100, 750, "RNG/splay_tree/F-R-SPLAY-String.csv");
        testerRNGString_splay_treeF.analyze();

        RemoveTesterLinearString<String,splay_tree<String,Integer>> testerLinearString_splay_treeR = new RemoveTesterLinearString<>(splay_trees,25, 500, 800, "Linear/splay_tree/R-L-SPLAY-String5.csv");
        testerLinearString_splay_treeR.analyze();

        RemoveTesterRNGString<String,splay_tree<String,Integer>> testerRNGString_splay_treeR = new RemoveTesterRNGString<>(splay_trees,25, 500, 800, "RNG/splay_tree/R-R-SPLAY-String5.csv");
        testerRNGString_splay_treeR.analyze();
    }

    public static void methodScapegoat() {
        System.out.println("Method 2 is executed");

        //sg
        ScapeGoatTree<Integer,Integer> sg_tree_ = new ScapeGoatTree<>();
        InsertTesterLinearINT<Integer,ScapeGoatTree<Integer,Integer>> testerLinearINT_sg = new InsertTesterLinearINT<>(sg_tree_,50, 100, 750, "Linear/sg_tree/I-L-SG-INT1.csv");
        testerLinearINT_sg.analyze();

        InsertTesterRNGINT<Integer,ScapeGoatTree<Integer,Integer>> testerRNGINT_sg = new InsertTesterRNGINT<>(sg_tree_,50, 100, 750, "Linear/sg_tree/I-R-SG-INT.csv");
        testerRNGINT_sg.analyze();

        FindTesterLinearINT<Integer,ScapeGoatTree<Integer,Integer>> testerLinearINT_ScapeGoatTreeF = new FindTesterLinearINT<>(sg_tree_,50, 100, 750, "Linear/sg_tree/F-L-SG-INT.csv");
        testerLinearINT_ScapeGoatTreeF.analyze();

        FindTesterRNGINT<Integer,ScapeGoatTree<Integer,Integer>> testerRNGINT_ScapeGoatTreeF = new FindTesterRNGINT<>(sg_tree_,50, 100, 750, "RNG/sg_tree/F-R-SG-INT.csv");
        testerRNGINT_ScapeGoatTreeF.analyze();

        RemoveTesterLinearINT<Integer,ScapeGoatTree<Integer,Integer>> testerLinearINT_ScapeGoatTreeR = new RemoveTesterLinearINT<>(sg_tree_,50, 100, 750, "Linear/sg_tree/R-L-SG-INT.csv");
        testerLinearINT_ScapeGoatTreeR.analyze();

        RemoveTesterRNGINT<Integer,ScapeGoatTree<Integer,Integer>> testerRNGINT_ScapeGoatTreeR = new RemoveTesterRNGINT<>(sg_tree_,50, 100, 750, "RNG/sg_tree/R-R-SG-INT.csv");
        testerRNGINT_ScapeGoatTreeR.analyze();

        ScapeGoatTree<String,Integer> sg_tree_s = new ScapeGoatTree<>();
        InsertTesterLinearString<String,ScapeGoatTree<String,Integer>> testerLinearString_sg = new InsertTesterLinearString<>(sg_tree_s,50, 100, 750, "RNG/sg_tree/I-L-SG-String.csv");
        testerLinearString_sg.analyze();

        InsertTesterRNGString<String,ScapeGoatTree<String,Integer>> testerRNGString_sg = new InsertTesterRNGString<>(sg_tree_s,50, 100, 750, "RNG/sg_tree/I-R-SG-String.csv");
        testerRNGString_sg.analyze();

        FindTesterLinearString<String,ScapeGoatTree<String,Integer>> testerLinearString_ScapeGoatTreeF = new FindTesterLinearString<>(sg_tree_s,50, 100, 750, "Linear/sg_tree/F-L-SG-String.csv");
        testerLinearString_ScapeGoatTreeF.analyze();

        FindTesterRNGString<String,ScapeGoatTree<String,Integer>> testerRNGString_ScapeGoatTreeF = new FindTesterRNGString<>(sg_tree_s,50, 100, 750, "RNG/sg_tree/F-R-SG-String.csv");
        testerRNGString_ScapeGoatTreeF.analyze();

        RemoveTesterLinearString<String,ScapeGoatTree<String,Integer>> testerLinearString_ScapeGoatTreeR = new RemoveTesterLinearString<>(sg_tree_s,50, 100, 750, "Linear/sg_tree/R-L-SG-String.csv");
        testerLinearString_ScapeGoatTreeR.analyze();

        RemoveTesterRNGString<String,ScapeGoatTree<String,Integer>> testerRNGString_ScapeGoatTreeR = new RemoveTesterRNGString<>(sg_tree_s,50, 100, 750, "RNG/sg_tree/R-R-SG-String.csv");
        testerRNGString_ScapeGoatTreeR.analyze();
    }

    public static void methodMAP() {
        System.out.println("Method 3 is executed");

        //TreeMap

        treeMap<Integer,Integer> map_tree = new treeMap<>();
        InsertTesterLinearINT<Integer,treeMap<Integer,Integer>> testerLinearINT_splay = new InsertTesterLinearINT<>(map_tree,50, 100, 750, "Linear/MAP/I-L-MAP-INT.csv");
        testerLinearINT_splay.analyze();

        InsertTesterRNGINT<Integer,treeMap<Integer,Integer>> testerRNGINT_splay = new InsertTesterRNGINT<>(map_tree,50, 100, 750, "RNG/MAP/I-R-MAP-INT.csv");
        testerRNGINT_splay.analyze();

        FindTesterLinearINT<Integer,treeMap<Integer,Integer>> testerLinearINT_splay_treeF = new FindTesterLinearINT<>(map_tree,50, 100, 750, "Linear/MAP/F-L-MAP-INT.csv");
        testerLinearINT_splay_treeF.analyze();

        FindTesterRNGINT<Integer,treeMap<Integer,Integer>> testerRNGINT_splay_treeF = new FindTesterRNGINT<>(map_tree,50, 100, 750, "RNG/MAP/F-R-AVL-MAP.csv");
        testerRNGINT_splay_treeF.analyze();

        RemoveTesterLinearINT<Integer,treeMap<Integer,Integer>> testerLinearINT_splay_treeR = new RemoveTesterLinearINT<>(map_tree,50, 100, 750, "Linear/MAP/R-L-MAP-INT.csv");
        testerLinearINT_splay_treeR.analyze();

        RemoveTesterRNGINT<Integer,treeMap<Integer,Integer>> testerRNGINT_splay_treeR = new RemoveTesterRNGINT<>(map_tree,50, 100, 750, "RNG/MAP/R-R-MAP-INT.csv");
        testerRNGINT_splay_treeR.analyze();

        treeMap<String,Integer> map_treeS = new treeMap<>();
        InsertTesterLinearString<String,treeMap<String,Integer>> testerLinearString_splay = new InsertTesterLinearString<>(map_treeS,50, 100, 750, "Linear/MAP/I-L-MAP-String.csv");
        testerLinearString_splay.analyze();

        InsertTesterRNGString<String,treeMap<String,Integer>> testerRNGString_splay = new InsertTesterRNGString<>(map_treeS,50, 100, 750, "RNG/MAP/I-R-MAP-String.csv");
        testerRNGString_splay.analyze();

        FindTesterLinearString<String,treeMap<String,Integer>> testerLinearString_splay_treeF = new FindTesterLinearString<>(map_treeS,50, 100, 750, "Linear/MAP/F-L-MAP-String.csv");
        testerLinearString_splay_treeF.analyze();

        FindTesterRNGString<String,treeMap<String,Integer>> testerRNGString_splay_treeF = new FindTesterRNGString<>(map_treeS,50, 100, 750, "RNG/MAP/F-R-MAP-String.csv");
        testerRNGString_splay_treeF.analyze();

        RemoveTesterLinearString<String,treeMap<String,Integer>> testerLinearString_splay_treeR = new RemoveTesterLinearString<>(map_treeS,50, 100, 750, "Linear/MAP/R-L-MAP-String.csv");
        testerLinearString_splay_treeR.analyze();

        RemoveTesterRNGString<String,treeMap<String,Integer>> testerRNGString_splay_treeR = new RemoveTesterRNGString<>(map_treeS,50, 100, 750, "RNG/MAP/R-R-MAP-String.csv");
        testerRNGString_splay_treeR.analyze();
    }


    public static void main(String[] args) {

        Scanner input = new Scanner(System.in);
        int userInput;

        do {
            System.out.println("Enter a number from 0 to 5 (or enter 99 to exit): ");
            System.out.println("1: testing AVL tree");
            System.out.println("2: testing SPLAY tree ");
            System.out.println("3: testing Scapegoat tree");
            System.out.println("4: testing MAP");

            while (!input.hasNextInt()) {
                input.nextLine(); // Clear the invalid input
                System.out.println("Invalid input");
                System.out.println("Enter a number from 0 to 5 (or enter 99 to exit): ");
                System.out.println("1: testing AVL tree");
                System.out.println("2: testing SPLAY tree ");
                System.out.println("3: testing Scapegoat tree");
                System.out.println("4: testing MAP");
            }
            userInput = input.nextInt();
            switch(userInput) {
                case 0:
                    methodAVL();
                    break;
                case 1:
                    methodSPLAY();
                    break;
                case 2:
                    methodScapegoat();
                    break;
                case 3:
                    methodMAP();
                    break;
                case 99:
                    System.out.println("Exiting program...");
                    input.close();
                    return;
                default:
                    System.out.println("Invalid input");
            }
        } while (true);


    }
}