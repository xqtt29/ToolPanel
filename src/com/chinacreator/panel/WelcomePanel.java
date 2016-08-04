package com.chinacreator.panel;

import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTabbedPane;
import com.chinacreator.util.TabUtil;

/**
 * @Description 
	欢迎界面初始化类
 * @Author qiang.zhu
 * @Datetime 2016年8月4日 上午10:05:38
 * @Version 
 * @Copyright (c) 2013 湖南科创信息技术股份有限公司

 */
public class WelcomePanel {
	
	private JPanel tabPanel;

	public WelcomePanel(){
		tabPanel=new JPanel();
		JLabel lab=new JLabel("Hello World");
		tabPanel.add(lab);
	}
	/**
	 * @Description 
		创建欢迎首页模块tab页面
	 * @Author qiang.zhu
	 * @param tabbedPane 主tab控件
	 * @param title tab页标题
	 */
	public void createWelcomeJPanel(final JTabbedPane tabbedPane,String title){
		//添加tab页面
		TabUtil.createTab(tabbedPane, tabPanel, title);
	}
}
