package mars_rover;


public enum Direction {
    N {
        @Override
        public Direction moveLeft() {
            return Direction.create(WEST);
        }

        @Override
        public Direction moveRight() {
            return Direction.create(EAST);
        }

        @Override
        public Coordinates move(Coordinates coordinates, int displacement) {
            return coordinates.moveAlongYAxis(displacement);
        }
    }, S {
        @Override
        public Direction moveLeft() {
            return Direction.create(EAST);
        }

        @Override
        public Direction moveRight() {
            return Direction.create(WEST);
        }

        @Override
        public Coordinates move(Coordinates coordinates, int displacement) {
            return coordinates.moveAlongYAxis(-displacement);
        }
    }, E {
        @Override
        public Direction moveLeft() {
            return Direction.create(NORTH);
        }

        @Override
        public Direction moveRight() {
            return Direction.create(SOUTH);
        }

        @Override
        public Coordinates move(Coordinates coordinates, int displacement) {
            return coordinates.moveAlongXAxis(displacement);
        }
    }, W {
        @Override
        public Direction moveLeft() {
            return Direction.create(SOUTH);
        }

        @Override
        public Direction moveRight() {
            return Direction.create(NORTH);
        }

        @Override
        public Coordinates move(Coordinates coordinates, int displacement) {
            return coordinates.moveAlongXAxis(-displacement);
        }
    };

    private static final String SOUTH = "S";
    private static final String NORTH = "N";
    private static final String EAST = "E";
    private static final String WEST = "W";

    public static Direction create(String direction) {
        if(NORTH.equals(direction)) return N;
        if(SOUTH.equals(direction)) return S;
        if(EAST.equals(direction)) return E;
        return W;
    }

    public abstract Direction moveLeft();
    public abstract Direction moveRight();
    public abstract Coordinates move(Coordinates coordinates, int displacement);
}
