package com.chinacreator.panel;

import java.awt.GridLayout;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTabbedPane;
import javax.swing.JTextArea;
import com.chinacreator.Action.PostAction;
import com.chinacreator.util.TabUtil;

/**
 * @Description 
	post请求界面初始化类
 * @Author qiang.zhu
 * @Datetime 2016年8月4日 上午10:05:38
 * @Version 
 * @Copyright (c) 2013 湖南科创信息技术股份有限公司

 */
public class PostPanel {
	//get请求模块主面板
	private JPanel tabPanel;
	//图形控件实例化
	public PostPanel(){
		tabPanel=new JPanel();
		JPanel panel=new JPanel(new GridLayout(4, 1));
		JPanel pUrl=new JPanel();
		JLabel labUrl=new JLabel("网址:");
		JTextArea textUrl=new JTextArea(3,60);
		textUrl.setLineWrap(true);
		JScrollPane scrollUrl = new JScrollPane(textUrl);
		scrollUrl.setHorizontalScrollBarPolicy(JScrollPane.HORIZONTAL_SCROLLBAR_AS_NEEDED); 
		scrollUrl.setVerticalScrollBarPolicy(JScrollPane.VERTICAL_SCROLLBAR_AS_NEEDED);
		pUrl.add(labUrl);
		pUrl.add(scrollUrl);
		panel.add(pUrl);

		JPanel pParam=new JPanel();
		JLabel labParam=new JLabel("参数:");
		JTextArea textParam=new JTextArea(3,60);
		textParam.setText("param1=value1&param2=value2....");
		textParam.setLineWrap(true);
		JScrollPane scrollParam = new JScrollPane(textParam);
		scrollParam.setHorizontalScrollBarPolicy(JScrollPane.HORIZONTAL_SCROLLBAR_AS_NEEDED); 
		scrollParam.setVerticalScrollBarPolicy(JScrollPane.VERTICAL_SCROLLBAR_AS_NEEDED);
		pParam.add(labParam);
		pParam.add(scrollParam);
		panel.add(pParam);
		
		JPanel pProp=new JPanel();
		JLabel labProp=new JLabel("属性:");
		JTextArea textProp=new JTextArea(3,60);
		textProp.setText("Content-Encoding(&_&)UTF-8(#_#)Cookie(&_&)value....");
		textProp.setLineWrap(true);
		JScrollPane scrollProp = new JScrollPane(textProp);
		scrollProp.setHorizontalScrollBarPolicy(JScrollPane.HORIZONTAL_SCROLLBAR_AS_NEEDED); 
		scrollProp.setVerticalScrollBarPolicy(JScrollPane.VERTICAL_SCROLLBAR_AS_NEEDED);
		pProp.add(labProp);
		pProp.add(scrollProp);
		panel.add(pProp);
		
		JPanel pButton=new JPanel();
		JLabel labPic=new JLabel();
		pButton.add(labPic);
		JButton button=new JButton("执行");
		pButton.add(button);
		panel.add(pButton);

		JPanel pOutPut=new JPanel();
		JTextArea textOutPut=new JTextArea(14,65);
		textOutPut.setLineWrap(true);
		JScrollPane scroll = new JScrollPane(textOutPut);
		scroll.setHorizontalScrollBarPolicy(JScrollPane.HORIZONTAL_SCROLLBAR_AS_NEEDED); 
		scroll.setVerticalScrollBarPolicy(JScrollPane.VERTICAL_SCROLLBAR_AS_NEEDED);
		pOutPut.add(scroll);

		button.addActionListener(new PostAction(textOutPut, labPic, textUrl, textProp, textParam));
		
		tabPanel.add(panel);
		tabPanel.add(pOutPut);
	}
	/**
	 * @Description 
		创建get请求模块tab页面
	 * @Author qiang.zhu
	 * @param tabbedPane 主tab控件
	 * @param title tab页标题
	 */
	public void createPostJPanel(final JTabbedPane tabbedPane,String title){
		//添加tab页面
		TabUtil.createTab(tabbedPane, tabPanel, title);
	}
}
