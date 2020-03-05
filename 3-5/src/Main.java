public class Main {
    public static void main(String[] args) {
        Queue q = new Queue();
        System.out.println(q.isEmpty());
        System.out.println(q.size());
        q.offer(1);
        q.offer(2);
        q.offer(3);
        q.offer(4);
        System.out.println(q.isEmpty());
        System.out.println(q.size());
        System.out.println();
        System.out.println(q.rear());
        System.out.println();
        while(!q.isEmpty()){
            System.out.println(q.peek());
            q.poll();
        }
        System.out.println(q.isEmpty());
        System.out.println(q.size());
    }
}
