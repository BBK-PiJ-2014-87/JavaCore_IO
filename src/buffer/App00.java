package buffer;

import java.io.BufferedOutputStream;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.OutputStream;
import java.util.Arrays;

/**
 * DECORATOR Pattern (two same classes on both ends);
 *
 */
public class App00 {
	public static void main(String[] args) throws IOException {
		OutputStream dst = new ByteArrayOutputStream();
		dst = new LogOS("AFTER:", dst);
		dst = new BufferedOutputStream(dst, 2);
		dst = new LogOS("BEFORE:", dst);

		dst.write(1);
		dst.write(2);
		dst.write(3);
		dst.write(4);
		dst.write(5);
		dst.flush();
		dst.close();
	}
}

class LogOS extends OutputStream {
	private final OutputStream impl;
	private final String name;

	LogOS(String name, OutputStream impl) {
		this.impl = impl;
		this.name = name;
	}

	@Override
	public void write(int b) throws IOException {
		System.out.println(name + ":write(" + b + ")");
		impl.write(b);
	}

	@Override
	public void write(byte[] b) throws IOException {
		System.out.println(name + ":write(" + Arrays.toString(b) + ")");
		impl.write(b);
	}

	@Override
	public void write(byte[] b, int off, int len) throws IOException {
		System.out.println(name + ":write(" + Arrays.toString(b) + ","
				+ off + "," + len + ")");
		impl.write(b, off, len);
	}

	@Override
	public void flush() throws IOException {
		System.out.println("flush");
		impl.flush();
	}

	@Override
	public void close() throws IOException {
		System.out.println("close");
		impl.close();
	}
}