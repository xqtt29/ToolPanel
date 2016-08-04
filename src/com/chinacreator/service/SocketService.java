package com.chinacreator.service;

import java.io.ByteArrayOutputStream;
import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.FileInputStream;
import java.net.InetSocketAddress;
import java.net.Socket;

import javax.swing.JTextArea;

/**
 * @Description 
	Socket请求服务类
 * @Author qiang.zhu
 * @Datetime 2016年8月4日 上午10:37:21
 * @Version 
 * @Copyright (c) 2013 湖南科创信息技术股份有限公司

 */
public class SocketService {
	
	/**
	 * @Description 
		发送Socket请求
	 * @Author qiang.zhu
	 * @param textOutPut 输出控件
	 * @param ip ip地址
	 * @param port 端口
	 * @param content 发送内容
	 * @return String 结果信息
	 */
	public void sendSocket(JTextArea textOutPut,String ip,String port,String content){
		Socket socket = null;
        DataOutputStream dos = null;
        DataInputStream dis = null;
        FileInputStream fis = null;
        ByteArrayOutputStream baos = null;
        try {
            try {
                socket = new Socket();
                socket.setSoTimeout(30000);
                socket.connect(new InetSocketAddress(ip,Integer.parseInt(port)),
                               30000);
                dos = new DataOutputStream(socket.getOutputStream());
                dos.write(content.getBytes(), 0, content.getBytes().length);
                dos.flush();
                textOutPut.setText("[info]发送成功！");
                textOutPut.append("\r\n[info]正在接收信息...");
                textOutPut.paintImmediately(textOutPut.getBounds());
            	dis = new DataInputStream(socket.getInputStream());
            	baos=new ByteArrayOutputStream();
            	byte[] bytes=new byte[1024];
            	int length=0;
            	while((length=dis.read(bytes, 0, 1024))!=-1){
            		baos.write(bytes, 0, length);
            	}
            }finally {
                if (dis != null)
                	dis.close();
                if (dos != null)
                    dos.close();
                if (fis != null)
                    fis.close();
                if (baos != null)
                	baos.close();
                if (socket != null)
                    socket.close();
            }
            textOutPut.append("\r\n[info]接受信息成功："+new String(baos.toByteArray(),"GBK"));
            textOutPut.paintImmediately(textOutPut.getBounds());
        }catch (Exception e) {
        	e.printStackTrace();
            textOutPut.append("\r\n[error]"+e.fillInStackTrace().getMessage());
            textOutPut.paintImmediately(textOutPut.getBounds());
        }
	}

}
