package Task03;
public class Producer extends Thread {
    private Product product;

    public Producer(Product product) {
        this.product = product;
    }

    @Override
    public void run() {
        while (!product.isEnd()) {
            synchronized (product) {
                while (!product.isConsumed()) {
                    try {
                        product.wait();
                    } catch (InterruptedException e) {
                        throw new IllegalArgumentException(e);
                    }
                }
                product.produce();
                product.notify();
            }
        }
    }
}