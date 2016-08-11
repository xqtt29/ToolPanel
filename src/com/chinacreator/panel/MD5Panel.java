package com.chinacreator.panel;

import java.awt.GridLayout;
import java.util.HashMap;
import java.util.Map;

import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTabbedPane;
import javax.swing.JTextArea;
import com.chinacreator.Action.MD5Action;
import com.chinacreator.Action.SaveAction;
import com.chinacreator.util.TabUtil;

/**
 * @Description 
	MD5加密界面初始化类
 * @Author qiang.zhu
 * @Datetime 2016年8月4日 上午10:05:38
 * @Version 
 * @Copyright (c) 2013 湖南科创信息技术股份有限公司

 */
public class MD5Panel {
	//MD5加密模块主面板
	private JPanel tabPanel;
	private JTextArea textContent;
	//图形控件实例化
	public MD5Panel(){
		tabPanel=new JPanel();
		JPanel panel=new JPanel(new GridLayout(2, 1));
		JPanel pUrl=new JPanel();
		JLabel labContent=new JLabel("明文:");
		textContent=new JTextArea(3,60);
		textContent.setText("");
		textContent.setLineWrap(true);
		JScrollPane scrollUrl = new JScrollPane(textContent);
		scrollUrl.setHorizontalScrollBarPolicy(JScrollPane.HORIZONTAL_SCROLLBAR_AS_NEEDED); 
		scrollUrl.setVerticalScrollBarPolicy(JScrollPane.VERTICAL_SCROLLBAR_AS_NEEDED);
		pUrl.add(labContent);
		pUrl.add(scrollUrl);
		panel.add(pUrl);

		JPanel pButton=new JPanel();
		JButton button=new JButton("执行");
		pButton.add(button);
		JButton saveButton=new JButton("保存");
		pButton.add(saveButton);
		panel.add(pButton);

		JPanel pOutPut=new JPanel();
		JTextArea textOutPut=new JTextArea(14,65);
		textOutPut.setLineWrap(true);
		JScrollPane scrollOutPut = new JScrollPane(textOutPut);
		scrollOutPut.setHorizontalScrollBarPolicy(JScrollPane.HORIZONTAL_SCROLLBAR_AS_NEEDED); 
		scrollOutPut.setVerticalScrollBarPolicy(JScrollPane.VERTICAL_SCROLLBAR_AS_NEEDED);
		pOutPut.add(scrollOutPut);
		button.addActionListener(new MD5Action(textOutPut, textContent));
		Map<String,Object> map = new HashMap<String,Object>();
		map.put("panelId", "MD5Panel");
		map.put("textContent", textContent);
		saveButton.addActionListener(new SaveAction(tabPanel, map));
		tabPanel.add(panel);
		tabPanel.add(pOutPut);
	}
	/**
	 * @Description 
		创建MD5加密模块tab页面
	 * @Author qiang.zhu
	 * @param tabbedPane 主tab控件
	 * @param title tab页标题
	 */
	public void createMD5JPanel(JTabbedPane tabbedPane,String title){
		//添加tab页面
		TabUtil.createTab(tabbedPane, tabPanel, title);
	}
	/**
	 * @Description 
		创建MD5加密模块tab页面
	 * @Author qiang.zhu
	 * @param tabbedPane 主tab控件
	 * @param title tab页标题
	 * @param textContent 明文
	 */
	public void createMD5JPanel(final JTabbedPane tabbedPane,String title,String textContent){
		this.textContent.setText(textContent);
		//添加tab页面
		TabUtil.createTab(tabbedPane, tabPanel, title);
	}
}
