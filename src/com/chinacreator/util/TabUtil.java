package com.chinacreator.util;

import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTabbedPane;

/**
 * @Description 
	tab页面控件操作工具类
 * @Author qiang.zhu
 * @Datetime 2016年8月4日 上午10:17:59
 * @Version 
 * @Copyright (c) 2013 湖南科创信息技术股份有限公司

 */
public class TabUtil {
	
	/**
	 * @Description 
		添加tab页面
	 * @Author qiang.zhu
	 * @param tabbedPane 主tab控件
	 * @param tabPanel tab页面板
	 * @param title	tab页标题
	 */
	public static void createTab(final JTabbedPane tabbedPane,final JPanel tabPanel,String title){
		//添加tab面板
		tabbedPane.addTab(title, tabPanel);
		//添加tab关闭按钮
		JPanel titlePanel=new JPanel();
		titlePanel.add(new JLabel(title));
		JLabel exit=new JLabel("X");
		exit.addMouseListener(new MouseAdapter() {
    		public void mouseClicked(MouseEvent e){
    			tabbedPane.remove(tabbedPane.indexOfComponent(tabPanel));
    		}
		});
		titlePanel.add(exit);
		titlePanel.setOpaque(false);
		tabbedPane.setTabComponentAt(tabbedPane.indexOfComponent(tabPanel),titlePanel);
		//选中当前tab页
		tabbedPane.setSelectedIndex(tabbedPane.indexOfComponent(tabPanel));
	}
}
