package levo.wakeup.trivia;

import java.io.IOException;
import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.InetAddress;

public class PushDatagramTest
{

	public static void main(String[] args) throws IOException
	{
		System.out.println("usage: PushDatagramTest [Target IP] [UDP Port] [Sleep Interval in ms]");
		System.out.println("ex: PushDatagramTest 192.168.1.19 666 1000");
		while (true)
		{
			try
			{
				// byte[] buffer = new byte[65508];
				// byte can be used
				DatagramSocket datagramSocket = new DatagramSocket();
				String buffer = "I'm here, Wake Up please!";

				// Can be traced with RawCap.exe tool for windows local loopback
				// and viewed with Wireshark
				InetAddress address = InetAddress.getByName(args[1]);
				DatagramPacket packet = new DatagramPacket(buffer.getBytes(),
						buffer.length(), address, Integer.parseInt(args[2]));

				datagramSocket.send(packet);

				try
				{
					Thread.sleep(Long.parseLong(args[3]));
					System.out.println("sleeping");
				} catch (InterruptedException e)
				{
					e.printStackTrace();
				}
			}
			finally
			{
				;
			}

		}

	}
}
