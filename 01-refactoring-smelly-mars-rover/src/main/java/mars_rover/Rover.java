package mars_rover;

public class Rover {

    public static final String NORTH = "N";
    public static final String SOUTH = "S";
    public static final String EAST = "E";
    public static final String WEST = "W";
    public static final String FORWARD = "f";
    public static final String LEFT = "l";
    public static final String RIGHT = "r";
    private String direction;
    private int y;
    private int x;

    public Rover(int x, int y, String direction) {
        this.direction = direction;
        this.y = y;
        this.x = x;
    }

    public void receive(String commandsSequence) {
        for (int i = 0; i < commandsSequence.length(); ++i) {
            String command = commandsSequence.substring(i, i + 1);

            if (command.equals(LEFT)) {

                // Rotate Rover
                if (direction.equals(NORTH)) {
                    direction = WEST;
                } else if (direction.equals(SOUTH)) {
                    direction = EAST;
                } else if (direction.equals(WEST)) {
                    direction = SOUTH;
                } else {
                    direction = NORTH;
                }
            } else if (command.equals(RIGHT)) {

                // Rotate Rover
                if (direction.equals(NORTH)) {
                    direction = EAST;
                } else if (direction.equals(SOUTH)) {
                    direction = WEST;
                } else if (direction.equals(WEST)) {
                    direction = NORTH;
                } else {
                    direction = SOUTH;
                }
            } else {

                // Displace Rover
                int displacement1 = -1;

                if (command.equals(FORWARD)) {
                    displacement1 = 1;
                }
                int displacement = displacement1;

                if (direction.equals(NORTH)) {
                    y += displacement;
                } else if (direction.equals(SOUTH)) {
                    y -= displacement;
                } else if (direction.equals(WEST)) {
                    x -= displacement;
                } else {
                    x += displacement;
                }
            }
        }
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Rover rover = (Rover) o;

        if (y != rover.y) return false;
        if (x != rover.x) return false;
        return direction != null ? direction.equals(rover.direction) : rover.direction == null;

    }

    @Override
    public int hashCode() {
        int result = direction != null ? direction.hashCode() : 0;
        result = 31 * result + y;
        result = 31 * result + x;
        return result;
    }

    @Override
    public String toString() {
        return "Rover{" +
            "direction='" + direction + '\'' +
            ", y=" + y +
            ", x=" + x +
            '}';
    }
}
