public class TST_Node {
    TST_Node[] nodes;
    boolean terminate;
    char c;

    public TST_Node(){
        nodes = new TST_Node[3];
        terminate = false;
    }

    public TST_Node(char c){
        nodes = new TST_Node[3];
        terminate = false;
        this.c = c;
    }
    public TST_Node(boolean t, char c){
        nodes = new TST_Node[3];
        terminate = t;
        this.c = c;
    }

    public TST_Node[] getNodes() {
        return nodes;
    }

    public void setNodes(TST_Node[] nodes) {
        this.nodes = nodes;
    }

    public boolean isTerminate() {
        return terminate;
    }

    public void setTerminate(boolean terminate) {
        this.terminate = terminate;
    }

    public char getC() {
        return c;
    }

    public void setC(char c) {
        this.c = c;
    }
}
