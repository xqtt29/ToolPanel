package com.chinacreator.Action;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JTextArea;
import com.chinacreator.util.MD5;

/**
 * @Description 
	MD5加密模块执行按钮事件类
 * @Author qiang.zhu
 * @Datetime 2016年8月4日 上午9:59:01
 * @Version 
 * @Copyright (c) 2013 湖南科创信息技术股份有限公司

 */
public class MD5Action implements ActionListener{
	//输出控件
	private JTextArea textOutPut;
	//明文文本控件
	private JTextArea textContent;
	
	public MD5Action(JTextArea textOutPut,JTextArea textContent){
		this.textOutPut=textOutPut;
		this.textContent=textContent;
	}
	@Override
	public void actionPerformed(ActionEvent e) {
		//调用MD5加密方法
		String key=MD5.getMD5Str(textContent.getText());
		textOutPut.setText(key);
		textOutPut.append("\r\n"+key.toLowerCase());
	}

}
