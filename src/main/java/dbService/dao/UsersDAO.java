package dbService.dao;

import dbService.dataSets.UsersDataSet;
import org.hibernate.Session;
import org.hibernate.query.Query;

import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Root;

public class UsersDAO {

    private Session session;

    public UsersDAO(Session session) {
        this.session = session;
    }

    public UsersDataSet get(long id) {
        return session.get(UsersDataSet.class, id);
    }

    public UsersDataSet getUserByLogin (String login) {
        CriteriaBuilder builder = session.getCriteriaBuilder();
        CriteriaQuery<UsersDataSet> query = builder.createQuery(UsersDataSet.class);

        Root<UsersDataSet> root = query.from(UsersDataSet.class);
        query.select(root).where(builder.equal(root.get("login"), login));
        Query<UsersDataSet> q = session.createQuery(query);
        if (q.list().size() == 0) {
            return null;
        }
        UsersDataSet user = q.getSingleResult();

        return user;
    }

}
