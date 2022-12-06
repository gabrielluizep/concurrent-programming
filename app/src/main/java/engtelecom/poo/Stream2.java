package engtelecom.poo;

public class Stream2 implements Runnable {
  public void printStream2() throws InterruptedException {
    for (int i = 0; i < 10; i++) {
      System.err.println("fluxo2: " + i);
      Thread.sleep(100);
    }
  }

  @Override
  public void run() {
    try {
      printStream2();
    } catch (InterruptedException e) {
      e.printStackTrace();
    }
  }
}
