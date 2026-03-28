/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.pqt.hibernatedemo;

import com.pqt.pojo.Category;
import com.pqt.pojo.Comment;
import com.pqt.pojo.OrderDetail;
import com.pqt.pojo.ProdTag;
import com.pqt.pojo.Product;
import com.pqt.pojo.SaleOrder;
import com.pqt.pojo.Tag;
import com.pqt.pojo.User;
import java.util.Properties;
import org.hibernate.SessionFactory;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;
import org.hibernate.cfg.Configuration;
import org.hibernate.cfg.Environment;
import org.hibernate.service.ServiceRegistry;

/**
 *
 * @author PHAM QUY TRUONG
 */
public class HibernateUtils {
    private static final SessionFactory FACTORY;

    
    static {
        Configuration conf = new Configuration();
        Properties props = new Properties();
        props.put(Environment.DIALECT, "org.hibernate.dialect.MySQLDialect");
        props.put(Environment.JAKARTA_JDBC_DRIVER, "com.mysql.cj.jdbc.Driver");
        props.put(Environment.JAKARTA_JDBC_URL, "jdbc:mysql://localhost/saledb");
        props.put(Environment.JAKARTA_JDBC_PASSWORD, "root");
        props.put(Environment.JAKARTA_JDBC_USER, "root");
        props.put(Environment.SHOW_SQL, "true");
        
        conf.setProperties(props);
        
        conf.addAnnotatedClass(Category.class);
        conf.addAnnotatedClass(Product.class);
        conf.addAnnotatedClass(Comment.class);
        conf.addAnnotatedClass(User.class);
        conf.addAnnotatedClass(SaleOrder.class);
        conf.addAnnotatedClass(OrderDetail.class);
        conf.addAnnotatedClass(Tag.class);
        conf.addAnnotatedClass(ProdTag.class);
        
        ServiceRegistry serviceRegistry = new StandardServiceRegistryBuilder().applySettings(conf.getProperties()).build();
        
        FACTORY = conf.buildSessionFactory(serviceRegistry);
    }
    
    public static SessionFactory getFACTORY() {
        return FACTORY;
    }
}
