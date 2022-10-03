package module12;


import java.util.LinkedList;
import java.util.Queue;
import java.util.concurrent.Semaphore;
import java.util.concurrent.atomic.AtomicInteger;

public class Exercise2 {
  private Queue<String> forOutput = new LinkedList<>();
  private AtomicInteger currentInteger = new AtomicInteger(1);
  private AtomicInteger maxInteger = new AtomicInteger(1);
  private Semaphore semaphore = new Semaphore(1);

  Exercise2(int n) {
    currentInteger.set(1);
    maxInteger.set(n);
  }
  void fizz() {
    while(currentInteger.get() <= maxInteger.get()) {
      try {
        semaphore.acquire();
        if(currentInteger.get() % 3 == 0
            && currentInteger.get() % 5 != 0
            && currentInteger.get() <= maxInteger.get()) {
          forOutput.add("fizz");
          currentInteger.incrementAndGet();
        }
      } catch (InterruptedException e) {
        throw new RuntimeException(e);
      } finally {
        semaphore.release();
      }
    }
  }

  void buzz() {
    while(currentInteger.get() <= maxInteger.get()) {
      try {
        semaphore.acquire();
        if(currentInteger.get() % 3 != 0
            && currentInteger.get() % 5 == 0
            && currentInteger.get() <= maxInteger.get()) {
          forOutput.add("buzz");
          currentInteger.incrementAndGet();
        }
      } catch (InterruptedException e) {
        throw new RuntimeException(e);
      } finally {
        semaphore.release();
      }
    }
  }

  void fizzbuzz() {
    while(currentInteger.get() <= maxInteger.get()) {
      try {
        semaphore.acquire();
        if(currentInteger.get() % 3 == 0
            && currentInteger.get() % 5 == 0
            && currentInteger.get() <= maxInteger.get()) {

          forOutput.add("fizzbuzz");
          currentInteger.incrementAndGet();
        }
      } catch (InterruptedException e) {
        throw new RuntimeException(e);
      } finally {
        semaphore.release();
      }
    }
  }

  void number() {

    while(currentInteger.get() <= maxInteger.get() || forOutput.size() > 0) {
      try {
        semaphore.acquire();

        if(currentInteger.get() % 3 != 0
            && currentInteger.get() % 5 != 0
            && currentInteger.get() <= maxInteger.get()) {
          forOutput.add("" + currentInteger.getAndIncrement());
        }

        while(forOutput.size() > 0) {
          if(forOutput.size() == 1 && currentInteger.get() > maxInteger.get()) {
            System.out.print(forOutput.poll());
          } else {
            System.out.print(forOutput.poll() + ", ");
          }
        }


      } catch (InterruptedException e) {
        throw new RuntimeException(e);
      } finally {
        semaphore.release();
      }

    }

  }


  public static void main(String[] args) {
    Exercise2 ex2 = new Exercise2(15);

    Thread A = new Thread(ex2::fizz);
    Thread B = new Thread(ex2::buzz);
    Thread C = new Thread(ex2::fizzbuzz);
    Thread D = new Thread(ex2::number);

    A.start();
    B.start();
    C.start();
    D.start();
  }

}
