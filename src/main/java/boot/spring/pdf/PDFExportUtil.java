package boot.spring.pdf;


import com.itextpdf.text.pdf.AcroFields;
import com.itextpdf.text.pdf.BaseFont;
import com.itextpdf.text.pdf.PdfReader;
import com.itextpdf.text.pdf.PdfStamper;

import java.io.ByteArrayOutputStream;
import java.io.FileOutputStream;
import java.io.OutputStream;
import java.util.ArrayList;
import java.util.Map;
import java.util.Objects;

public class PDFExportUtil {
    private static final String FILE_NAME = "xy.pdf";

    /**
     * 根据模版pdf生成新的pdf文件
     * @param targetPdfName
     * @param data
     */
    public static void export(String targetPdfName,Map<String,String> data){
        try {
            // pdf模板所在路径，就是网站制作好后下载的pdf模板路径
            String fileName = Objects.requireNonNull(PDFExportUtil.class.getClassLoader().getResource(FILE_NAME)).getPath();
            PdfReader reader = new PdfReader(fileName);
            ByteArrayOutputStream bos = new ByteArrayOutputStream();
            PdfStamper ps = new PdfStamper(reader, bos);
            // 使用中文字体
            BaseFont bf = BaseFont.createFont("STSong-Light", "UniGB-UCS2-H", BaseFont.NOT_EMBEDDED);
            ArrayList<BaseFont> fontList = new ArrayList<BaseFont>();
            fontList.add(bf);
            AcroFields fields = ps.getAcroFields();
            fields.setSubstitutionFonts(fontList);
            fillData(fields, data);
            //必须要调用这个，否则文档不会生成的
            ps.setFormFlattening(true);
            ps.close();
            //生成pdf路径存放的路径 ->生成pdf
            OutputStream fos = new FileOutputStream(targetPdfName+".pdf");
            fos.write(bos.toByteArray());
            fos.flush();
            fos.close();
            bos.close();
        }catch (Exception e){
            e.printStackTrace();
        }
    }

    /**
     * 填充模板中的数据
     */
    public static void fillData(AcroFields fields, Map<String, String> data) {
        try {
            for (String key : data.keySet()) {
                String value = data.get(key);
                // 为字段赋值,注意字段名称是区分大小写的
                fields.setField(key, value);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}