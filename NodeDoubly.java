public class NodeDoubly<Tipe> {
    protected Tipe data;
    protected NodeDoubly<Tipe> next, prev;
    
    // Constructor
    public NodeDoubly() {
        next = null;
        prev = null;
        data = null;
    }
    
    // Constructor
    public NodeDoubly(Tipe d, NodeDoubly<Tipe> n, NodeDoubly<Tipe> p) {
        data = d;
        next = n;
        prev = p;
    }
    
    // Function to set link to next node
    public void setLinkNext(NodeDoubly<Tipe> n) {
        next = n;
    }
    
    // Function to set link to previous node
    public void setLinkPrev(NodeDoubly<Tipe> p) {
        prev = p;
    }
    
    // Funtion to get link to next node
    public NodeDoubly<Tipe> getLinkNext() {
        return next;
    }
    
    // Function to get link to previous node
    public NodeDoubly<Tipe> getLinkPrev() {
        return prev;
    }
    
    // Function to set data to node
    public void setData(Tipe d) {
        data = d;
    }
    
    // Function to get data from node
    public Tipe getData() {
        return data;
    }
}