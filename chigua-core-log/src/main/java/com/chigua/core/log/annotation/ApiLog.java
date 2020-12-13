package com.chigua.core.log.annotation;

import java.lang.annotation.*;

/**
 * ProjectName: chigua-tool
 * ClassName: com.chigua.core.log.annotation.ApiLog
 *
 * @author Mr.zhou <ijiami.cn>
 * @description 日志记录
 * @copyright (C), 2020 ijiami <https://www.ijiami.cn>
 * @date 2020/12/08 - 15:25
 */
@Target(ElementType.METHOD)
@Retention(RetentionPolicy.RUNTIME)
@Documented
public @interface ApiLog {
    /**
     * 日志描述
     *
     * @return {String}
     */
    String value() default "日志记录";
}
