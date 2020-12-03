package lesson7;

public class Tests {
    @Test
    public void test1() {
        System.out.println("Test1: default priority = 5");
    }

    @Test(priority = 1)
    public void test2() {
        System.out.println("Test2: priority = 1");
    }

    @Test(priority = 7)
    public void test3() {
        System.out.println("Test3: priority = 7");
    }

    @BeforeSuite
    public void beforeAll() {
        System.out.println("Before all...");
    }

    @AfterSuite
    public void afterAll() {
        System.out.println("After all...");
    }

//    @BeforeSuite
//    public void beforeAll1() {
//        System.out.println("Before all _ 1...");
//    }

//    @AfterSuite
//    public void afterAll1() {
//        System.out.println("After all _ 1...");
//    }

}
