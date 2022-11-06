package Dao.porder;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.Query;

import Dao.DbConnection;
import Model.Porder;

public class implPorder implements PorderDao {

	public static void main(String[] args) {
//		Porder p=new Porder("F桌",2,1,2);//新增
//		new implPorder().add(p);
		
		 //全部查詢 
//		System.out.println(new implPorder().queryAll());
		
//		System.out.println(new implPorder().querySum(100,900));//查詢sum
//		System.out.println(new implPorder().queryPorder(1));// 查詢是否存在這個id 並輸出內容
	
		/*
		Porder p = new implPorder().queryPorder(6);//取得要修改的位置ID
//		p.setDesk("F桌");//修改值
		p.setA(3);//修改值
		p.setB(2);//修改值
		p.setC(1);//修改值
		p.getSum();
		new implPorder().update(p);//建立更新
		*/
//				new implPorder().delete(4);//刪除第3個id
		

	}

	@Override
	public void add(Porder p) {
		EntityManager em = DbConnection.getDb();// 連線
		em.getTransaction().begin();// 開始
		em.persist(p);// 新增傳入
		em.getTransaction().commit();// 提交
		em.close();// 關閉連線
	}

	@Override
	public List<Porder> queryAll() {
		EntityManager em = DbConnection.getDb();
		String JPQL = "select m from Porder m";
		Query q = em.createQuery(JPQL);
		List<Porder> l = q.getResultList();
		return l;
		
	}

	@Override
	public List<Porder> querySum(int start, int end) {
		EntityManager em = DbConnection.getDb();
		String JPQL = "select p from Porder p where p.sum>=?1 and p.sum<=?2";
		Query q = em.createQuery(JPQL);
		q.setParameter(1, start);
		q.setParameter(2, end);
		List<Porder> l = q.getResultList();
		return l;

	
	}

	@Override
	public void update(Porder p) {
		EntityManager em = DbConnection.getDb();// 連線
		em.getTransaction().begin();// 開始
		em.merge(p);// 傳入m
		em.getTransaction().commit();// 提交
		em.close();// 關閉連線
	}

	@Override
	public void delete(int id) {
		EntityManager em = DbConnection.getDb();// 連線
		Porder p=em.find(Porder.class, id);//find找到id
		em.getTransaction().begin();// 開始
		em.remove(p);// 傳入m
		em.getTransaction().commit();
		em.close();// 關閉連線
	}

	@Override
	public Porder queryPorder(int id) {
		EntityManager em = DbConnection.getDb();
		String JPQL = "select p from Porder p where p.id=?1";
		Query q = em.createQuery(JPQL);
		q.setParameter(1, id);
		List<Porder> list = q.getResultList();
		if (list.size() == 0) {
			return null;
		} else {
			Porder[] p = list.toArray(new Porder[list.size()]);
			return p[0];
		}

	}

}
