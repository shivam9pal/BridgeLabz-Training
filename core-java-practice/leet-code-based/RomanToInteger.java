package week01.leetcode;

class RomanToInteger {
	//Function to return ROman Numbers Value
    static int value(char chr){
        if(chr=='I'){
            return 1;
        }else if(chr=='V'){
            return 5;
        }else if(chr=='X'){
            return 10;
        }else if(chr=='L'){
            return 50;
        }else if(chr=='C'){
            return 100;
        }else if(chr=='D'){
            return 500;
        }else if(chr=='M'){
            return 1000;
        }
        return -1;
    }
    //Finding Roman Number and adding them to single unit
    public int romanToInt(String s) {
        int number=0;
        for(int i=0;i<s.length();i++){
            int r1=value(s.charAt(i));

            if(i+1 < s.length()){
                int r2=value(s.charAt(i+1));

                if(r1>=r2){
                    number +=r1;
                }else{
                    number+=(r2-r1);
                    i++;
                }
            }
            else{
                number += r1;
            }
        }
        return number;
    }
}
