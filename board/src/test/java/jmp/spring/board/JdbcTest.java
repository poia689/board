package jmp.spring.board;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

import javax.sql.DataSource;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import jmp.spring.mapper.BoardMapper;
import lombok.extern.log4j.Log4j;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration("file:src/main/webapp/WEB-INF/spring/root-context.xml")
@Log4j
public class JdbcTest {

	@Autowired
	DataSource dataSource;

	@Autowired
	BoardMapper mapper;

	@Test
	public void mybatisTest() {
		log.info("==== 매퍼 ====" + mapper.getTime());
		log.info("==== 매퍼2 ====" + mapper.getTime2());
	}

	@Test
	public void DBTest() {
		try {
			Connection conn = DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:XE", "spring", "1234");
			log.info("==== 디비 ====" + conn);
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

	@Test
	public void testConnection() {
		try (Connection con = dataSource.getConnection()) {
			log.info("========테스트! " + con);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

}
