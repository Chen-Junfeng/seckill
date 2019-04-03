package cn.codingxiaxw.service;

import cn.codingxiaxw.dto.Exposer;
import cn.codingxiaxw.dto.SeckillExecution;
import cn.codingxiaxw.entity.Seckill;
import cn.codingxiaxw.exception.RepeatKillException;
import cn.codingxiaxw.exception.SeckillCloseException;
import cn.codingxiaxw.exception.SeckillException;

import java.util.List;


public interface SeckillService {
	/**
	 * 查询全部的秒杀记录
	 * 
	 * @return
	 */
	List<Seckill> getSeckillList();

	/**
	 * 查询单个秒杀记录
	 * 
	 * @param seckillId
	 * @return
	 */
	Seckill getById(long seckillId);

	// 再往下，是我们最重要的行为的一些接口

	/**
	 * 在秒杀开启时输出秒杀接口的地址，否则输出系统时间和秒杀时间
	 * 
	 * @param seckillId
	 */
	Exposer exportSeckillUrl(long seckillId);

	/**
	 * 执行秒杀操作，有可能失败，有可能成功，所以要抛出我们允许的异常
	 * 
	 * @param seckillId
	 * @param userPhone
	 * @param md5
	 * @return
	 */
	SeckillExecution executeSeckill(long seckillId, long userPhone, String md5)
			throws SeckillException, RepeatKillException, SeckillCloseException;

	/**
	 * 调用存储过程来执行秒杀操作，不需要抛出异常
	 *
	 * @param seckillId 秒杀的商品ID
	 * @param userPhone 手机号码
	 * @param md5 md5加密值
	 * @return 根据不同的结果返回不同的实体信息
	 */
	SeckillExecution executeSeckillProcedure(long seckillId,long userPhone,String md5);
}
