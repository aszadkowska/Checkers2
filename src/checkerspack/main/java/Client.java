import io.socket.client.IO;
import io.socket.client.Socket;
import io.socket.emitter.Emitter;

import java.net.URISyntaxException;

/**
 * Created by ada on 26.04.17.
 */
public class Client {
    public static void main(String [] args) throws URISyntaxException {

        final Socket socket = IO.socket("http://192.168.0.101:3000");
        socket.on(Socket.EVENT_CONNECT, new Emitter.Listener() {


            public void call(Object... args) {
//                socket.emit("chat message", "hi");
//                socket.disconnect();
            }

        }).on("message", new Emitter.Listener() {

            public void call(Object... args) {
                String data = (String) args[0];
                System.out.println(data);
            }
        }).on(Socket.EVENT_DISCONNECT, new Emitter.Listener() {

            public void call(Object... args) {
            }
        });
        socket.connect();
    }
}
