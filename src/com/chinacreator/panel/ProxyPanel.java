package com.chinacreator.panel;

import java.awt.GridLayout;
import java.util.HashMap;
import java.util.Map;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTabbedPane;
import javax.swing.JTextField;
import com.chinacreator.Action.ProxyAction;
import com.chinacreator.Action.SaveAction;
import com.chinacreator.common.Global;
import com.chinacreator.util.TabUtil;

/**
 * @Description 
	代理配置界面初始化类
 * @Author qiang.zhu
 * @Datetime 2016年8月4日 上午10:05:38
 * @Version 
 * @Copyright (c) 2013 湖南科创信息技术股份有限公司

 */
public class ProxyPanel {
	//get请求模块主面板
	private JPanel tabPanel;
	private JTextField textIp;
	private JTextField textPort;
	private JTextField textUser;
	private JTextField textPass;
	//图形控件实例化
	public ProxyPanel(){
		tabPanel=new JPanel();
		JPanel panel=new JPanel(new GridLayout(5, 1));
		JPanel pUrl=new JPanel();
		JLabel labIp=new JLabel("代理地址:");
		textIp=new JTextField(20);
		textIp.setText(Global.proxyHost);
		pUrl.add(labIp);
		pUrl.add(textIp);
		panel.add(pUrl);

		JPanel pPort=new JPanel();
		JLabel labPort=new JLabel("代理端口:");
		textPort=new JTextField(20);
		textPort.setText(Global.proxyPort);
		pPort.add(labPort);
		pPort.add(textPort);
		panel.add(pPort);
		
		JPanel pUser=new JPanel();
		JLabel labUser=new JLabel("代理用户:");
		textUser=new JTextField(20);
		textUser.setText(Global.proxyUser);
		pUser.add(labUser);
		pUser.add(textUser);
		panel.add(pUser);
		
		JPanel pPass=new JPanel();
		JLabel labPass=new JLabel("代理密码:");
		textPass=new JTextField(20);
		textPass.setText(Global.proxyPass);
		pPass.add(labPass);
		pPass.add(textPass);
		panel.add(pPass);
		
		JPanel pButton=new JPanel();
		JButton button=new JButton("保存");
		pButton.add(button);
		JButton saveButton=new JButton("另存为");
		pButton.add(saveButton);
		panel.add(pButton);
		
		button.addActionListener(new ProxyAction(textIp,textPort,textUser,textPass));
		Map<String,Object> map = new HashMap<String,Object>();
		map.put("panelId", "ProxyPanel");
		map.put("textIp", textIp);
		map.put("textPort", textPort);
		map.put("textUser", textUser);
		map.put("textPass", textPass);
		saveButton.addActionListener(new SaveAction(tabPanel, map));
		tabPanel.add(panel);
	}
	/**
	 * @Description 
		创建get请求模块tab页面
	 * @Author qiang.zhu
	 * @param tabbedPane 主tab控件
	 * @param title tab页标题
	 */
	public void createProxyJPanel(final JTabbedPane tabbedPane,String title){
		//添加tab页面
		TabUtil.createTab(tabbedPane, tabPanel, title);
	}
	/**
	 * @Description 
		创建代理配置模块tab页面
	 * @Author qiang.zhu
	 * @param tabbedPane 主tab控件
	 * @param title tab页标题
	 * @param textIp IP
	 * @param textPort 端口
	 * @param textUser 用户
	 * @param textPass 密码
	 */
	public void createProxyJPanel(final JTabbedPane tabbedPane,String title,String textIp,String textPort,String textUser,String textPass){
		this.textIp.setText(textIp);
		this.textPort.setText(textPort);
		this.textUser.setText(textUser);
		this.textPass.setText(textPass);
		//添加tab页面
		TabUtil.createTab(tabbedPane, tabPanel, title);
	}
}
