public record Drink(String name, boolean iced) {
    @Override
    public String toString() {
        return (iced ? "Iced " : "Hot ") + name;
    }
}