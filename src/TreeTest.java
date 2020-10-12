import org.junit.jupiter.api.BeforeAll;

import static org.junit.jupiter.api.Assertions.*;

class TreeTest {
    private Tree testTree;

    @org.junit.jupiter.api.Test
    public void Setup() {
        testTree = new Tree();
        assertTrue(testTree.isEmpty());

        testTree.insert("dog");
        testTree.insert("monkey");
        testTree.insert("cat");
        testTree.insert("ape");
        testTree.insert("pig");
        testTree.insert("zebra");
        testTree.insert("quail");
        testTree.insert("crocodile");
        testTree.inOrder();
        testTree.preOrder();
        testTree.postOrder();
    }

    @org.junit.jupiter.api.Test
    void isLeaf() {

    }

    @org.junit.jupiter.api.Test
    void inOrder() {
    }

    @org.junit.jupiter.api.Test
    void preOrder() {
    }

    @org.junit.jupiter.api.Test
    void height() {
    }
}