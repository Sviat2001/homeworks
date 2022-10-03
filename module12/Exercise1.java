package module12;

import static java.time.temporal.ChronoUnit.SECONDS;

import java.time.LocalTime;

public class Exercise1 {
  static LocalTime startDate = LocalTime.now();

  public static void exercise1() {
    new Thread(() -> {
      while(true) {
        try {
          Thread.sleep(1000);
        } catch (InterruptedException e) {
          throw new RuntimeException(e);
        }


        System.out.println(SECONDS.between(startDate, LocalTime.now()));

      }
    }).start();


    new Thread(() -> {
      while(true) {
        try {
          Thread.sleep(5000);
        } catch (InterruptedException e) {
          throw new RuntimeException(e);
        }

        System.out.println("Пройшло 5 секунд");


      }
    }).start();

  }

  public static void main(String[] args) {
    exercise1();
  }

}
