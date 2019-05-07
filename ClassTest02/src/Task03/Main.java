package Task03;


import java.io.File;
import java.io.IOException;

public class Main {
    public static void main(String[] args) throws IOException {
        File f1 = new File("text1.txt");
        File f2 = new File("text2.txt");
        Product p = new Product(f1,f2);
        Producer producer = new Producer(p);
        Consumer  consumer = new Consumer(p);
        producer.start();
        consumer.start();

    }
}
