class Solution {
    public String intToRoman(int num) {
        int n = -1;
        Deque<Integer> stack = new ArrayDeque<>();
        while(num>0){
            stack.push(num%10);
            num/=10;
            n++;
        }
        StringBuilder sb = new StringBuilder();
        while(!stack.isEmpty()){
            int curr = stack.poll();
            if(n==3){
                sb.append(String.valueOf('M').repeat(curr));
            }else if(n==2){
                if(curr != 4 && curr != 9){
                    if(curr>=5){
                        sb.append('D');
                        curr=curr%5;
                    };
                    if(curr>0){
                        sb.append(String.valueOf('C').repeat(curr));
                    }
                }
                else{
                    if(curr==4){
                        sb.append("CD");
                    }else{
                        sb.append("CM");
                    }
                }
            }else if(n==1){
                if(curr != 4 && curr != 9){
                    if(curr>=5){
                        sb.append('L');
                        curr=curr%5;
                    };
                    if(curr>0){
                        sb.append(String.valueOf('X').repeat(curr));
                    }
                }
                else{
                    if(curr==4){
                        sb.append("XL");
                    }else{
                        sb.append("XC");
                    }
                }
            }else{
                if(curr != 4 && curr != 9){
                    if(curr>=5){
                        sb.append('V');
                        curr=curr%5;
                    };
                    if(curr>0){
                        sb.append(String.valueOf('I').repeat(curr));
                    }
                }
                else{
                    if(curr==4){
                        sb.append("IV");
                    }else{
                        sb.append("IX");
                    }
                }
            }
            n--;
        }
        return sb.toString();
    }
}