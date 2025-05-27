import java.util.*;
public class Main {
    PriorityQueue<Integer> small=new PriorityQueue<>((a,b)->b-a);
    PriorityQueue<Integer> large=new PriorityQueue<>();
    boolean even=true;
    // public MedianFinder() {
        
    // }
    
    public void addNum(int num) {
        if(even){
            large.offer(num);
            small.offer(large.poll());
        }
        else{
            small.offer(num);
            large.offer(small.poll());
        }
        even=!even;
    }
    
    public double findMedian() {
        if(even) return (small.peek()+large.peek())/2.0;
        else return small.peek();
    }
    public static void main(String[] args) {
        Main obj = new Main();
        obj.addNum(1);
        System.out.println(obj.findMedian()); // 1.0
        obj.addNum(2);
        System.out.println(obj.findMedian()); // 1.5
        obj.addNum(3);
        System.out.println(obj.findMedian()); // 2.0
        obj.addNum(4);
        System.out.println(obj.findMedian()); // 2.5
    }
}
