package Dao.porder;

import java.util.List;

import Model.Porder;

public interface PorderDao {

	//create新增
	void add(Porder p);
	//read查詢
	List<Porder> queryAll();
	
	List<Porder>querySum(int start,int end);
	Porder queryPorder(int id);
	//update修改
	void update(Porder p);
	//delete刪除
	void delete(int id);
}
