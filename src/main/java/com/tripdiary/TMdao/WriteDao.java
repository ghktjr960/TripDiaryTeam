package com.tripdiary.TMdao;

import java.util.List;
import java.util.Map;

import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.tripdiary.TMvo.MapCmd;
import com.tripdiary.TMvo.TagCmd;
import com.tripdiary.TMvo.WriteCmd;

@Repository
public class WriteDao {
	
	private SqlSessionTemplate sqlSessionTemplate;
	
	@Autowired
	public WriteDao(SqlSessionTemplate sqlSessionTemplate) {
		this.sqlSessionTemplate = sqlSessionTemplate;
	}
	
	public void write(WriteCmd writeCmd) {
		writeCmd.setTripdate(writeCmd.getYear()+"-"+writeCmd.getMonth()+"-"+writeCmd.getDay());
		sqlSessionTemplate.insert("write", writeCmd);
	}
	
	public void insertFile(Map<String, Object> map) throws Exception {
		sqlSessionTemplate.insert("insertFile", map);
	}

	public void insertTag(Map<String,Object> tag) {
		sqlSessionTemplate.insert("insertTag",tag);
	}
	
	public void insertMap (MapCmd mapCmd) {
		sqlSessionTemplate.insert("insertMap", mapCmd);
	}
	public void cntUp(int memberNum) {
		sqlSessionTemplate.update("cntUp", memberNum);
	}
	
	public WriteCmd getBoard(int boardNum) {
		return sqlSessionTemplate.selectOne("getBoard", boardNum);
	}
	
	public List<TagCmd> getTag(int boardNum){
		return sqlSessionTemplate.selectList("getTag", boardNum);
	}
	
	public void writeUpdate(WriteCmd writeCmd) {
		writeCmd.setTripdate(writeCmd.getYear()+"-"+writeCmd.getMonth()+"-"+writeCmd.getDay());
		sqlSessionTemplate.update("writeUpdate", writeCmd);
	}
	
	public void deleteTag(int boardNum) {
		sqlSessionTemplate.delete("deleteTag", boardNum);
	}

	
	public void deleteThumbnail(int boardNum) {
		sqlSessionTemplate.delete("deleteThumbnail", boardNum);
	}
	
	public void deleteFile(int boardNum) {
		sqlSessionTemplate.delete("deleteFile", boardNum);
	}
	
	public String getMainImg(int boardNum) {
		return sqlSessionTemplate.selectOne("getMainImg", boardNum);
	}
	
	public List<String> getSubImg(int boardNum) {
		return sqlSessionTemplate.selectList("getSubImg", boardNum);
	}

}
