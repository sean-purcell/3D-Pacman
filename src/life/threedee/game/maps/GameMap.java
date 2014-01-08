package life.threedee.game.maps;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import life.threedee.Point;
import life.threedee.ThreeDeeObject;
import life.threedee.game.Pellet;

public class GameMap {
	private List<ThreeDeeObject> objects;
	private Map<MapLocation, List<ThreeDeeObject>> map;
	
	private List<Pellet> pelletsList;
	
	public GameMap() {
		objects = MapBuilder.createMap();
		map = MapBuilder.deserializeMap(objects);
	}
	
	public List<ThreeDeeObject> getObjects() {
		return objects;
	}
	
	public List<ThreeDeeObject> getObjects(Point pos) {
		return map.get(new MapLocation(pos.x, pos.z));
	}
	
	public List<Pellet> pelletsList() {
		if(pelletsList == null) {
			pelletsList = new ArrayList<Pellet>();
			for(ThreeDeeObject o : objects) {
				if(o instanceof Pellet) {
					pelletsList.add((Pellet) o);
				}
			}
		}
		return pelletsList;
	}
}
