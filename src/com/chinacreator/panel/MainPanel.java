package com.chinacreator.panel;

import java.awt.Dimension;
import java.awt.Toolkit;
import javax.swing.JFrame;
import javax.swing.JMenuBar;
import javax.swing.JTabbedPane;
import com.chinacreator.menu.FileMenu;
import com.chinacreator.menu.HelpMenu;

/**
 * @Description 
	程序主面板实例类
 * @Author qiang.zhu
 * @Datetime 2016年8月4日 上午10:11:10
 * @Version 
 * @Copyright (c) 2013 湖南科创信息技术股份有限公司

 */
public class MainPanel {
	//tab页
	private JTabbedPane tabbedPane;
	//主框架
	private JFrame jf;
	/**
	 * @Description 
	 	初始化主程序界面
	 * @Author qiang.zhu
	 */
	public void initMainPanel(){
		jf=new JFrame("主程序");
		//初始化主窗口大小
		jf.setSize(800, 600);
		//初始化主窗口位置
		Dimension screensize = Toolkit.getDefaultToolkit().getScreenSize();
    	Dimension framesize = jf.getSize();
    	int x = (int)screensize.getWidth()/2 - (int)framesize.getWidth()/2;
    	int y = (int)screensize.getHeight()/2 - (int)framesize.getHeight()/2;
    	jf.setLocation(x,y);
    	//初始化关闭按钮
		jf.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

		//初始化tab页
		tabbedPane = new JTabbedPane();
		new WelcomePanel().createWelcomeJPanel(tabbedPane, "首页");
		jf.add(tabbedPane);
		
		//初始化菜单
		JMenuBar menuBar=new JMenuBar();
		//创建文件菜单
		menuBar.add(new FileMenu().createFileMenu(tabbedPane));
		//创建帮助菜单
		menuBar.add(new HelpMenu(jf).createHelpMenu(tabbedPane));
		jf.setJMenuBar(menuBar);
		
		//显示主窗口
		jf.setVisible(true);
	}
	
}
