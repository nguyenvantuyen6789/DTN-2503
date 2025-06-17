package com.data;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;
import org.hibernate.cfg.Configuration;
import org.hibernate.query.Query;
import org.hibernate.service.ServiceRegistry;

public class Program6Delete {
    public static void main(String[] args) {
        Session session = null;
        try {
            // tạo ra 1 phiên làm việc
            session = buildSessionFactory().openSession();

            // cần transaction cho thêm, cập nhật, xoá
            session.beginTransaction();

            Query<Account> query = session.createQuery("DELETE FROM Account WHERE id = 1");
            query.executeUpdate();

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
