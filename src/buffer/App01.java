package buffer;


import java.io.*;
import java.util.zip.GZIPOutputStream;

public class App01 {

	public static void main(String[] args) throws IOException {
		ByteArrayOutputStream buff = new ByteArrayOutputStream();
		OutputStream dst = new BufferedOutputStream(buff, 8*1024);
		dst = new GZIPOutputStream(dst);
		DataOutput out = new DataOutputStream(dst);
		
		for (int k=0; k < 1_000_000;k++){
			out.writeDouble(k % 2 == 0 ? 0.5 : 1.5);
		}
		
		dst.flush();
		dst.close();
		byte[] rawData = buff.toByteArray();
		System.out.println(rawData.length);
	}

}
