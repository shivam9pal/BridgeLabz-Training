package JUnit_demo.JUnit;

import java.util.List;

public class ListManager {
	 
	 public void addElement(List<Integer> list, int e) {
		 list.add(e);
	 }
	 public void removeElement(List<Integer> list, int e) {
		 list.remove(e);
	 }
	 public int getSize(List<Integer> list) {
		 return list.size();
	 }
}
