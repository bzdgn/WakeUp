package levo.wakeup.trivia;

import java.io.IOException;
import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.InetAddress;

public class UdpPortForwarder
{

	public static void main(String[] args) throws IOException, InterruptedException
	{
		System.out.println("usage: UdpPortForwarder [UDP Port] [Forward Target Ip] [Target UDP Port] [Listener Sleep Interval in ms]");
		System.out.println("ex: UdpPortForwarder 666 777 192.168.1.66 1000");
		
		System.out.println("");
		System.out.println("Listener initializing;");
		for(int j = 0; j < 10; j++)
			for(int i = 0; i < 40; i++)
				System.out.printf(".");
		System.out.println("Listener: UDP Port[" + args[0] + "]");
		DatagramSocket datagramSocket = new DatagramSocket(Integer.parseInt(args[0]));
		byte[] buffer = new byte[1024];
		
		while (true)
		{			
//			try
//			{
				
//				byte can be used
				
				DatagramPacket packet = new DatagramPacket(buffer, buffer.length);

				datagramSocket.receive(packet);
				byte[] buffer2 = packet.getData();
				String msg = new String(buffer2, "UTF-8");
				
				System.out.println
				(
					"Received UDP Packet from: [" + packet.getSocketAddress().toString() + "]"
				);
				System.out.println("...Payload: " + msg);
				
				//FORWARD HERE
				//************
				DatagramSocket forwardDatagramSocket = new DatagramSocket();

				// Can be traced with RawCap.exe tool for windows local loopback
				// and viewed with Wireshark
				InetAddress address = InetAddress.getByName(args[1]);
				DatagramPacket forwardPacket = new DatagramPacket(buffer2,
						buffer2.length, address, Integer.parseInt(args[2]));

				forwardDatagramSocket.send(forwardPacket);
				System.out.println("Packet forwarded to: " + args[1] + ":" + args[2]);
				//************
				//FORWARD HERE
				
				forwardDatagramSocket = null;
				forwardPacket = null;
				packet = null;
				
				try
				{
					Thread.sleep(Long.parseLong(args[3]));
					System.out.println("sleeping for " + args[1] + " ms");
				} catch (InterruptedException e)
				{
					e.printStackTrace();
				}

		}

	}

}