package lab1;

import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;


public class DeleteZeroLab {
	public static void filterElem(InputStream in, OutputStream out) throws IOException{
		while (true){
			int value = in.read();
			if (value > 0){
				out.write(value);
			}else if(value == -1){
				break;
			}
		}
	}
	
	public static void filterBuff(InputStream in, OutputStream out, int buffSize) throws IOException{
		final int ZERO_STATE = 0;
		final int NUMBER_STATE = 1;
		byte[] buff = new byte[buffSize];
		int count;
		while((count = in.read(buff)) != -1){
			int state = ZERO_STATE;
			for(int index = 0; index < count; index++){
				switch(state){
				case ZERO_STATE:
					if(buff[index] > 0){//change
						//
						state = ZERO_STATE;
					}else{
						//
						state = NUMBER_STATE;
					}
					break;
				case NUMBER_STATE:
					if(buff[index] > 0){ //change
						//
						state = ZERO_STATE;
					}else{
						//
						state = NUMBER_STATE;
					}
					
				}
			}
			if (state == ZERO_STATE){
				//
			}else{
				//
			}
		}
	}

}
