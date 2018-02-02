package test1;

//import java.util.*;

//---------------------覆盖equals-----------------------
/*
对于equals，我们必须遵循如下规则：
    对称性：如果x.equals(y)返回是“true”，那么y.equals(x)也应该返回是“true”。
    自反性：x.equals(x)必须返回是“true”。
    传递性：如果x.equals(y)返回是“true”，而且y.equals(z)返回是“true”，那么z.equals(x)也应该返回是“true”。
    一致性：如果x.equals(y)返回是“true”，只要x和y内容一直不变，不管你重复x.equals(y)多少次，返回都是“true”。
任何情况下，x.equals(null)，永远返回是“false”；x.equals(和x不同类型的对象)永远返回是“false”。
*/

class Person{
	private String name,number;
	private int age;
	
	public Person(String name, int age, String number){
		this.name = name;
		this.age = age;
		this.number = number;
	}
	
	public boolean equals(Object obj){
		if (this == obj){
			return true;
		}
		if (obj == null){
			return false;
		}
		/*if (obj instanceof Person){
			Person st = (Person) obj;
			return this.name.equals(st.name) && this.age == st.age && this.number.equals(st.number);
		} else{
			return false;
		}*/
	    if (getClass() != obj.getClass() ){
		    return false;
	    }
	    Person st = (Person) obj;
		return this.name.equals(st.name) && this.age == st.age && this.number.equals(st.number);
	  
	}
}


public class Test {
      public static void main(String[] args) {
		Person p1 = new Person("qwer", 12, "qwer");
		Person p2 = new Person("qwer", 12, "qwer");
		System.out.println(p1==p2 ? "yes" : "no");
		System.out.println(p1.equals(p2) ? "yes" : "no");
	}
}
