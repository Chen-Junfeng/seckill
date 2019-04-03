package cn.codingxiaxw.dao;

import static org.junit.Assert.*;

import javax.annotation.Resource;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import cn.codingxiaxw.entity.SuccessKilled;

@RunWith(SpringJUnit4ClassRunner.class)
//告诉junit spring的配置文件
@ContextConfiguration({ "classpath:spring/spring-dao.xml" })
public class SuccessKilledDaoTest {

	@Resource
	private SuccessKilledDao successKilledDao;

	/**
	 * 第一次：insertCount=1 第二次：insertCount=0
	 * 
	 * 不允许重复插入，忽略报错，用insertCount表示是否插入成功
	 */
	@Test
	public void insertSuccessKilled() throws Exception {

		long seckillId = 1001L;
		long userPhone = 13476191877L;
		int insertCount = successKilledDao.insertSuccessKilled(seckillId, userPhone);
		System.out.println("insertCount=" + insertCount);
	}

	@Test
	public void queryByIdWithSeckill() throws Exception {
		long seckillId = 1001L;
		long userPhone = 13476191877L;
		SuccessKilled successKilled = successKilledDao.queryByIdWithSeckill(seckillId, userPhone);
		System.out.println(successKilled);
		System.out.println(successKilled.getSeckill());
	}
}