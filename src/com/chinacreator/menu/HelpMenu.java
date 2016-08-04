package com.chinacreator.menu;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JFrame;
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
	
	private JFrame jf;
	
	public HelpMenu(JFrame jf){
		this.jf=jf;
	}
	/**
	 * @Description 
		初始化文件菜单图形界面
	 * @Author qiang.zhu
	 * @param tabbedPane 主tab页控件
	 * @return JMenu 帮助菜单
	 */
	public JMenu createHelpMenu(JTabbedPane tabbedPane){
		JMenu menu=new JMenu("帮助");
		JMenuItem helpAbout=new JMenuItem("当前版本");
		helpAbout.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				JOptionPane.showMessageDialog(jf, "version:20160802", "当前版本",JOptionPane.WARNING_MESSAGE);
			}
		});
		menu.add(helpAbout);
		return menu;
	}
}
