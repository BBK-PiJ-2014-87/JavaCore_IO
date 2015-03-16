import java.io.IOException;
import java.io.InputStream;
import java.net.URL;


/**
 * Application reads URL.
 *
 */
public class App01 {
	public static void main(String[] args) throws IOException {
		InputStream inStream = new URL("http://rus.delfi.lv/").openStream();
		readFullyByByte(inStream);
	}
	
	
	public static void readFullyByByte(InputStream in) throws IOException{
		while(true){
			int oneByte = in.read();
			if (oneByte != -1){
				System.out.print((char)oneByte);
			}else{
				System.out.print("\n" + "THE END");
				break;
			}
		}
	}

}
