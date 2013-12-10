package life.engine.land;

public interface LandObject{
	public void step();

	public int getX();

	public int getY();

	public double getEnergy();

	public void setLand(Land l);

	public String getString();
}
