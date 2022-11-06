package task2;

public class FizzBuzz extends Thread implements MyProducer {
    int n;
    boolean updated = false;
    boolean stop = false;

    @Override
    public void setN(int n) {
        this.n = n;
        updated = true;
    }

    @Override
    public boolean isUpdated() {
        return updated;
    }

    @Override
    public void inter(boolean bool) {
        this.stop = bool;
    }

    @Override
    public synchronized void run() {
        while (!stop) {
            try {
                if (updated) {
                    updated = false;
                    if (n % 15 == 0) {
                        System.out.println("FizzBuzz");
                        notifyAll();
                    }
                }
                Thread.sleep(100);
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }

        }

    }
}
