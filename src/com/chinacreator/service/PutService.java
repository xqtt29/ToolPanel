package com.chinacreator.service;

import java.awt.image.BufferedImage;
import java.io.BufferedReader;
import java.io.DataOutputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.InetSocketAddress;
import java.net.Proxy;
import java.net.URL;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import javax.imageio.ImageIO;

import com.chinacreator.common.Global;
import com.chinacreator.util.SslUtils;

/**
 * @Description 
	put请求服务类
 * @Author qiang.zhu
 * @Datetime 2016年8月4日 上午10:37:21
 * @Version 
 * @Copyright (c) 2013 湖南科创信息技术股份有限公司

 */
public class PutService {
	/**
	 * @Description 
		发送put请求
	 * @Author qiang.zhu
	 * @param strUrl url网址
	 * @param inputParam 请求参数
	 * @param properties 请求头部属性
	 * @param isUseProxy 使用代理
	 * @return Map 结果信息
	 */
	public Map<String,Object> sendPut(String strUrl,String inputParam,String properties,boolean isUseProxy){
		Map<String,Object> outMap = new HashMap<String,Object>();
		StringBuffer strResponse = new StringBuffer();
		HttpURLConnection connection = null;
		DataOutputStream out = null;
		BufferedReader reader = null;
		try {
			SslUtils.ignoreSsl();
			URL url = new URL(strUrl);
			//如果使用代理
			if(isUseProxy){
				Proxy proxy=new Proxy(Proxy.Type.HTTP, new InetSocketAddress(Global.proxyHost==null?"":Global.proxyHost, Global.proxyPort==null?808:Integer.parseInt(Global.proxyPort)));
				connection = (HttpURLConnection) url.openConnection(proxy);
			}else{
				connection = (HttpURLConnection) url.openConnection();
			}
			connection.setDoOutput(true);
			connection.setDoInput(true);
			String encode="UTF-8";
			if(properties!=null&&properties.length()!=0){
				String[] props=properties.split("\\(#\\_#\\)");
				for(String prop : props){
					String[] temps=prop.split("\\(&\\_&\\)");
					connection.setRequestProperty(temps[0], temps[1]);
					if("Content-Encoding".equals(temps[0])){
						encode=temps[1];
					}
				}
			}
			connection.setRequestMethod("PUT");
			connection.setConnectTimeout(15*1000);
			connection.setReadTimeout(15*1000);
			connection.connect();
			out = new DataOutputStream(connection
					.getOutputStream());
			out.write(inputParam.toString().getBytes(encode));
			out.flush();
            Map<String, List<String>> map = connection.getHeaderFields();
            String fileType=map.get("Content-Type")==null?"":map.get("Content-Type").toString();
            if(fileType.indexOf("image")>0){
	            BufferedImage bi = ImageIO.read(connection.getInputStream());
	            outMap.put("yzpic", bi);
            }else{
				reader = new BufferedReader(new InputStreamReader(
						connection.getInputStream(), encode));
				String line = "";
				while ((line = reader.readLine()) != null) {
					strResponse.append(line);
				}
	            outMap.put("content", strResponse.toString());
            }
            // 遍历所有的响应头字段
            for (String key : map.keySet()) {
            	outMap.put(key,map.get(key));
            }
		} catch (Exception e) {
			e.printStackTrace();
			outMap.put("error", e.fillInStackTrace().getMessage());
		} finally {
			if (connection != null) {
				connection.disconnect();
			}
			if (out != null) {
				try {
					out.close();
				} catch (IOException e) {
				};
			}
			if (reader != null) {
				try {
					reader.close();
				} catch (IOException e) {
				};
			}
		}
		return outMap;
	}

}
