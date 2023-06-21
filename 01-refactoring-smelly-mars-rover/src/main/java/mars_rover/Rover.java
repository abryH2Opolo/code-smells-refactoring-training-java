package mars_rover;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

public class Rover {

    private static final int DEFAULT_DISPLACEMENT = 1;
    private static final int DISPLACEMENT_FORWARD = DEFAULT_DISPLACEMENT;
    private static final int DISPLACEMENT_BACKWARDS = -DEFAULT_DISPLACEMENT;
    private Direction direction;
    private Coordinates coordinates;

    public Rover(int x, int y, String direction) {
        this.direction = Direction.create(direction);
        setCoordinates(x, y);
    }

    public void setCoordinates(int x, int y) {
        this.coordinates = new Coordinates(x, y);
    }

    public void receive(String commandsSequence) {
        execute(extractCommands(commandsSequence));
    }

    private void execute(List<String> commands) {
        commands.forEach(this::execute);
    }

    private static List<String> extractCommands(String commandsSequence) {
        List<String> commands = new ArrayList<>();
        for (int i = 0; i < commandsSequence.length(); ++i) {
            String command = commandsSequence.substring(i, i + 1);
            commands.add(command);
        }
        return commands;
    }

    private void execute(String command) {
        if (command.equals("l")) {
            this.direction = direction.moveLeft();
        } else if (command.equals("r")) {
            this.direction = direction.moveRight();
        } else if (command.equals("f")) {
            this.coordinates = direction.move(coordinates, DISPLACEMENT_FORWARD);
        } else {
            this.coordinates = direction.move(coordinates, DISPLACEMENT_BACKWARDS);
        }
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
