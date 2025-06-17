package com.data;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;
import org.hibernate.cfg.Configuration;
import org.hibernate.query.Query;
import org.hibernate.service.ServiceRegistry;

import java.util.List;

public class Program3GetById {
    public static void main(String[] args) {
        Session session = null;
        try {
            // tạo ra 1 phiên làm việc
            session = buildSessionFactory().openSession();

            // tạo câu truy vấn
            Query<Account> query = session.createQuery("FROM Account WHERE id = 1");

            // thực thi câu query để lấy ra dữ liệu
            Account account = query.getSingleResultOrNull();

            System.out.println(account);
            // sv chụp ảnh màn hình lên fb

        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }

    // hàm gọi đến cấu file cấu hình hibernate.cfg.xml - > dbname, tài khoản root
    private static SessionFactory buildSessionFactory() {
        // load db info
        Configuration configuration = new Configuration();
        configuration.configure("hibernate.cfg.xml");

        // add entity
        configuration.addAnnotatedClass(Account.class);

        ServiceRegistry serviceRegistry = new StandardServiceRegistryBuilder()
                .applySettings(configuration.getProperties()).build();

        return configuration.buildSessionFactory(serviceRegistry);
    }
}
