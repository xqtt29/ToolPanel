package com.chinacreator.menu;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JMenu;
import javax.swing.JMenuItem;
import javax.swing.JOptionPane;
import javax.swing.JTabbedPane;
import com.chinacreator.panel.ProxyPanel;

/**
 * @Description 
	工具菜单实例类
 * @Author qiang.zhu
 * @Datetime 2016年8月4日 上午10:00:52
 * @Version 
 * @Copyright (c) 2013 湖南科创信息技术股份有限公司

 */
public class ToolMenu {
	
	/**
	 * @Description 
		初始化工具菜单图形界面
	 * @Author qiang.zhu
	 * @param tabbedPane 主tab页控件
	 * @return JMenu 帮助菜单
	 */
	public JMenu createToolMenu(final JTabbedPane tabbedPane){
		JMenu menu=new JMenu("工具");
		JMenuItem toolProxy=new JMenuItem("代理配置");
		toolProxy.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				//初始代理配置模块界面
				new ProxyPanel().createProxyJPanel(tabbedPane, "代理配置");
			}
		});
		menu.add(toolProxy);
		
		JMenuItem fileUploadDown=new JMenuItem("文件上传与下载");
		fileUploadDown.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				//初始文件上传下载模块界面
				//MainAction.creatFrame();
				JOptionPane.showMessageDialog(tabbedPane, "暂未集成", "文件上传与下载",JOptionPane.WARNING_MESSAGE);
			}
		});
		menu.add(fileUploadDown);
		return menu;
	}
}
