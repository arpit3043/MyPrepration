package Tries;
import java.util.Arrays;
public class LongestCommonPrefix {
    private String longestCommonPrefixUsingTrie(String[] strs) {
        Trie trie = new Trie();
        for(String str : strs){
            trie.insert(str);
        }
        return trie.maxPrefix(strs.length, trie.root, new StringBuilder());
    }
    class Trie {
        TrieNode root;
        Trie(){
            root = new TrieNode();
        }
        public void insert(String str){
            TrieNode tempNode = new TrieNode();
            tempNode = root;
            for(char ch : str.toCharArray()){
                if(tempNode.getNode(ch) == null)
                    tempNode.putNode(ch);
                tempNode = tempNode.getNode(ch);
                tempNode.increasePrefixCount();
            }
            tempNode.setEnd();
        }

        public String maxPrefix(int size, TrieNode root, StringBuilder sb){
            TrieNode tempNode = new TrieNode();
            for(char ch = 'a'; ch <= 'z'; ch++){
                tempNode = root.getNode(ch);

                if(tempNode != null && tempNode.getPrefixCount()==size){
                    sb.append(ch);
                    maxPrefix(size, tempNode, sb);
                }
            }
            return sb.toString();
        }
    }

    class TrieNode{
        TrieNode[] nodes;
        int prefixCount;
        boolean isEnd;
        public TrieNode(){
            nodes = new TrieNode[26];
            prefixCount = 0;
        }
        public TrieNode getNode(char ch){
            return nodes[ch-'a'];
        }
        public void putNode(char ch){
            nodes[ch-'a'] = new TrieNode();
        }
        public void increasePrefixCount(){
            prefixCount++;
        }
        public void setEnd(){
            isEnd = true;
        }
        public int getPrefixCount() {
            return prefixCount;
        }
    }
    private static String longestCommonPrefixUsingSlidingWindow(String[] strs) {
        int N = strs.length;
        int c = 0;
        Arrays.sort(strs);
        if (N == 0) {
            return "";
        }
        String first = strs[0];
        String last = strs[N - 1];
        while (c < first.length()) {
            if (first.charAt(c) == last.charAt(c)) {
                c++;
            } else {
                break;
            }
        }
        if (c == 0) {
            return "";
        }
        return first.substring(0, c);
    }
}