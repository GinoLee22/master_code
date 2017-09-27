/* HashTableChained.java */

package hw6.dict;

import hw6.list.*;
import hw6.list.DList;

/**
 * HashTableChained implements a Dictionary as a hash table with chaining.
 * All objects used as keys must have a valid hashCode() method, which is
 * used to determine which bucket of the hash table an entry is stored in.
 * Each object's hashCode() is presumed to return an int between
 * Integer.MIN_VALUE and Integer.MAX_VALUE.  The HashTableChained class
 * implements only the compression function, which maps the hash code to
 * a bucket in the table's range.
 * <p>
 * DO NOT CHANGE ANY PROTOTYPES IN THIS FILE.
 **/

public class HashTableChained implements Dictionary {

    /**
     * Place any data fields here.
     **/
    private int numOfBucket;                // number of bucket that should be prime
    private int numOfEntry;                 // number of Entry in the hash table
    private List[] buckets;                 // array of Lists: because the buckets should be LIST


    /**
     * Construct a new empty hash table intended to hold roughly sizeEstimate
     * entries.  (The precise number of buckets is up to you, but we recommend
     * you use a prime number, and shoot for a load factor between 0.5 and 1.)
     **/

    public HashTableChained(int sizeEstimate) {
        // Your solution here.
        numOfEntry = 0;
        // choose the load factor: 0.75 = n (sizeEstimate) / N (number of buckets)
        numOfBucket = 4 * sizeEstimate / 3;
        while (!help.isPrime(numOfBucket)) {            // make the numOfBucket the smallest prime integer larger than given
            numOfBucket++;
        }
        // have to initialize the List[] (can change to SList/DList or any other list in future) element because I want toString method could directly print the result
        buckets = new List[numOfBucket];
        for (int index = 0; index < numOfBucket; index++) {
            buckets[index] = new DList();
        }
    }

    /**
     * Construct a new empty hash table with a default size.  Say, a prime in
     * the neighborhood of 100.
     **/

    public HashTableChained() {
        // Your solution here.
        numOfEntry = 0;
        // size: 101
        numOfBucket = 101;
        buckets = new List[numOfBucket];
        for (int index = 0; index < numOfBucket; index++) {
            buckets[index] = new DList();
        }
    }

    /**
     * Converts a hash code in the range Integer.MIN_VALUE...Integer.MAX_VALUE
     * to a value in the range 0...(size of hash table) - 1.
     * <p>
     * This function should have package protection (so we can test it), and
     * should be used by insert, find, and remove.
     **/

    int compFunction(int code) {
        // Replace the following line with your solution.
        // number of bucket is 0
        if (numOfBucket == 0) {
            return -1;          // illegal output
        }
        //linear transform coefficient: a = 2, b = 50
        int a = 2;
        int b = 50;
        int p = 16908799;          // a large prime number
        int indexBucket = ((a * code + b) % p) % numOfBucket;
        if (indexBucket < 0) {             // sometimes the upper result would be negative
            indexBucket += numOfBucket;
        }
        return indexBucket;
//        return 88;
    }

    /**
     * Returns the number of entries stored in the dictionary.  Entries with
     * the same key (or even the same key and value) each still count as
     * a separate entry.
     *
     * @return number of entries in the dictionary.
     **/

    public int size() {
        // Replace the following line with your solution.
//        return 0;
        return numOfEntry;
    }

    /**
     * Tests if the dictionary is empty.
     *
     * @return true if the dictionary has no entries; false otherwise.
     **/

    public boolean isEmpty() {
        // Replace the following line with your solution.
//        return true;
        return numOfEntry == 0;
    }


    /**
     * Create a new Entry object referencing the input key and associated value,
     * and insert the entry into the dictionary.  Return a reference to the new
     * entry.  Multiple entries with the same key (or even the same key and
     * value) can coexist in the dictionary.
     * <p>
     * This method should run in O(1) time if the number of collisions is small.
     *
     * @param key   the key by which the entry can be retrieved.
     * @param value an arbitrary object.
     * @return an entry containing the key and value.
     **/

    public Entry insert(Object key, Object value) {
        // Replace the following line with your solution.
        // construct a Entry to store "key" & "value"
        Entry entry = new Entry();
        entry.key = key;
        entry.value = value;

        int indexBucket = compressHashCode(key);
        if (indexBucket == -1) {                // illegal index: number of bucket is 0
            return null;
        }
        // construct a List to reference the entry. Need to initialize it in the 1st place
        buckets[indexBucket].insertBack(entry);           // cast operation is required
        numOfEntry++;
        return entry;
//        return null;
    }

    /**
     * Search for an entry with the specified key.  If such an entry is found,
     * return it; otherwise return null.  If several entries have the specified
     * key, choose one arbitrarily and return it.
     * <p>
     * This method should run in O(1) time if the number of collisions is small.
     *
     * @param key the search key.
     * @return an entry containing the key and an associated value, or null if
     * no entry contains the specified key.
     **/

    public Entry find(Object key) {
        // Replace the following line with your solution.
        int indexBucket = compressHashCode(key);
        try {
            return (Entry) (buckets[indexBucket].front().item());
        } catch (InvalidNodeException ine) {
            System.err.println(ine);
        }
        // after catch the InvalidNodeException, return null
        return null;
//        return null;
    }

    /**
     * Remove an entry with the specified key.  If such an entry is found,
     * remove it from the table and return it; otherwise return null.
     * If several entries have the specified key, choose one arbitrarily, then
     * remove and return it.
     * <p>
     * This method should run in O(1) time if the number of collisions is small.
     *
     * @param key the search key.
     * @return an entry containing the key and an associated value, or null if
     * no entry contains the specified key.
     */

    public Entry remove(Object key) {
        // Replace the following line with your solution.
        int indexBucket = compressHashCode(key);
        try {       // if the node is valid: not the sentinel node
            Entry removeEntry = (Entry) (buckets[indexBucket].front().item());
            buckets[indexBucket] = new DList();         // make this bucket empty
            numOfEntry--;
            return removeEntry;
        } catch (InvalidNodeException ine) {
            System.err.println(ine);
        }
        // after catch the InvalidNodeException, return null
        return null;
//        return null;
    }

    /**
     * Remove all entries from the dictionary.
     */

    public void makeEmpty() {
        // Your solution here.
        // here: I don't use "buckets = new DList[numOfBucket]" because I want the hash table is able to insert even it is empty without a new construction
        for (int index = 0; index < numOfBucket; index++) {
            buckets[index] = new DList();
        }
        numOfEntry = 0;
    }

    /**
     * calculate the compressed index of Hash Table
     *
     * @return index of Hash Table
     */
    private int compressHashCode(Object key) {
        int hashCode = key.hashCode();
        return compFunction(hashCode);
    }

    @Override
    public String toString() {
        String output = "";
        for (int index = 0; index < buckets.length; index++) {
            output += "{" + (buckets[index]).toString() + "} ";
        }
        return output;
    }

    /**
     * the expect collision
     */
    public double expectCollisions() {
        return numOfEntry - numOfBucket + numOfBucket * Math.pow((1 - 1 / ((double) numOfBucket)), numOfEntry);
    }

    /**
     * the real collision
     */
    public int realCollisions() {
        int numCollisions = 0;
        for (int i = 0; i < buckets.length; i++) {
            if (buckets[i].length() > 1) {
                numCollisions += buckets[i].length() - 1;
            }
        }
        return numCollisions;
    }

    public static void main(String[] args) {
        System.out.println("\n ---------- Testing of HashTableChained constructor, size(), isEmpty()");
//        HashTableChained hashTableChained = new HashTableChained();
        HashTableChained hashTableChained = new HashTableChained(3);
        System.out.println("The size of the HashTable is: " + hashTableChained.size() + " isEmpty: " + hashTableChained.isEmpty());

        System.out.println("\n ---------- Testing of compFunction()");
        System.out.println(hashTableChained.compFunction("Shuocun".hashCode()));
        System.out.println(hashTableChained.compFunction("JinMachao".hashCode()));


        System.out.println("\n ---------- Testing of insert(), find(), remove(), makeEmpty()");
        Entry insertEntry1 = hashTableChained.insert("Shuocun", "ZhengJingRen");
        System.out.println(insertEntry1.toString());
        System.out.println(hashTableChained.toString());
        Entry insertEntry2 = hashTableChained.insert("JinMachao", "PaoWang");
        System.out.println(insertEntry2.toString());
        System.out.println(hashTableChained.toString());
        Entry insertEntry3 = hashTableChained.insert("Shuocun", "24");
        System.out.println(insertEntry3.toString());
        System.out.println(hashTableChained.toString());

        Entry findEntry1 = hashTableChained.find("Shuocun");
        System.out.println(findEntry1);
        Entry findEntry2 = hashTableChained.find("JinMachao");
        System.out.println(findEntry2);
//        Entry findEntry3 = hashTableChained.find("hehe");           // I am wondering the position of Exception. Why
//        System.out.println(findEntry3);

        Entry removeEntry1 = hashTableChained.remove("Shuocun");
//        Entry removeEntry1 = hashTableChained.remove("JinMachao");
//        Entry removeEntry1 = hashTableChained.remove("hehe");
        System.out.println(removeEntry1.toString());
        System.out.println(hashTableChained.toString());

        hashTableChained.makeEmpty();
        System.out.println(hashTableChained.toString());

    }
}
