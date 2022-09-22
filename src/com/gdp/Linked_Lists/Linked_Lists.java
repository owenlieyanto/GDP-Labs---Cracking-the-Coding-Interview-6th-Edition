package com.gdp.Linked_Lists;

import java.util.HashSet;
import java.util.Random;

public class Linked_Lists {

    public static void main(String[] args) {
        LinkedListNode linkedListNode = createNewRandomLinkedListNode(null, 10);
        System.out.println("Initial LinkedList: \t" + linkedListNode.printForward());

        deleteDups(linkedListNode);
        System.out.println("Processed LinkedList: \t" + linkedListNode.printForward());
    }

    /**
     * delete all duplicate data in a {@link LinkedListNode} sequence
     *
     * @param n a {@link LinkedListNode} sequence
     */
    static void deleteDups(LinkedListNode n) {
        HashSet<Integer> set = new HashSet<Integer>();
        LinkedListNode previous = null;
        while (n != null) {
            if (set.contains((n.data))) {
                previous.next = n.next;
            } else {
                set.add(n.data);
                previous = n;
            }
            n = n.next;
        }
    }


    static Random random = new Random();
    static int min = 1;
    static int max = 5;
    /**
     * create a sequence of {@link LinkedListNode} with random data.
     *
     * @param prev null, if you want to create from empty sequence.
     * @param n    length of the {@link LinkedListNode} sequence (will create {@link LinkedListNode} with n sequence)
     * @return a com.gdp.Linked_Lists.LinkedListNode sequence
     */
    private static LinkedListNode createNewRandomLinkedListNode(LinkedListNode prev, int n) {
        if (n <= 0) {
            return null;
        }
        LinkedListNode linkedListNode = new LinkedListNode();

        linkedListNode.data = random.nextInt(max - min + 1) + min;
        linkedListNode.next = createNewRandomLinkedListNode(linkedListNode, n - 1);
        if (prev != null) {
            linkedListNode.prev = prev;
        }

        return linkedListNode;
    }
}

