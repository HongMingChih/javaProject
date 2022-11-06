package Dao.member;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.Query;

import Dao.DbConnection;
import Model.Member;

public class implMember implements memberDao {

	public static void main(String[] args) {
//		Member m= new Member("Jerry","1234","Jerry","台北","000","111");//新增
//		new implMember().add(m);
//		System.out.println(new implMember().queryAll());

		/*
		 * //全部查詢 List<Member> l=new implMember().queryAll(); for(Member m:l) {
		 * System.out.println(m); }
		 */

//		System.out.println(new implMember().queryMember("abc","1234"));//查詢帳號密碼
//		System.out.println(new implMember().queryUsername("abc"));// 比對帳號存在使用
//		System.out.println(new implMember().queryMember(1));// 查詢是否存在這個id 並輸出內容
		/*
		Member m = new implMember().queryMember(1);//取得要修改的位置ID
		m.setName("Eric");//修改值
		m.setUsername("Eric");
		m.setMobile("0988998988");
		new implMember().update(m);//建立更新
		*/
		
//		new implMember().delete(3);//刪除第3個id
	}

	@Override
	public void add(Member m) {
		EntityManager em = DbConnection.getDb();// 連線
		em.getTransaction().begin();// 開始
		em.persist(m);// 新增傳入
		em.getTransaction().commit();// 提交
		em.close();// 關閉連線

	}

	@Override
	public List<Member> queryAll() {
		EntityManager em = DbConnection.getDb();
		String JPQL = "select m from Member m";
		Query q = em.createQuery(JPQL);
		List<Member> l = q.getResultList();

		return l;
	}

	@Override
	public Member queryMember(String username, String password) {
		EntityManager em = DbConnection.getDb();
		String JPQL = "select m from Member m where m.username=?1 and m.password=?2";
		Query q = em.createQuery(JPQL);
		q.setParameter(1, username);
		q.setParameter(2, password);

		List<Member> l = q.getResultList();
		if (l.size() == 0) {
			return null;
		} else {
			Member[] m = l.toArray(new Member[l.size()]);
			return m[0];
		}

	}

	@Override
	public boolean queryUsername(String username) {
		EntityManager em = DbConnection.getDb();
		String JPQL = "select m from Member m where m.username=?1";
		Query q = em.createQuery(JPQL);
		q.setParameter(1, username);
		List<Member> l = q.getResultList();
		if (l.size() != 0) {
			return true;
		}
		return false;
	}

	@Override
	public Member queryMember(int id) {
		EntityManager em = DbConnection.getDb();
		String JPQL = "select m from Member m where m.id=?1";
		Query q = em.createQuery(JPQL);
		q.setParameter(1, id);
		List<Member> l = q.getResultList();
		if (l.size() == 0) {
			return null;
		} else {
			Member[] m = l.toArray(new Member[l.size()]);
			return m[0];
		}

	}

	@Override
	public void update(Member m) {
		EntityManager em = DbConnection.getDb();// 連線
		em.getTransaction().begin();// 開始
		em.merge(m);// 傳入m
		em.getTransaction().commit();// 提交
		em.close();// 關閉連線
	}

	@Override
	public void delete(int id) {
		EntityManager em = DbConnection.getDb();// 連線
		Member m=em.find(Member.class, id);//find找到id
		em.getTransaction().begin();// 開始
		em.remove(m);// 傳入m
		em.getTransaction().commit();// 提交
		em.close();// 關閉連線
	}

}
