package mars_rover;


public enum Direction {
    N {
        @Override
        public Direction moveLeft() {
            return Direction.create("W");
        }

        @Override
        public Direction moveRight() {
            return Direction.create("E");
        }
    }, S {
        @Override
        public Direction moveLeft() {
            return Direction.create("E");
        }

        @Override
        public Direction moveRight() {
            return Direction.create("W");
        }
    }, E {
        @Override
        public Direction moveLeft() {
            return Direction.create("N");
        }

        @Override
        public Direction moveRight() {
            return Direction.create("S");
        }
    }, W {
        @Override
        public Direction moveLeft() {
            return Direction.create("S");
        }

        @Override
        public Direction moveRight() {
            return Direction.create("N");
        }
    };

    public static Direction create(String direction) {
        if("N".equals(direction)) return N;
        if("S".equals(direction)) return S;
        if("E".equals(direction)) return E;
        return W;
    }

    public abstract Direction moveLeft();
    public abstract Direction moveRight();
}
