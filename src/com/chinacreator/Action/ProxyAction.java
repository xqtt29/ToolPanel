package com.chinacreator.Action;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JTextField;
import com.chinacreator.common.Global;

/**
 * @Description 
	代理配置模块执行按钮事件类
 * @Author qiang.zhu
 * @Datetime 2016年8月4日 上午9:57:16
 * @Version 
 * @Copyright (c) 2013 湖南科创信息技术股份有限公司

 */
public class ProxyAction implements ActionListener{
	//IP
	private JTextField textIp;
	//端口
	private JTextField textPort;
	//用户
	private JTextField textUser;
	//密码
	private JTextField textPass;
	
	public ProxyAction(JTextField textIp,JTextField textPort,JTextField textUser,JTextField textPass){
		this.textIp=textIp;
		this.textPort=textPort;
		this.textUser=textUser;
		this.textPass=textPass;
	}
	@Override
	public void actionPerformed(ActionEvent e) {
		Global.isProxy=true;
		Global.proxyHost=textIp.getText();
		Global.proxyPort=textPort.getText();
		Global.proxyUser=textUser.getText();
		Global.proxyPass=textPass.getText();
	}

}
