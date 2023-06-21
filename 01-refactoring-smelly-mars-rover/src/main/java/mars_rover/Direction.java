package mars_rover;


public enum Direction {
    N {
        @Override
        public Direction moveLeft() {
            return Direction.create("W");
        }
    }, S {
        @Override
        public Direction moveLeft() {
            return Direction.create("E");
        }
    }, E {
        @Override
        public Direction moveLeft() {
            return Direction.create("N");
        }
    }, W {
        @Override
        public Direction moveLeft() {
            return Direction.create("S");
        }
    };

    public static Direction create(String direction) {
        if("N".equals(direction)) return N;
        if("S".equals(direction)) return S;
        if("E".equals(direction)) return E;
        return W;
    }

    public abstract Direction moveLeft();
}
