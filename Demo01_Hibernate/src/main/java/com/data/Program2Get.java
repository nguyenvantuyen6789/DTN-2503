package com.data;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;
import org.hibernate.cfg.Configuration;
import org.hibernate.query.Query;
import org.hibernate.service.ServiceRegistry;

import java.util.List;

public class Program2Get {
    public static void main(String[] args) {
        Session session = null;
        try {
            // tạo ra 1 phiên làm việc
            session = buildSessionFactory().openSession();

            // tạo câu truy vấn
            Query<Account> query = session.createQuery("FROM Account WHERE id > 1");

            // thực thi câu query để lấy ra dữ liệu
            List<Account> accounts = query.getResultList();
            System.out.println("Size:");
            System.out.println(accounts.size());

            accounts.forEach(account -> {
                System.out.println("Id: " + account.getId());
                System.out.println("Username: " + account.getUsername());
                System.out.println("Password: " + account.getPassword());
            });
            // các bạn in ra rồi chụp lên fb nhé

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
