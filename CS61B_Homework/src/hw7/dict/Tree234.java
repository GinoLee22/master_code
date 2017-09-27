/* Tree234.java */

package hw7.dict;

/**
 * A Tree234 implements an ordered integer dictionary ADT using a 2-3-4 tree.
 * Only int keys are stored; no object is associated with each key.  Duplicate
 * keys are not stored in the tree.
 *
 * @author Jonathan Shewchuk
 **/
public class Tree234 extends IntDictionary {

    /**
     * You may add fields if you wish, but don't change anything that
     * would prevent toString() or find() from working correctly.
     * <p>
     * (inherited)  size is the number of keys in the dictionary.
     * root is the root of the 2-3-4 tree.
     **/
    Tree234Node root;

    /**
     * Tree234() constructs an empty 2-3-4 tree.
     * <p>
     * You may change this constructor, but you may not change the fact that
     * an empty Tree234 contains no nodes.
     */
    public Tree234() {
        root = null;
        size = 0;
    }

    /**
     * toString() prints this Tree234 as a String.  Each node is printed
     * in the form such as (for a 3-key node)
     * <p>
     * (child1)key1(child2)key2(child3)key3(child4)
     * <p>
     * where each child is a recursive call to toString, and null children
     * are printed as a space with no parentheses.  Here's an example.
     * ((1)7(11 16)22(23)28(37 49))50((60)84(86 95 100))
     * <p>
     * DO NOT CHANGE THIS METHOD.  The test code depends on it.
     *
     * @return a String representation of the 2-3-4 tree.
     **/
    public String toString() {
        if (root == null) {
            return "";
        } else {
      /* Most of the work is done by Tree234Node.toString(). */
            return root.toString();
        }
    }

    /**
     * printTree() prints this Tree234 as a tree, albeit sideways.
     * <p>
     * You're welcome to change this method if you like.  It won't be tested.
     **/
    public void printTree() {
        if (root != null) {
      /* Most of the work is done by Tree234Node.printSubtree(). */
            root.printSubtree(0);
        }
    }

    /**
     * find() prints true if "key" is in this 2-3-4 tree; false otherwise.
     *
     * @param key is the key sought.
     * @return true if "key" is in the tree; false otherwise.
     **/
    public boolean find(int key) {
        Tree234Node node = root;
        while (node != null) {
            if (key < node.key1) {
                node = node.child1;
            } else if (key == node.key1) {
                return true;
            } else if ((node.keys == 1) || (key < node.key2)) {             // this setting because key2 & key3 are arbitrary when keys == 1.
                node = node.child2;
            } else if (key == node.key2) {
                return true;
            } else if ((node.keys == 2) || (key < node.key3)) {
                node = node.child3;
            } else if (key == node.key3) {
                return true;
            } else {
                node = node.child4;
            }
        }
        return false;
    }

    /**
     * insert() inserts the key "key" into this 2-3-4 tree.  If "key" is
     * already present, a duplicate copy is NOT inserted.
     *
     * @param key is the key sought.
     **/
    public void insert(int key) {
        // Fill in your solution here.
        // the key already in the tree --> no operation
        if (find(key)) {
            return;
        }
        // not duplicate key
        if (root == null) {                         // empty tree
            root = new Tree234Node(null, key);
            size++;
        } else {                                      // non-empty tree
            Tree234Node currentNode = root;
            Tree234Node nextNode = root;
            // 234Tree reconstruction
            while (nextNode != null) {           // loop until the last node
                // 1st: reconstruct the 234Tree if necessary
                if (currentNode.keys == 3) {        // eliminate the 3-key node
                    currentNode = insertReconstructTree(currentNode);
                }
                // 2nd: comparing
                if (key < currentNode.key1) {
                    if (currentNode.child1 != null) {
                        nextNode = currentNode.child1;
                        currentNode = currentNode.child1;
                    } else {
                        nextNode = currentNode.child1;
                    }
                } else if (currentNode.keys == 1 || key < currentNode.key2) {
                    if (currentNode.child2 != null) {
                        nextNode = currentNode.child2;
                        currentNode = currentNode.child2;
                    } else {
                        nextNode = currentNode.child2;
                    }
                } else if (currentNode.keys == 2 || key < currentNode.key3) {      // currentNode.keys == 2
                    if (currentNode.child3 != null) {
                        nextNode = currentNode.child3;
                        currentNode = currentNode.child3;
                    } else {
                        nextNode = currentNode.child3;
                    }
                } else {
                    if (currentNode.child4 != null) {
                        nextNode = currentNode.child4;
                        currentNode = currentNode.child4;
                    } else {
                        nextNode = currentNode.child4;
                    }
                }
            }
            // inserting operation: return back to currentNode.parent --> only 1 key or 2 keys
            if (key < currentNode.key1) {
                currentNode.key3 = currentNode.key2;
                currentNode.key2 = currentNode.key1;
                currentNode.key1 = key;
                currentNode.keys++;
            } else if (currentNode.keys == 1 || key < currentNode.key2) {
                currentNode.key3 = currentNode.key2;
                currentNode.key2 = key;
                currentNode.keys++;
            } else {
                currentNode.key3 = key;
                currentNode.keys++;
            }
        }


    }

    /**
     * reconstruct the 234Tree start from the "node"
     * invariant: the node must be a node with 3 keys: keys == 3
     *
     * @param node return a Tree234Node that should be regarded as current node
     */

    private Tree234Node insertReconstructTree(Tree234Node node) {
        // 3 key node: must change the field; DO NOT create a new object
        Tree234Node left = new Tree234Node(node, node.key1);
        Tree234Node right = new Tree234Node(node, node.key3);

        left.child1 = node.child1;
        left.child2 = node.child2;
        right.child1 = node.child3;
        right.child2 = node.child4;

        if (node.parent == null) {              // 3-key node is root, the size should be increased by 2
//            node.keys = 1;
//            node.key1 = node.key2;
//            node.child1 = left;
//            node.child2 = right;
//            node.child3 = null;
//            node.child4 = null;
//            size += 2;
//            return node;
            root = new Tree234Node(null, node.key2);
            root.keys = 1;
            root.child1 = left;
            root.child2 = right;
            left.parent = root;
            right.parent = root;
            if (node.child1 != null) {
                node.child1.parent = left;
            }
            if (node.child2 != null) {
                node.child2.parent = left;
            }
            if (node.child3 != null) {
                node.child3.parent = right;
            }
            if (node.child4 != null) {
                node.child4.parent = right;
            }
            size += 2;
            return root;
        } else {                                  // not the root, the size should be increased by 1
            if (node.key2 < node.parent.key1) { // left most node is a 3-key node
                // operation of parent key
                node.parent.key3 = node.parent.key2;
                node.parent.key2 = node.parent.key1;
                node.parent.key1 = node.key2;
                // operation of parent children
                node.parent.child4 = node.parent.child3;
                node.parent.child3 = node.parent.child2;
                node.parent.child2 = right;
                node.parent.child1 = left;
            } else if (node.parent.keys == 1 || node.key2 < node.parent.key2) {       // mid node is a 3-key node
                // operation of parent key
                node.parent.key3 = node.parent.key2;
                node.parent.key2 = node.key2;
                // operation of parent children
                node.parent.child4 = node.parent.child3;
                node.parent.child3 = right;
                node.parent.child2 = left;
            } else {                                                                  // right most node is 3-key node
                // operation of parent key
                node.parent.key3 = node.key2;
                // operation of parent children
                node.parent.child4 = right;
                node.parent.child3 = left;
            }
            // operation of node children
            if (node.child1 != null) {
                node.child1.parent = left;
            }
            if (node.child2 != null) {
                node.child2.parent = left;
            }
            if (node.child3 != null) {
                node.child3.parent = right;
            }
            if (node.child4 != null) {
                node.child4.parent = right;
            }
            left.parent = node.parent;
            right.parent = node.parent;
            node.parent.keys += 1;
            size++;
            return node.parent;                                                       // assign node.parent to node for comparing
        }
    }

    /**
     * testHelper() prints the String representation of this tree, then
     * compares it with the expected String, and prints an error message if
     * the two are not equal.
     *
     * @param correctString is what the tree should look like.
     **/
    public void testHelper(String correctString) {
        String treeString = toString();
        System.out.println(treeString);
        if (!treeString.equals(correctString)) {
            System.out.println("ERROR:  Should be " + correctString);
        }
    }

    /**
     * main() is a bunch of test code.  Feel free to add test code of your own;
     * this code won't be tested or graded.
     **/
    public static void main(String[] args) {
//        System.out.println("\n ---------- Self-Testing of insertReconstructTree() \ntestTree1");
//        Tree234 testTree1 = new Tree234();
//        testTree1.root = new Tree234Node(null, 20);
//        testTree1.root.keys = 3;
//        testTree1.root.key2 = 40;
//        testTree1.root.key3 = 50;
//        testTree1.root.child1 = new Tree234Node(testTree1.root, 10);
//        testTree1.root.child2 = new Tree234Node(testTree1.root, 25);
//        testTree1.root.child3 = new Tree234Node(testTree1.root, 45);
//        testTree1.root.child4 = new Tree234Node(testTree1.root, 60);
//        System.out.println(testTree1.toString());
//        System.out.println("TestTree1 after reconstruction:");
//        testTree1.insertReconstructTree(testTree1.root);
//        System.out.println(testTree1.toString());
//
//        System.out.println("\ntestTree2");
//        Tree234 testTree2 = new Tree234();
//        testTree2.root = new Tree234Node(null, 40);
//        testTree2.root.keys = 1;
//        testTree2.root.child1 = new Tree234Node(testTree2.root, 10);
//        testTree2.root.child1.keys = 3;
//        testTree2.root.child1.key2 = 20;
//        testTree2.root.child1.key3 = 30;
//        testTree2.root.child2 = new Tree234Node(testTree2.root, 50);
//        System.out.println(testTree2.toString());
//        System.out.println("TestTree2 after reconstruction:");
//        testTree2.insertReconstructTree(testTree2.root.child1);
//        System.out.println(testTree2.toString());
//
//        System.out.println("\ntestTree3");
//        Tree234 testTree3 = new Tree234();
//        testTree3.root = new Tree234Node(null, 40);
//        testTree3.root.keys = 1;
//        testTree3.root.child1 = new Tree234Node(testTree3.root, 30);
//        testTree3.root.child2 = new Tree234Node(testTree3.root, 50);
//        testTree3.root.child2.keys = 3;
//        testTree3.root.child2.key2 = 60;
//        testTree3.root.child2.key3 = 70;
//        System.out.println(testTree3.toString());
//        System.out.println("TestTree3 after reconstruction:");
//        testTree3.insertReconstructTree(testTree3.root.child2);
//        System.out.println(testTree3.toString());
//
//        System.out.println("\ntestTree4");
//        Tree234 testTree4 = new Tree234();
//        testTree4.root = new Tree234Node(null, 20);
//        testTree4.root.keys = 2;
//        testTree4.root.key2 = 30;
//        testTree4.root.child1 = new Tree234Node(testTree4.root, 10);
//        testTree4.root.child2 = new Tree234Node(testTree4.root, 25);
//        testTree4.root.child3 = new Tree234Node(testTree4.root, 40);
//        testTree4.root.child3.keys = 3;
//        testTree4.root.child3.key2 = 50;
//        testTree4.root.child3.key3 = 60;
//        System.out.println(testTree4.toString());
//        System.out.println("\n234TreeNode before reconstruction");
//        System.out.println(testTree4.root.child3);
//        System.out.println("TestTree4 after reconstruction:");
//        Tree234Node currentNode = testTree4.insertReconstructTree(testTree4.root.child3);
//        System.out.println(testTree4.toString());
//        System.out.println("\n234TreeNode after reconstruction");
//        System.out.println(currentNode);


        System.out.println("\n ---------- Provided Testing");
        Tree234 t = new Tree234();

        System.out.println("\nInserting 84.");
        t.insert(84);
        t.testHelper("84");

        System.out.println("\nInserting 7.");
        t.insert(7);
        t.testHelper("7 84");

        System.out.println("\nInserting 22.");
        t.insert(22);
        t.testHelper("7 22 84");

        System.out.println("\nInserting 95.");
        t.insert(95);
        t.testHelper("(7)22(84 95)");

        System.out.println("\nInserting 50.");
        t.insert(50);
        t.testHelper("(7)22(50 84 95)");

        System.out.println("\nInserting 11.");
        t.insert(11);
        t.testHelper("(7 11)22(50 84 95)");

        System.out.println("\nInserting 37.");
        t.insert(37);
        t.testHelper("(7 11)22(37 50)84(95)");

        System.out.println("\nInserting 60.");
        t.insert(60);
        t.testHelper("(7 11)22(37 50 60)84(95)");

        System.out.println("\nInserting 1.");
        t.insert(1);
        t.testHelper("(1 7 11)22(37 50 60)84(95)");

        System.out.println("\nInserting 23.");
        t.insert(23);
        t.testHelper("(1 7 11)22(23 37)50(60)84(95)");

        System.out.println("\nInserting 16.");
        t.insert(16);
        t.testHelper("((1)7(11 16)22(23 37))50((60)84(95))");

        System.out.println("\nInserting 100.");
        t.insert(100);
        t.testHelper("((1)7(11 16)22(23 37))50((60)84(95 100))");

        System.out.println("\nInserting 28.");
        t.insert(28);
        t.testHelper("((1)7(11 16)22(23 28 37))50((60)84(95 100))");

        System.out.println("\nInserting 86.");
        t.insert(86);
        t.testHelper("((1)7(11 16)22(23 28 37))50((60)84(86 95 100))");

        System.out.println("\nInserting 49.");
        t.insert(49);
        t.testHelper("((1)7(11 16)22(23)28(37 49))50((60)84(86 95 100))");

        System.out.println("\nInserting 81.");
        t.insert(81);
        t.testHelper("((1)7(11 16)22(23)28(37 49))50((60 81)84(86 95 100))");

        System.out.println("\nInserting 51.");
        t.insert(51);
        t.testHelper("((1)7(11 16)22(23)28(37 49))50((51 60 81)84(86 95 100))");

        System.out.println("\nInserting 99.");
        t.insert(99);
        t.testHelper("((1)7(11 16)22(23)28(37 49))50((51 60 81)84(86)95(99 100))");

        System.out.println("\nInserting 75.");
        t.insert(75);
        t.testHelper("((1)7(11 16)22(23)28(37 49))50((51)60(75 81)84(86)95" +
                "(99 100))");

        System.out.println("\nInserting 66.");
        t.insert(66);
        t.testHelper("((1)7(11 16)22(23)28(37 49))50((51)60(66 75 81))84((86)95" +
                "(99 100))");

        System.out.println("\nInserting 4.");
        t.insert(4);
        t.testHelper("((1 4)7(11 16))22((23)28(37 49))50((51)60(66 75 81))84" +
                "((86)95(99 100))");

        System.out.println("\nInserting 80.");
        t.insert(80);
        t.testHelper("(((1 4)7(11 16))22((23)28(37 49)))50(((51)60(66)75" +
                "(80 81))84((86)95(99 100)))");

        System.out.println("\nFinal tree:");
        t.printTree();
    }

}
