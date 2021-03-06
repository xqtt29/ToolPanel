package com.chinacreator.panel;

import java.awt.GridLayout;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTabbedPane;
import javax.swing.JTextArea;
import com.chinacreator.Action.SocketAction;
import com.chinacreator.util.TabUtil;

/**
 * @Description 
	socket请求界面初始化类
 * @Author qiang.zhu
 * @Datetime 2016年8月4日 上午10:05:38
 * @Version 
 * @Copyright (c) 2013 湖南科创信息技术股份有限公司

 */
public class SocketPanel {
	//socket请求模块主面板
	private JPanel tabPanel;
	//图形控件实例化
	public SocketPanel(){
		tabPanel=new JPanel();
		JPanel panel=new JPanel(new GridLayout(4, 1));
		JPanel pIp=new JPanel();
		JLabel labIp=new JLabel("IP:");
		JTextArea textIp=new JTextArea(3,60);
		textIp.setLineWrap(true);
		JScrollPane scrollUrl = new JScrollPane(textIp);
		scrollUrl.setHorizontalScrollBarPolicy(JScrollPane.HORIZONTAL_SCROLLBAR_AS_NEEDED); 
		scrollUrl.setVerticalScrollBarPolicy(JScrollPane.VERTICAL_SCROLLBAR_AS_NEEDED);
		pIp.add(labIp);
		pIp.add(scrollUrl);
		panel.add(pIp);

		JPanel pParam=new JPanel();
		JLabel labPort=new JLabel("端口:");
		JTextArea textPort=new JTextArea(3,60);
		textPort.setLineWrap(true);
		JScrollPane scrollParam = new JScrollPane(textPort);
		scrollParam.setHorizontalScrollBarPolicy(JScrollPane.HORIZONTAL_SCROLLBAR_AS_NEEDED); 
		scrollParam.setVerticalScrollBarPolicy(JScrollPane.VERTICAL_SCROLLBAR_AS_NEEDED);
		pParam.add(labPort);
		pParam.add(scrollParam);
		panel.add(pParam);
		
		JPanel pProp=new JPanel();
		JLabel labContent=new JLabel("内容:");
		JTextArea textContent=new JTextArea(3,60);
		textContent.setLineWrap(true);
		JScrollPane scrollProp = new JScrollPane(textContent);
		scrollProp.setHorizontalScrollBarPolicy(JScrollPane.HORIZONTAL_SCROLLBAR_AS_NEEDED); 
		scrollProp.setVerticalScrollBarPolicy(JScrollPane.VERTICAL_SCROLLBAR_AS_NEEDED);
		pProp.add(labContent);
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
		JScrollPane scrollOutPut = new JScrollPane(textOutPut);
		scrollOutPut.setHorizontalScrollBarPolicy(JScrollPane.HORIZONTAL_SCROLLBAR_AS_NEEDED); 
		scrollOutPut.setVerticalScrollBarPolicy(JScrollPane.VERTICAL_SCROLLBAR_AS_NEEDED);
		pOutPut.add(scrollOutPut);
		
		button.addActionListener(new SocketAction(textOutPut, textIp, textPort, textContent));
		
		tabPanel.add(panel);
		tabPanel.add(pOutPut);
	}
	/**
	 * @Description 
		创建socket请求模块tab页面
	 * @Author qiang.zhu
	 * @param tabbedPane 主tab控件
	 * @param title tab页标题
	 */
	public void createSocketJPanel(final JTabbedPane tabbedPane,String title){
		//添加tab页面
		TabUtil.createTab(tabbedPane, tabPanel, title);
	}
}
