package com.chinacreator.panel;

import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.util.HashMap;
import java.util.Map;

import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTabbedPane;
import javax.swing.JTextArea;
import javax.swing.JTextField;

import com.chinacreator.Action.GetAction;
import com.chinacreator.Action.SaveAction;
import com.chinacreator.util.TabUtil;

/**
 * @Description 
	get请求界面初始化类
 * @Author qiang.zhu
 * @Datetime 2016年8月4日 上午10:05:38
 * @Version 
 * @Copyright (c) 2013 湖南科创信息技术股份有限公司

 */
public class GetPanel {
	//get请求模块主面板
	private JPanel tabPanel;
	private JTextArea textUrl;
	private JTextArea textParam;
	private JTextArea textProp;
	//图形控件实例化
	public GetPanel(){
		tabPanel=new JPanel();
		JPanel panel=new JPanel(new GridLayout(4, 1));
		JPanel pUrl=new JPanel();
		JLabel labUrl=new JLabel("网址:");
		textUrl=new JTextArea(3,60);
		textUrl.setLineWrap(true);
		JScrollPane scrollUrl = new JScrollPane(textUrl);
		scrollUrl.setHorizontalScrollBarPolicy(JScrollPane.HORIZONTAL_SCROLLBAR_AS_NEEDED); 
		scrollUrl.setVerticalScrollBarPolicy(JScrollPane.VERTICAL_SCROLLBAR_AS_NEEDED);
		pUrl.add(labUrl);
		pUrl.add(scrollUrl);
		panel.add(pUrl);

		JPanel pParam=new JPanel();
		JLabel labParam=new JLabel("参数:");
		textParam=new JTextArea(3,60);
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
		textProp=new JTextArea(3,60);
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
		JTextField textThreadCounts=new JTextField();
		textThreadCounts.setText("1");
		textThreadCounts.setColumns(3);
		pButton.add(textThreadCounts);
		JButton button=new JButton("执行");
		pButton.add(button);
		JButton clearButton=new JButton("重置");
		pButton.add(clearButton);
		JButton saveButton=new JButton("保存");
		pButton.add(saveButton);
		panel.add(pButton);

		JPanel pOutPut=new JPanel();
		final JTextArea textOutPut=new JTextArea(13,65);
		textOutPut.setLineWrap(true);
		JScrollPane scrollOutPut = new JScrollPane(textOutPut);
		scrollOutPut.setHorizontalScrollBarPolicy(JScrollPane.HORIZONTAL_SCROLLBAR_AS_NEEDED); 
		scrollOutPut.setVerticalScrollBarPolicy(JScrollPane.VERTICAL_SCROLLBAR_AS_NEEDED);
		pOutPut.add(scrollOutPut);
		
		button.addActionListener(new GetAction(textOutPut,textThreadCounts, labPic, textUrl, textProp, textParam));
		clearButton.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				textOutPut.setText("");
			}
		});
		labParam.addMouseListener(new MouseAdapter() {
			public void mouseClicked(MouseEvent e){
				int pos=textProp.getCaret().getDot();
				textProp.insert("(&_&)", pos);
    		}
		});
		labProp.addMouseListener(new MouseAdapter() {
			public void mouseClicked(MouseEvent e){
				int pos=textProp.getCaret().getDot();
				textProp.insert("(#_#)", pos);
    		}
		});
		Map<String,Object> map = new HashMap<String,Object>();
		map.put("panelId", "GetPanel");
		map.put("textUrl", textUrl);
		map.put("textParam", textParam);
		map.put("textProp", textProp);
		saveButton.addActionListener(new SaveAction(tabPanel, map));
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
	public void createGetJPanel(final JTabbedPane tabbedPane,String title){
		//添加tab页面
		TabUtil.createTab(tabbedPane, tabPanel, title);
	}
	/**
	 * @Description 
		创建get请求模块tab页面
	 * @Author qiang.zhu
	 * @param tabbedPane 主tab控件
	 * @param title tab页标题
	 * @param textUrl 网址
	 * @param textParam 参数
	 * @param textProp 属性
	 */
	public void createGetJPanel(final JTabbedPane tabbedPane,String title,String textUrl,String textParam,String textProp){
		this.textUrl.setText(textUrl);
		this.textParam.setText(textParam);
		this.textProp.setText(textProp);
		//添加tab页面
		TabUtil.createTab(tabbedPane, tabPanel, title);
	}
}
