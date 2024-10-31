import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;
import java.util.function.Function;
import java.util.stream.Collectors;

public class MyHashMap<K,V> {

    public static int INITIAL_CAPACITY = 16;
    public static int MAXIMUM_CAPACITY = 30;

    Entry[] hashtable;

    MyHashMap(){
        hashtable = new Entry[INITIAL_CAPACITY];
    }

    public MyHashMap(int capacity){
        int hashTableSize = tableSizeFor(capacity);
        hashtable = new Entry[hashTableSize];
    }

    // ensuring the capacity is always a power of 2
    final int tableSizeFor(int cap) {
        int n = cap - 1;
        n |= n >>> 1;
        n |= n >>> 2;
        n |= n >>> 4;
        n |= n >>> 8;
        n |= n >>> 16;
        return (n < 0) ? 1 : (n >= MAXIMUM_CAPACITY) ? MAXIMUM_CAPACITY : n + 1;
    }

    public void put(K key,V value){
        int hashCode = key.hashCode() % hashtable.length;
        Entry node = hashtable[hashCode];

        if(node == null){
            Entry entry = new Entry(key,value);
            hashtable[hashCode] = entry;
        }
        else{
            Entry previousNode = node;
            while(node!=null){

                if(node.getKey()==key){
                    node.setValue(value);
                    return;
                }
                previousNode = node;
                node = node.next;
            }
            Entry entry = new Entry(key,value);
            previousNode.next = entry;
        }
    }

    public V get(K key){
        int hashCode = key.hashCode() % hashtable.length;
        Entry node = hashtable[hashCode];

        while(node!=null){
            if(node.getKey().equals(key)){
                return (V) node.getValue();
            }
            node = node.next;
        }

        return null;
    }


    public static void main(String[] args){
        MyHashMap<Integer,String> map = new MyHashMap<>(75);
        map.put(1,"Saswata");
        map.put(2,"works");
        map.put(3,"as");
        map.put(4,"an");
        map.put(5,"Applications");
        map.put(6,"Engineer");
        map.put(7,"at");
        map.put(8,"Oracle");

        String value = map.get(8);
        System.out.println(value);

        // Java 8 practice

//        String input="saswata";
//        Map<String,Long> map1 = Arrays.stream(input.split("")).collect(Collectors.groupingBy(Function.identity(),Collectors.counting()));
//        System.out.println(map1);
    }

}

class Entry<K,V>{

    K key;
    V value;
    Entry next;

    public Entry(K k,V v){
        key = k;
        value = v;
    }

    public K getKey() {
        return key;
    }

    public void setKey(K key) {
        this.key = key;
    }

    public V getValue() {
        return value;
    }

    public void setValue(V value) {
        this.value = value;
    }
}
