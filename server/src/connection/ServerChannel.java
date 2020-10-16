package connection;

import java.io.*;
import java.net.*;
import java.nio.ByteBuffer;
import java.nio.channels.DatagramChannel;

public class ServerChannel {
    private int port;
    private InetSocketAddress address;
    private DatagramSocket socket;
    private DatagramChannel channel;
    private SocketAddress client;

    public ServerChannel(int port) throws IOException {
        this.port = port;
        channel = DatagramChannel.open();
        channel.configureBlocking(false);
        address = new InetSocketAddress("localhost", port);
        socket = channel.socket();
        socket.bind(address);
    }

    public Message recieveMessage() throws IOException, ClassNotFoundException, InterruptedException {
        ByteBuffer in = ByteBuffer.allocate(65507);
        byte[] byteMessage;
        while (true){
            client = channel.receive(in);
            if(client == null){
                return new Message("NO");
            }
            in.flip();
            byteMessage = new byte[in.remaining()];
            in.get(byteMessage);
            if(client != null){
                break;
            }
        }
        ByteArrayInputStream byteArrayInputStream = new ByteArrayInputStream(byteMessage);
        ObjectInputStream objectInputStream = new ObjectInputStream(byteArrayInputStream);
        return (Message) objectInputStream.readObject();
    }

    public void sendMessage(Message message) throws IOException {
        ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
        ObjectOutputStream objectOutputStream = new ObjectOutputStream(byteArrayOutputStream);
        objectOutputStream.writeObject(message);
        objectOutputStream.flush();
        byte[] byteMessage = byteArrayOutputStream.toByteArray();
        ByteBuffer buf = ByteBuffer.wrap(byteMessage);
        channel.send(buf, client);
        //channel.close();
        System.out.println("Message sent to "+client.toString());
    }
}
