import java.util.*;

public class Main {
    //比较含退格的字符串
    public boolean backspaceCompare(String S, String T) {
        StringBuilder SS = new StringBuilder();
        StringBuilder TT = new StringBuilder();
        int count = 0;
        for(int i = S.length()-1;i >= 0;i--){
            char t = S.charAt(i);
            if(t == '#'){
                count++;
                continue;
            }
            if(count > 0){
                count--;
                continue;
            } else {
                SS.append(t);
            }
        }
        count = 0;
        for(int i = T.length()-1;i >= 0;i--){
            char t = T.charAt(i);
            if(t == '#'){
                count++;
                continue;
            }
            if(count > 0) {
                count--;
                continue;
            } else {
                TT.append(t);
            }
        }
        if(SS.toString().equals(TT.toString())){
            return true;
        } else {
            return false;
        }
    }

    //棒球比赛
    public int calPoints(String[] ops) {
        int sum = 0;
        Stack<String> stack = new Stack<>();
        for(int i = 0;i < ops.length;i++){
            switch (ops[i]){
                case "C":
                    sum -= Integer.parseInt(stack.pop());
                    break;
                case "D":
                    sum += 2*Integer.parseInt(stack.peek());
                    stack.push(String.valueOf(2*Integer.parseInt(stack.peek())));
                    break;
                case "+":
                    sum += (Integer.parseInt(stack.elementAt(stack.size()-1))+Integer.parseInt(stack.elementAt(stack.size()-2)));
                    stack.push(String.valueOf(Integer.parseInt(stack.elementAt(stack.size()-1))+Integer.parseInt(stack.elementAt(stack.size()-2))));
                    break;
                default://整数
                    stack.push(ops[i]);
                    sum += Integer.parseInt(ops[i]);
                    break;

            }
        }
        return sum;
    }

    //栈的弹出压入序列
    public boolean IsPopOrder(int [] pushA,int [] popA) {
        if(pushA.length == 0 || popA.length == 0 || pushA.length != popA.length) {
            return false;
        }
        Stack<Integer> stack = new Stack<>();
        int j = 0;
        for(int i = 0;i < pushA.length;i++) {
            stack.push(pushA[i]);
            while((!stack.empty())&&stack.peek() == popA[j]){
                stack.pop();
                j++;
            }
        }
        return stack.empty() == true;
    }

    //逆波兰表达式求值
    public int evalRPN(String[] tokens) {
        Stack<Integer> stack = new Stack<>();
        for (String s : tokens) {
            switch (s) {
                case "+":
                    stack.push(stack.pop() + stack.pop());
                    break;
                case "-":
                    stack.push(- stack.pop() + stack.pop());
                    break;
                case "*":
                    stack.push(stack.pop() * stack.pop());
                    break;
                case "/":
                    Integer second = stack.pop();
                    Integer first = stack.pop();
                    stack.push(first / second);
                    break;
                default:
                    stack.push(Integer.valueOf(s));
                    break;
            }
        }
        return stack.pop();
    }

    //约瑟夫问题2
    public int getResult(int n) {
        LinkedList<Integer> res=new LinkedList<Integer>();
        int round=2,i=0,curr=0;
        for( i=1;i<=n;i++) {
            res.add(i);
        }
        while(res.size()>1) {
            i=0;
            while(res.size()>1&&i<res.size()) {
                curr=(curr+1)%round;
                if(curr!=1){
                    res.remove(i);
                } else {
                    i++;
                }
            }
            round++;
            curr=0;
            if(res.size()>1) {
                int last=res.removeLast();
                res.addFirst(last);
            }
        }
        return res.pop();
    }

    //猫狗收容所
    public ArrayList<Integer> asylum(int[][] ope) {
        Queue<Integer> dog=new LinkedList<Integer>();
        Queue<Integer> cat=new LinkedList<Integer>();
        Queue<Integer> all=new LinkedList<Integer>();
        ArrayList<Integer> animal=new ArrayList<Integer>();
        for(int i=0;i<ope.length;i++) {
            if(ope[i][0]==1) {
                all.add(ope[i][1]);
                if(ope[i][1]>0) {
                    dog.add(ope[i][1]);
                }
                else if(ope[i][1]<0) {
                    cat.add(ope[i][1]);
                }
            } else if(ope[i][0]==2) {
                if(ope[i][1]==0) {
                    if(!all.isEmpty()) {
                        //看最先被领养的是猫还是狗 同步删除猫或狗中的stack
                        int temp=all.poll();
                        animal.add(temp);
                        if(temp>0) {
                            dog.poll();
                        } else {
                            cat.poll();
                        }
                    }
                } else if(ope[i][1]>0) {
                    if(!dog.isEmpty()) {
                        //看最先被领养的是猫还是狗 同步删除混合stack中的值
                        int temp=dog.poll();
                        animal.add(temp);
                        all.remove(temp);
                    }
                } else {
                    if(!cat.isEmpty()) {
                        //看最先被领养的是猫还是狗 同步删除混合stack中的值
                        int temp=cat.poll();
                        animal.add(temp);
                        all.remove(temp);
                    }
                }
            }
        }
        return animal;
    }

    //员工重要性
    class Employee {
        // It's the unique id of each node;
        // unique id of this employee
        public int id;
        // the importance value of this employee
        public int importance;
        // the id of direct subordinates
        public List<Integer> subordinates;
    }
    public int getImportance(List<Employee> employees, int id) {
        if(employees.size()==0) return 0;
        Queue<Integer> q = new LinkedList<>();
        q.offer(id);
        int result = 0;
        while(!(q.size()==0)){
            int tmp = q.poll();
            for(Employee e: employees){
                if(tmp==e.id){
                    result += e.importance;
                    for(int i: e.subordinates){
                        q.add(i);
                    }
                }
            }
        }
        return result;
    }

    //
}

//设计循环双端队列
class MyCircularDeque {
    int[] myqueue ;
    int front;//队头指针
    int rear;//队尾指针
    int size;//队列当前的大小
    int capacity;//队列的容量

    /** Initialize your data structure here. Set the size of the deque to be k. */
    public MyCircularDeque(int k) {
        this.myqueue = new int[k];
        this.front = 0;
        this.rear = 0;
        this.size = 0;
        this.capacity = k;
    }

    /** Adds an item at the front of Deque. Return true if the operation is successful. */
    public boolean insertFront(int value) {
        if(rear==front && size == capacity) return  false;//如果队列满，插入失败
        else {
            front = (front + capacity -1)% capacity;
            myqueue[front] = value;
            size++;
            return true;
        }
    }

    /** Adds an item at the rear of Deque. Return true if the operation is successful. */
    public boolean insertLast(int value) {
        if(rear==front && size == capacity) return  false;//如果队列满，插入失败
        else {
            myqueue[rear] = value;
            rear = (rear+1+capacity)%capacity;
            size++;
            return true;
        }

    }

    /** Deletes an item from the front of Deque. Return true if the operation is successful. */
    public boolean deleteFront() {
        if( rear == front && size == 0) return false;
        else {
            front = (front+1) % capacity;
            size--;
            return true;
        }

    }

    /** Deletes an item from the rear of Deque. Return true if the operation is successful. */
    public boolean deleteLast() {
        if( rear == front && size == 0) return false;
        else {
            rear = (rear - 1 + capacity) % capacity;
            size--;
            return true;
        }

    }

    /** Get the front item from the deque. */
    public int getFront() {
        if((rear == front) && size==0) return -1;
        else {
            int frontE = myqueue[front];
            //front = (front + 1) % capacity;
            //size--;
            return frontE;
        }
    }

    /** Get the last item from the deque. */
    public int getRear() {
        if((rear == front) && size==0) return -1;
        else {
            int rearE = myqueue[(rear-1+capacity)%capacity];
            // rear = (rear - 1 +capacity)%capacity;
            //size--;
            return rearE;
        }

    }

    /** Checks whether the circular deque is empty or not. */
    public boolean isEmpty() {
        return (rear == front) && size==0;
    }

    /** Checks whether the circular deque is full or not. */
    public boolean isFull() {
        return rear==front && size == capacity;

    }
}

//最近请求次数
class RecentCounter {
    private Queue<Integer> q;

    public RecentCounter() {
        q = new LinkedList<Integer>();
    }

    public int ping(int t) {
        q.offer(t);
        while(q.peek() < t-3000)
            q.poll();
        return q.size();
    }
}

//股票价格跨度
class StockSpanner {
    List<Integer> list;
    List<Integer> rests;

    public StockSpanner() {
        list = new ArrayList<>();
        rests = new ArrayList<>();
    }

    public int next(int price) {
        int va = 1;
        for (int i = list.size()-1; i >= 0;) {
            if (list.get(i) > price) {
                break;
            }
            int dqwd = rests.get(i);
            va += dqwd;
            i -= dqwd;
        }
        list.add(price);
        rests.add(va);
        return va;
    }
}