package com.chinacreator.service;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;

public class PropFileService {
	
	public Map<String,Object> getPropFileInfo(String absPath){
		Map<String,Object> map = new HashMap<String,Object>();
		File f=new File(absPath);
		BufferedReader br=null;
		try{
			br=new BufferedReader(new FileReader(f));
			String line="";
			while((line=br.readLine())!=null){
				String[] lines = line.split("\\(split\\)");
				if(lines.length==2){
					map.put(lines[0], lines[1]);
				}else{
					map.put(lines[0], "");
				}
			}
		}catch(Exception e){
			e.printStackTrace();
		}finally{
			if(br!=null){
				try {
					br.close();
				} catch (IOException e) {
					e.printStackTrace();
				}
			}
		}
		return map;
	}
	
	
	public void setPropFileInfo(String absPath,Map<String,Object> map){
		File f=new File(absPath);
		BufferedWriter bw=null;
		try{
			bw=new BufferedWriter(new FileWriter(f));
			Iterator<String> it=map.keySet().iterator();
			while(it.hasNext()){
				String key=it.next();
				Object value=map.get(key);
				bw.write(key+"(split)"+value+"\r\n");
			}
			bw.flush();
		}catch(Exception e){
			e.printStackTrace();
		}finally{
			if(bw!=null){
				try {
					bw.close();
				} catch (IOException e) {
					e.printStackTrace();
				}
			}
		}
	}
}
