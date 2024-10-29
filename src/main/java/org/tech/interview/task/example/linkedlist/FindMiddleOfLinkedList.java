package org.tech.interview.task.example.linkedlist;

import org.w3c.dom.Node;

public class FindMiddleOfLinkedList {

    public static class Node {

        private String name;
        private Node next;

        public Node(String name, Node next) {
            this.name = name;
            this.next = next;
        }

        public String getName() {
            return name;
        }

        public void setName(String name) {
            this.name = name;
        }

        public Node getNext() {
            return next;
        }

        public void setNext(Node next) {
            this.next = next;
        }

        @Override
        public String toString() {
            return "Node{" +
                    "name='" + name + '\'' +
                    '}';
        }
    }
//  0 1 2 3 4 5 /6/ 7 8 9 10 11 12
    public static Node init() {
        Node node = new Node("head", null);
        for (int i = 0; i < 13; i++) {
            node = new Node("node" + i, node);
        }
        return node;
    }

    public static void showResult() {
        System.out.println("GroupBooksByTitleAndDate(latest publish date): " + findMiddleElement(init()));
    }

    public static Node findMiddleElement(Node head) {
        Node fast = head;
        Node slow = head;
        int count = 1;
        while (fast.getNext() != null) {
            fast = fast.getNext();
            if (count % 2 == 0) {
                slow = slow.getNext();
            }
            count++;
        }
        return slow;
    }
}
