package levo.wakeup;

import java.io.IOException;
import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.InetAddress;

public class PushDatagram
{

	public static void main(String[] args) throws IOException
	{
		while (true)
		{
			try {
				// byte[] buffer = new byte[65508];
				// byte can be used
				DatagramSocket datagramSocket = new DatagramSocket();
				String buffer = "I'm here, Wake Up please!";

				// Can be traced with RawCap.exe tool for windows local loopback
				// and viewed with Wireshark
				InetAddress address = InetAddress.getByName("192.168.1.101");
				DatagramPacket packet = new DatagramPacket(buffer.getBytes(),
						buffer.length(), address, 9000);

				datagramSocket.send(packet);

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
