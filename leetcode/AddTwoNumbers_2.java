package week_4;

public class AddTwoNumbers_2 {

	static class ListNode {
		int val;
		ListNode next;

		ListNode() {
		}

		ListNode(int val) {
			this.val = val;
		}

		ListNode(int val, ListNode next) {
			this.val = val;
			this.next = next;
		}
	}

	public ListNode addTwoNumbers(ListNode l1, ListNode l2) {

		ListNode dummy = new ListNode(0);
		ListNode current = dummy;
		int carry = 0;

		while (l1 != null || l2 != null || carry != 0) {

			int sum = carry;

			if (l1 != null) {
				sum += l1.val;
				l1 = l1.next;
			}

			if (l2 != null) {
				sum += l2.val;
				l2 = l2.next;
			}

			carry = sum / 10;
			current.next = new ListNode(sum % 10);
			current = current.next;
		}

		return dummy.next;
	}

	public static void main(String[] args) {

		AddTwoNumbers_2 obj = new AddTwoNumbers_2();

		ListNode l1 = new ListNode(2, new ListNode(4, new ListNode(3)));

		ListNode l2 = new ListNode(5, new ListNode(6, new ListNode(4)));

		ListNode result = obj.addTwoNumbers(l1, l2);

		while (result != null) {
			System.out.print(result.val + " ");
			result = result.next;
		}
	}
}
