import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Objects;

import static java.lang.Math.abs;

/** implementation of hashtable where keys are strings and values are Objects
 *
 */
public class HashTable {

    private List<List<Entry>> buckets;
    private static int DEFAULTSIZE=5;
    int bucketSize;

    /** create each bucket, which is a list of Entry
     *
     * @param bucketSize the number of buckets
     */
    public HashTable(int bucketSize) {
        this.bucketSize=bucketSize;
        buckets = new ArrayList<List<Entry>>();
        for (int i=0;i<bucketSize;i++) {
            buckets.add(new LinkedList<Entry>());
        }
    }

    /** create a table of default size
     *    by calling other constructor
     */
    public HashTable() {
        this(DEFAULTSIZE);
    }

    /** public function to put a new key-value pair in
     *     note that client doesn't deal with Entrys
     * @param key
     * @param value
     */
    public void put(String key, Object value){
        List<Entry> bucket= getBucket(key);
        Entry existingEntry = findEntry(bucket,key);
        if (existingEntry!=null) {
            existingEntry.setValue(value);
        }
        else {
            bucket.add(new Entry(key,value));
        }

    }

    /** public function to get the value for a key
     *
     * @param key the key to search for
     * @return either the value of the found entry, or null
     */
    public Object get(String key) {
        List<Entry> bucket = getBucket(key);
        Entry entry = findEntry(bucket, key);
        if (entry!= null){
            return entry.getValue();
        } else {
            return null;
        }
    }

    /** hash uses Java library hashcode for string
     *     as described in special topic 15.1 of Horstmann book (within 15.4)
     *
     * @param key the key to be found
     * @return the hash code for the key
     */
    private int hash(String key) {
        final int HASH_MULTIPLIER = 31;
        int h = 0;
        for (int i = 0; i < key.length(); i++)
        {
            h = HASH_MULTIPLIER * h + key.charAt(i);
        }
        return abs(h)% bucketSize;
    }


    private List<Entry> getBucket(String key) {
        int bucketNum=hash(key);
        List<Entry> bucket = buckets.get(bucketNum);
        return bucket;
    }

    /** helper function to find a key given a bucket
     *
     * @param bucket the bucket to search
     * @param key the key to search for
     * @return either an Entry if key found, or null
     */
    private Entry findEntry(List<Entry> bucket, String key) {

        Entry temp = new Entry(key,"");
        int posInBucket=bucket.indexOf(temp);
        if (posInBucket>=0) {
            return bucket.get(posInBucket);
        } else {
            return null;
        }
    }

    /** private class Entry holds a key-value pair
     *
     */
    private class Entry {
        private String key;
        private Object value;

        public Entry(String key, Object value) {
            this.key = key;
            this.value = value;
        }

        public String getKey() {
            return key;
        }

        public void setKey(String key) {
            this.key = key;
        }

        public Object getValue() {
            return value;
        }

        public void setValue(Object value) {
            this.value = value;
        }

        @Override
        public String toString() {
            return "Entry{" +
                    "key='" + key + '\'' +
                    ", value=" + value +
                    '}';
        }

        /** equals just compares keys of entries
         *
         * @param o the other Entry
         * @return true if keys equal
         */
        @Override
        public boolean equals(Object o) {
            if (this == o) return true;
            if (o == null || getClass() != o.getClass()) return false;
            Entry entry = (Entry) o;
            return Objects.equals(getKey(), entry.getKey());
        }

        @Override
        public int hashCode() {

            return Objects.hash(getKey());
        }
    }
    // END class Entry

    @Override
    public String toString() {
        String s="";
        for (List list: buckets) {
            s=s+list.toString()+"\n";
        }
        return s;
    }

    public static void main(String args[]) {
        HashTable hTable = new HashTable(5);
        hTable.put("Joe","Jose");
        hTable.put("home","casa");
        hTable.put("dog", "perro");
        hTable.put("cat","gato");
        hTable.put("horse","caballo");
        hTable.put("mother","madre");
        hTable.put("dog","pierro");
        System.out.println(hTable.get("dog"));
        System.out.println(hTable.get("horse"));
        System.out.println(hTable);
    }
}



