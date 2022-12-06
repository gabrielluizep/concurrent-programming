package engtelecom.poo;

public class Stream1 extends Thread {
  public void printStream1() throws InterruptedException {
    for (int i = 0; i < 10; i++) {
      System.err.println("fluxo1: " + i);
      Thread.sleep(100);
    }
  }

  public void run() {
    try {
      printStream1();
    } catch (InterruptedException e) {
      e.printStackTrace();
    }
  }
}
