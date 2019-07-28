package com.canavdan.todo.repository;

import com.canavdan.todo.domain.Member;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface MemberRepository extends JpaRepository<Member,Long> {
    Member findByUsername(String username);
    Boolean existsByUsernameAndPassword(String username,String password);
    Member findMemberByUsernameAndPassword(String username,String password);
}
