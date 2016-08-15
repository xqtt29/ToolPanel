package com.chinacreator.Action;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import javax.swing.JFileChooser;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.filechooser.FileFilter;
import javax.swing.text.JTextComponent;
import com.chinacreator.service.PropFileService;

/**
 * @Description 
	GET请求模块执行按钮事件类
 * @Author qiang.zhu
 * @Datetime 2016年8月4日 上午9:57:16
 * @Version 
 * @Copyright (c) 2013 湖南科创信息技术股份有限公司

 */
public class SaveAction implements ActionListener{
	//主tab控件
	private JPanel tabPane;
	//待保存数据
	private Map<String,Object> datas;
	
	public SaveAction(JPanel tabPane,Map<String,Object> datas){
		this.tabPane=tabPane;
		this.datas=datas;
	}
	@Override
	public void actionPerformed(ActionEvent e) {
		JFileChooser saveChooserSavePath=new JFileChooser();
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
		int returnval=saveChooserSavePath.showSaveDialog(tabPane);
        if(returnval==JFileChooser.APPROVE_OPTION) 
        { 
        	File file = saveChooserSavePath.getSelectedFile();
        	Map<String,Object> map = new HashMap<String,Object>();
        	map.putAll(datas);
        	Iterator<String> it=datas.keySet().iterator();
        	while(it.hasNext()){
        		String key=it.next();
        		Object value=datas.get(key);
        		if(!"panelId".equals(key)){
        			map.put(key, ((JTextComponent)value).getText());
        		}
        	}
        	new PropFileService().setPropFileInfo(file.getAbsolutePath()+(file.getAbsolutePath().endsWith(".prop")?"":".prop"), map);
        	JOptionPane.showMessageDialog(tabPane, "保存成功", "提示",JOptionPane.WARNING_MESSAGE);
        } 
	}

}
