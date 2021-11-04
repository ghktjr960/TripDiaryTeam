package com.tripdiary.TMutil;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.stereotype.Component;

import com.tripdiary.TMvo.TagCmd;
import com.tripdiary.TMvo.WriteCmd;

@Component
public class TagUtils {
	public List<Map<String, Object>> tagList(WriteCmd writeCmd, TagCmd tagCmd) {
		
		List<Map<String, Object>> list = new ArrayList<Map<String,Object>>();
		Map<String, Object> listMap = null;
		
		int num = writeCmd.getBoardNum();
		
		for(int i=0; i<tagCmd.getTag().size(); i++) {
			listMap = new HashMap<String, Object>();
			listMap.put("boardNum", num);
			listMap.put("tag", tagCmd.getTag().get(i));
			list.add(listMap);
		}
		
		
		return list;
	}

}
