package org.example.minutes.service;

import java.util.List;

import javax.ejb.Local;

import org.example.minutes.dto.MemberDetailDto;

@Local
public interface MemberService {
	List<MemberDetailDto> findMemberList();

	void registerMember(MemberDetailDto dto);

	void modifyMember(MemberDetailDto dto);
}
