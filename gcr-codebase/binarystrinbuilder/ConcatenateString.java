package week03.gcrcodebase.binarystrinbuilder;

class ConcatenateString {
	public static String concatenateStr(String[] str) {
		StringBuffer strBuffer=new StringBuffer();
		
		for(String s:str) {
			strBuffer.append(s);
		}
		
		return strBuffer.toString();
	}
	
	public static void main(String[] args) {
		String[] words = {"Java", " ", "is", " ", "powerful", "!"};
        String result = concatenateStr(words);

        System.out.println( result);
	}
}
