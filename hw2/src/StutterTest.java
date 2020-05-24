import org.junit.Test;
import org.junit.Before;
import org.junit.After;
import org.junit.platform.commons.util.ExceptionUtils;
import org.junit.runner.FilterFactory;
import java.io.File;
import static org.junit.Assert.*;
import java.io.*;

public class StutterTest {

    @Before
    public void createFile() throws IOException {
        PrintWriter writer = new PrintWriter("aaaa", "UTF-8");
        writer.println("asdf--fdsa");
        writer.println("asdf--fdsa");
        writer.close();
    }

    @After
    public void deleteFile() throws IOException {
        File f = new File("aaaa");
        f.delete();
    }

    @Test
    public void testA() throws IOException {
        Stutter stutter = new Stutter();
        String[] strings = {"aaaa"};
        stutter.main(strings);
    }

    @Test
    public void testB() throws IOException {
        Stutter stutter = new Stutter();
        String[] strings = {null};

        InputStream sysInBackup = System.in; // backup System.in to restore it later
        ByteArrayInputStream in = new ByteArrayInputStream("asdf".getBytes());
        System.setIn(in);

        stutter.main(strings);

        System.setIn(sysInBackup);

    }

    @Test
    public void testC() throws IOException {
        Stutter stutter = new Stutter();
        String[] strings = {};

        InputStream sysInBackup = System.in; // backup System.in to restore it later
        ByteArrayInputStream in = new ByteArrayInputStream("asdf".getBytes());
        System.setIn(in);

        stutter.main(strings);

        System.setIn(sysInBackup);

    }
}