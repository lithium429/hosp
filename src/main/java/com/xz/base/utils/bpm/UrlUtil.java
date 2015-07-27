package com.xz.base.utils.bpm;


import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import javax.servlet.ServletInputStream;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/**
 * Created by Wizzer on 14-3-8.
 */

public class UrlUtil {
	Logger log=LoggerFactory.getLogger(UrlUtil.class);
	public static String readStreamParameter(ServletInputStream in) {
        StringBuilder buffer = new StringBuilder();
        BufferedReader reader = null;
        try {
            reader = new BufferedReader(new InputStreamReader(in));
            String line = null;
            while ((line = reader.readLine()) != null) {
                buffer.append(new String(line.getBytes(), "UTF-8"));
            }
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            if (null != reader) {
                try {
                    reader.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }
        return buffer.toString();
    }
	
	 public static String sNull(Object obj, String def) {
	        return obj != null?obj.toString():def;
	 }
	
}
