/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 */

package com.pqt.hibernatedemo;

import com.pqt.pojo.Category;
import com.pqt.pojo.Product;
import com.pqt.repositories.impl.CategoryRepositoryImpl;
import com.pqt.repositories.impl.ProductRepositoryImpl;
import com.pqt.repositories.impl.StatsRepositoryImpl;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 *
 * @author PHAM QUY TRUONG
 */
public class HibernateDemo {

    public static void main(String[] args) {
        CategoryRepositoryImpl cateImpl = new CategoryRepositoryImpl();
        List<Category> cates = cateImpl.getCates();
        cates.forEach(c -> System.out.println(c.getName()));
        
        
        ProductRepositoryImpl productImpl = new ProductRepositoryImpl();
        Map<String, String> params = new HashMap<>();
        params.put("kw", "Iphone");
        params.put("fromPrice", "15000000");
        params.put("toPrice", "29000000");
        params.put("page", "1");
        
        List<Product> products = productImpl.getProducts(params);
        products.forEach(p -> System.out.printf("Name: %s - Price: %d\n", p.getName(), p.getPrice()));
        
        
        System.out.println("==============================");
        
        StatsRepositoryImpl s = new StatsRepositoryImpl();
        s.statsRevenueByProduct().forEach(o -> System.out.printf("%d - %s: %d\n", o[0], o[1], o[2]));
        
        
        s.statsRevenueByTime("QUARTER", 2020).forEach(o -> System.out.printf("Quy %d: %d\n", o[0], o[1]));
        
    }
}
