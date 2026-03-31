package week04.gcrcodebase.annotation.advanced7;

import java.lang.reflect.Method;
import java.util.HashMap;
import java.util.Map;

class DataProcessor {

    @CacheResult
    public int expensiveCalculation(int n) {
        System.out.println("Computing for " + n + "...");
        int result = 0;
        for (int i = 0; i < n * 1000000; i++) {
            result += i;
        }
        return result;
    }

    @CacheResult
    public String fetchData(String key) {
        System.out.println("Fetching data for " + key + "...");
        try {
            Thread.sleep(1000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        return "Data_" + key;
    }
}

class CacheProxy {

    private Map<String, Object> cache = new HashMap<>();
    private Object target;

    public CacheProxy(Object target) {
        this.target = target;
    }

    public Object invoke(String methodName, Object... args) throws Exception {
        Method[] methods = target.getClass().getDeclaredMethods();
        Method targetMethod = null;

        for (Method m : methods) {
            if (m.getName().equals(methodName)) {
                targetMethod = m;
                break;
            }
        }

        if (targetMethod == null) {
            throw new Exception("Method not found");
        }

        if (targetMethod.isAnnotationPresent(CacheResult.class)) {
            String cacheKey = methodName + "_" + java.util.Arrays.toString(args);

            if (cache.containsKey(cacheKey)) {
                System.out.println("Returning from cache");
                return cache.get(cacheKey);
            }

            Object result = targetMethod.invoke(target, args);
            cache.put(cacheKey, result);
            return result;
        }

        return targetMethod.invoke(target, args);
    }
}

public class Advanced7_CacheResult {

    public static void main(String[] args) throws Exception {
        DataProcessor processor = new DataProcessor();
        CacheProxy proxy = new CacheProxy(processor);

        System.out.println("=== First call ===");
        proxy.invoke("expensiveCalculation", 5);

        System.out.println("\n=== Second call (should be cached) ===");
        proxy.invoke("expensiveCalculation", 5);

        System.out.println("\n=== Different parameter ===");
        proxy.invoke("expensiveCalculation", 10);

        System.out.println("\n=== String method ===");
        proxy.invoke("fetchData", "user123");

        System.out.println("\n=== Cached string call ===");
        proxy.invoke("fetchData", "user123");
    }
}
