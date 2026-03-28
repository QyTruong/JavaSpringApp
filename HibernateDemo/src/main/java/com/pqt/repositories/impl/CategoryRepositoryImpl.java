/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.pqt.repositories.impl;

import com.pqt.hibernatedemo.HibernateUtils;
import com.pqt.pojo.Category;
import org.hibernate.query.Query;
import java.util.List;
import org.hibernate.Session;

/**
 *
 * @author PHAM QUY TRUONG
 */
public class CategoryRepositoryImpl {
    public List<Category> getCates(){
        try (Session session = HibernateUtils.getFACTORY().openSession()){
            Query query = session.createQuery("FROM Category", Category.class);
            return query.getResultList();
        }
    }
}
