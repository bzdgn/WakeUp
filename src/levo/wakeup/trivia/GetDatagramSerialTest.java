package levo.wakeup.trivia;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.InetAddress;

import levo.wakeup.model.UdpObject;

public class GetDatagramSerialTest
{

	public static void main(String[] args) throws IOException, InterruptedException, ClassNotFoundException
	{
		DatagramSocket datagramSocket = new DatagramSocket(9000);
		byte[] buffer = new byte[20];
		
		while (true)
		{			
//			try
//			{
				
//				byte can be used
				
				DatagramPacket packet = new DatagramPacket(buffer, buffer.length);

				datagramSocket.receive(packet);
				byte[] byteArr = packet.getData();
				
				UdpObject ob = null;
				
				ByteArrayInputStream bIn = new ByteArrayInputStream(byteArr);
				ObjectInputStream objectIn = new ObjectInputStream(bIn);
				ob = (UdpObject)objectIn.readObject();
				
				System.out.println("Name = " + ob.getName() + ", Message = " + ob.getMessage());
				
				
				
				
				
//				System.out.println
//				(
//					"Received UDP Packet from: [" + packet.getSocketAddress().toString() + "]" + 
//					", with payload: " + msg
//				);
				
				Thread.sleep(1000);
				System.out.println("sleeping");
				
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