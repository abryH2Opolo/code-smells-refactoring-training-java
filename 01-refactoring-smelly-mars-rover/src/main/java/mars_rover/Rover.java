package mars_rover;

import java.util.Objects;

public class Rover {

    public static final String NORTH = "N";
    public static final String SOUTH = "S";
    public static final String EAST = "E";
    public static final String WEST = "W";
    public static final String FORWARD = "f";
    public static final String LEFT = "l";
    public static final String RIGHT = "r";
    private Direction direction;
    private int y;
    private int x;

    public Rover(int x, int y, String direction) {
        this.setDirection(direction);
        setCoordinates(x, y);
    }

    public void setCoordinates(int x, int y){
        this.x = x;
        this.y = y;
    }

    public void receive(String commandsSequence) {
        for (int i = 0; i < commandsSequence.length(); ++i) {
            String command = commandsSequence.substring(i, i + 1);

            if (command.equals(LEFT)) {

                // Rotate Rover
                if (isFacingNorth()) {
                    setDirection(WEST);
                } else if (isFacingSouth()) {
                    setDirection(EAST);
                } else if (isFacingWest()) {
                    setDirection(SOUTH);
                } else {
                    setDirection(NORTH);
                }
            } else if (command.equals(RIGHT)) {

                // Rotate Rover
                if (isFacingNorth()) {
                    setDirection(EAST);
                } else if (isFacingSouth()) {
                    setDirection(WEST);
                } else if (isFacingWest()) {
                    setDirection(NORTH);
                } else {
                    setDirection(SOUTH);
                }
            } else {

                // Displace Rover
                int displacement1 = -1;

                if (command.equals(FORWARD)) {
                    displacement1 = 1;
                }
                int displacement = displacement1;

                if (isFacingNorth()) {
                    setCoordinates(x,y + displacement);
                } else if (isFacingSouth()) {
                    setCoordinates(x, y - displacement);
                } else if (isFacingWest()) {
                    setCoordinates(x - displacement, y);
                } else {
                    setCoordinates(x + displacement, y);
                }
            }
        }
    }

    private boolean isFacingWest() {
        return direction.equals(Direction.W);
    }

    private boolean isFacingSouth() {
        return direction.equals(Direction.S);
    }

    private boolean isFacingNorth() {
        return direction.equals(Direction.N);
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Rover)) return false;
        Rover rover = (Rover) o;
        return y == rover.y && x == rover.x && direction == rover.direction;
    }

    @Override
    public int hashCode() {
        return Objects.hash(direction, y, x);
    }

    @Override
    public String toString() {
        return "Rover{" +
            "directionType=" + direction +
            ", y=" + y +
            ", x=" + x +
            '}';
    }

    private void setDirection(String direction) {
        this.direction = Direction.create(direction);
    }
}
