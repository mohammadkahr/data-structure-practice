import java.util.Scanner;
public class question2 {
    public static void main(String[] args) {
        //mohammad._.hr
        //4003623039
        //week4 # question2 # 100 point
        Scanner input = new Scanner(System.in);
        ArrayQueue<Integer> arrayQueue = new ArrayQueue<>();
        int number = input.nextInt();
        for (int i = 0; i <= number; i++) {
            arrayQueue.enqueue(Binary(i));
        }
        for (int i = 0; i <= number; i++) {
            System.out.println(arrayQueue.dequeue());
        }
    }
    public static int Binary(int number){
        int z = number;
        int r,h=0,p=1;
        while (z != 0){
            r = z % 2;
            z = z / 2;
            h = h+ p*r;
            p = p * 10;
        }
        return h ;
    }
}
class ArrayQueue<E> {
    private E[] data;
    private int first = 0;
    private int siez = 0;
    private static final int CAPACITY = 1000;
    public ArrayQueue(){this(CAPACITY);}
    public ArrayQueue(int capacity){
        data = (E[]) new Object[capacity];
    }
    public int size(){
        return siez;
    }
    public boolean isEmpty(){
        return (siez==0);
    }
    public void enqueue(E e){
//        if (siez == 0 ) {
//            System.out.println("Queue is full");
//        }
        int avail = (first + siez) % data.length;
        data[avail] = e ;
        siez++;
    }
    public E first(){
        if (isEmpty()){
            return null;
        }
        return data[first];
    }
    public E dequeue(){
        if (isEmpty()){
            return null;
        }
        E answer = data[first];
        data[first] = null;
        first = (first+1) % data.length;
        siez--;
        return answer;
    }
}
