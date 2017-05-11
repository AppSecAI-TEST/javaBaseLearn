package com.learn.utils;

import java.io.*;

/**
 * Created by xia_yu on 2017/5/11.
 */
public class JsonUtil {
    public static String readJsonFile(String jsonPath,String encoding) throws UnsupportedEncodingException, FileNotFoundException {
        StringBuilder stringBuilder=new StringBuilder();
        File file=new File(jsonPath);
        String result= null;
        InputStreamReader read=null;
        try {
            try {
                read = new InputStreamReader(new FileInputStream(file), encoding);
            } catch (UnsupportedEncodingException e) {
                throw new UnsupportedEncodingException("不支持的编码格式");
            }
            BufferedReader reader=new BufferedReader(read);
            try {
                while((result=reader.readLine())!=null){
                    stringBuilder.append(result);
                }
                reader.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        } catch (FileNotFoundException e) {
           throw new FileNotFoundException("文件不存在！");
        }
        return stringBuilder.toString();
    }
    public static String formatJson(String jsonStr) {
        if (null == jsonStr || "".equals(jsonStr))
            return "";
        StringBuilder sb = new StringBuilder();
        char last;
        char current = '\0';
        int indent = 0;
        boolean isInQuotationMarks = false;
        for (int i = 0; i < jsonStr.length(); i++) {
            last = current;
            current = jsonStr.charAt(i);
            switch (current) {
                case '"':
                    if (last != '\\'){
                        isInQuotationMarks = !isInQuotationMarks;
                    }
                    sb.append(current);
                    break;
                case '{':
                case '[':
                    sb.append(current);
                    if (!isInQuotationMarks) {
                        sb.append('\n');
                        indent++;
                        addIndentBlank(sb, indent);
                    }
                    break;
                case '}':
                case ']':
                    if (!isInQuotationMarks) {
                        sb.append('\n');
                        indent--;
                        addIndentBlank(sb, indent);
                    }
                    sb.append(current);
                    break;
                case ',':
                    sb.append(current);
                    if (last != '\\' && !isInQuotationMarks) {
                        sb.append('\n');
                        addIndentBlank(sb, indent);
                    }
                    break;
                default:
                    sb.append(current);
            }
        }

        return sb.toString();
    }

    /**
     *
     * @param builder
     * @param indent
     */
    private static void addIndentBlank(StringBuilder builder, int indent) {
        for (int i = 0; i < indent; i++) {
            builder.append('\t');
        }
    }
}
