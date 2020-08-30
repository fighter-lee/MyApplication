package com.fighter.app_optimize;

import java.lang.annotation.Documented;

import androidx.annotation.IntDef;

/**
 * @author fighter_lee
 * @date 2020/8/28
 */
class Shape {

    public static final int AAA = 0;
    public static final int BBB = 1;
    public static final int CCC = 2;

    @Documented
    @IntDef(flag = true, value = {AAA, BBB, CCC})
    public @interface Model {

    }

    public static void setModel(@Model int model) {

    }

}
