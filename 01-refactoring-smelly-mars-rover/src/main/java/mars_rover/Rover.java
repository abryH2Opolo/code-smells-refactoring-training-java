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
    private String direction;
    private Direction directionType;
    private int y;
    private int x;

    public Rover(int x, int y, String direction) {
        this.setDirection(direction);
        this.y = y;
        this.x = x;
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
                } else if (getDirection().equals(WEST)) {
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
                } else if (getDirection().equals(WEST)) {
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
                    y += displacement;
                } else if (isFacingSouth()) {
                    y -= displacement;
                } else if (getDirection().equals(WEST)) {
                    x -= displacement;
                } else {
                    x += displacement;
                }
            }
        }
    }

    private boolean isFacingSouth() {
        return directionType.equals(Direction.S);
    }

    private boolean isFacingNorth() {
        return directionType.equals(Direction.N);
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Rover)) return false;
        Rover rover = (Rover) o;
        return y == rover.y && x == rover.x && directionType == rover.directionType;
    }

    @Override
    public int hashCode() {
        return Objects.hash(directionType, y, x);
    }

    @Override
    public String toString() {
        return "Rover{" +
            "directionType=" + directionType +
            ", y=" + y +
            ", x=" + x +
            '}';
    }

    private String getDirection() {
        return direction;
    }

    private void setDirection(String direction) {
        this.direction = direction;
        this.directionType = Direction.create(direction);
    }
}
