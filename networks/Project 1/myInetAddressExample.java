import java.net.*;  // for InetAddress
import java.util.*; //for Scanner

public class myInetAddressExample {

  public static void main(String[] args) {

    // Get name and IP address of the local host
    Scanner scanner = new Scanner(System.in);
      System.out.print("Please enter a hostname address: ");
      String address = scanner.next();
    try {
      InetAddress hostAddress = InetAddress.getByName(address);
      String ipAddress = hostAddress.getHostAddress();
      System.out.println("The hostname address in binary is : " + getBinary(ipAddress));
      System.out.println("The hostname address in binary dotted-quad format : " + getBinaryQuad(ipAddress));
      System.out.println("The hostname address in decimal dotted-quad format : " + ipAddress);
    } catch (UnknownHostException e) {
      System.out.println("Unable to determine this host's address");
    }
}

    private static String getBinary(String ip) {
      String ans = "";
      String[] arr = ip.split("\\.", 4);
      for (String str : arr) {
          int a = Integer.parseInt(str);
          String b = Integer.toBinaryString(a);
          ans += b;
      }
      return ans;
  }

  private static String getBinaryQuad(String ip) {
    String ans = "";
    String[] arr = ip.split("\\.", 4);
    int count = 0;
    for (String str : arr) {
        int a = Integer.parseInt(str);
        String b = Integer.toBinaryString(a);
        count++;
        if (count <= 3) {
            ans += b + ".";
        } else {  ans += b; }
      }
      return ans;
  }
}