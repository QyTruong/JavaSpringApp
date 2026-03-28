/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.pqt.repositories.impl;

import com.pqt.hibernatedemo.HibernateUtils;
import com.pqt.pojo.CartItem;
import com.pqt.pojo.OrderDetail;
import com.pqt.pojo.SaleOrder;
import java.util.Date;
import java.util.List;
import org.hibernate.Session;

/**
 *
 * @author PHAM QUY TRUONG
 */
public class ReceiptRepositoryImpl {
    public void addReceipt(List<CartItem> carts){
        try (Session session = HibernateUtils.getFACTORY().openSession()){
            SaleOrder s = new SaleOrder();
            s.setCreatedDate(new Date());
            s.setUserId(new UserRepositoryImpl().getUserByUsername("Truong ne"));
            
            session.persist(s);
            
            for (var c : carts){
                OrderDetail d = new OrderDetail();
                d.setQuantity(c.getQuantity());
                d.setUnitPrice(c.getPrice());
                d.setProductId(new ProductRepositoryImpl().getProductById(c.getId()));
                d.setOrderId(s);
                
                session.persist(d);
            }
        }
    }
}
