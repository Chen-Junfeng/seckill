package cn.codingxiaxw.dao;

import cn.codingxiaxw.entity.Seckill;
import org.apache.ibatis.annotations.Param;

import java.util.Date;
import java.util.List;
import java.util.Map;

public interface SeckillDao {

	/**
	 * 减库存
	 * 
	 * @param seckillId
	 * @param killTime
	 * @return 如果影响行数>1，表示更新库存的记录行数
	 */
	int reduceNumber(@Param("seckillId") long seckillId, @Param("killTime") Date killTime);

	/**
	 * 根据id查询秒杀的商品信息
	 * 
	 * @param seckillId
	 * @return
	 */
	Seckill queryById(long seckillId);

	/**
	 * 根据偏移量查询秒杀商品列表
	 * 
	 * java没有保存形参的记录，java在运行的时候会把List<Seckill> queryAll(int offset,int
	 * limit);中的参数变成这样:queryAll(int arg0,int arg1),这样我们就没有办法去传递多个参数。
	 * 
	 * @param off
	 * @param limit
	 * @return
	 */
	List<Seckill> queryAll(@Param("offset") int offset, @Param("limit") int limit);
	/**
	 *  使用储存过程执行秒杀
	 * @param paramMap
	 */
	void killByProcedure(Map<String,Object> paramMap);
}