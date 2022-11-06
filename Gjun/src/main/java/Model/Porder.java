package Model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "porder")
public class Porder {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer id;
	
	private String desk;
	
	private Integer a;
	
	private Integer b;
	
	private Integer c;
	
	private Integer sum;

	public Porder() {

	}

	public Porder(String desk, Integer a, Integer b, Integer c) {
		super();
		this.desk = desk;
		this.a = a;
		this.b = b;
		this.c = c;
		this.sum = a*120+b*135+c*150;
	}
	

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getDesk() {
		return desk;
	}

	public void setDesk(String desk) {
		this.desk = desk;
	}

	public Integer getA() {
		return a;
	}

	public void setA(Integer a) {
		this.a = a;
	}

	public Integer getB() {
		return b;
	}

	public void setB(Integer b) {
		this.b = b;
	}

	public Integer getC() {
		return c;
	}

	public void setC(Integer c) {
		this.c = c;
	}

	public Integer getSum() {
		sum = a*120+b*135+c*150;
		return sum;
	}

	public void setSum(Integer sum) {
		this.sum = sum;
	}

	@Override
	public String toString() {
		return "Porder [id=" + id + ", desk=" + desk + ", a=" + a + ", b=" + b + ", c=" + c + ", sum=" + sum + "]";
	}
	
	
	
	
}
