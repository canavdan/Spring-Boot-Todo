package com.canavdan.todo.service;


import com.canavdan.todo.domain.Member;

import java.util.List;
import java.util.Optional;

public interface IMemberService {
    Member saveOrUpdateMember(Member member);
    List<Member> findAllMembers();
    Optional<Member> findMemberById(Long id);

}
