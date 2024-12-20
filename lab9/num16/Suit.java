package lab9.num16;

enum Suit {
    SPADES("Пики"),
    HEARTS("Черви"),
    DIAMONDS("Бубны"),
    CLUBS("Трефы");

    private final String name;

    Suit(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }
}

