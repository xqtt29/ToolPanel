package com.chinacreator.panel;

import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;
import java.util.HashMap;
import java.util.Map;

import javax.swing.JButton;
import javax.swing.JFileChooser;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTabbedPane;
import javax.swing.JTextArea;
import javax.swing.JTextField;
import javax.swing.filechooser.FileFilter;
import com.chinacreator.Action.OracleDataInputAction;
import com.chinacreator.Action.SaveAction;
import com.chinacreator.util.TabUtil;

/**
 * @Description 
	oracle数据导入界面初始化类
 * @Author qiang.zhu
 * @Datetime 2016年8月4日 上午10:05:38
 * @Version 
 * @Copyright (c) 2013 湖南科创信息技术股份有限公司

 */
public class OracleDataInputPanel {
	//oracle数据导入模块主面板
	private JPanel tabPanel;
	private JTextArea textUrl;
	private JTextArea textParam;
	//图形控件实例化
	public OracleDataInputPanel(){
		tabPanel=new JPanel();
		JPanel panel=new JPanel(new GridLayout(4, 1));
		JPanel pUrl=new JPanel();
		JLabel labUrl=new JLabel("数据库串:");
		textUrl=new JTextArea(3,60);
		textUrl.setText("userid=ecb/ecb2012@bsweb_new rows=1000 direct=TRUE");
		textUrl.setLineWrap(true);
		JScrollPane scrollUrl = new JScrollPane(textUrl);
		scrollUrl.setHorizontalScrollBarPolicy(JScrollPane.HORIZONTAL_SCROLLBAR_AS_NEEDED); 
		scrollUrl.setVerticalScrollBarPolicy(JScrollPane.VERTICAL_SCROLLBAR_AS_NEEDED);
		pUrl.add(labUrl);
		pUrl.add(scrollUrl);
		panel.add(pUrl);

		JPanel pParam=new JPanel();
		JLabel labParam=new JLabel("表列参数:");
		textParam=new JTextArea(3,60);
		textParam.setText("TD_BIGDIAL_SPNUM#_#	#_#SPNUM,SPTYPE constant \"TICKET_READ10\"");
		textParam.setLineWrap(true);
		JScrollPane scrollParam = new JScrollPane(textParam);
		scrollParam.setHorizontalScrollBarPolicy(JScrollPane.HORIZONTAL_SCROLLBAR_AS_NEEDED); 
		scrollParam.setVerticalScrollBarPolicy(JScrollPane.VERTICAL_SCROLLBAR_AS_NEEDED);
		pParam.add(labParam);
		pParam.add(scrollParam);
		panel.add(pParam);
		
		JPanel pFile=new JPanel();
		JLabel labFile=new JLabel("数据文件:");
		final JTextField textFile=new JTextField(54);
		textFile.setEditable(false);
		JButton btnFile=new JButton("选择");
		final JFileChooser addChooserSavePath=new JFileChooser();
    	addChooserSavePath.setFileSelectionMode(JFileChooser.FILES_ONLY);
    	btnFile.addActionListener(new ActionListener(){
			@Override
			public void actionPerformed(ActionEvent arg0) {
				addChooserSavePath.setAcceptAllFileFilterUsed(false);
				addChooserSavePath.addChoosableFileFilter(new FileFilter() {
					@Override
					public String getDescription() {
						return "数据文件(*.csv)";
					}
					@Override
					public boolean accept(File f) {
						if(f.isDirectory()){
							return true;
						}
						if(f.getName().endsWith(".csv")){
					        return true;
					    }
					    return false;
					}
				});
				addChooserSavePath.addChoosableFileFilter(new FileFilter() {
					@Override
					public String getDescription() {
						return "文本文件(*.txt)";
					}
					@Override
					public boolean accept(File f) {
						 if(f.getName().endsWith(".txt")){
					          return true;
					     }
					     return false;
					}
				});
				int returnval=addChooserSavePath.showOpenDialog(tabPanel);
		        if(returnval==JFileChooser.APPROVE_OPTION) 
		        { 
		        	textFile.setText(addChooserSavePath.getSelectedFile().getAbsolutePath());
		        } 
			}
    		
    	});
    	pFile.add(labFile);
    	pFile.add(textFile);
    	pFile.add(btnFile);
		panel.add(pFile);
		
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
		button.addActionListener(new OracleDataInputAction(textOutPut, textUrl, textFile, textParam));

		Map<String,Object> map = new HashMap<String,Object>();
		map.put("panelId", "OracleDataInputPanel");
		map.put("textUrl", textUrl);
		map.put("textParam", textParam);
		saveButton.addActionListener(new SaveAction(tabPanel, map));
		tabPanel.add(panel);
		tabPanel.add(pOutPut);
	}
	/**
	 * @Description 
		创建oracle数据导入模块tab页面
	 * @Author qiang.zhu
	 * @param tabbedPane 主tab控件
	 * @param title tab页标题
	 */
	public void createOracleDataInputJPanel(JTabbedPane tabbedPane,String title){
		//添加tab页面
		TabUtil.createTab(tabbedPane, tabPanel, title);
	}
	/**
	 * @Description 
		创建oracle数据导入模块tab页面
	 * @Author qiang.zhu
	 * @param tabbedPane 主tab控件
	 * @param title tab页标题
	 */
	public void createOracleDataInputJPanel(final JTabbedPane tabbedPane,String title,String textUrl,String textParam){
		this.textUrl.setText(textUrl);
		this.textParam.setText(textParam);
		//添加tab页面
		TabUtil.createTab(tabbedPane, tabPanel, title);
	}
}
