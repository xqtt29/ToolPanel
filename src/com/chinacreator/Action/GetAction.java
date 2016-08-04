package com.chinacreator.Action;

import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.image.BufferedImage;
import java.util.Map;
import javax.swing.ImageIcon;
import javax.swing.JLabel;
import javax.swing.JTextArea;
import com.chinacreator.service.GetService;

/**
 * @Description 
	GET请求模块执行按钮事件类
 * @Author qiang.zhu
 * @Datetime 2016年8月4日 上午9:57:16
 * @Version 
 * @Copyright (c) 2013 湖南科创信息技术股份有限公司

 */
public class GetAction implements ActionListener{
	//输出控件
	private JTextArea textOutPut;
	//验证码控件
	private JLabel labPic;
	//url文本控件
	private JTextArea textUrl;
	//属性文本控件
	private JTextArea textProp;
	//参数文本控件
	private JTextArea textParam;
	
	public GetAction(JTextArea textOutPut,JLabel labPic,JTextArea textUrl,JTextArea textProp,JTextArea textParam){
		this.textOutPut=textOutPut;
		this.labPic=labPic;
		this.textUrl=textUrl;
		this.textProp=textProp;
		this.textParam=textParam;
	}
	@Override
	public void actionPerformed(ActionEvent e) {
		//调用get请求服务
		Map<String,Object> result=new GetService().sendGet(textUrl.getText(), textParam.getText(), textProp.getText());
		//如果是验证码图片，则在控件中显示验证码图片
		if(result.get("yzpic")!=null){
			final BufferedImage bi=(BufferedImage)result.get("yzpic");
			ImageIcon ii=new ImageIcon((Image)bi);
			labPic.setIcon(ii);
			result.remove("yzpic");
		}
		//在输出控件上输出get请求结果
		textOutPut.setText(result.toString());
	}

}
