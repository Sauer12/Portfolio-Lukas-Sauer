package heroes;

public class Hunter extends Hero{
	
	public Hunter(String nickname, int level, float hp, float mana, float armor, float damage) {
		super(nickname, level, hp, mana, armor, damage);
	}

	@Override
	public float ability1() {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public float ability2() {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public float ability3() {
		// TODO Auto-generated method stub
		return 0;
	}
	
	@Override
	public String toString() {
		return nickname + " -> Hunter(level: " + this.level + ")\nHP: " + this.hp + "\nMana: " + this.mana  + "\nArmor: " + this.armor + "\nDamage: " + this.damage + "\n";
	}

}
