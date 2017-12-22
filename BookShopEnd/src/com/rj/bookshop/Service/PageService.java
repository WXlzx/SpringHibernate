package com.rj.bookshop.Service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.rj.bookshop.Dao.PageDao;

@Service
public class PageService {
	@Autowired 
	private PageDao pageDao;
	
	public List page(List list,int page) {
		return pageDao.page(list, page);
	}
}
