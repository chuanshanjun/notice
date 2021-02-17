package org.young.chap4.copy_on_write;

import java.util.List;
import java.util.concurrent.CopyOnWriteArrayList;

/**
 * @author:ChuanShanJun
 * @date:2021/2/17
 * @description:
 */
public class GoodsListService {

    private static final List<String> goods = new CopyOnWriteArrayList<>();

    /** 获取商品 */
    public String getGood(int index) {
        return goods.get(index);
    }

    /** 增加商品 */
    public void addGood(String good) {
        goods.add(good);
    }

    /** 批量增加商品-尽量使用批量新增商品，减少写的次数 */
    public void batchAdd(List<String> goods) {
        goods.addAll(goods);
    }
}
