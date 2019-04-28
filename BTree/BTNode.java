import java.util.ArrayList;

class BTNode <G extends Comparable<G>>{

    private boolean leaf;
    BTNode<G> parent;
    ArrayList<G> keys;
    ArrayList<BTNode<G>> nodes;

    BTNode(int order) {
        leaf = true;
        parent = null;
        keys = new ArrayList<>(0);
        nodes = new ArrayList<>(order * 2);
    }

    void notLeaf() {
        leaf = false;
    }

    boolean isLeaf() {
        return leaf;
    }

    void sort() {
        for(int i = 0; i < keys.size() - 1; i++) {
            for(int j = 1; j < keys.size() - i; j++) {
                if(keys.get(j - 1).compareTo(keys.get(j)) > 0) {
                    G temp = keys.get(j - 1);
                    keys.set(j - 1, keys.get(j));
                    keys.set(j, temp);
                }
            }
        }
    }

    BTNode<G> getLeftSibling() {
        if(this.parent.nodes.indexOf(this) != 0) {
            return this.parent.nodes.get(this.parent.nodes.indexOf(this) - 1);
        }
        return null;
    }

    BTNode<G> getRightSibling() {
        if(this.parent.nodes.indexOf(this) != this.parent.nodes.size() - 1) {
            return this.parent.nodes.get(this.parent.nodes.indexOf(this) + 1);
        }
        return null;
    }

}