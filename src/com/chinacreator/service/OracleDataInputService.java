package com.chinacreator.service;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import javax.swing.JTextArea;

/**
 * @Description 
	oracle数据导入服务类
 * @Author qiang.zhu
 * @Datetime 2016年8月4日 上午10:37:21
 * @Version 
 * @Copyright (c) 2013 湖南科创信息技术股份有限公司

 */
public class OracleDataInputService {
	
	/**
	 * @Description 
		oracle数据导入请求
	 * @Author qiang.zhu
	 * @param textOutPut 输出控件
	 * @param uri oracle数据库连接串等参数
	 * @param dataFilePath 数据源文件
	 * @param param 导入表结构参数
	 */
	public void dataInput(JTextArea textOutPut,String uri,String dataFilePath,String param){
		String controlFilePath=System.getProperty("java.io.tmpdir")+File.separator+"ToolPanel_OracleControl.ctl";
		try {
			initControlFile(controlFilePath, dataFilePath, param);
			Process process=Runtime.getRuntime().exec("sqlldr "+uri+" control="+controlFilePath);
			InputStream fis = process.getInputStream(); 
            BufferedReader br = new BufferedReader(new InputStreamReader(fis,"gbk")); 
            String infoLine = "";
            //将rar打包输出信息打印到前台组件
            textOutPut.setText("");
            textOutPut.paintImmediately(textOutPut.getBounds());
            while ((infoLine = br.readLine()) != null) {
            	textOutPut.append("\r\n[info]"+infoLine);
            	textOutPut.paintImmediately(textOutPut.getBounds());
            }

			InputStream eis = process.getErrorStream();
            BufferedReader ebr = new BufferedReader(new InputStreamReader(eis,System.getProperty("sun.jnu.encoding")));
            String errLine = "";
            while ((errLine = ebr.readLine()) != null) {
            	textOutPut.append("\r\n[error]"+errLine);
            	textOutPut.paintImmediately(textOutPut.getBounds());
            }
		} catch (Exception e) {
			e.printStackTrace();
			textOutPut.setText(e.fillInStackTrace().getMessage());
		}
	}
	/**
	 * @Description 
		在系统临时文件夹中创建导入数据的控制文件
	 * @Author qiang.zhu
	 * @param controlFilePath 控制文件绝对路径
	 * @param dataFilePath 数据源文件绝对路径
	 * @param params 导入参数
	 * @throws Exception
	 */
	private void initControlFile(String controlFilePath,String dataFilePath,String params) throws Exception{
		if(params==null||params.length()==0){
			return;
		}
		OutputStreamWriter osw=null;
		try {
			String[] param=params.split("#_#");
			if(param.length!=3){
				return;
			}
			osw=new OutputStreamWriter(new FileOutputStream(new File(controlFilePath)),System.getProperty("sun.jnu.encoding"));
			osw.write("LOAD DATA\r\n");
			osw.write("INFILE '"+dataFilePath+"'\r\n");
			osw.write("INTO TABLE "+param[0]+"\r\n");
			osw.write("APPEND\r\n");
			osw.write("fields terminated by '"+param[1]+"'\r\n");
			osw.write("(\r\n");
			osw.write(param[2]);
			osw.write(")\r\n");
			osw.flush();
		} catch (Exception e) {
			throw e;
		} finally{
			if(osw!=null){
				try {
					osw.close();
				} catch (IOException e) {
					e.printStackTrace();
				}
			}
		}
	}
}
