import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.URL;


/**
 * App reads data from URL and writes it into txt file using buffer.
 *
 */
public class App03_IS_OSbuf {

	public static void main(String[] args) {
		
		String srcFile = "http://www.zenbacteria.com/";
		String trgtFile = "zenbacteria.txt";
		
		try(InputStream source = new URL(srcFile).openStream();
			OutputStream target = new FileOutputStream(trgtFile)){
			copy(source,target);
			
		} catch (FileNotFoundException e) {
			System.out.println("No such file.");
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	
	public static void copy(InputStream source, OutputStream target) throws IOException{
		//creating a 64Kb buffer
		byte[] buffer = new byte[64*1024];
		while(true){
			//returns count of data
			int count = source.read(buffer);
			if (count != -1){
				target.write(buffer, 0, count);
			}else{
				return;
			}
		}
	}

}
