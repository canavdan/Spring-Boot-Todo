package com.canavdan.todo;

import com.canavdan.todo.domain.Member;
import com.canavdan.todo.repository.MemberRepository;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.test.context.junit4.SpringRunner;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;

@RunWith(SpringRunner.class)
@DataJpaTest
public class MemberRepositoryTests {

    @Autowired
    private MemberRepository memberRepository;

    @Test
    public void testSaveMember() {

        Member member = new Member("testuser", "test", "test@gmail.com");
        memberRepository.save(member);
        Member member2 = memberRepository.findByUsername("testuser");
        assertNotNull(member);
        assertEquals(member2.getUsername(), member.getPassword());
        assertEquals(member2.getUsername(), member.getPassword());
    }

    @Test
    public void testGetMember() {

        Member member = new Member("testuser", "test", "test@gmail.com");
        memberRepository.save(member);
        Member member2 = memberRepository.findByUsername("testuser");
        assertNotNull(member);
        assertEquals(member2.getUsername(), member.getPassword());
        assertEquals(member2.getUsername(), member.getPassword());
    }

    @Test
    public void testDeleteMember() {
        Member member = new Member("testuser", "test", "test@gmail.com");
        memberRepository.save(member);
        memberRepository.delete(member2.getId());
    }
}
