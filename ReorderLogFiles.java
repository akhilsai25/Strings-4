// This solution writes a custom comparator
// both digits - do nothing
// digit and letter - swap letter to first
// letter and digt - do not swap
// both letters - swap by ids
class Solution {
    public String[] reorderLogFiles(String[] logs) {
        Arrays.sort(logs,(a, b) -> {
            String[] split1 = a.split(" ", 2);
            String[] split2 = b.split(" ", 2);

            boolean split1Digit = Character.isDigit(split1[1].charAt(0));
            boolean split2Digit = Character.isDigit(split2[1].charAt(0));
            if(split1Digit&&split2Digit) {
                return 0;
            }

            if(split1Digit && !split2Digit) {
                return 1;
            } else if(split2Digit && !split1Digit) {
                return -1;
            } else if(!split1Digit && !split2Digit) {
                int temp = split1[1].compareTo(split2[1]);
                if(temp==0) {
                    return split1[0].compareTo(split2[0]);
                }
                return temp;
            }
            return 0;
        });
        return logs;
    }
}

