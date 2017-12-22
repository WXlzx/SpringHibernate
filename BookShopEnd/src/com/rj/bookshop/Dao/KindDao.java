package com.rj.bookshop.Dao;

import java.util.List;

import com.rj.bookshop.Entity.Kind;

public interface KindDao {
	public List<Kind> select();
	public Kind selectById(int kind_id);
	public boolean insert(Kind kind);
	public boolean update(Kind kind);
	public boolean delete(Kind kind);

}
