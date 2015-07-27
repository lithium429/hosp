package com.xz.base.utils.bpm;


import org.apache.commons.lang3.reflect.FieldUtils;
import java.lang.reflect.Field;

/**
 * 实现对象的克隆功能
 */

public abstract class CloneUtils
{

    public static void copyFields(Object source, Object target, String... fieldNames)
    {
//        Assert.assertNotNull(source);
//        Assert.assertNotNull(target);
//        Assert.assertSame(source.getClass(), target.getClass());

        for (String fieldName : fieldNames)
        {
            try
            {
                Field field = FieldUtils.getField(source.getClass(), fieldName, true);
                field.setAccessible(true);
                field.set(target, field.get(source));
            }
            catch (Exception e)
            {
                //TODO 
            }
        }
    }
}
