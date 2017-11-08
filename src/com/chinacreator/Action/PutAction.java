package com.chinacreator.Action;

import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.image.BufferedImage;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import javax.swing.ImageIcon;
import javax.swing.JCheckBox;
import javax.swing.JLabel;
import javax.swing.JTextArea;
import javax.swing.JTextField;
import com.chinacreator.service.PutService;

/**
 * @Description 
	PUT请求模块执行按钮事件类
 * @Author qiang.zhu
 * @Datetime 2016年8月4日 上午9:57:16
 * @Version 
 * @Copyright (c) 2013 湖南科创信息技术股份有限公司

 */
public class PutAction implements ActionListener{
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
	private List<String> list;
	private List<String> listProp;
	private int counts;
	
	public PutAction(JTextArea textOutPut,JTextField textThreadCounts,JLabel labPic,JTextArea textUrl,JTextArea textProp,JTextArea textParam,JCheckBox proxyBox){
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
		Pattern pattern = Pattern.compile("\\<(.+?)\\>");
		Matcher matcher = pattern.matcher(textParam.getText());
		list=new ArrayList<String>();
		while(matcher.find()){
			list.add(matcher.group(1));
		}
		Matcher matcherProp = pattern.matcher(textProp.getText());
		listProp=new ArrayList<String>();
		while(matcherProp.find()){
			listProp.add(matcherProp.group(1));
		}
		counts=1;
		for(int i=0;i<threadCounts;i++){
			new Thread(new Runnable() {
				public void run() {
					String text=textParam.getText();
					for(String temp : list){
						text=text.replace("<"+temp+">", getLenStr(counts++,Integer.parseInt(temp),"0"));
					}
					String textP=textProp.getText();
					for(String temp : listProp){
						textP=textP.replace("<"+temp+">", getLenStr(counts++,Integer.parseInt(temp),"0"));
					}
					//调用post请求服务
					Map<String,Object> result=new PutService().sendPut(textUrl.getText(), text, textP,proxyBox.isSelected());
					//如果是验证码图片，则在控件中显示验证码图片
					if(result.get("yzpic")!=null){
						final BufferedImage bi=(BufferedImage)result.get("yzpic");
						ImageIcon ii=new ImageIcon((Image)bi);
						labPic.setIcon(ii);
						result.remove("yzpic");
					}
					//在输出控件上输出get请求结果
					textOutPut.append("\r\n"+Thread.currentThread().getName()+"--"+text+":\r\n"+result.toString());
					textOutPut.paintImmediately(textOutPut.getBounds());
				}
			}).start();;
		}
	}
	private String getLenStr(int num,int len,String index){
		int numLen=String.valueOf(num).length();
		if(len<=numLen){
			return String.valueOf(num);
		}
		StringBuffer sb = new StringBuffer();
		for(int i=0;i<len-numLen;i++){
			sb.append(index);
		}
		sb.append(num);
		return sb.toString();
	}
}
