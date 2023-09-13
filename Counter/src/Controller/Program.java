package Controller;

import java.util.HashMap;
import java.util.Map;
import java.util.StringTokenizer;

import Model.Element;
import View.Menu;

public class Program extends Menu<String> {
    static String [] mainChoice = {"Count Word","Count Character","Exit"};
    protected String value;
    protected Map<Character, Integer> charCounter;
    protected Map<String, Integer> wordCounter;

    public Program(Element e){
        super("Count system",mainChoice);
        value = e.getValue();
        charCounter = new HashMap<Character, Integer>();
        wordCounter = new HashMap<String, Integer>();
    }

    public void execute(int n){
        switch (n){
            case 1:{
                wordCounter(value);
                break;
            }
            case 2:{
                charCounter(value);
                break;
            }
            case 3:{
                System.exit(0);
            }
        }
    }

    public void charCounter(String content) {
        for (char ch : content.toCharArray()) {
            if (Character.isSpaceChar(ch)) continue;
            if (!charCounter.containsKey(ch)) {
                charCounter.put(ch, 1);
            } else {
                charCounter.put(ch, ((int) charCounter.get(ch)) + 1);
            }
        }
        System.out.println(charCounter);
    }
    public void wordCounter(String content){
        StringTokenizer tokenizer = new StringTokenizer(content);
        while (tokenizer.hasMoreTokens()) {
            String token = tokenizer.nextToken();
            if (!wordCounter.containsKey(token)) {
                wordCounter.put(token, 1);
            } else {
                wordCounter.put(token, ((int) wordCounter.get(token)) + 1);
            }
        }
        System.out.println(wordCounter);
    }
}
