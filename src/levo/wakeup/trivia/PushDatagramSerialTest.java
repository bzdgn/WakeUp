package levo.wakeup.trivia;

import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.ObjectOutputStream;
import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.InetAddress;

import levo.wakeup.model.UdpObject;

public class PushDatagramSerialTest
{

	public static void main(String[] args) throws IOException
	{
		while (true)
		{
			try
			{
				// byte[] buffer = new byte[65508];
				// byte can be used
				DatagramSocket datagramSocket = new DatagramSocket();
				UdpObject ob = new UdpObject("Levent", "I'm here, please wake up!");
				
				ByteArrayOutputStream b = new ByteArrayOutputStream();
				ObjectOutputStream objectOut = new ObjectOutputStream(b);
				objectOut.writeObject(ob);
				objectOut.flush(); //we have our serialized object instance as bytes
				
				// Can be traced with RawCap.exe tool for windows local loopback
				// and viewed with Wireshark
				InetAddress address = InetAddress.getByName("85.105.173.113");
//				DatagramPacket packet = new DatagramPacket(buffer.getBytes(),
//						buffer.length(), address, 9000);
				DatagramPacket packet = new DatagramPacket(b.toByteArray(), b.toByteArray().length, address, 9000);

				datagramSocket.send(packet);

				try
				{
					Thread.sleep(1000);
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
