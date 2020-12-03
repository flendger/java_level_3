package lesson7;

/*
1. Создать класс, который может выполнять «тесты».
В качестве тестов выступают классы с наборами методов, снабженных аннотациями @Test. Класс,
запускающий тесты, должен иметь статический метод start(Class testClass), которому в качестве
аргумента передается объект типа Class. Из «класса-теста» вначале должен быть запущен метод с
аннотацией @BeforeSuite, если он присутствует. Далее запускаются методы с аннотациями @Test, а
по завершении всех тестов – метод с аннотацией @AfterSuite .
К каждому тесту необходимо добавить приоритеты (i nt- числа от 1 до 10), в соответствии с которыми
будет выбираться порядок их выполнения. Если приоритет одинаковый, то порядок не имеет
значения. Методы с аннотациями @BeforeSuite и @AfterSuite должны присутствовать в
единственном экземпляре. Если это не так – необходимо бросить RuntimeException при запуске
«тестирования».
 */

import java.lang.annotation.Annotation;
import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

public class TestExecutor {
    public static void start(Class testClass) {
        List<Method> listTests = new ArrayList<>();
        Method mBefore = null;
        Method mAfter = null;

        try {
            Object o = testClass.getDeclaredConstructor().newInstance();

            for (Method method: testClass.getMethods()
                 ) {
                Annotation annoTest = method.getAnnotation(Test.class);
                if (annoTest != null) {
                    listTests.add(method);
                    continue;
                }

                Annotation annoBeforeSuite = method.getAnnotation(BeforeSuite.class);
                if (annoBeforeSuite != null) {
                    if (mBefore != null) {
                        throw new RuntimeException("@BeforeSuite is more than in one place...");
                    }

                    mBefore = method;
                    continue;
                }

                Annotation annoAfterSuite = method.getAnnotation(AfterSuite.class);
                if (annoAfterSuite != null) {
                    if (mAfter != null) {
                        throw new RuntimeException("@AfterSuite is more than in one place...");
                    }
                    mAfter = method;
                }
            }

            listTests.sort(new Comparator<>() {
                @Override
                public int compare(Method o1, Method o2) {
                    return o2.getAnnotation(Test.class).priority() - o1.getAnnotation(Test.class).priority();
                }
            });

            if (mBefore != null) {
                System.out.println("@BeforeSuite");
                mBefore.invoke(o);
            }

            for (Method m: listTests
                 ) {
                System.out.println("@Test");
                m.invoke(o);
            }

            if (mAfter != null) {
                System.out.println("@AfterSuite");
                mAfter.invoke(o);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
