class People {
	String name;
	int age;
	char sex;
	
	People() {
		this.name = name;
		this.age = age;
		this.sex = sex;
	}
	
	People(String name,int age,char sex) {
		this.name = name;
		this.age = age;
		this.sex = sex;
	}
	
	void setName(String name) {
		this.name = name;
	}
	
	String getName() {
		return name;
	}
	
	void setAge(int age) {
		this.age = age;
	}
	
	int getAge() {
		return age;
	}
	
	void setSex(char sex) {
		this.sex = sex;
	}
	
	char getSex() {
		return sex;
	}
}

public class ClassPractice {
	
	public static void main(String[] args) {
		People p = new People("张三",18,'男');
		System.out.println(p.name+" "+p.age+" "+p.sex);
		p.setName("Lisa");
		p.setAge(19);
		//System.out.println();
		p.setSex('女');
		//System.out.println();
		System.out.println(p.getName()+" "+p.getAge()+" "+p.getSex());
	}
}