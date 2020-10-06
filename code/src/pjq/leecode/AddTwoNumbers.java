package pjq.leecode;

/**
 * 两数相加：
 */
public class AddTwoNumbers {

    public static void main(String[] args) {
        AddTwoNumbers addTwoNumbers = new AddTwoNumbers();
        ListNode node1 = addTwoNumbers.createNode1();
        ListNode node2 = addTwoNumbers.createNode2();
//        while(node1 != null) {
//            System.out.println(node1.val + " -> ");
//            node1 = node1.next;
//        }
//        while(node2 != null) {
//            System.out.println(node2.val + " -> ");
//            node2 = node2.next;
//        }

        ListNode res = addTwoNumbers.addTwoNumbers(node1, node2);
        while (res != null) {
            System.out.println(res.val + " -> ");
            res = res.next;
        }
    }

    public ListNode createNode1() {
        ListNode tmp1 = new ListNode(2);
        ListNode tmp2 = new ListNode(4);
        ListNode tmp3 = new ListNode(9);
//        ListNode tmp4 = new ListNode(2);
        tmp1.next = tmp2;
        tmp2.next = tmp3;

        return tmp1;
    }

    public ListNode createNode2() {
        ListNode tmp1 = new ListNode(5);
        ListNode tmp2 = new ListNode(6);
        ListNode tmp3 = new ListNode(9);
//        ListNode tmp4 = new ListNode(2);
        tmp1.next = tmp2;
        tmp2.next = tmp3;

        return tmp1;
    }

    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        ListNode root = new ListNode(-1);
        ListNode node = root;
        int i = 0;  //进位
        int sum = 0;

        while (l1 != null || l2 != null) {
            ListNode tmp = null;
            int num1 = (l1 == null) ? 0 : l1.val;
            int num2 = (l2 == null) ? 0 : l2.val;
            sum = num1 + num2 + i;

            i = sum >= 10 ? 1 : 0;

            tmp = new ListNode(sum % 10);

            node.next = tmp;
            node = node.next;

            if(l1 != null) l1 = l1.next;
            if(l2 != null) l2 = l2.next;
        }

        if (sum >= 10) {
            node.next = new ListNode(1);
        }
        return root.next;
    }

}

class ListNode {
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
