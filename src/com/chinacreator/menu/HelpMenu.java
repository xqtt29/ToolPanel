package com.chinacreator.menu;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JMenu;
import javax.swing.JMenuItem;
import javax.swing.JOptionPane;
import javax.swing.JTabbedPane;

/**
 * @Description 
	帮助菜单实例类
 * @Author qiang.zhu
 * @Datetime 2016年8月4日 上午10:00:52
 * @Version 
 * @Copyright (c) 2013 湖南科创信息技术股份有限公司

 */
public class HelpMenu {
	
	/**
	 * @Description 
		初始化文件菜单图形界面
	 * @Author qiang.zhu
	 * @param tabbedPane 主tab页控件
	 * @return JMenu 帮助菜单
	 */
	public JMenu createHelpMenu(final JTabbedPane tabbedPane){
		JMenu menu=new JMenu("帮助");
		JMenuItem helpAbout=new JMenuItem("当前版本");
		helpAbout.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				JOptionPane.showMessageDialog(tabbedPane, "version:20160816\r\n增加代理配置", "当前版本",JOptionPane.WARNING_MESSAGE);
			}
		});
		menu.add(helpAbout);
		return menu;
	}
}
