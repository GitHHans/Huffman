//
// Source code recreated from a .class file by IntelliJ IDEA
// (powered by FernFlower decompiler)
//

public class HuffNode implements Comparable<HuffNode> {
    private char character;
    private int weight;
    private HuffNode left;
    private HuffNode right;
    private String code;

    public HuffNode(char ch, int weight) {
        this.character = ch;
        this.weight = weight;
    }

    public HuffNode(char ch, int weight, HuffNode left, HuffNode right) {
        this.character = ch;
        this.left = left;
        this.right = right;
        this.weight = weight;
    }

    public void setLeft(HuffNode left) {
        this.left = left;
    }

    public void setRight(HuffNode right) {
        this.right = right;
    }

    public void setCharacter(char ch) {
        this.character = ch;
    }

    public void setWeight(int weight) {
        this.weight = weight;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public HuffNode getLeft() {
        return this.left;
    }

    public HuffNode getRight() {
        return this.right;
    }

    public char character() {
        return this.character;
    }

    public int weight() {
        return this.weight;
    }

    public String getCode() {
        return this.code;
    }

    public boolean isLeaf() {
        assert this.left == null && this.right == null || this.left != null && this.right != null;

        return this.left == null && this.right == null;
    }

    public String toString() {
        return this.character + " : " + this.weight;
    }

    public int compareTo(HuffNode t) {
        return Integer.compare(this.weight(), t.weight());
    }
}
