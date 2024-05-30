//
// Source code recreated from a .class file by IntelliJ IDEA
// (powered by FernFlower decompiler)
//

import java.util.ArrayList;
import java.util.Collections;
import java.util.Iterator;

public class HuffTree {
    private HuffNode root;
    ArrayList<Integer> freq;
    ArrayList<HuffNode> tree = new ArrayList();
    ArrayList<HuffNode> leafNodes = new ArrayList();

    public HuffTree(ArrayList<Character> chars, ArrayList<Integer> freq) {
        this.freq = freq;

        for(int i = 0; i < chars.size(); ++i) {
            this.tree.add(new HuffNode((Character)chars.get(i), (Integer)freq.get(i)));
        }

        while(this.tree.size() > 1) {
            Collections.sort(this.tree);
            HuffNode second = (HuffNode)this.tree.remove(1);
            HuffNode first = (HuffNode)this.tree.remove(0);
            int weightSum = first.weight() + second.weight();
            HuffNode parent = new HuffNode('`', weightSum, first, second);
            this.tree.add(parent);
            this.root = parent;
        }

        this.assignCodes(this.root, "");
    }

    public void assignCodes(HuffNode current, String s) {
        if (current.isLeaf()) {
            current.setCode(s);
            this.leafNodes.add(current);
        } else {
            this.assignCodes(current.getLeft(), s + "0");
            this.assignCodes(current.getRight(), s + "1");
        }
    }

    public void printTable() {
        System.out.printf("   %-12s|   %-18s|   %-18s %n", "Character", "Huffman Code", "Number of Bits");
        Iterator var1 = this.leafNodes.iterator();

        while(var1.hasNext()) {
            HuffNode n = (HuffNode)var1.next();
            System.out.printf("   %-12s|   %-18s|   %-18d %n", n.character(), n.getCode(), this.countBits(n.getCode()));
        }

    }

    public String toHuffCodeEquivalent(String s, char c) throws Exception {
        StringBuilder sb = new StringBuilder();
        String temp = s;

        try {
            while(!temp.isBlank()) {
                boolean proceed = false;
                char token = temp.charAt(0);
                Iterator var7 = this.leafNodes.iterator();

                while(var7.hasNext()) {
                    HuffNode node = (HuffNode)var7.next();
                    if (token == node.character()) {
                        if (c == 'a') {
                            sb.append(node.getCode()).append(" ");
                        } else {
                            sb.append(node.getCode());
                        }

                        proceed = true;
                    }
                }

                temp = temp.substring(1);
                if (!proceed) {
                    throw new Exception();
                }
            }
        } catch (Exception var9) {
            throw new Exception();
        }

        return sb.toString();
    }

    public String toTextEquivalent(String s) throws Exception {
        StringBuilder sb = new StringBuilder();
        String[] token = s.split(" ");
        String[] var4 = token;
        int var5 = token.length;

        for(int var6 = 0; var6 < var5; ++var6) {
            String code = var4[var6];
            boolean proceed = false;
            Iterator var9 = this.leafNodes.iterator();

            while(var9.hasNext()) {
                HuffNode node = (HuffNode)var9.next();
                if (code.equals(node.getCode())) {
                    sb.append(node.character());
                    proceed = true;
                }
            }

            if (!proceed) {
                throw new Exception();
            }
        }

        return sb.toString();
    }

    public int countBits(String s) {
        int res = 0;

        for(int i = 0; i < s.length(); ++i) {
            ++res;
        }

        return res;
    }

    public double computePercentageOfSavings() {
        double totalBits = 0.0;
        double huffBits = 0.0;

        Iterator var5;
        Integer i;
        for(var5 = this.freq.iterator(); var5.hasNext(); totalBits += (double)i) {
            i = (Integer)var5.next();
        }

        totalBits *= 7.0;

        HuffNode n;
        for(var5 = this.leafNodes.iterator(); var5.hasNext(); huffBits += (double)this.countBits(n.getCode())) {
            n = (HuffNode)var5.next();
        }

        return (totalBits - huffBits) / totalBits * 100.0;
    }

    public HuffNode root() {
        return this.root;
    }

    public int weight() {
        return this.root.weight();
    }

    public void inorderTraversal() {
        this.inorderHelper(this.root);
    }

    private void inorderHelper(HuffNode node) {
        if (node != null) {
            this.inorderHelper(node.getLeft());
            System.out.println(node);
            this.inorderHelper(node.getRight());
        }
    }
}
