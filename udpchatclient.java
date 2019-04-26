import java.net.*;
import java.util.*;
class udpchatclient implements Runnable
{
static DatagramSocket ds;
public static void main(String args[]) throws Exception
{
ds=new DatagramSocket(1024);
byte b[];
Scanner sc=new Scanner(System.in);
String str=" ";
Thread t=new Thread(new udpchatclient());
t.start();
InetAddress i=InetAddress.getLocalHost();
while(!str.equals("stop"))
{
str=sc.next();
b=str.getBytes();
DatagramPacket dp=new DatagramPacket(b,b.length,i,1023);
ds.send(dp);
Thread.sleep(100);
}
System.exit(0);
}
public void run()
{
try
{
String str="";
while(!str.equals("stop"))
{
byte b[]=new byte[10];
DatagramPacket dp=new DatagramPacket(b,10);
ds.receive(dp);
str=new String(b);
System.out.println(str);
Thread.sleep(100);
}
}
catch(Exception e){}
}
}