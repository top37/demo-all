package demo.utils;

import com.csvreader.CsvReader;
import com.sun.xml.internal.ws.util.Constants;

import java.io.IOException;
import java.nio.charset.Charset;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 *
 * @author 张志刚  2017年8月19日 下午6:39:09
 * @功能 : 数据驱动工具类
 * 		     从CSV格式的文件中读取数据且封装到List中
 */
public class CsvUtils {

    private CsvUtils() {}

    /**
     * <p>
     * 	Title : 从指定的CSV格式的资源文件中获取内容，将内容封装成List<Map<String, String>>形式返回
     * 	CSV第一行内容是标题，对应的是Map中的key
     * 	其他行的内容是values，通过逗号进行隔开
     *  相对jar包路径
     * </p>
     * @author 张志刚  2017年8月19日 下午6:42:26
     * @param  path 	资源文件路径，相对路径
     * @param  encoding		编码格式
     */
    public static List<Map<String, String>> readCsv(String path, String encoding) throws IOException {

        List<Map<String, String>> resList =new ArrayList<>();
        CsvReader reader = new CsvReader(CsvUtils.class.getResourceAsStream(path),',', Charset.forName(encoding));
        reader.setSafetySwitch(false);
        reader.setUseComments(true);
        reader.readHeaders();
        int i = reader.getHeaderCount();
        String[] headers = new String[i];
        for(int j=0;j<=i-1;j++){
            headers[j] = reader.getHeader(j);
        }
        while (reader.readRecord()) {
            if("".equals(reader.getRawRecord()) || reader.getRawRecord()==null) continue;
            Map<String,String> map = new HashMap<>();
            for(int j=0;j<=i-1;j++) {
                map.put(headers[j], reader.get(headers[j]));
            }
            resList.add(map);
        }
        reader.close();

        return resList;
    }

    /**
     * @author 张志刚  2017年8月22日 下午4:13:38
     * @param  path
     * @功能 : 从csv中获取数据封装成List对象，缺省enconding参数，默认为UTF-8
     */
    public static List<Map<String, String>> readCsv(String path) throws IOException {
        return readCsv(path, "UTF-8");
    }

    public static void main(String[] args) throws IOException {
        String path = "/csv/01-车险渠道-车辆信息.csv";
        CsvUtils.readCsv(path);
    }
}

