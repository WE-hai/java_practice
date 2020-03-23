public class Hash {
    private Node[] array;
    private int size;
    private static final double LOAD_FACTORY = 0.7;

    public Hash() {
        array = new Node[10];
        size = 0;
    }

    public double loadFactory() {
        return size * 1.0 / array.length;
    }

    public int put(int key, int value) {
        if (loadFactory() >= LOAD_FACTORY) {
            resize();
        }
        int idx = key % array.length;
        Node cur = array[idx];
        while (cur != null) {
            if (cur.key == key) {
                int oldV = cur.value;
                cur.value = value;
                return oldV;
            }
            cur = cur.next;
        }
        cur = new Node(key, value);
        cur.next = array[idx];
        array[idx] = cur;
        ++size;
        return -1;
    }

    private void resize() {
        Node[] newarr = new Node[array.length * 2];
        for (int i = 0; i < array.length; i++) {
            Node curHead = array[i];
            while (curHead != null) {
                Node next = curHead.next;
                int idx = curHead.key % newarr.length;
                curHead.next = newarr[idx];
                newarr[idx] = curHead;
                curHead = next;
            }
        }
        array = newarr;
    }

    public int get(int key) {
        int idx = key % array.length;
        Node cur = array[idx];
        while (cur != null) {
            if (cur.key == key) {
                return cur.value;
            }
            cur = cur.next;
        }
        return -1;
    }

    public int remove(int key) {
        int idx = key % array.length;
        Node prev = null;
        Node cur = array[idx];
        while (cur != null) {
            if (cur.key == key) {
                if (prev == null) {
                    array[idx] = cur.next;
                } else {
                    prev.next = cur.next;
                }
                return cur.value;
            } else {
                prev = cur;
                cur = cur.next;
            }
        }
        return -1;
    }

    public void print() {
        for (int i = 0;i < array.length;i++) {
            Node cur = array[i];
            while (cur != null) {
                System.out.print(cur.key+"--->"+cur.value+"\t");
                cur = cur.next;
            }
        }
    }

    public static void main(String[] args) {
        Hash hb = new Hash();
        hb.put(1,1);
        hb.put(2,2);
        hb.put(3,3);
        hb.put(4,4);
        hb.put(5,5);
        hb.put(6,6);
        hb.print();
        System.out.println();
        hb.put(1,-1);
        hb.put(2,-2);
        hb.print();
        System.out.println();
        System.out.println(hb.get(5));
        hb.print();
        System.out.println();
        System.out.println(hb.remove(2));
        hb.print();
        System.out.println();
        System.out.println(hb.remove(12));
        hb.print();
    }
}