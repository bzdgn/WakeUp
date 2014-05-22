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
		
		DatagramSocket datagramSocket = new DatagramSocket(Integer.parseInt(args[1]));
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
					"Received UDP Packet from: [" + packet.getSocketAddress().toString() + "]" + 
					", with payload: " + msg
				);
				
//				Thread.sleep(1000);
//				System.out.println("sleeping");
				
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