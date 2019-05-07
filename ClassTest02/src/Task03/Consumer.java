package Task03;

public class Consumer extends Thread {
    private Product product;

    public Consumer(Product product) {
        this.product = product;
    }

    @Override
    public void run() {
        while (!product.isEnd()) {
            synchronized (product) {
                while (!product.isProduced()) {
                    try {
                        product.wait();
                    } catch (InterruptedException e) {
                        throw new IllegalArgumentException(e);
                    }
                }
                product.consume();
                product.notify();
            }
        }
    }
}