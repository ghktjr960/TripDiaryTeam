package com.tripdiary.TMutil;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.tripdiary.TMvo.PageCmd;

@Component
public class PageCalc {
	private PageCmd pageVO;
	@Autowired
	public PageCalc(PageCmd pageVO) {
		this.pageVO = pageVO;
	}
	
	public PageCmd getPageVO() {
		return pageVO;
	}

	public void setPageVO(PageCmd pageVO) {
		this.pageVO = pageVO;
	}

	public PageCmd pageCalc(int currentPage, int articleCount) {
		// currentPage = ����������, articleCount = �� �� ����
		int countList = 9;//�� �������� ������ �� ����
		int countPage = 3;// ������ ���� ex ) [1] [2] [3] ����
		int block = articleCount / countList;
		
		if(articleCount % countList != 0) {
			block++;
		}
		if(currentPage <= 0 ) {
			currentPage = 1;
		}
		if(currentPage > block) {
			currentPage -= countPage;
		}
		int startPage = (currentPage-1) / countPage * countPage + 1; // ���� ������
		int endPage = startPage + countPage - 1; // �� ������
		if (endPage > block) {
			endPage = block;
		}
		int first = currentPage*countList - countList + 1; //fist ���� second ������ �Խù��� �����ش�
		int second = currentPage*countList; //	ex) 1~5 �� �Խù� ���̱�
		
		
		pageVO.setStartPage(startPage);
		pageVO.setEndPage(endPage);
		pageVO.setCountPage(countPage);
		pageVO.setCurrentPage(currentPage);
		pageVO.setFirst(first);
		pageVO.setSecond(second);
		pageVO.setBlock(block);
		
		return pageVO;
	}
}
