package nl.lilianetop.spring6.ocp17;

import java.util.*;

public class Chapter9 {
    public static void main(String[] args) {
        var list1 = List.of(1, 2);
        var list2 = List.of(2, 1);
        var set1 = Set.of(1, 2);
        var set2 = Set.of(2, 1);

        var set3 = new HashSet<String>();
        set3.add(null);
        var set4 = new TreeSet<String>();
//        set4.add(null); FIXME: TreeSet doesn't allow a null value

        System.out.println(list1.equals(list2));
        System.out.println(set1.equals(set2));
        System.out.println(list1.equals(set1));

        var heights = new ArrayList<Integer>();
        heights.add(null);
        Integer h = heights.get(0);//complies and runs fine
//        int h2 = heights.get(0);//throws NullPointer exception as you can't unbox null => can't run a method on an int

        var linked1 = new LinkedList<String>();
        var linked2 = new LinkedList<String>(linked1);//copy of first empty linked1 no type need to be defined
        //var linked3 = new LinkedList<String>(10); FIXME: doesn't compile
        var linked4 = new LinkedList<>();//LinkedList of Objects as no type defined

        var arraylist1 = new ArrayList<String>();
        var arraylist2 = new ArrayList<>(arraylist1);
        var arraylist3 = new ArrayList<>(10);//list of Objects as it is not defined
        var arraylist4 = new ArrayList<Boolean>(4);


        //How to turn a List into an array[]
        List<String> birds = new ArrayList<>();
        birds.add("hawk");
        birds.add("robin");
        //String[] stringArray = birds.toArray(); FIXME: does not compile as default is Object[]
        String[] strings = birds.toArray(new String[0]);

        //comparing different implementations of LinkedList, Queue and Deque
        LinkedList<String> linkedList = new LinkedList<>();
        List<String> stringList = new LinkedList<>();
        Deque<Integer> deque = new LinkedList<>();
        Queue<Integer> queue = new LinkedList<>();
        queue.add(10);//adds at end/back
        queue.add(14);//adds at end/back
        queue.offer(8);//adds at end/back
        System.out.println(queue);
        queue.remove();//remove first/head
        System.out.println(queue);
        System.out.println(queue.peek());//returns first/head
        queue.poll();//removes first/head
        System.out.println(queue);

        deque.addFirst(100);//adds head/first [100]
        deque.addFirst(140);//adds head/first [140, 100]
        deque.addLast(234);//adds last/tail [140, 100, 234]
        System.out.println(deque);
        System.out.println(deque.getFirst());//140
        System.out.println(deque.getLast());//234
        System.out.println(deque.peek());//140
        System.out.println(deque.poll());//140 remove first/head
        System.out.println(deque);//[100, 234]
        System.out.println(deque.pop());//100 remove first/head
        System.out.println(deque);//[234]

//       ArrayDeque<String> arrayDeque = new LinkedList<>();  FIXME: doesn't compile

        ArrayDeque<String> arrayDeque = new ArrayDeque<>();//no access to List methods
        Deque<String> deque1 = new ArrayDeque<>();
//       List<String> list = new ArrayDeque<String>(); FIXME: doesn't compile

        //Experimenting with Map
//        Map<String, String> map = new HashMap<>();
        Map<String, String> mapNull = new HashMap<>();
        mapNull.put(null, null);
        mapNull.put(null, "w");
        mapNull.put("a", null);
        System.out.println("size " + mapNull.size());
        Map<String, String> map = new TreeMap<>();
//        map.put(null, null); FIXME: TreeMap doesn't allow key as null
        map.put("a", null);

        map.put("koala", "bamboo");
        map.put("lion", "meat");
        map.put("giraffe", "leaf");
        String food = map.get("koala");//return value for that key
        System.out.println(food);//bamboo
        System.out.println(map.containsKey("lion"));//true
        System.out.println(map.containsValue("lion"));//false
        for (String key : map.keySet()) {
            System.out.print(key + ", ");
        }
        System.out.println();
        for (String value : map.values()) {
            System.out.print(value + ", ");
        }
        System.out.println();
        //Note that the map interface doesn't have the method contains() like the other collections
        System.out.println(map.containsKey("leaf"));
        System.out.println(map.containsValue("leaf"));
    }
}
