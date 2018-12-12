package com.sq.ncreport.constant;

public interface Constant {

    interface Http{
        String SESSION = "SESSION";
        Integer _1 = 1;
    }

    interface File{
        String FILE_NAME_DEMO = "BkMsg_Xvoucher_N_(1).xml";
        String FILE_ERR_NAME_DEMO = "BkMsg_Err_Xvoucher_N_(1).xml";
    }

    interface Charset{
        String UTF8 = "UTF-8";
    }

    interface Xml{
        String XML_0 = "<?xml version=\"1.0\" encoding='UTF-8'?>\n" +
                "<ufinterface billtype=\"gl\" filename=\"20181119voucher_3_(1).xml\" isexchange=\"Y\" proc=\"add\" receiver=\"N100130@N100130-0002\" replace=\"Y\" roottag=\"sendresult\" sender=\"9998\" successful=\"Y\">\n" +
                "    <sendresult>\n" +
                "        <billpk>\n" +
                "        </billpk>\n" +
                "        <bdocid>20181119_6</bdocid>\n" +
                "        <filename>20181119voucher_3_(1).xml</filename>\n" +
                "        <resultcode>1</resultcode>\n" +
                "        <resultdescription>单据20181119_6开始处理...\n" +
                "单据20181119_6处理完毕!</resultdescription>\n" +
                "        <content>2018.11-业务凭证-6</content>\n" +
                "    </sendresult>\n" +
                "</ufinterface>";

        String XML_1 = "<?xml version=\"1.0\" encoding='UTF-8'?>\n" +
                "<ufinterface billtype=\"gl\" filename=\"20181119voucher_2_(1).xml\" isexchange=\"Y\" proc=\"add\" receiver=\"N100574@N100574-0002\" replace=\"Y\" roottag=\"sendresult\" sender=\"9998\" successful=\"N\">\n" +
                "\t<sendresult>\n" +
                "        <billpk>\n" +
                "        </billpk>\n" +
                "        <bdocid>20181119_558</bdocid>\n" +
                "        <filename>20181119voucher_2_(1).xml</filename>\n" +
                "        <resultcode>-31004</resultcode>\n" +
                "        <resultdescription>由于同一批中其他单据出现错误，此单据也取消导入，请修正错误后再试.</resultdescription>\n" +
                "        <content>2018.11-业务凭证-558</content>\n" +
                "    </sendresult>\n" +
                "    <sendresult>\n" +
                "        <billpk>\n" +
                "        </billpk>\n" +
                "        <bdocid>20181119_559</bdocid>\n" +
                "        <filename>20181119voucher_2_(1).xml</filename>\n" +
                "        <resultcode>-32000</resultcode>\n" +
                "        <resultdescription>单据20181119_559开始处理...\n" +
                "单据20181119_559处理错误:业务插件处理错误:插件类=nc.bs.gl.pfxx.VoucherPlugin,异常信息:\n" +
                "java.lang.NullPointerException</resultdescription>\n" +
                "        <content></content>\n" +
                "    </sendresult>\n" +
                "    <sendresult>\n" +
                "        <billpk>\n" +
                "        </billpk>\n" +
                "        <bdocid>20181119_560</bdocid>\n" +
                "        <filename>20181119voucher_2_(1).xml</filename>\n" +
                "        <resultcode>-31004</resultcode>\n" +
                "        <resultdescription>由于同一批中其他单据出现错误，此单据也取消导入，请修正错误后再试.</resultdescription>\n" +
                "        <content>2018.11-业务凭证-560</content>\n" +
                "    </sendresult>\n" +
                "</ufinterface>";

        String XML_DEMO = "<books>\n" +
                "    <book>\n" +
                "        <author>Thomas</author>\n" +
                "        <title>Java从入门到放弃</title>\n" +
                "        <publisher>UCCU</publisher>\n" +
                "    </book>\n" +
                "    <book>\n" +
                "        <author>小白</author>\n" +
                "        <title>MySQL从删库到跑路</title>\n" +
                "        <publisher>Go Die</publisher>\n" +
                "    </book>\n" +
                "    <book>\n" +
                "        <author>PHPer</author>\n" +
                "        <title>Best PHP</title>\n" +
                "        <publisher>PHPchurch</publisher>\n" +
                "    </book>\n" +
                "</books>";
    }

}
