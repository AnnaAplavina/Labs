package connection;

import inputOutput.InputOutputManager;
import inputOutput.NoScannerInputException;

import java.io.*;
import java.net.*;

public class ClientServerConnection {
    private InetAddress server;
    private int port;
    private DatagramSocket socket;
    private InputOutputManager inputOutputManager;

    public ClientServerConnection(String dns, int port, InputOutputManager inputOutputManager) throws UnknownHostException, SocketException {
        this.server = InetAddress.getByName(dns);
        this.port = port;
        this.inputOutputManager = inputOutputManager;
        socket = new DatagramSocket();
    }

    public void sendMessage(Message message) throws IOException {
        ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
        ObjectOutputStream objectOutputStream = new ObjectOutputStream(byteArrayOutputStream);
        objectOutputStream.writeObject(message);
        objectOutputStream.flush();
        byte[] byteMessage = byteArrayOutputStream.toByteArray();
        DatagramPacket packet = new DatagramPacket(byteMessage, byteMessage.length ,server, port);
        System.out.println(" "+ packet.getAddress() + "port " + packet.getPort());
        socket.send(packet);
    }

    public Message receiveMessege() throws IOException, ClassNotFoundException, NoScannerInputException {
        socket.setSoTimeout(7000);
        byte[] buff = new byte[10000];
        DatagramPacket packet = new DatagramPacket(buff, buff.length);
        try{socket.receive(packet);}
        catch (SocketTimeoutException ex){
            System.out.println("Не получен ответ от сервера, чтобы продолжить ожидание введите 1");
            if(inputOutputManager.nextLine().equals("1")){
                return receiveMessege();
            }
        }
        byte[] receivedData = packet.getData();
        ByteArrayInputStream byteArrayInputStream = new ByteArrayInputStream(receivedData);
        ObjectInputStream objectInputStream = new ObjectInputStream(byteArrayInputStream);
        byteArrayInputStream.close();
        objectInputStream.close();
        return (Message) objectInputStream.readObject();
    }

    public void closeSocket(){
        socket.close();
    }
}
