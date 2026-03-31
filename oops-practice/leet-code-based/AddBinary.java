package week02.gcrcodebase.leetcode;

public class AddBinary {
	
	public static String addBinary(String a, String b) {
        StringBuilder sb=new StringBuilder();
        int la=a.length()-1;
        int lb=b.length()-1;
        int carry=0;
        while(la>=0 || lb>=0 || carry>0){
            int sum=carry;
            if(la>=0){
                sum+=a.charAt(la--)-'0';
            }
            if(lb>=0){
                sum+=b.charAt(lb--)-'0';
            }
            sb.append(sum%2);
            carry=sum/2;

        }
        return sb.reverse().toString();
	}

	public static void main(String[] args) {
		String str1="111";
		String str2="111";
		
		String sum=addBinary(str1,str2);
		System.out.println(sum);

	}

}
