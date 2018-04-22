package javaBase2;

public class Game {

	public static void main(String[] args) {
		Feeder feeder = new Feeder();
		feeder.name = "张三";
		feeder.age = 30;
		
		Horse h = new Horse();
		h.type = "汗血宝马";
		h.color = "棕色";
		h.age = 5;
		h.sex = '雄';
		feeder.eat(h);
		feeder.ride(h);
		feeder.introduce(h);
	}

}
