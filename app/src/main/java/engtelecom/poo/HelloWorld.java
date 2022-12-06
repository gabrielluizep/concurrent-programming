package engtelecom.poo;

public class HelloWorld extends Thread {

  public HelloWorld() {
    super("1");
  }

  public HelloWorld(String name) {
    super(name);
  }

  @Override
  public void run() {
    Thread next = null;

    if (!this.getName().equals("10")) {
      next = new HelloWorld(Integer.toString(Integer.parseInt(this.getName()) + 1));
      next.start();
    }

    if (next != null) {
      try {
        next.join();
      } catch (InterruptedException e) {
        e.printStackTrace();
      }
    }

    System.err.println("Hello World! " + getName());

  }

}