/**
 * Node
 */
public class Node {
    private Node hd;
    private Node hi;
    private int number;
    public Node(){}
    public void setHD(Node hd){
        this.hd = hd;
    }
    public void setHI(Node hi){
        this.hi = hi;
    }
    public void setNumber(int number){
        this.number = number;
    }
    public Node getHD(){
        return hd;
    }
    public Node getHI(){
        return hi;
    }
    public int getNumber(){
        return number;
    }
}