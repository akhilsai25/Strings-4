// This solution uses an approach where we initially trim the spaces. We first calculate the sign of the number from the first character
// We keep appending the number. At any point if the number crosses the max/10 value we compare the last digit and to make sure if we are out of bounds or in bounds
// We will have two scenarios if so far formed number greater than, we directly return max or min based on sign flag 
class Solution {
    public int myAtoi(String s) {
        s=s.trim();
        int response = 0;
        int limit = Integer.MAX_VALUE/10;
        boolean flag = false;
        int i=0;
        for(i=0;i<s.length();i++) {
            char c = s.charAt(i);
            if(!Character.isDigit(c)) {
                if(i==0 && c=='-') {
                    flag=true;
                    continue;
                } else if(i==0 && c=='+') {
                    continue;
                }
                break;
            }

            if(response==limit) {
                if(!flag && c-'0'>=8) {
                    return Integer.MAX_VALUE;
                } else if(flag && c-'0'>=8) {
                    return Integer.MIN_VALUE;
                }
                 else {
                    response=response*10+(c-'0');
                    continue;
                }
            }

            if(response>limit) {
                if(!flag) return Integer.MAX_VALUE;
                else return Integer.MIN_VALUE;
            }
            response=response*10+(c-'0');
        }

        if(flag) return -response;
        return response;
    }
}
