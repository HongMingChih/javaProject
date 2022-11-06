package Dao.member;

import java.util.List;

import Model.Member;

public interface memberDao {
		//Create新增
		void add(Member m);
		
		//Read 查詢
		List<Member> queryAll();//全部查詢
		Member queryMember(String username,String password);//帳號,密碼
		boolean queryUsername(String username);//
		Member queryMember(int id);
		
		//Update修改
		void update(Member m);
		
		//Delete刪除
		void delete(int id);
		
}
