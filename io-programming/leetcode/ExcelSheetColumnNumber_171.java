package week_5;
public class ExcelSheetColumnNumber_171 {
	public int titleToNumber(String columnTitle) {
		int result = 0;
		for (int i = 0; i < columnTitle.length(); i++) {
			result = result * 26 + (columnTitle.charAt(i) - 'A' + 1);
		}
		return result;
	}

	public static void main(String[] args) {
		ExcelSheetColumnNumber_171 obj = new ExcelSheetColumnNumber_171();
		String columnTitle = "AB";
		System.out.println(obj.titleToNumber(columnTitle));
	}
}
