//package <set your test package>;
import com.experitest.client.*;
import org.junit.*;
/**
 *
 *
*/
public class Untitled {
    private String host = "localhost";
    private int port = 8889;
    private String projectBaseDirectory = "C:\\Users\\gmandala\\workspace\\project2";
    protected Client client = null;

    @Before
    public void setUp(){
        client = new Client(host, port, true);
        client.setProjectBaseDirectory(projectBaseDirectory);
        client.setReporter("xml", "reports", "Untitled");
    }

    @Test
    public void testUntitled(){
        client.setDevice("Cloud Devices");
        client.click("default", "element 0", 0, 1);
    }

    @After
    public void tearDown(){
        client.generateReport(true);
    }
}
