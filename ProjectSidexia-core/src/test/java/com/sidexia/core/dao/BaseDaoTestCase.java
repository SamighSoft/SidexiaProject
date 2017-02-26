package com.sidexia.core.dao;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.junit.runner.RunWith;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.BeansException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ApplicationContextAware;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.transaction.annotation.Transactional;

/**
 * 
 * Base class for running DAO tests.
 * 
 */

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(

locations = { "classpath:/applicationContext-resources.xml",

"classpath:/applicationContext-dao.xml",

"classpath*:/applicationContext.xml",

"classpath:**/applicationContext*.xml" })
@Transactional
public abstract class BaseDaoTestCase implements ApplicationContextAware{

	@Autowired
	private SessionFactory sessionFactory;
	
	private ApplicationContext applicationContext;

	/**
	 * 
	 * Log variable for all child classes. Uses LogFactory.getLog(getClass())
	 * from Commons Logging
	 */

	private static final Logger LOG = LoggerFactory.getLogger(BaseDaoTestCase.class);


	
    @Override
    public void setApplicationContext(final ApplicationContext applicationContext) throws BeansException {
       LOG.debug("setting context");
        this.applicationContext = applicationContext;
    }

	protected void flush() throws BeansException {

		Session currentSession = sessionFactory.getCurrentSession();

		currentSession.flush();

	}

}