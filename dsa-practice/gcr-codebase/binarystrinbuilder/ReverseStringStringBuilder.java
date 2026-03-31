package week03.gcrcodebase.binarystrinbuilder;

class ReverseStringStringBuilder {

	public static void main(String[] args) {
		//instance of StringBuilder
		StringBuilder sb=new StringBuilder();
		sb.append("hello");
		sb.reverse();
		//output
		System.out.println(sb.toString());
	}
}
