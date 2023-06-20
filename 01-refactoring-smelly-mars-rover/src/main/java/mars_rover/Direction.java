package mars_rover;


public enum Direction {
    N, S, E, W;

    public static Direction create(String direction) {
        if("N".equals(direction)) return N;
        if("S".equals(direction)) return S;
        if("E".equals(direction)) return E;
        return W;
    }
}
