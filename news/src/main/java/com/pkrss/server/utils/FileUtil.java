package com.pkrss.server.utils;

import java.io.ByteArrayOutputStream;
import java.io.InputStream;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.Map.Entry;

public final class FileUtil {
    
    private static Map<String, String> FILE_TYPE_MAP;
    private static Map<String, String> getAllFileType()    
    {    
        if(FILE_TYPE_MAP!=null)
            return FILE_TYPE_MAP;
        FILE_TYPE_MAP = new HashMap<String, String>();
        FILE_TYPE_MAP.put("jpg", "FFD8FF"); //JPEG (jpg)    
        FILE_TYPE_MAP.put("png", "89504E47");  //PNG (png)    
        FILE_TYPE_MAP.put("gif", "47494638");  //GIF (gif)    
        FILE_TYPE_MAP.put("tif", "49492A00");  //TIFF (tif)    
        FILE_TYPE_MAP.put("bmp", "424D"); //Windows Bitmap (bmp)    
        FILE_TYPE_MAP.put("dwg", "41433130"); //CAD (dwg)    
        FILE_TYPE_MAP.put("html", "68746D6C3E");  //HTML (html)    
        FILE_TYPE_MAP.put("rtf", "7B5C727466");  //Rich Text Format (rtf)    
        FILE_TYPE_MAP.put("xml", "3C3F786D6C");    
        FILE_TYPE_MAP.put("zip", "504B0304");    
        FILE_TYPE_MAP.put("rar", "52617221");    
        FILE_TYPE_MAP.put("psd", "38425053");  //Photoshop (psd)    
        FILE_TYPE_MAP.put("eml", "44656C69766572792D646174653A");  //Email [thorough only] (eml)    
        FILE_TYPE_MAP.put("dbx", "CFAD12FEC5FD746F");  //Outlook Express (dbx)    
        FILE_TYPE_MAP.put("pst", "2142444E");  //Outlook (pst)    
        FILE_TYPE_MAP.put("xls", "D0CF11E0");  //MS Word    
        FILE_TYPE_MAP.put("doc", "D0CF11E0");  //MS Excel 注意：word 和 excel的文件头一样    
        FILE_TYPE_MAP.put("mdb", "5374616E64617264204A");  //MS Access (mdb)    
        FILE_TYPE_MAP.put("wpd", "FF575043"); //WordPerfect (wpd)     
        FILE_TYPE_MAP.put("eps", "252150532D41646F6265");    
        FILE_TYPE_MAP.put("ps", "252150532D41646F6265");    
        FILE_TYPE_MAP.put("pdf", "255044462D312E");  //Adobe Acrobat (pdf)    
        FILE_TYPE_MAP.put("qdf", "AC9EBD8F");  //Quicken (qdf)    
        FILE_TYPE_MAP.put("pwl", "E3828596");  //Windows Password (pwl)    
        FILE_TYPE_MAP.put("wav", "57415645");  //Wave (wav)    
        FILE_TYPE_MAP.put("avi", "41564920");    
        FILE_TYPE_MAP.put("ram", "2E7261FD");  //Real Audio (ram)    
        FILE_TYPE_MAP.put("rm", "2E524D46");  //Real Media (rm)    
        FILE_TYPE_MAP.put("mpg", "000001BA");  //    
        FILE_TYPE_MAP.put("mov", "6D6F6F76");  //Quicktime (mov)    
        FILE_TYPE_MAP.put("asf", "3026B2758E66CF11"); //Windows Media (asf)    
        FILE_TYPE_MAP.put("mid", "4D546864");  //MIDI (mid)   
        return FILE_TYPE_MAP;
    } 
    
    /**
     * 判断文件类型是否是图片	
     * <p>Description:              </p>
     * <p>Create Time: 2016年4月14日   </p>
     * @author liandeliang
     * @param ext
     * @return
     */
    public static boolean isImgFileExt(String ext){
        if(ext == null || ext.length()==0)
            return false;
        
        final String[] imgExts = new String[]{"jpg","jpeg","png","bmp","gif","svg","tif","bmp","psd"};
        for(String imgExt : imgExts){
            if(imgExt.equals(ext))
                return true;
        }
        return false;
    }
    
    /**
     * 获取文件扩展名
     * <p>Description: ".png" ==  getFileExt("xxx/1.png"); </p>
     * <p>Create Time: 2016年3月28日   </p>
     * @author liandeliang
     * @param path
     * @return
     */
    public static String getFileExt(String path){
        int pos = path.lastIndexOf(".");
        if(pos < 0)
            return "";
        
        int pos2 = path.lastIndexOf("/");
        if(pos2>pos)
            return "";
        
        pos2 = path.lastIndexOf("%2f");
        if(pos2>pos)
            return "";
        
        path = path.substring(pos+1).toLowerCase();
        
        if(path!=null && path.length()>0)
            return "." + path;
        return "";
    }
    
    /**
     * 获取文件扩展,先通过文件名判断，后通过 流 来判断
     * <p>Description:              </p>
     * <p>Create Time: 2016年3月29日   </p>
     * @author liandeliang
     * @param path
     * @param inputStream
     * @return
     */
    public static String getFileExt(String path, InputStream inputStream){
        int pos = path.lastIndexOf(".");
        if(pos < 0){
            ByteArrayOutputStream output = new ByteArrayOutputStream();
            byte[] buffer = new byte[64];
            int n = 0;
            
            try{
                if (-1 != (n = inputStream.read(buffer))) {
                    output.write(buffer, 0, n);
                }
                inputStream.reset();
                return getFileExt(output.toByteArray());
            }catch(Exception e){
                e.printStackTrace();
            }
            return "";
        }
        return path.substring(pos+1).toLowerCase();
    }
    
    /**
     * 获取文件上传时的文件名	
     * <p>Description: "xx/1.png" == getUploadFileName("http://example.com/xx/1.png"); </p>
     * <p>Create Time: 2016年3月28日   </p>
     * @author liandeliang
     * @param url
     * @return
     */
    public static String getUploadFileName(String url){
        int pos = url.indexOf("://");
        if(pos < 0)
            return url;
        
        String path = url.substring(pos+3);
        
        pos = path.indexOf("/");
        
        if(pos < 0)
            return path;
        
        return path.substring(pos+1);
    }
    
    /**
     * 获取文件扩展	
     * <p>Description:              </p>
     * <p>Create Time: 2016年3月29日   </p>
     * @author liandeliang
     * @param b
     * @return
     */
    public final static String getFileExt(byte[] b)    
    {    
        String filetypeHex = String.valueOf(getFileHexString(b));    
        Iterator<Entry<String, String>> entryiterator = getAllFileType().entrySet().iterator();    
        while (entryiterator.hasNext()) {    
            Entry<String,String> entry =  entryiterator.next();    
            String fileTypeHexValue = entry.getValue();    
            if (filetypeHex.toUpperCase().startsWith(fileTypeHexValue)) {    
                return entry.getKey();    
            }    
        }    
        return null;    
    }
    
    private final static String getFileHexString(byte[] b)    
    {    
        StringBuilder stringBuilder = new StringBuilder();    
        if (b == null || b.length <= 0)    
        {    
            return null;    
        }    
        for (int i = 0; i < b.length; i++)    
        {    
            int v = b[i] & 0xFF;    
            String hv = Integer.toHexString(v);    
            if (hv.length() < 2)    
            {    
                stringBuilder.append(0);    
            }    
            stringBuilder.append(hv);    
        }    
        return stringBuilder.toString();    
    }  
}
