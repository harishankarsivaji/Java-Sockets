public class RunServer {
    public static void main(String argv[]) throws Exception {
        ThreadPooledServer server = new ThreadPooledServer(5550);
        new Thread(server).start();
            try {
                Thread.sleep(20 * 1000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            System.out.println("Stopping Server");
            server.stop();
    }
}
