package com.data;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;
import org.hibernate.cfg.Configuration;
import org.hibernate.query.Query;
import org.hibernate.service.ServiceRegistry;

public class Program4Save {
    public static void main(String[] args) {
        Session session = null;
        try {
            // tạo ra 1 phiên làm việc
            session = buildSessionFactory().openSession();

            // cần transaction cho thêm, cập nhật, xoá
            session.beginTransaction();

            // tạo entity rồi save lại
            Account account = new Account();
            account.setUsername("t30");
            account.setPassword("100");

            session.save(account);

            session.getTransaction().commit();
            // sv chạy rồi chụp ảnh lên fb

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
