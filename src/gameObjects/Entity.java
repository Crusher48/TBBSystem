package gameObjects;

import gameObjects.Ability.ABILITY_TIMING;
import gameObjects.Ability.AbilityEffect;

import java.util.ArrayList;

/*
 * entity objects, with attributes and abilities
 * TODO: add ability-related methods
 */
public class Entity
{
	String name; //name of entity
	String team = "[N]"; //team of entity
	int maxHealth; //maximum health of entity
	int health; //current health of entity
	String[] traits; //list of traits
	boolean isActive = false; //whether or not the entity can take actions (starts as false)
	boolean isDead = false; //whether or not the entity is dead
	ArrayList<Ability> abilities = new ArrayList<Ability>();; //list of abilities possessed by this creature
	ArrayList<Entity> entityList; //list of entities that methods can reference (may not be needed)
	//constructs an entity 
	public Entity(ArrayList<Entity> refs, String mname, int mhealth)
	{
		entityList = refs;
		name = mname;
		maxHealth = mhealth;
		health = mhealth;
	}
	public void addAbility(ABILITY_TIMING t, AbilityEffect e) 
	{
		abilities.add(new Ability(t,e));
	}
	//adds an ability to the entity
	public void addAbility(Ability a) 
	{
		abilities.add(a);
	}
	//returns abilities list
	public ArrayList<Ability> getAbilities() 
	{
		return abilities;
	}
	//causes the entity to take damage
	public void takeDamage(int damageVal) 
	{
		health -= damageVal;
		checkDeath();
	}
	//checks if entity has died, and handles death if the entity is dead
	public void checkDeath() 
	{
		if (health <= 0) 
		{
			System.out.println(name + " has died");
			isDead = true;
			//dead entities are not removed immediately due to abilities relating to dead entities
		}
	}
	//signals the entity that the round started or ended
	public void startRound() 
	{
		isActive = true;
	}
	public void endRound() 
	{
		isActive = false;
	}
	
	//misc. getter methods
	public String getName() 
	{
		return name;
	}
	public String getTeam() 
	{
		return team;
	}
	public int getMaximumHealth() 
	{
		return maxHealth;
	}
	public int getHealth() 
	{
		return health;
	}
	public String[] getTraits() 
	{
		return traits;
	}
	public boolean canAct() 
	{
		return isActive;
	}
	public boolean isDead() 
	{
		return isDead;
	}
	//setter methods
	public void setName(String newName) 
	{
		name = newName;
	}
	public void setTeam(String newTeam) 
	{
		team = newTeam;
	}
	public void setMaximumHealth(int newMaxHealth) 
	{
		maxHealth = newMaxHealth;
	}
	public void setHealth(int newHealth) 
	{
		health = newHealth;
	}
	public void setActive(boolean canAct) 
	{
		isActive = canAct;
	}
}
