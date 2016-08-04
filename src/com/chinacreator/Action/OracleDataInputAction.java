package com.chinacreator.Action;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JTextArea;
import javax.swing.JTextField;
import com.chinacreator.service.OracleDataInputService;

/**
 * @Description 
	oracle数据批量导入模块执行按钮事件类
 * @Author qiang.zhu
 * @Datetime 2016年8月4日 上午9:59:01
 * @Version 
 * @Copyright (c) 2013 湖南科创信息技术股份有限公司

 */
public class OracleDataInputAction implements ActionListener{
	//输出控件
	private JTextArea textOutPut;
	//url文本控件
	private JTextArea textUrl;
	//数据文件路径控件
	private JTextField textFile;
	//参数文本控件
	private JTextArea textParam;
	
	public OracleDataInputAction(JTextArea textOutPut,JTextArea textUrl,JTextField textFile,JTextArea textParam){
		this.textOutPut=textOutPut;
		this.textUrl=textUrl;
		this.textFile=textFile;
		this.textParam=textParam;
	}
	@Override
	public void actionPerformed(ActionEvent e) {
		//调用oracle数据批量导入服务类
		new OracleDataInputService().dataInput(textOutPut,textUrl.getText(),textFile.getText(), textParam.getText());
	}

}
