//
// Source code recreated from a .class file by IntelliJ IDEA
// (powered by FernFlower decompiler)
//

import java.util.ArrayList;

public class TextUtility {
    private String text;
    private ArrayList<Character> characters = new ArrayList();
    private ArrayList<Integer> frequency = new ArrayList();

    public TextUtility(String text) {
        this.text = text;
    }

    public ArrayList<Character> getCharacters() {
        char token;
        for(String temp = this.text; !temp.isBlank(); temp = this.removeChar(temp, token)) {
            token = temp.charAt(0);
            this.characters.add(token);
        }

        return this.characters;
    }

    public ArrayList<Integer> getFrequency() {
        char token;
        for(String temp = this.text; !temp.isBlank(); temp = this.removeChar(temp, token)) {
            token = temp.charAt(0);
            this.frequency.add(this.countChar(temp, token));
        }

        return this.frequency;
    }

    private int countChar(String str, char car) {
        int count = 0;

        for(int i = 0; i < str.length(); ++i) {
            if (str.charAt(i) == car) {
                ++count;
            }
        }

        return count;
    }

    private String removeChar(String str, char rChar) {
        for(int i = 0; i < str.length(); ++i) {
            if (str.charAt(i) == rChar) {
                str = str.replaceAll(String.valueOf(rChar), "");
            }
        }

        return str;
    }
}
