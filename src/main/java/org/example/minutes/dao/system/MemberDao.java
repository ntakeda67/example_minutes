package org.example.minutes.dao.system;

import java.math.BigDecimal;
import java.util.List;

import javax.ejb.Local;

import org.example.minutes.entity.Member;

@Local
public interface MemberDao {
	
	Member findMemberByLoginIdAndPassword(String loginId, String password);
	
	List<Member> findAll();

	Member find(BigDecimal rid);
	
	Member findLock(BigDecimal rid);
	
	void insert(Member entity);
	
	void update(Member entity);
}
