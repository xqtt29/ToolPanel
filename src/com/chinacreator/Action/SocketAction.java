package com.chinacreator.Action;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JCheckBox;
import javax.swing.JTextArea;
import com.chinacreator.service.SocketService;

/**
 * @Description 
	Socket请求模块执行按钮事件类
 * @Author qiang.zhu
 * @Datetime 2016年8月4日 上午9:57:16
 * @Version 
 * @Copyright (c) 2013 湖南科创信息技术股份有限公司

 */
public class SocketAction implements ActionListener{
	//输出控件
	private JTextArea textOutPut;
	//IP文本控件
	private JTextArea textIp;
	//端口文本控件
	private JTextArea textPort;
	//信息文本控件
	private JTextArea textContent;
	//是否使用代理
	private JCheckBox proxyBox;
	
	public SocketAction(JTextArea textOutPut,JTextArea textIp,JTextArea textPort,JTextArea textContent,JCheckBox proxyBox){
		this.textOutPut=textOutPut;
		this.textIp=textIp;
		this.textPort=textPort;
		this.textContent=textContent;
		this.proxyBox=proxyBox;
	}
	@Override
	public void actionPerformed(ActionEvent e) {
		//调用Socket请求服务
		new Thread(new Runnable() {
			public void run() {
				new SocketService().sendSocket(textOutPut,textIp.getText(), textPort.getText(), textContent.getText(),proxyBox.isSelected());
			}
		}).start();
	}
}
