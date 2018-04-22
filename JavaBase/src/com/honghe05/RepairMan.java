package com.honghe05;

public class RepairMan extends People {
	int salary;

	RepairMan(int salary){
		if (salary < 0) {
			this.salary = 0;
		} else {
			this.salary = salary;
		}
	}
	public int getSalary() {
		return this.salary;
	}

	public void setSalary(int salary) {
		if (salary < 0) {
			this.salary = 0;
		} else {
			this.salary = salary;
		}
	}
	
	
}
