package com.javaapi.test.spring.spring.pattern.template.util;


import org.springframework.util.Assert;

import java.lang.reflect.InvocationTargetException;
import java.util.*;

public class ThrowableAnalyzer {
    public static final ThrowableCauseExtractor DEFAULT_EXTRACTOR = new ThrowableCauseExtractor() {
        public Throwable extractCause(Throwable throwable) {
            return throwable.getCause();
        }
    };
    public static final ThrowableCauseExtractor INVOCATIONTARGET_EXTRACTOR = new ThrowableCauseExtractor() {
        public Throwable extractCause(Throwable throwable) {
            ThrowableAnalyzer.verifyThrowableHierarchy(throwable, InvocationTargetException.class);
            return ((InvocationTargetException) throwable).getTargetException();
        }
    };
    private static final Comparator<Class<? extends Throwable>> CLASS_HIERARCHY_COMPARATOR = new Comparator<Class<? extends Throwable>>() {
        public int compare(Class<? extends Throwable> class1, Class<? extends Throwable> class2) {
            if (class1.isAssignableFrom(class2)) {
                return 1;
            } else {
                return class2.isAssignableFrom(class1) ? -1 : class1.getName().compareTo(class2.getName());
            }
        }
    };
    private final Map<Class<? extends Throwable>, ThrowableCauseExtractor> extractorMap;

    public ThrowableAnalyzer() {
        this.extractorMap = new TreeMap(CLASS_HIERARCHY_COMPARATOR);
        this.initExtractorMap();
    }

    protected final void registerExtractor(Class<? extends Throwable> throwableType, ThrowableCauseExtractor extractor) {
        Assert.notNull(extractor, "Invalid extractor: null");
        this.extractorMap.put(throwableType, extractor);
    }

    protected void initExtractorMap() {
        this.registerExtractor(InvocationTargetException.class, INVOCATIONTARGET_EXTRACTOR);
        this.registerExtractor(Throwable.class, DEFAULT_EXTRACTOR);
    }

    final Class<? extends Throwable>[] getRegisteredTypes() {
        Set<Class<? extends Throwable>> typeList = this.extractorMap.keySet();
        return (Class[]) typeList.toArray(new Class[typeList.size()]);
    }

    public final Throwable[] determineCauseChain(Throwable throwable) {
        if (throwable == null) {
            throw new IllegalArgumentException("Invalid throwable: null");
        } else {
            List<Throwable> chain = new ArrayList();

            for (Throwable currentThrowable = throwable; currentThrowable != null; currentThrowable = this.extractCause(currentThrowable)) {
                chain.add(currentThrowable);
            }

            return (Throwable[]) chain.toArray(new Throwable[chain.size()]);
        }
    }

    private Throwable extractCause(Throwable throwable) {
        Iterator var2 = this.extractorMap.entrySet().iterator();

        Map.Entry entry;
        Class throwableType;
        do {
            if (!var2.hasNext()) {
                return null;
            }

            entry = (Map.Entry) var2.next();
            throwableType = (Class) entry.getKey();
        } while (!throwableType.isInstance(throwable));

        ThrowableCauseExtractor extractor = (ThrowableCauseExtractor) entry.getValue();
        return extractor.extractCause(throwable);
    }

    public final Throwable getFirstThrowableOfType(Class<? extends Throwable> throwableType, Throwable[] chain) {
        if (chain != null) {
            Throwable[] var3 = chain;
            int var4 = chain.length;

            for (int var5 = 0; var5 < var4; ++var5) {
                Throwable t = var3[var5];
                if (t != null && throwableType.isInstance(t)) {
                    return t;
                }
            }
        }

        return null;
    }

    public static void verifyThrowableHierarchy(Throwable throwable, Class<? extends Throwable> expectedBaseType) {
        if (expectedBaseType != null) {
            if (throwable == null) {
                throw new IllegalArgumentException("Invalid throwable: null");
            } else {
                Class<? extends Throwable> throwableType = throwable.getClass();
                if (!expectedBaseType.isAssignableFrom(throwableType)) {
                    throw new IllegalArgumentException("Invalid type: '" + throwableType.getName() + "'. Has to be a subclass of '" + expectedBaseType.getName() + "'");
                }
            }
        }
    }
}
