public class Node {

    Node[] nodes;
    boolean terminate;

    public Node(){
        nodes = new Node[27];
        terminate = false;
    }
    public Node(boolean t){
        nodes = new Node[27];
        terminate = t;
    }

    public Node[] getNodes() {
        return nodes;
    }

    public void setNodes(Node[] nodes) {
        this.nodes = nodes;
    }

    public boolean isTerminate() {
        return terminate;
    }

    public void setTerminate(boolean terminate) {
        this.terminate = terminate;
    }
}
