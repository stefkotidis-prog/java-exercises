public record Dish(String name, double price) {
    @Override
    public String toString() {
        return name + " ($" + price + ")";
    }
}