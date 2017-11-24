package com.chinacreator.menu;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;
import java.util.Map;
import javax.swing.JFileChooser;
import javax.swing.JMenu;
import javax.swing.JMenuItem;
import javax.swing.JTabbedPane;
import javax.swing.filechooser.FileFilter;

import com.chinacreator.panel.DeletePanel;
import com.chinacreator.panel.GetPanel;
import com.chinacreator.panel.MD5Panel;
import com.chinacreator.panel.OracleDataInputPanel;
import com.chinacreator.panel.PostPanel;
import com.chinacreator.panel.PostPanel2;
import com.chinacreator.panel.ProxyPanel;
import com.chinacreator.panel.PutPanel;
import com.chinacreator.panel.SocketPanel;
import com.chinacreator.service.PropFileService;

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
	public JMenu createFileMenu(final JTabbedPane tabbedPane){
		JMenu menu=new JMenu("文件");
		
		JMenu menuFileAdd=new JMenu("添加模块");
		//添加【post请求子菜单】
		menuFileAdd.add(initFileAddPostItem(tabbedPane));
		//添加【post2请求子菜单】
		menuFileAdd.add(initFileAddPost2Item(tabbedPane));
		//添加【get请求子菜单】
		menuFileAdd.add(initFileAddGetItem(tabbedPane));
		//添加【put请求子菜单】
		menuFileAdd.add(initFileAddPutItem(tabbedPane));
		//添加【delete请求子菜单】
		menuFileAdd.add(initFileAddDeleteItem(tabbedPane));
		//添加【oracle数据导入子菜单】
		menuFileAdd.add(initFileAddOracleDataInputItem(tabbedPane));
		//添加【MD5加密子菜单】
		menuFileAdd.add(initFileAddMD5Item(tabbedPane));
		//添加【socket请求子菜单】
		menuFileAdd.add(initFileAddSocketItem(tabbedPane));
		
		menu.add(menuFileAdd);
		
		menu.add(initFileOpenItem(tabbedPane));
		
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
		初始化文件菜单中的【添加模块】的子菜单【post请求2】
	 * @Author qiang.zhu
	 * @param tabbedPane 主tab页控件
	 * @return JMenu post请求菜单子项
	 */
	private JMenuItem initFileAddPost2Item(final JTabbedPane tabbedPane){
		JMenuItem fileAddPost=new JMenuItem("post请求2");
		fileAddPost.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				//初始化post请求模块界面
				new PostPanel2().createPostJPanel(tabbedPane, "post请求2");
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
		初始化文件菜单中的【添加模块】的子菜单【put请求】
	 * @Author qiang.zhu
	 * @param tabbedPane 主tab页控件
	 * @return JMenu put请求菜单项
	 */
	private JMenuItem initFileAddPutItem(final JTabbedPane tabbedPane){
		JMenuItem fileAddPut=new JMenuItem("put请求");
		fileAddPut.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				//初始化put请求模块界面
				new PutPanel().createPutJPanel(tabbedPane, "put请求");
			}
		});
		return fileAddPut;
	}
	/**
	 * @Description 
		初始化文件菜单中的【添加模块】的子菜单【delete请求】
	 * @Author qiang.zhu
	 * @param tabbedPane 主tab页控件
	 * @return JMenu delete请求菜单项
	 */
	private JMenuItem initFileAddDeleteItem(final JTabbedPane tabbedPane){
		JMenuItem fileAddDelete=new JMenuItem("delete请求");
		fileAddDelete.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				//初始化delete请求模块界面
				new DeletePanel().createDeleteJPanel(tabbedPane, "delete请求");
			}
		});
		return fileAddDelete;
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
	/**
	 * @Description 
		初始化文件菜单中的【打开】菜单
	 * @Author qiang.zhu
	 * @param tabbedPane 主tab页控件
	 * @return JMenu oracle数据导入菜单项
	 */
	private JMenuItem initFileOpenItem(final JTabbedPane tabbedPane){
		JMenuItem fileOpen=new JMenuItem("打开");
		fileOpen.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				final JFileChooser saveChooserSavePath=new JFileChooser();
				saveChooserSavePath.setFileSelectionMode(JFileChooser.FILES_ONLY);
				saveChooserSavePath.setAcceptAllFileFilterUsed(false);
				saveChooserSavePath.setCurrentDirectory(new File(System.getProperty("user.dir")));
				saveChooserSavePath.addChoosableFileFilter(new FileFilter() {
					@Override
					public String getDescription() {
						return "属性文件(*.prop)";
					}
					@Override
					public boolean accept(File f) {
						if(f.isDirectory()){
							return true;
						}
						if(f.getName().endsWith(".prop")){
					        return true;
					    }
					    return false;
					}
				});
				int returnval=saveChooserSavePath.showOpenDialog(tabbedPane);
		        if(returnval==JFileChooser.APPROVE_OPTION) 
		        { 
		        	File file = saveChooserSavePath.getSelectedFile();
		        	Map<String,Object> map=new PropFileService().getPropFileInfo(file.getAbsolutePath());
		        	String panelId=map.get("panelId")==null?"":map.get("panelId").toString();
		        	if("PostPanel".equals(panelId)){
		        		new PostPanel().createPostJPanel(tabbedPane, "post请求", map.get("textUrl")==null?"":map.get("textUrl").toString(), map.get("textParam")==null?"":map.get("textParam").toString(), map.get("textProp")==null?"":map.get("textProp").toString());
		        	}else if("PostPanel2".equals(panelId)){
		        		new PostPanel2().createPostJPanel(tabbedPane, "post请求2", map.get("textUrl")==null?"":map.get("textUrl").toString(), map.get("textParam")==null?"":map.get("textParam").toString(), map.get("textProp")==null?"":map.get("textProp").toString());
		        	}else if("GetPanel".equals(panelId)){
		        		new GetPanel().createGetJPanel(tabbedPane, "get请求", map.get("textUrl")==null?"":map.get("textUrl").toString(), map.get("textParam")==null?"":map.get("textParam").toString(), map.get("textProp")==null?"":map.get("textProp").toString());
		        	}else if("PutPanel".equals(panelId)){
		        		new PutPanel().createPutJPanel(tabbedPane, "put请求", map.get("textUrl")==null?"":map.get("textUrl").toString(), map.get("textParam")==null?"":map.get("textParam").toString(), map.get("textProp")==null?"":map.get("textProp").toString());
		        	}else if("DeletePanel".equals(panelId)){
		        		new DeletePanel().createDeleteJPanel(tabbedPane, "delete请求", map.get("textUrl")==null?"":map.get("textUrl").toString(), map.get("textParam")==null?"":map.get("textParam").toString(), map.get("textProp")==null?"":map.get("textProp").toString());
		        	}else if("OracleDataInputPanel".equals(panelId)){
		        		new OracleDataInputPanel().createOracleDataInputJPanel(tabbedPane, "oracle数据导入", map.get("textUrl")==null?"":map.get("textUrl").toString(), map.get("textParam")==null?"":map.get("textParam").toString());
		        	}else if("MD5Panel".equals(panelId)){
		        		new MD5Panel().createMD5JPanel(tabbedPane, "MD5加密", map.get("textContent")==null?"":map.get("textContent").toString());
		        	}else if("SocketPanel".equals(panelId)){
		        		new SocketPanel().createSocketJPanel(tabbedPane, "socket请求", map.get("textIp")==null?"":map.get("textIp").toString(), map.get("textPort")==null?"":map.get("textPort").toString(), map.get("textContent")==null?"":map.get("textContent").toString());
		        	}else if("ProxyPanel".equals(panelId)){
		        		new ProxyPanel().createProxyJPanel(tabbedPane, "代理配置", map.get("textIp")==null?"":map.get("textIp").toString(), map.get("textPort")==null?"":map.get("textPort").toString(), map.get("textUser")==null?"":map.get("textUser").toString(), map.get("textPass")==null?"":map.get("textPass").toString());
		        	}
		        } 
			}
		});
		return fileOpen;
	}
}
