package com.canavdan.todo.service;

import com.canavdan.todo.domain.Member;
import com.canavdan.todo.repository.MemberRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;
@Service
public class MemberService implements IMemberService {

    @Autowired
    private MemberRepository memberRepository;
    @Transactional
    @Override
    public Member saveOrUpdateMember(Member member) {
        return memberRepository.save(member);
    }
    @Transactional(readOnly = true )
    @Override
    public List<Member> findAllMembers() {
        return memberRepository.findAll();
    }
    @Transactional(readOnly = true )
    @Override
    public Optional<Member> findMemberById(Long id) {
        return memberRepository.findById(id);
    }

    @Override
    public boolean existsByUsernameAndPassword(String username, String password) {
        return memberRepository.existsByUsernameAndPassword(username,password);
    }

    @Override
    public Member findMemberByUsernameAndPassword(String username, String password) {
        return memberRepository.findMemberByUsernameAndPassword(username,password);
    }
}
