package org.codelabor.example.datasource.spring;

import static org.junit.Assert.fail;

import java.sql.Connection;
import java.sql.SQLException;

import javax.sql.DataSource;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration("classpath:/**/applicationContext.xml")
public class DataSourceTest {

	Logger logger = LoggerFactory.getLogger(DataSourceTest.class);

	@Autowired
	ApplicationContext context;

	@Test
	public void test() {
		DataSource ds = (DataSource) context.getBean("dataSource");
		logger.debug("dataSource: {}", ds);

		try {
			Connection conn = ds.getConnection();
			logger.debug("connection: {}", conn);
		} catch (SQLException e) {
			fail(e.getMessage());
		}
	}

}