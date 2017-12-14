package com.chinacreator.Action;

import java.awt.Desktop;
import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.util.Map;

import javax.imageio.ImageIO;
import javax.swing.ImageIcon;
import javax.swing.JCheckBox;
import javax.swing.JLabel;
import javax.swing.JTextArea;
import javax.swing.JTextField;

import com.chinacreator.service.PostService;

/**
 * @Description 
	POST请求模块执行按钮事件类
 * @Author qiang.zhu
 * @Datetime 2016年8月4日 上午9:57:16
 * @Version 
 * @Copyright (c) 2013 湖南科创信息技术股份有限公司

 */
public class PostAction2 implements ActionListener{
	//输出控件
	private JTextArea textOutPut;
	//并发数
	private JTextField textThreadCounts;
	//验证码控件
	private JLabel labPic;
	//url文本控件
	private JTextArea textUrl;
	//属性文本控件
	private JTextArea textProp;
	//参数文本控件
	private JTextArea textParam;
	//是否使用代理
	private JCheckBox proxyBox;
	
	public PostAction2(JTextArea textOutPut,JTextField textThreadCounts,JLabel labPic,JTextArea textUrl,JTextArea textProp,JTextArea textParam,JCheckBox proxyBox){
		this.textOutPut=textOutPut;
		this.textThreadCounts=textThreadCounts;
		this.labPic=labPic;
		this.textUrl=textUrl;
		this.textProp=textProp;
		this.textParam=textParam;
		this.proxyBox=proxyBox;
	}
	@Override
	public void actionPerformed(ActionEvent e) {
		int threadCounts=Integer.parseInt(textThreadCounts.getText());
		for(int i=0;i<threadCounts;i++){
			new Thread(new Runnable() {
				public void run() {
					String text=textParam.getText();
					String textP=textProp.getText();
					//调用post请求服务
					Map<String,Object> result=new PostService().sendPost(textUrl.getText(), text, textP,proxyBox.isSelected());
					//如果是验证码图片，则在控件中显示验证码图片
					if(result.get("yzpic")!=null){
						final BufferedImage bi=(BufferedImage)result.get("yzpic");
						try {
							String fileName = System.getProperty("user.dir")+File.separator+"temp.png";
							ImageIO.write(bi, "PNG", new File(fileName));
							Desktop.getDesktop().open(new File(fileName));
						} catch (IOException e) {
							// TODO Auto-generated catch block
							e.printStackTrace();
						}
						/*
						ImageIcon ii=new ImageIcon((Image)bi);
						labPic.setIcon(ii);
						*/
						result.remove("yzpic");
					}
					//在输出控件上输出get请求结果
					textOutPut.append("\r\n"+Thread.currentThread().getName()+"--"+text+":\r\n"+result.toString());
					textOutPut.paintImmediately(textOutPut.getBounds());
				}
			}).start();;
		}
	}
}
