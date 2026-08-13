class Node{
    int maxLen;
    int suffix, prefix;
    char left, right;
    Node(int maxLen, int suffix, int prefix, char left, char right){
        this.maxLen = maxLen;
        this.suffix = suffix; 
        this.prefix = prefix;
        this.left = left;
        this.right = right;
    }
}
class Solution {
    public int[] longestRepeating(String s, String q, int[] qi) {
        int n = s.length();
        int k = qi.length;
        Node[] segmentTree = new Node[4*n];
        BuildTree(s, segmentTree, 0, 0, n-1);
        int[] res = new int[k];
        for(int i = 0; i<k; i++){
            int pos = qi[i];
            char c = q.charAt(i);
            update(0, 0, n-1, c, pos, segmentTree);
            res[i] = segmentTree[0].maxLen;
        }
        return res;
    }

    void merge(Node[] segmentTree, int i, int l, int mid, int r){
        Node lft = segmentTree[2*i + 1];
        Node rght = segmentTree[2*i + 2];

        int m = Math.max(lft.maxLen, rght.maxLen);
        int tempPrefix = lft.prefix;
        int tempSuffix = rght.suffix;
        if(lft.right == rght.left){
            m = Math.max(m, lft.suffix + rght.prefix);
            if(lft.prefix == mid - l + 1)tempPrefix = lft.prefix + rght.prefix;
            if(rght.prefix == r-mid)tempSuffix = lft.suffix + rght.suffix;
        }
        segmentTree[i] = new Node(m, tempSuffix, tempPrefix, lft.left, rght.right);
    }

    void update(int i, int l, int r, char c, int pos, Node[] segmentTree){
        if(l==r){
            segmentTree[i].left = c;
            segmentTree[i].right = c;
            return;
        }
        int mid = l + (r-l)/2;
        if(pos<=mid){
            update(2*i+1, l, mid, c, pos, segmentTree);
        }else{
            update(2*i+2, mid+1, r, c, pos, segmentTree);
        }
        merge(segmentTree, i, l, mid, r);
    
    }

    void BuildTree(String s, Node[] segmentTree, int i, int l, int r){
        if(l==r){
            segmentTree[i] = new Node(1, 1, 1, s.charAt(l), s.charAt(r));
            return ;
        }
        int mid = l+(r-l)/2;
        BuildTree(s, segmentTree, 2*i+1, l, mid);
        BuildTree(s, segmentTree, 2*i+2, mid+1, r);
        Node lft = segmentTree[2*i + 1];
        Node rght = segmentTree[2*i + 2];
        int m = Math.max(lft.maxLen, rght.maxLen);
        if(s.charAt(mid) == s.charAt(mid+1)){
            m = Math.max(m, lft.suffix+rght.prefix);
        }
        int tempPrefix = lft.prefix;
        if(lft.prefix == mid-l+1 && (lft.right == rght.left)){
            tempPrefix = lft.prefix + rght.prefix;
        }
        int tempSuffix = rght.suffix;
        if(rght.suffix == r-mid && (rght.left == lft.right)){
            tempSuffix = rght.suffix + lft.suffix;
        }
        char tempLeft = lft.left;
        char tempRight = rght.right;

        segmentTree[i] = new Node(m, tempSuffix, tempPrefix, tempLeft, tempRight);
        return;
    }
}