package heroes;

import java.util.Random;

public class Hero {
	
	String nickname;
	protected int level;
	public float hp;
	protected float mana;
	protected float armor;
	protected float damage;
	private Random random;
	private boolean death = false;
	
	public boolean isDeath() {
		return death;
	}

	public Hero(String nickname, int level, float hp,  float mana, float armor, float damage) {
		this.nickname = nickname;
		this.level = level;
		this.hp = hp;
		this.mana = mana;
		this.armor = armor;
		this.damage = damage;		
		random = new Random();
	}
	
//	Funkcia vypocita pravdepodonost miss hitu a nastavi damage podla armoru nepriatela na prislusnu hodnotu ktoru vrati
	public float armor(float damage) {
		float missChance = this.armor * 0.5f;
		float chance = random.nextFloat() * 100;
		float totalDamage;
		if(chance >= missChance) {
			totalDamage = damage - this.armor * 0.2f;
			if(totalDamage < 0) {
				return 0;		
			}
			return totalDamage;
		}
		else {
			totalDamage = 0;
			return totalDamage;
		}		
	}
	
// Postava zautoci na nepriatelsku postavu zakladnym utokom a ubere jej zivot
	public void attack(Hero enemy) {
		float basicDamage = enemy.armor(this.damage);
		enemy.setHp(enemy.hp - basicDamage);
		System.out.println("Zautocil si basic attackom a ubral si nepriatelovi " + basicDamage + "HP");
		deathControl(enemy);
	}	
	
//	Kontroluje ci nepriatel nezomrel a ci jeho zivot nie je mensi ako 0, ak ano, nastavi zivot na 0 a vypise win hlasku
	public void deathControl(Hero enemy) {
		if(enemy.hp <= 0) {
			enemy.setHp(0);
			System.out.println("Zabil si nepriatela, vyhral si!");
			death = true;
		}			
	}
	
	public float ability1() {
		return 0; 
	}
	
	public float ability2() {
		return 0;
	}
	
	public float ability3() {
		return 0;
	}

	public float getHp() {
		return hp;
	}

	public void setHp(float hp) {
		this.hp = hp;
	}

	public float getArmor() {
		return armor;
	}

	public void setArmor(float armor) {
		this.armor = armor;
	}

	public float getDamage() {
		return damage;
	}

	public void setDamage(float damage) {
		this.damage = damage;
	}

	public float getMana() {
		return mana;
	}

	public void setMana(float mana) {
		this.mana = mana;
	}

	public int getLevel() {
		return level;
	}

	public void setLevel(int level) {
		this.level = level;
	}
	
	
}
