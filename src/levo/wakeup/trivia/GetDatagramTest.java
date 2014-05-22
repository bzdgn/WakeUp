package levo.wakeup.trivia;

import java.io.IOException;
import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.InetAddress;

public class GetDatagramTest
{

	public static void main(String[] args) throws IOException, InterruptedException
	{
		System.out.println("usage: GetDatagramTest [UDP Port]");
		System.out.println("ex: GetDatagramTest 666");
		
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
				
				try
				{
					Thread.sleep(Long.parseLong(args[1]));
					System.out.println("sleeping for " + args[1] + " ms");
				} catch (InterruptedException e)
				{
					e.printStackTrace();
				}
				
//				try
//				{
//					Thread.sleep(1000);
//					System.out.println("sleeping");
//				} catch (InterruptedException e)
//				{
//					e.printStackTrace();
//				}
//			} finally
//			{
//				;
//			}

		}

	}

}