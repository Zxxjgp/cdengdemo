package com.vedeng.message.demo.filter.eache;

import org.apache.ibatis.cache.Cache;

import java.util.concurrent.locks.ReadWriteLock;

/**
 * 功能描述
 * className
 *
 * @author Bert
 * @date 2018/11/27 16:32
 * @Description //TODO
 * @version: 1.0
 */
public class MybatisEache implements Cache {
	@Override
	public String getId() {
		return null;
	}

	@Override
	public void putObject(Object o, Object o1) {

	}

	@Override
	public Object getObject(Object o) {
		return null;
	}

	@Override
	public Object removeObject(Object o) {
		return null;
	}

	@Override
	public void clear() {

	}

	@Override
	public int getSize() {
		return 0;
	}

	@Override
	public ReadWriteLock getReadWriteLock() {
		return null;
	}

}
