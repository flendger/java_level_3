import java.util.ArrayList;

public class DemoLesson1 {
    public static void main(String[] args) {
        doDemo1();
        doDemo2();
    }

    public static void doDemo2(){
        Box<Apple> appleBox1 = new Box();
        appleBox1.add(new Apple());
        appleBox1.add(new Apple());
        appleBox1.add(new Apple());
        System.out.println(appleBox1);

        Box<Apple> appleBox2 = new Box();
        appleBox2.add(new Apple());
        appleBox2.add(new Apple());
        System.out.println(appleBox2);

        Box<Orange> orangeBox1 = new Box();
        orangeBox1.add(new Orange());
        orangeBox1.add(new Orange());
        System.out.println(orangeBox1);

        System.out.println(appleBox1.compare(orangeBox1));

        appleBox1.addAllFruits(appleBox2);
        System.out.println(appleBox1);
        System.out.println(appleBox2);
    }

    public static void doDemo1(){
        String[] arrString = {"first", "second", "third"};
        ArrayModifier.printArray(arrString);
        ArrayModifier.changeValues(arrString, 2,1);
        ArrayModifier.printArray(arrString);

        Integer[] arrInt = {1, 2, 3};
        ArrayModifier.printArray(arrInt);
        ArrayModifier.changeValues(arrInt, 0,2);
        ArrayModifier.printArray(arrInt);

        ArrayList<String> stringList = ArrayModifier.toArrayList(arrString);
        System.out.println(stringList);

        ArrayList<Integer> intList = ArrayModifier.toArrayList(arrInt);
        System.out.println(intList);
    }
}
