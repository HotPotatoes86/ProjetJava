package character;
public abstract class NPC {

	protected int HP = 100;
	protected String NPCname = "Villageois";
	protected int Attack = 0;

	public abstract void talk();
	public abstract void setHP(int hp);
}