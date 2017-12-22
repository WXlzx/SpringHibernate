package com.rj.bookshop.DaoImpl;

import java.util.List;

import org.springframework.stereotype.Repository;

import com.rj.bookshop.Dao.PageDao;
import com.rj.bookshop.Entity.PageBean;

@Repository
public class PageDaoImpl implements PageDao {

	@Override
	public List page(List list,int page) {
		PageBean pagebean = new PageBean(list.size());
		pagebean.setCurPage(page);
		
		int pagesize = pagebean.getPageSize();
		
		int firstIndex = (page-1)*pagesize;
		int toIndex = page*pagesize;
		
		if(toIndex > list.size()) {
			toIndex = list.size();
		}
		
		if(firstIndex >toIndex) {
			firstIndex = toIndex - pagesize;
			if(firstIndex <=0) {
				firstIndex = 0;
			}
		}
		
		List courseList = list.subList(firstIndex, toIndex);
		
		return courseList;
	}

}
