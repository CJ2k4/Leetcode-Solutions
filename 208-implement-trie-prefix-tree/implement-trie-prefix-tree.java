class Node{
    Map<Character, Node> children = new HashMap<>();
    boolean isEnd = false;
}
class Trie {
    Node root;
    public Trie() {
        root = new Node();
    }
    
    public void insert(String word) {
        Node node = root;
        int n = word.length();
        for(int i = 0; i<n; i++){
            char ch = word.charAt(i);
            node.children.putIfAbsent(ch, new Node());
            node = node.children.get(ch);
        }
        node.isEnd = true;
    }
    
    public boolean search(String word) {
        int n = word.length();
        Node cur = root;
        for(int i = 0; i<n; i++){
            char ch = word.charAt(i);
            if(cur.children.containsKey(ch)){
                cur = cur.children.get(ch);
            }else return false;
        }
        return cur.isEnd;
    }
    
    public boolean startsWith(String prefix) {
        Node cur = root;
        for(char ch : prefix.toCharArray()){
            if(!cur.children.containsKey(ch))return false;
            cur = cur.children.get(ch);
        }
        return true;
    }
}

/**
 * Your Trie object will be instantiated and called as such:
 * Trie obj = new Trie();
 * obj.insert(word);
 * boolean param_2 = obj.search(word);
 * boolean param_3 = obj.startsWith(prefix);
 */