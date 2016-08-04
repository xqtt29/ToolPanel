package com.chinacreator.menu;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JMenu;
import javax.swing.JMenuItem;
import javax.swing.JTabbedPane;
import com.chinacreator.panel.GetPanel;
import com.chinacreator.panel.MD5Panel;
import com.chinacreator.panel.OracleDataInputPanel;
import com.chinacreator.panel.PostPanel;
import com.chinacreator.panel.SocketPanel;

/**
 * @Description 
	文件菜单实例类
 * @Author qiang.zhu
 * @Datetime 2016年8月4日 上午10:00:52
 * @Version 
 * @Copyright (c) 2013 湖南科创信息技术股份有限公司

 */
public class FileMenu {
	
	/**
	 * @Description 
		初始化文件菜单图形界面
	 * @Author qiang.zhu
	 * @param tabbedPane 主tab页控件
	 * @return JMenu 文件菜单
	 */
	public JMenu createFileMenu(JTabbedPane tabbedPane){
		JMenu menu=new JMenu("文件");
		
		JMenu menuFileAdd=new JMenu("添加模块");
		//添加【post请求子菜单】
		menuFileAdd.add(initFileAddPostItem(tabbedPane));
		//添加【get请求子菜单】
		menuFileAdd.add(initFileAddGetItem(tabbedPane));
		//添加【oracle数据导入子菜单】
		menuFileAdd.add(initFileAddOracleDataInputItem(tabbedPane));
		//添加【MD5加密子菜单】
		menuFileAdd.add(initFileAddMD5Item(tabbedPane));
		//添加【socket请求子菜单】
		menuFileAdd.add(initFileAddSocketItem(tabbedPane));
		
		menu.add(menuFileAdd);
		
		return menu;
	}
	/**
	 * @Description 
		初始化文件菜单中的【添加模块】的子菜单【post请求】
	 * @Author qiang.zhu
	 * @param tabbedPane 主tab页控件
	 * @return JMenu post请求菜单子项
	 */
	private JMenuItem initFileAddPostItem(final JTabbedPane tabbedPane){
		JMenuItem fileAddPost=new JMenuItem("post请求");
		fileAddPost.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				//初始化post请求模块界面
				new PostPanel().createPostJPanel(tabbedPane, "post请求");
			}
		});
		return fileAddPost;
	}
	
	/**
	 * @Description 
		初始化文件菜单中的【添加模块】的子菜单【get请求】
	 * @Author qiang.zhu
	 * @param tabbedPane 主tab页控件
	 * @return JMenu get请求菜单项
	 */
	private JMenuItem initFileAddGetItem(final JTabbedPane tabbedPane){
		JMenuItem fileAddGet=new JMenuItem("get请求");
		fileAddGet.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				//初始化get请求模块界面
				new GetPanel().createGetJPanel(tabbedPane, "get请求");
			}
		});
		return fileAddGet;
	}
	
	/**
	 * @Description 
		初始化文件菜单中的【添加模块】的子菜单【oracle数据导入】
	 * @Author qiang.zhu
	 * @param tabbedPane 主tab页控件
	 * @return JMenu oracle数据导入菜单项
	 */
	private JMenuItem initFileAddOracleDataInputItem(final JTabbedPane tabbedPane){
		JMenuItem fileAddOracleDataInputItem=new JMenuItem("oracle数据导入");
		fileAddOracleDataInputItem.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				//初始化oracle数据导入模块界面
				new OracleDataInputPanel().createOracleDataInputJPanel(tabbedPane, "oracle数据导入");
			}
		});
		return fileAddOracleDataInputItem;
	}
	/**
	 * @Description 
		初始化文件菜单中的【添加模块】的子菜单【MD5加密】
	 * @Author qiang.zhu
	 * @param tabbedPane 主tab页控件
	 * @return JMenu oracle数据导入菜单项
	 */
	private JMenuItem initFileAddMD5Item(final JTabbedPane tabbedPane){
		JMenuItem fileAddMD5Item=new JMenuItem("MD5加密");
		fileAddMD5Item.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				//初始化MD5加密模块界面
				new MD5Panel().createMD5JPanel(tabbedPane, "MD5加密");
			}
		});
		return fileAddMD5Item;
	}
	/**
	 * @Description 
		初始化文件菜单中的【添加模块】的子菜单【socket请求】
	 * @Author qiang.zhu
	 * @param tabbedPane 主tab页控件
	 * @return JMenu oracle数据导入菜单项
	 */
	private JMenuItem initFileAddSocketItem(final JTabbedPane tabbedPane){
		JMenuItem fileAddSocketItem=new JMenuItem("socket请求");
		fileAddSocketItem.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				//初始化MD5加密模块界面
				new SocketPanel().createSocketJPanel(tabbedPane, "socket请求");
			}
		});
		return fileAddSocketItem;
	}
}
