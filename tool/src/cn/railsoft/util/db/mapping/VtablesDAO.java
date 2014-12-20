package cn.railsoft.util.db.mapping;

import java.util.List;
import org.hibernate.LockMode;
import org.hibernate.Query;
import org.hibernate.criterion.Example;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * A data access object (DAO) providing persistence and search support for
 * Vtables entities. Transaction control of the save(), update() and delete()
 * operations can directly support Spring container-managed transactions or they
 * can be augmented to handle user-managed Spring transactions. Each of these
 * methods provides additional information for how to configure it for the
 * desired type of transaction control.
 * 
 * @see cn.railsoft.util.db.mapping.Vtables
 * @author MyEclipse Persistence Tools
 */
public class VtablesDAO extends BaseHibernateDAO {
	private static final Logger log = LoggerFactory.getLogger(VtablesDAO.class);

	// property constants

	public void save(Vtables transientInstance) {
		log.debug("saving Vtables instance");
		try {
			getSession().save(transientInstance);
			log.debug("save successful");
		} catch (RuntimeException re) {
			log.error("save failed", re);
			throw re;
		}
	}

	public void delete(Vtables persistentInstance) {
		log.debug("deleting Vtables instance");
		try {
			getSession().delete(persistentInstance);
			log.debug("delete successful");
		} catch (RuntimeException re) {
			log.error("delete failed", re);
			throw re;
		}
	}

	public Vtables findById(cn.railsoft.util.db.mapping.VtablesId id) {
		log.debug("getting Vtables instance with id: " + id);
		try {
			Vtables instance = (Vtables) getSession().get(
					"com.repos.logistics.db.mapping.Vtables", id);
			return instance;
		} catch (RuntimeException re) {
			log.error("get failed", re);
			throw re;
		}
	}

	@SuppressWarnings("rawtypes")
	public List findByExample(Vtables instance) {
		log.debug("finding Vtables instance by example");
		try {
			List results = getSession()
					.createCriteria("com.repos.logistics.db.mapping.Vtables")
					.add(Example.create(instance)).list();
			log.debug("find by example successful, result size: "
					+ results.size());
			return results;
		} catch (RuntimeException re) {
			log.error("find by example failed", re);
			throw re;
		}
	}

	@SuppressWarnings("rawtypes")
	public List findByProperty(String propertyName, Object value) {
		log.debug("finding Vtables instance with property: " + propertyName
				+ ", value: " + value);
		try {
			String queryString = "from Vtables as model where model."
					+ propertyName + "= ?";
			Query queryObject = getSession().createQuery(queryString);
			queryObject.setParameter(0, value);
			return queryObject.list();
		} catch (RuntimeException re) {
			log.error("find by property name failed", re);
			throw re;
		}
	}

	@SuppressWarnings("rawtypes")
	public List findAll() {
		log.debug("finding all Vtables instances");
		try {
			String queryString = "from Vtables";
			Query queryObject = getSession().createQuery(queryString);
			return queryObject.list();
		} catch (RuntimeException re) {
			log.error("find all failed", re);
			throw re;
		}
	}

	public Vtables merge(Vtables detachedInstance) {
		log.debug("merging Vtables instance");
		try {
			Vtables result = (Vtables) getSession().merge(detachedInstance);
			log.debug("merge successful");
			return result;
		} catch (RuntimeException re) {
			log.error("merge failed", re);
			throw re;
		}
	}

	public void attachDirty(Vtables instance) {
		log.debug("attaching dirty Vtables instance");
		try {
			getSession().saveOrUpdate(instance);
			log.debug("attach successful");
		} catch (RuntimeException re) {
			log.error("attach failed", re);
			throw re;
		}
	}

	public void attachClean(Vtables instance) {
		log.debug("attaching clean Vtables instance");
		try {
			getSession().lock(instance, LockMode.NONE);
			log.debug("attach successful");
		} catch (RuntimeException re) {
			log.error("attach failed", re);
			throw re;
		}
	}
}