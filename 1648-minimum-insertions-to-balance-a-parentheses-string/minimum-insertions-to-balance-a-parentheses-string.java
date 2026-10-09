class Solution {
    public int minInsertions(String s) {
        int numOfIns=0;
        int open = 0;
        int n = s.length();
        int i = 0 ;
        while(i<n){
            char ch = s.charAt(i);
            if(ch=='('){
                open++;
            }else{
                if(open>0){
                    if(i+1<n && s.charAt(i+1)==')'){
                        i++;
                    }
                    else numOfIns++;
                    open--;
                }else{
                    if(i+1<n && s.charAt(i+1)==')'){
                        numOfIns++;
                        i++;
                    }
                    else numOfIns+=2;
                }
            }
            i++;
        }
        return numOfIns+2*open;
    }
}