package mars_rover;

import org.junit.jupiter.api.Test;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.core.Is.is;

class DirectionTest {

    @Test
    void creatingDirectionsGivenTheirEncodings() {
        assertThat(Direction.create("N"), is(Direction.N));
        assertThat(Direction.create("S"), is(Direction.S));
        assertThat(Direction.create("E"), is(Direction.E));
        assertThat(Direction.create("W"), is(Direction.W));
    }
}