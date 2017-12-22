package com.rj.bookshop.Service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.rj.bookshop.Dao.KindDao;
import com.rj.bookshop.Entity.Kind;
@Service
@Transactional
public class KindService {
	@Autowired
	private KindDao kindDao;

	public List<Kind> selectKind() {
		return kindDao.select();
	}

	public Kind selectKindById(int kind_id) {
		return kindDao.selectById(kind_id);
	}

	public boolean insertKind(Kind kind) {
		return kindDao.insert(kind);
	}

	public boolean updateKind(Kind kind) {
		return kindDao.update(kind);
	}

	public boolean deleteKind(Kind kind) {
		return kindDao.delete(kind);
	}
}
