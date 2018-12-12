import com.jcraft.jsch.ChannelSftp;
import com.jcraft.jsch.SftpException;
import demo.util.SFTPUtil;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;

public class SFTPUtil1 {

    private SFTPUtil sftp;
//    private static String sep = File.separator;
    private static String sep = "/";

    @Before
    public void setUp() {
        sftp = new SFTPUtil("zy_test", "8uQRpyOX4+lrq{", "10.163.1.95", 22);
        sftp.login();
    }

    @Test
    public void testUpload() throws FileNotFoundException, SftpException {
        sftp.upload("data","E:\\hehe\\sq.txt");
    }

    @Test
    public void testDownload() {
        try {
            sftp.download("/data/ZhongYouSftp/2027/20270101/","LoanList-GOME-20261231.txt");
        } catch (SftpException | IOException e) {
            e.printStackTrace();
        }
    }

    @Test
    public void okLoad() throws Exception {
        ChannelSftp s = sftp.sftp;
        s.cd("/data");
        s.mkdir("SHANYIN1");
    }

    @After
    public void tearDown(){
        sftp.logout();
    }
}
