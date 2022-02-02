
/**
 * TODO: Add your file header
 * Name:
 * ID:
 * Email:
 * Sources used: Put "None" if you did not have any external help
 * Some example of sources used would be Tutors, Zybooks, and Lecture Slides
 * 
 * 2-4 sentence file description here
 */

import static org.junit.Assert.*;
import org.junit.*;
import java.util.*;

/**
 * TODO: Add your class header
 * 
 * IMPORTANT: Do not change the method headers and points are awarded
 * only if your test cases cover cases that the public tester file
 * does not take into account.
 */
public class MyLinkedListCustomTester {
    private MyLinkedList testList, testEmptyList;
    private MyLinkedList.MyListIterator testListIter, testEmptyListIter;

    /**
     * This sets up the test fixture. JUnit invokes this method before
     * every testXXX method. The @Before tag tells JUnit to run this method
     * before each test.
     */
    @Before
    public void setUp() throws Exception {
        testList = new MyLinkedList();
        testList.add("A");
        testList.add("B");
        testList.add("C");
        testListIter = testList.new MyListIterator();

        testEmptyList = new MyLinkedList();
        testEmptyListIter = testEmptyList.new MyListIterator();
    }

    /**
     * test the hasNext method when idx is at it's max value
     */
    @Test
    public void testHasNext() {
        testListIter.idx = testList.size;

        assertEquals("hasNext should return false", false, testListIter.hasNext());

    }

    /**
     * test the next method when at the end of a list.
     */
    @Test
    public void testNext() {
        testListIter.idx = testList.size;

        boolean exceptionThrown = false;
        try {
            testListIter.next();
        } catch (NoSuchElementException e) {
            exceptionThrown = true;
            System.out.println("Succesfully Caught NoSuchElementException @ testNext()");
        }
        assertTrue("testNext()", exceptionThrown);

    }

    /**
     * test the hasPrevious method with an empty list
     */
    @Test
    public void testHasPrevious() {
        boolean exceptionThrown = false;
        try {
            testEmptyListIter.previous();
        } catch (NoSuchElementException e) {
            exceptionThrown = true;
            System.out.println("Succesfully Caught NoSuchElementException @ testPrevious()");
        }
        assertTrue("testPrevious()", exceptionThrown);
    }

    /**
     * test to make sure a NoSuchElementExceotion is thrown when applicable
     */
    @Test
    public void testPrevious() {
        testListIter.idx = 0;

        boolean exceptionThrown = false;
        try {
            testListIter.previous();
        } catch (NoSuchElementException e) {
            exceptionThrown = true;
            System.out.println("Succesfully Caught NoSuchElementException @ testNext()");
        }
        assertTrue("testHasPrevious()", exceptionThrown);

    }

    /**
     * test the nextIndex method with an empty list
     */
    @Test
    public void testNextIndex() {
       assertEquals("Checks nextIndex with an empty list", 0, testEmptyListIter.nextIndex());
    }

    /**
     * test the previousIndex method with an empty list
     */
    @Test
    public void testPreviousIndex() {
        assertEquals("Checks nextIndex with an empty list", -1, testEmptyListIter.previousIndex());
    }

    /**
     * test the set method's ability to catch applicable exceptions
     */
    @Test
    public void testSet() {
        boolean exceptionThrownOne = false;
        boolean exceptionThrownTwo = false;
        try {
            testListIter.set(null);
        } catch (NullPointerException e) {
            exceptionThrownOne = true;
            System.out.println("Succesfully Caught NullPointerException @ testSet()");
        }

        testListIter.next();
        testListIter.add("E");
        try {
            testListIter.set("D");
        } catch (IllegalStateException e) {
            exceptionThrownTwo = true;
            System.out.println("Succesfully Caught IllegalStateException @ testSet()");
        }
        assertTrue("testSet()", exceptionThrownOne);
        assertTrue("testSet2()", exceptionThrownTwo);
    }

    /**
     * test the remove's method ability to throw an IllegalStateException after adding an element.
     */
    @Test
    public void testRemoveTestOne() {
        boolean exceptionThrown = false;

        testListIter.next();
        testListIter.add("E");
        try {
            testListIter.remove();
        } catch (IllegalStateException e) {
            exceptionThrown = true;
            System.out.println("Succesfully Caught IllegalStateException @ testRemove()");
        }
        assertTrue("testRemove()", exceptionThrown);
    }

    /**
     * test the remove method when removing the first element and checking if the head is updated
     */
    @Test
    public void testRemoveTestTwo() {
        boolean exceptionThrown = false;
        testListIter.idx = 1;
        testListIter.forward = true;
        testListIter.canRemoveOrSet = true;

        testListIter.remove();
        testListIter.idx = 0;
        assertEquals("Check if the first element was removed", "B", testList.head.getNext().getElement());
        
    }

    /**
     * test the add method when adding at the end of a list.
     */
    @Test
    public void testAdd() {
        testListIter.idx = testList.size;
        testListIter.add("F");

        assertEquals("Check if element was added at the end of the list", "F", testListIter.left.getElement());
        
    }

}