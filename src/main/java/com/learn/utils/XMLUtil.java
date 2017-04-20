package com.learn.utils;

import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBException;
import javax.xml.bind.Marshaller;
import javax.xml.bind.Unmarshaller;
import java.io.*;

/**
 * Created by xia_yu on 2017/4/20.
 */
public class XMLUtil {
    /**
     * 将对象转成string类型的xml节点输出
     * @param object
     * @return
     */
    public static String convertToXml(Object object){
        //创建输出流
        StringWriter stringWriter=new StringWriter();
        try{
            JAXBContext context=JAXBContext.newInstance(object.getClass());
            Marshaller marshaller=context.createMarshaller();
            //格式化xml输出的格式
            marshaller.setProperty(Marshaller.JAXB_FORMATTED_OUTPUT,true);
            //将对象转成输出流形式的xml
            marshaller.marshal(object,stringWriter);
        }catch (JAXBException e){
            e.printStackTrace();
        }
        return  stringWriter.toString();
    }

    /**
     * 将对象转换成xml文件
     * @param object
     * @param saveXmlFilePath
     */
    public static void convertToXml(Object object,String saveXmlFilePath){
        try{
            JAXBContext context=JAXBContext.newInstance(object.getClass());
            Marshaller marshaller=context.createMarshaller();
            marshaller.setProperty(Marshaller.JAXB_FORMATTED_OUTPUT,true);
            FileWriter xmlWriter=null;
            try{
                xmlWriter=new FileWriter(saveXmlFilePath);
            }catch (IOException e){
                e.printStackTrace();
            }
            marshaller.marshal(object,xmlWriter);
        }catch (JAXBException e){
            e.printStackTrace();
        }
    }

    /**
     * 将string类型的xml转成对象
     * @param xml
     * @param clazz
     * @return
     */
    @SuppressWarnings("unchecked")
    public static Object convertXmlStringToObject(String xml,Class clazz){
        Object object=null;
        try{
            JAXBContext context=JAXBContext.newInstance(clazz);
            Unmarshaller unmarshaller=context.createUnmarshaller();
            StringReader xmlReader=new StringReader(xml);
            object=unmarshaller.unmarshal(xmlReader);
        }catch (JAXBException e){
            e.printStackTrace();
        }
        return object;
    }

    /**
     * 将file类型的xml转成对象
     * @param xmlPath
     * @param clazz
     * @return
     */
    @SuppressWarnings("unchecked")
    public static Object convertXmlPathToObject(String xmlPath,Class clazz){
        Object object=null;
        try{
            JAXBContext context=JAXBContext.newInstance(clazz);
            Unmarshaller unmarshaller=context.createUnmarshaller();
            FileReader xmlReader=null;
            try{
                xmlReader=new FileReader(xmlPath);
            }catch (FileNotFoundException e){
                e.printStackTrace();
            }
            object=unmarshaller.unmarshal(xmlReader);
        }catch (JAXBException e){
            e.printStackTrace();
        }
        return object;
    }

}
