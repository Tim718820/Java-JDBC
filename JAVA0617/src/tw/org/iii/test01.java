package tw.org.iii;

public class test01 {

	public static void main(String[] args) {
		p1 obj1 = new AA111();
		p1 obj2 = new AA222();
		m4(obj1);
	}
	static void m4(p1 anyObj){
		anyObj.m1();
		if(anyObj instanceof AA111){
			((AA111)anyObj).m2();
		}else{
			((AA222)anyObj).m3();
		}
			
	}

}

interface p1{
	void m1();
}
class AA111 implements p1{
	public void m1(){System.out.println("A");};
	void m2(){System.out.println("A1");};
}
class AA222 implements p1{
	public void m1(){System.out.println("b");};
	void m3(){System.out.println("B1");};
}