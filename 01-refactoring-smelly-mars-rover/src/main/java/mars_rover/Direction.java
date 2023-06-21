package mars_rover;


public enum Direction {
    N {
        @Override
        public Direction moveLeft() {
            return W;
        }

        @Override
        public Direction moveRight() {
            return E;
        }

        @Override
        public Coordinates move(Coordinates coordinates, int displacement) {
            return coordinates.moveAlongYAxis(displacement);
        }
    }, S {
        @Override
        public Direction moveLeft() {
            return E;
        }

        @Override
        public Direction moveRight() {
            return W;
        }

        @Override
        public Coordinates move(Coordinates coordinates, int displacement) {
            return coordinates.moveAlongYAxis(-displacement);
        }
    }, E {
        @Override
        public Direction moveLeft() {
            return N;
        }

        @Override
        public Direction moveRight() {
            return S;
        }

        @Override
        public Coordinates move(Coordinates coordinates, int displacement) {
            return coordinates.moveAlongXAxis(displacement);
        }
    }, W {
        @Override
        public Direction moveLeft() {
            return S;
        }

        @Override
        public Direction moveRight() {
            return N;
        }

        @Override
        public Coordinates move(Coordinates coordinates, int displacement) {
            return coordinates.moveAlongXAxis(-displacement);
        }
    };

    private static final String SOUTH_ENCODING = "S";
    private static final String NORTH_ENCODING = "N";
    private static final String EAST_ENCODING = "E";

    public static Direction create(String direction) {
        if(NORTH_ENCODING.equals(direction)) return N;
        if(SOUTH_ENCODING.equals(direction)) return S;
        if(EAST_ENCODING.equals(direction)) return E;
        return W;
    }

    public abstract Direction moveLeft();
    public abstract Direction moveRight();
    public abstract Coordinates move(Coordinates coordinates, int displacement);
}
