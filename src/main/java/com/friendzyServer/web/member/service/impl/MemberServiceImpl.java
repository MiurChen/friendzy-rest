package com.friendzyServer.web.member.service.impl;




import javax.naming.NamingException;

import org.apache.commons.validator.routines.EmailValidator;

import com.friendzyServer.web.member.dao.MemberDao;
import com.friendzyServer.web.member.dao.impl.MemberDaoImpl;
import com.friendzyServer.web.member.pojo.Member;
import com.friendzyServer.web.member.service.MemberService;

public class MemberServiceImpl implements MemberService{
	private MemberDao memberDao;

	public MemberServiceImpl() throws NamingException {
		memberDao = new MemberDaoImpl();
	}
	
	
	@Override
	public String register(Member member) throws Exception {
		String email = member.getEmail();
		String password = member.getMpassword();
		String name = member.getMember_name();
		if(email == null || password == null || name == null) {
			return "欄位不可為空";
		}
		
		if (memberDao.seleteBy(email) != null) {
			return "該帳戶已註冊過，請確認後再執行";	
		}
		
		if(!EmailValidator.getInstance().isValid(email)) {
			return "信箱格式錯誤";
		}
		
		if(password.length() <8) {
			return "密碼長度需大於8";
		}
		
		int count = memberDao.insert(member);
		if(count>0) {
			return null;
		}else {
			return "註冊失敗";
		}

	}

}
