package week04.gcrcodebase.reflection;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;


interface Task {
    void performTask();
}

class TaskImpl implements Task {

    @Override
    public void performTask() {
        try {
            Thread.sleep(500); // Simulate work
            System.out.println("Task completed");
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}

class TimingHandler implements InvocationHandler {

    private final Object target;

    public TimingHandler(Object target) {
        this.target = target;
    }

    @Override
    public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {

        long start = System.nanoTime();

        Object result = method.invoke(target, args);

        long end = System.nanoTime();

        System.out.println("Method: " + method.getName() +
                " executed in " + (end - start) + " ns");

        return result;
    }
}

class TimingDemo {

    public static void main(String[] args) {

        Task original = new TaskImpl();

        Task proxy = (Task) Proxy.newProxyInstance(
                Task.class.getClassLoader(),
                new Class[]{Task.class},
                new TimingHandler(original)
        );

        proxy.performTask();
    }
}

