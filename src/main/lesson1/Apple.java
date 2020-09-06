package main.lesson1;

public class Apple implements Fruit {
    @Override
    public float getFruitWeight() {
        return 1.0f;
    }

    @Override
    public String toString() {
        return "main.lesson1.Apple{"+ getFruitWeight() + "}";
   }
}
