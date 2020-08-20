import java.util.ArrayList;

public class Box <T extends Fruit> {
    private final ArrayList<T> fruits = new ArrayList<>();

    public void add(T t){
        fruits.add(t);
    }

    public ArrayList<T> getFruits() {
        return fruits;
    }

    private void removeAllFruits(){
        this.fruits.clear();
    }

    @Override
    public String toString() {
        return "Box{" +
                "fruits=" + fruits +
                '}' + "weight: " + getWeight();
    }

    public float getWeight(){
        //если бы в одной коробке были бы разные фрукты, вычисление было бы суммированием в цикле, что логичнее
        if (fruits.size() == 0) {
            return 0;
        }

        return fruits.get(0).getFruitWeight() * fruits.size();
    }

    public <K extends Fruit> boolean compare (Box<K> newBox){
        return this.getWeight() == newBox.getWeight();
    }

    public void addAllFruits(Box<T> newBox){
        if (this == newBox) {
            return;
        }

        this.fruits.addAll(newBox.getFruits());
        newBox.removeAllFruits();
    }
}
