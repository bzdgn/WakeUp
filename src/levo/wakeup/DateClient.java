package levo.wakeup;

import java.io.IOException;
import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.InetAddress;

/**
 * Trivial client for the date server.
 */
public class DateClient {

    /**
     * Runs the client as an application.  First it displays a dialog
     * box asking for the IP address or hostname of a host running
     * the date server, then connects to it and displays the date that
     * it serves.
     */
    public static void main(String[] args) throws IOException
    {
        String serverAddress = "192.168.2.89";
        
        while(true)
        {
//        	Socket s = new Socket(serverAddress, 9090);
        	
            try
            {
//            	byte[] buffer = new byte[65508];
            	DatagramSocket datagramSocket = new DatagramSocket();
            	String buffer = "I'm here, Wake Up please!";
            	
            	InetAddress address = InetAddress.getByName("localhost");
            	DatagramPacket packet = new DatagramPacket(buffer.getBytes(), buffer.length(), address, 9000);
            	InetAddress address2 = InetAddress.getByName("192.168.2.89");
            	DatagramPacket packet2 = new DatagramPacket(buffer.getBytes(), buffer.length(), address, 9000);
            	
            	datagramSocket.send(packet);
            	
////            	MulticastSocket s = new MulticastSocket(8080);
//            	Socket s = new Socket("localhost", 9090)
//            	String msg = "I'm here, Wake Up please!";
//            	InetAddress ip = InetAddress.getByName("localhost");
////            	InetAddress ip = InetAddress.getByName("192.168.2.89");
//            	DatagramPacket hi = new DatagramPacket(msg.getBytes(), msg.length(), ip, 8080);
//            	s.send(hi);
            	
//            	 String msg = "I'm here, Wake Up please!";
//            	 InetAddress group = InetAddress.getByName(serverAddress);
//            	 MulticastSocket s = new MulticastSocket(6789);
//            	 s.joinGroup(group);
//            	 DatagramPacket hi = new DatagramPacket(msg.getBytes(), msg.length(),
//            	                             group, 6789);
//            	 s.send(hi);
            	
//                PrintWriter out =
//                    new PrintWriter(s.getOutputStream(), true);
//                out.println("I'm here, Wake Up please!");
            	try {
					Thread.sleep(1000);
					System.out.println("sleeping");
				} catch (InterruptedException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
            } finally 
            {
                ;
            }

        }
        
    }
}
