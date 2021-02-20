package org.young.chap4.thread_local;

import lombok.*;

/**
 * @author:ChuanShanJun
 * @date:2021/2/20
 * @description:
 */
public class Competition {

    public static ThreadLocal<Material> material = ThreadLocal.withInitial(() -> new Material("default code", "default config"));

    @Getter
    @Setter
    @AllArgsConstructor
    @NoArgsConstructor
    public static class Material {
        private String code;
        private String config;
    }
}
