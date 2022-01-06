package com.wzc.login.dao;

import com.wzc.login.domain.Limit;

public class TestDao {

	public static void main(String[] args) {
		// TODO 自动生成的方法存根
        Limit limit =new Limit();
        limit.setId(100001);
        limit.setName("2018013000");
        limit.setLimit("root");
        LimitDao dao =new LimitDao();
        dao.insert(limit);
	}

}
