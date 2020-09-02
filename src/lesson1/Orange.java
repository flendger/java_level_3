package lesson1;

public class Orange implements Fruit {
    @Override
    public float getFruitWeight() {
        return 1.5f;
    }

    @Override
    public String toString() {
        return "lesson1.Orange{"+ getFruitWeight() + "}";
    }
}
