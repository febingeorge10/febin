import java.net.*;
import java.util.*;
class udpchatserver implements Runnable
{
static DatagramSocket ds;
public static void main(String args[]) throws Exception
{
ds=new DatagramSocket(1023);
Thread t=new Thread(new udpchatserver());
t.start();
try
{
String str="";
while(!str.equals("stop"))
{
byte b[]=new byte[10];
DatagramPacket dp=new DatagramPacket(b,10);
ds.receive(dp);
str=new String(b).trim();
System.out.println(str);
}
}
catch(Exception e){}
System.exit(0);
}
public void run()
{
try
{
byte b[];
Scanner sc=new Scanner(System.in);
String str="";
InetAddress i=InetAddress.getLocalHost();
while(!str.equals("stop"))
{
str=sc.next();
b=str.getBytes();
DatagramPacket dp=new DatagramPacket(b,b.length,i,1024);
ds.send(dp);
Thread.sleep(100);
}
}
catch(Exception e){}
}
}

