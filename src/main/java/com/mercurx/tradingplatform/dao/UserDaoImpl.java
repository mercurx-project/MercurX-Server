package com.mercurx.tradingplatform.dao;

import com.mercurx.tradingplatform.model.User;
import jakarta.persistence.TypedQuery;
import jakarta.persistence.criteria.CriteriaBuilder;
import jakarta.persistence.criteria.CriteriaQuery;
import jakarta.persistence.criteria.Root;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.query.Query;
import org.springframework.stereotype.Component;

import java.util.List;
@Component
public class UserDaoImpl {
    private SessionFactory sessionFactory;

    public void setSessionFactory(SessionFactory sessionFactory) {
        this.sessionFactory = sessionFactory;
    }

    public int addUser(final User user) {
        Session session = null;
        Transaction transaction = null;
        int status = 0;
        try {
            session = this.sessionFactory.openSession();
            transaction = session.beginTransaction();
            session.save(user);
            transaction.commit();
            status = 1;
        } catch (Exception e) {
            //
        } finally {
            if (session != null) {
                session.close();
            }
        }
        return status;
    }

    public List<User> getUsersList() {
        Session session = null;
        Transaction transaction = null;
        List userList = null;
        try {
            session = this.sessionFactory.openSession();
            CriteriaBuilder cb = session.getCriteriaBuilder();
            CriteriaQuery<Module> cq = cb.createQuery(Module.class);
            Root<Module> rootEntry = cq.from(Module.class);
            CriteriaQuery<Module> all = cq.select(rootEntry);
            TypedQuery<Module> query = session.createQuery(all);
            userList = query.getResultList();
        } catch (Exception e) {
            //
        } finally {
            if (session != null) {
                session.close();
            }
        }
        return userList;
    }


    public User updateUser(final User user) {
        Session session = null;
        Transaction transaction = null;
        int status = 0;
        try {
            session = this.sessionFactory.openSession();
            transaction = session.beginTransaction();
            session.update(user);
            transaction.commit();
            status = 1;
        } catch (Exception e) {
            //
        } finally {
            if (session != null) {
                session.close();
            }
        }
        return status == 1? user: null;
    }

    public User getUserDetails(final String userName){
        Session session = null;
        Transaction transaction = null;
        User user = new User();
        int status = 0;
        try {
            session = this.sessionFactory.openSession();
            Query query = session.createQuery("SELECT u FROM User u WHERE u.username=:userName");
            query.setParameter("userName", userName);
            user =  (User) query.uniqueResult();
            status = 1;
        } catch (Exception e) {
            //
        } finally {
            if (session != null) {
                session.close();
            }
        }
        return user;
    }

    public User getUserById(final long id){
        Session session = null;
        Transaction transaction = null;
        User user = new User();
        int status = 0;
        try {
            session = this.sessionFactory.openSession();
            Query query = session.createQuery("SELECT u FROM User u WHERE u.id=:id");
            query.setParameter("id", id);
            user =  (User) query.uniqueResult();
            status = 1;
        } catch (Exception e) {
            //
        } finally {
            if (session != null) {
                session.close();
            }
        }
        return user;
    }

//        public int updateModuleStatus(final String moduleId){
//            Session session = null;
//            Transaction transaction = null;
//            ModuleMarks moduleData = new ModuleMarks();
//            int status = 0;
//            try {
//                session = this.sessionFactory.openSession();
//                Query query = session.createQuery("update  Module mk set mk.hasMLModel =1 WHERE mk.id= :moduleId" );
//                query.setParameter("moduleId", moduleId);
//                moduleData =  (ModuleMarks) query.uniqueResult();
//                status = 1;
//            } catch (Exception e) {
//                //
//            } finally {
//                if (session != null) {
//                    session.close();
//                }
//            }
//            return status;
//        }
//
//        public ModuleMarks getModuleData(final long studentId, final String moduleId){
//            Session session = null;
//            Transaction transaction = null;
//            ModuleMarks moduleData = new ModuleMarks();
//            int status = 0;
//            try {
//                session = this.sessionFactory.openSession();
//                Query query = session.createQuery("SELECT mk FROM ModuleMarks mk WHERE mk.studentId=:studentId and mk.moduleId= :moduleId" );
//                query.setParameter("studentId", studentId);
//                query.setParameter("moduleId", moduleId);
//                moduleData =  (ModuleMarks) query.uniqueResult();
//                status = 1;
//            } catch (Exception e) {
//                //
//            } finally {
//                if (session != null) {
//                    session.close();
//                }
//            }
//            return moduleData;
//        }


}
