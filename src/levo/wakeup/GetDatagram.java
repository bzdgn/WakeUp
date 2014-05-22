package levo.wakeup;

import java.io.IOException;
import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.InetAddress;

public class GetDatagram
{

	public static void main(String[] args) throws IOException
	{
		while (true)
		{
			try
			{
				DatagramSocket datagramSocket = new DatagramSocket(80);

//				byte[] buffer = new byte[10];
//				byte can be used
				String buffer = "";
				
				DatagramPacket packet = new DatagramPacket(buffer.getBytes(), buffer.length());

				datagramSocket.receive(packet);
				
				System.out.println
				(
					"Received UDP Packet from: [" + packet.getSocketAddress().toString() + ":" + packet.getSocketAddress().toString() +
					":" + packet.getPort() + " , with payload: " + buffer
				);

				try
				{
					Thread.sleep(1000);
					System.out.println("sleeping");
				} catch (InterruptedException e)
				{
					e.printStackTrace();
				}
			} finally
			{
				;
			}

		}

	}

}