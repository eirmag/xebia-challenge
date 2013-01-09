package fr.nunix.MowItNow;

/**
 * Another possibility was to manage orientation given the degree angle, ranging
 * from 0 to 360
 * 
 * @author gabriel
 * 
 */
public enum Orientation {

	NORTH {
		@Override
		public Orientation left() {
			return WEST;
		}

		@Override
		public Orientation right() {
			return EAST;
		}
	},
	EAST {
		@Override
		public Orientation left() {
			return NORTH;
		}

		@Override
		public Orientation right() {
			return SOUTH;
		}
	},
	SOUTH {
		@Override
		public Orientation left() {
			return EAST;
		}

		@Override
		public Orientation right() {
			return WEST;
		}
	},
	WEST {
		@Override
		public Orientation left() {
			return SOUTH;
		}

		@Override
		public Orientation right() {
			return NORTH;
		}
	},
	;

	abstract public Orientation left();

	abstract public Orientation right();

}
