package util;

import org.hibernate.Session;
import peaksoft.entity.Employee;

public class UseEmployee {

    public static int create(Employee employee) {
       Session session = HibernateUtil.getSession().openSession();
       session.beginTransaction();
       session.save(employee);
       session.getTransaction().commit();
       session.close();
        System.out.println("Успешное создание================================= "+ employee);
        return employee.getId();

    }


}
