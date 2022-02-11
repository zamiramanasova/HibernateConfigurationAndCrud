package util;

import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.criterion.Restrictions;
import org.hibernate.query.Query;
import peaksoft.entity.Employee;

import java.util.Arrays;
import java.util.List;

public class App {

    public static void main(String[] args) {

        HibernateUtil.getSession();

        Employee employee = new Employee("Аза","Бариков","бармен", 26);

        //create(employee);

        //Чтение всех работников
         for (Employee e: read()) {
           System.out.println(e);
         }
         read();

        // 2  Аты Аза болгон жумушчулардын жашын 18ге озгортунуз.
        //updateEmployee(2,"Аза", 18);

        //удаление  Аза по id
        //deleteByName(2);

        // Вывод работника Аза и работников страше 20 лет
        update(20,"Аза");

        //Удалить все
        //deleteAll();



    }

    public static int create(Employee employee) {
        Session session = HibernateUtil.getSession().openSession();
        session.beginTransaction();
        session.save(employee);
        session.getTransaction().commit();
        session.close();
        System.out.println("Успешное создание================================= " + employee);
        return employee.getId();

    }
    ////Чтение всех работников
    public static List<Employee> read() {
        Session session = HibernateUtil.getSession().openSession();
        session.beginTransaction();
        List<Employee> employees = session.createQuery("FROM Employee ").getResultList();
        session.getTransaction().commit();
        session.close();
        System.out.println("++++++++++++Finded " + employees.size() + " employees ");
        return employees;
    }
    // Вывод работника Аза и работников страше 20 лет
    public static void update(int age,String name) {
        String sql = "FROM Employee WHERE age >:age and name =:name";
        Session session = HibernateUtil.getSession().openSession();
        session.beginTransaction();
        Query<Employee> query = session.createQuery(sql)
                .setParameter("age", age)
                       .setParameter("name", name);
        List <Employee> employee = query.getResultList();
        for(Employee e: employee){
            System.out.println(e.toString());
        }
        session.getTransaction().commit();
        session.close();

    }
        ////удаление  Аза по id
    public static void deleteByName(int id) {
        Session session = HibernateUtil.getSession().openSession();
        session.beginTransaction();
        Employee employee = (Employee) session.get(Employee.class, id);
        session.delete(employee);
        session.getTransaction().commit();
        session.close();
        System.out.println("Работник успешно удален");

    }

        // 2  Аты Аза болгон жумушчулардын жашын 18ге озгортунуз.
    public static void updateEmployee(int id,String name, int age) {
        Session session = HibernateUtil.getSession().openSession();
        session.beginTransaction();
        Employee employee = (Employee) session.get(Employee.class, id);
        employee.setName("Аза");
        employee.setAge(18);
        session.getTransaction().commit();
        session.close();
        System.out.println("Возраст работника изменен: " +  age + name);

    }
        //УДАЛИТЬ ВСЕ
    public static void deleteAll() {
        Session session=HibernateUtil.getSession().openSession();
        session.beginTransaction();
        Query query=session.createQuery("DELETE FROM Employee");
        query.executeUpdate();
        session.getTransaction().commit();
        session.close();
        System.out.println("SuccessfullydeletedalldatasinEmployee");

    }

}

