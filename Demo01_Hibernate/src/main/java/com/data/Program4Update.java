package com.data;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;
import org.hibernate.cfg.Configuration;
import org.hibernate.query.Query;
import org.hibernate.service.ServiceRegistry;

public class Program4Update {
    public static void main(String[] args) {
        Session session = null;
        try {
            // tạo ra 1 phiên làm việc
            session = buildSessionFactory().openSession();

            // cần transaction cho thêm, cập nhật, xoá
            session.beginTransaction();

            // b1: lấy 1 account trong db ra
            // b2: set giá trị lại
            // b3: gọi hàm save để cập nhật
            Query<Account> query = session.createQuery("FROM Account WHERE id = 1");
            Account account = query.getSingleResultOrNull();

            if (account != null) {
                account.setUsername("Pham Long");
                account.setPassword("999");

                session.save(account);
            }


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
