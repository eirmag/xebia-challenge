package fr.nunix.MowItNow.surface;

import fr.nunix.MowItNow.object.MovableObject;

public interface Surface {
	
	/**
	 * A movable object can notify the surface to let it know it moves on his ground.
	 * @param object
	 */
	void notify (MovableObject object);

	Boundary getBoundary();
	
}
