package com.salientCrgt.hudStack.utils;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

public class AppUtils {

    public static <T> List<T> castList(final Class<? extends T> clazz,
            final Collection<?> c) {
        final List<T> r = new ArrayList<T>(c.size());
        for (final Object o : c) {
            r.add(clazz.cast(o));
        }
        return r;
    }

    public static boolean isEmptyString(final String str) {
        return ((str == null) || str.trim().equals(""));
    }
}
