package jsmart.core;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.OutputStream;
import java.io.PrintStream;

public class BaseAPITest {

    Logger logger = LoggerFactory.getLogger(this.getClass());

    protected PrintStream printStream;

    protected PrintStream getPrintStream() {
        if (printStream == null) {
            OutputStream output = new OutputStream() {
                ByteArrayOutputStream baos = new ByteArrayOutputStream();

                @Override
                public void write(int b) throws IOException {
                    baos.write(b);
                }

                @Override
                public void flush() {
                    logger.debug(this.baos.toString());
                    baos = new ByteArrayOutputStream();
                }
            };
            printStream = new PrintStream(output, true);  // true: autoflush must be set!
        }
        return printStream;
    }
}
