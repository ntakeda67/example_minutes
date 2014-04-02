package org.example.minutes.service.impl;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.ejb.EJB;
import javax.ejb.LocalBean;
import javax.ejb.Stateless;

import org.example.minutes.dao.system.MemberDao;
import org.example.minutes.dto.MemberDetailDto;
import org.example.minutes.entity.Member;
import org.example.minutes.service.MemberService;

@Stateless
@LocalBean
public class MemberServiceImpl implements MemberService {
	
	@EJB
	private MemberDao memberDao;
	
	public List<MemberDetailDto> findMemberList() {
		List<Member> memberList = memberDao.findAll();
		return convertToMemberEntity(memberList);
	}
	
	public List<MemberDetailDto> convertToMemberEntity(List<Member> entityList){
		List<MemberDetailDto> dtoList = new ArrayList<MemberDetailDto>();
		
		for(Member entity : entityList){
			dtoList.add(convertToDetailDto(entity));
		}
		return dtoList;
	}
	
	private MemberDetailDto convertToDetailDto(Member entity){
		MemberDetailDto dto = new MemberDetailDto();
		
		dto.setRid(entity.getRid());
		dto.setSurName(entity.getSurName());
		dto.setFirstName(entity.getFirstName());
		dto.setMailAddress(entity.getMailAddress());
		dto.setLoginId(entity.getLoginId());
		dto.setComments(entity.getComments());
		dto.setUpdateDate(entity.getUpdateDate().getTime());
		
		return dto;
	}

	public void registerMember(MemberDetailDto dto) {
		Date transactionDate = new Date();
		
		Member entity = convertToEntity(dto);
		entity.setRegisterDate(transactionDate);
		
		memberDao.insert(entity);
	}
	
	private Member convertToEntity(MemberDetailDto dto){
		Member entity = new Member();
		
		entity.setRid(dto.getRid());
		entity.setSurName(dto.getSurName());
		entity.setFirstName(dto.getFirstName());
		entity.setMailAddress(dto.getMailAddress());
		entity.setLoginId(dto.getLoginId());
		// FIXME
		entity.setPassword(dto.getLoginId());
		// FIXME
		entity.setRegisterDate(new Date());
		
		return entity;
	}

	public void modifyMember(MemberDetailDto dto) {
		Member previousEntity = memberDao.find(dto.getRid());
		
		if(previousEntity == null || previousEntity.getUpdateDate().getTime() != dto.getUpdateDate().longValue()){
			throw new RuntimeException("Memberの更新時に排他エラー  rid:" + dto.getRid() );
		}
		mergeToEntity(dto, previousEntity);
	}

	private void mergeToEntity(MemberDetailDto dto, Member entity){
		entity.setSurName(dto.getSurName());
		entity.setFirstName(dto.getFirstName());
		entity.setMailAddress(dto.getMailAddress());
		entity.setLoginId(dto.getLoginId());
	}

}
