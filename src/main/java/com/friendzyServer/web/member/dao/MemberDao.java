package com.friendzyServer.web.member.dao;

import java.util.List;

import com.friendzyServer.core.dao.dao;
import com.friendzyServer.web.member.pojo.Member;

public abstract class MemberDao implements dao<Member>{
	
	@Override
	public abstract int insert(Member item) throws Exception;
	
	@Override
	public abstract int update(Member item) throws Exception;
	
	@Override
	public abstract int deleteBy(String id) throws Exception;
	
	@Override
	public abstract Member seleteBy(String id) throws Exception;
	
	@Override
	public abstract List<Member> seleteAll() throws Exception;

	
}
