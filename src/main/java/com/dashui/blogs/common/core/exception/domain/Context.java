package com.dashui.blogs.common.core.exception.domain;

import java.time.LocalDateTime;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

/**
 * @Author dashui
 * @user Administrator
 * @Date 2023/4/22 21:10
 * @PackageName: com.dashui.naruto.exception
 * @ClassName: Context
 * @Description: TODO
 * @Version 1.0
 */
public class Context implements AutoCloseable {

    private final Map<String, String> callStack = new ConcurrentHashMap<>();

    private static final ThreadLocal<Context> threadLocalContext = new ThreadLocal<>();

    private Context() {}

    /**
     * 获取当前线程的Context对象。
     * 如果当前线程没有绑定Context对象，则创建一个新的Context对象并绑定到当前线程。
     * @return 当前线程的Context对象
     */
    public static Context getCurrentContext() {
        Context context = threadLocalContext.get();
        if (context == null) {
            context = new Context();
            threadLocalContext.set(context);
        }
        return context;
    }

    public Map<String, String> getCallStack() {
        return callStack;
    }

    /**
     * 将当前方法名添加到调用链中。
     * @param methodName 方法名
     */
    public void addCallStack(String methodName) {
        String className = Thread.currentThread().getStackTrace()[2].getClassName();
        callStack.put(className + "." + methodName, LocalDateTime.now().toString());
    }

    /**
     * 将当前方法名添加到调用链中。
     * @param methodName 方法名
     */
    public void removeCallStack(String methodName) {
        String className = Thread.currentThread().getStackTrace()[2].getClassName();
        callStack.remove(className + "." + methodName, LocalDateTime.now().toString());
    }

    /**
     * 创建并返回当前Context对象的副本。
     * @return 对象副本
     */
    public Context copy() {
        Context context = new Context();
        context.callStack.putAll(callStack);
        return context;
    }

    /**
     * 释放资源，从当前线程中移除Context对象。
     * @throws Exception
     */
    @Override
    public void close(){
        threadLocalContext.remove();
    }
}
