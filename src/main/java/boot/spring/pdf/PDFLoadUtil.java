package boot.spring.pdf;

import com.spire.pdf.PdfDocument;
import com.spire.pdf.PdfPageBase;

import java.io.*;
import java.util.HashMap;
import java.util.Map;
import java.util.Objects;

/**
 * @program: SSM
 * @description:
 * @author: Hatake
 * @create: 2020-12-14 19:27
 **/
public class PDFLoadUtil {

    public static void main(String[] args) {
        InputStream fileInputStream = PDFLoadUtil.class.getClassLoader().getResourceAsStream(SOURCE_PDF_NAME);
        PDFExportUtil.export("res",PDFLoadUtil.getDataFromPDF(fileInputStream));
    }

    private static final String SOURCE_PDF_NAME = "HT.pdf";

    private static final String SELL_USER_NAME = "sellUserName";
    private static final String SELL_USER_ACCOUNT_NAME = "sellUserAccountName";
    private static final String SELL_USER_ACCOUNT_NUMBER = "sellUserAccountNumber";

    private static final String BUY_USER_NAME = "buyUserName";
    private static final String BUY_USER_ACCOUNT_NAME = "buyUserAccountName";
    private static final String BUY_USER_ACCOUNT_NUMBER = "buyUserAccountNumber";

    private static final String ITEM_NAME = "itemName";
    private static final String ITEM_NUMBER = "itemNumber";
    private static final String ITEM_PRICE= "itemPrice";

    private static final String YEAR = "year";
    private static final String MONTH = "month";
    private static final String DAY = "day";


    /**
     * 从用户提交的pdf文件中读取数据
     * @param inputStream
     * @return
     */
    private static Map<String,String> getDataFromPDF(InputStream inputStream){
        PdfDocument pdfDocument = new PdfDocument();
        pdfDocument.loadFromStream(inputStream);
        PdfPageBase page = pdfDocument.getPages().get(0);
        String [] arr  = page.extractText(true).split("\\n");
        int acconutNameMark = 0;
        int acconut = 0;
        HashMap<String,String> keyWords = new HashMap<>();
        for (String anArr : arr) {
            int index = anArr.indexOf("：");
            if (anArr.contains("买家：")) {
                String buyName = anArr.substring(index + 1, anArr.length());
                keyWords.put(BUY_USER_NAME, buyName);
            } else if (anArr.contains("卖家：")) {
                String sellName = anArr.substring(index + 1, anArr.length());
                keyWords.put(SELL_USER_NAME, sellName);
            } else if (anArr.contains("户名：")) {
                if (acconutNameMark == 0) {
                    String sellAcconutName = anArr.substring(index + 1, anArr.length());
                    keyWords.put(SELL_USER_ACCOUNT_NAME, sellAcconutName);
                    acconutNameMark++;
                } else {
                    String buyAcconutName = anArr.substring(index + 1, anArr.length());
                    keyWords.put(BUY_USER_ACCOUNT_NAME, buyAcconutName);
                }
            } else if (anArr.contains("账号：")) {
                if (acconut == 0) {
                    String sellAcconut = anArr.substring(index + 1, anArr.length());
                    keyWords.put(SELL_USER_ACCOUNT_NUMBER, sellAcconut);
                    acconut++;
                } else {
                    String buyAcconut = anArr.substring(index + 1, anArr.length());
                    keyWords.put(BUY_USER_ACCOUNT_NUMBER, buyAcconut);
                }
            } else if (anArr.contains("商品：")) {
                String itemName = anArr.substring(index + 1, anArr.length());
                keyWords.put(ITEM_NAME, itemName);

            } else if (anArr.contains("数量：")) {
                String itemNum = anArr.substring(index + 1, anArr.length());
                keyWords.put(ITEM_NUMBER, itemNum);
            } else if (anArr.contains("单价：")) {
                String itemPrice = anArr.substring(index + 1, anArr.length());
                keyWords.put(ITEM_PRICE, itemPrice);
            } else if (anArr.contains("年") && anArr.contains("月") && anArr.contains("日")) {
                String year = anArr.substring(0, anArr.indexOf("年")).trim();
                String month = anArr.substring(anArr.indexOf("年") + 1, anArr.indexOf("月"));
                String day = anArr.substring(anArr.indexOf("月") + 1, anArr.indexOf("日"));

                keyWords.put(YEAR, year);
                keyWords.put(MONTH, month);
                keyWords.put(DAY, day);
            }
        }
        //todo 计算总价
        keyWords.put("totalPrice","不知道怎么算和格式");
        return keyWords;
    }

}
