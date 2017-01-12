package gameObjects;

import abilityAttributes.AbilityEffect;
import abilityAttributes.DamageEffect;

/*
 * Class containing data on abilities possessed by entities
 * TODO: Implement ability subclasses for effects
 * TODO: Improve referencing, potentially integrate into Entity class
 */
public class Ability
{
	//ability timing (when ability is activated)
	//ability conditions (conditions that can modify the ability or its effects)
	//ability effect (what effect the ability has when activated)
	public enum ABILITY_TIMING {ACTION,REACTION,OTHER}
	public String abilityName;
	public ABILITY_TIMING timing;
	public AbilityEffect effect;
	//test method
	public Ability() 
	{
		abilityName = "Generic Ability";
		timing = ABILITY_TIMING.ACTION;
		effect = new DamageEffect(5);
	}
	//creates a custom ability
	public Ability(ABILITY_TIMING t, AbilityEffect e) 
	{
		timing = t;
		effect = e;
	}
	public void activateAbility(Entity target) 
	{
		effect.activateEffect(target);
	}
	/* Moved to separate classes
	//class for an ability's effect
	public class AbilityEffect 
	{
		public void activateEffect(Entity target)
		{
			//trigger target's reactions?
			//extended by subclasses
		}
	}
	//damage effect, damages an entity (can potentially be inverted for healing effects)
	public class DamageEffect extends AbilityEffect 
	{
		int damage;
		public DamageEffect(int damageVal) 
		{
			damage = damageVal;
		}
		public void activateEffect(Entity target) 
		{
			target.takeDamage(damage);
		}
	}
	//class for a condition that can be used in an ability
	public class AbilityCondition
	{
		
	}
	//class to designate what an ability targets
	public class AbilityTarget 
	{
		
	}
	//class to designate when an ability activates
	public class AbilityTiming 
	{
		
	}
	*/
}
