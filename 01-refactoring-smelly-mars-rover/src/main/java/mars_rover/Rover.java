package mars_rover;

import java.util.Objects;

public class Rover {

    private Direction direction;
    private Coordinates coordinates;

    public Rover(int x, int y, String direction) {
        this.setDirection(direction);
        setCoordinates(x, y);
    }

    public void setCoordinates(int x, int y) {
        this.coordinates = new Coordinates(x, y);
    }

    public void receive(String commandsSequence) {
        for (int i = 0; i < commandsSequence.length(); ++i) {
            String command = commandsSequence.substring(i, i + 1);

            if (command.equals("l")) {

                // Rotate Rover
                this.direction = direction.moveLeft();

            } else if (command.equals("r")) {

                // Rotate Rover
                if (isFacingNorth()) {
                    setDirection("E");
                } else if (isFacingSouth()) {
                    setDirection("W");
                } else if (isFacingWest()) {
                    setDirection("N");
                } else {
                    setDirection("S");
                }
            } else {

                // Displace Rover
                int displacement1 = -1;

                if (command.equals("f")) {
                    displacement1 = 1;
                }
                int displacement = displacement1;

                if (isFacingNorth()) {
                    this.coordinates = coordinates.moveAlongYAxis(displacement);
                } else if (isFacingSouth()) {
                    this.coordinates = coordinates.moveAlongYAxis(-displacement);
                } else if (isFacingWest()) {
                    this.coordinates = coordinates.moveAlongXAxis(-displacement);
                } else {
                    this.coordinates = coordinates.moveAlongXAxis(displacement);
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
        return direction == rover.direction && Objects.equals(coordinates, rover.coordinates);
    }

    @Override
    public int hashCode() {
        return Objects.hash(direction, coordinates);
    }

    @Override
    public String toString() {
        return "Rover{" +
            "direction=" + direction +
            ", coordinates=" + coordinates +
            '}';
    }

    private void setDirection(String direction) {
        this.direction = Direction.create(direction);
    }
}
