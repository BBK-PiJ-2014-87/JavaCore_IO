import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;


/**
 * Application reads URL.
 *
 */
public class App01 {
	public static void main(String[] args) throws IOException {
//		InputStream inStream = new URL("http://rus.delfi.lv/").openStream();
		InputStream inStream = new FileInputStream("015_0332_114_Upper_Shirley_Road_cam_01.jpg");
		readFullyByByte(inStream);
	}
	
	
	public static void readFullyByByte(InputStream in) throws IOException{
		while(true){
			int oneByte = in.read();
			if (oneByte != -1){
				System.out.print(oneByte);
			}else{
				System.out.print("\n" + "THE END");
				break;
			}
		}
	}

}
