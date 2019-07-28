package com.canavdan.todo.rest;

import com.canavdan.todo.domain.Member;
import com.canavdan.todo.service.IMemberService;
import com.canavdan.todo.validation.MapValidationError;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/v1/member")
@Slf4j
public class MemberApi {


    private IMemberService memberService;
    private MapValidationError mapValidationError;
    private BCryptPasswordEncoder bCryptPasswordEncoder;

    public MemberApi(IMemberService memberService,
                          BCryptPasswordEncoder bCryptPasswordEncoder,MapValidationError mapValidationError) {
        this.memberService = memberService;
        this.bCryptPasswordEncoder = bCryptPasswordEncoder;
        this.mapValidationError = mapValidationError;
    }

    @GetMapping("/all")
    public ResponseEntity<?> getAllMembers(){
        List<Member> memberList=memberService.findAllMembers();
        return new ResponseEntity<List<Member>>(memberList, HttpStatus.OK);
    }

    @GetMapping("/{memberId]")
    public  ResponseEntity<?> getMemberById(@PathVariable Long id){
        Optional<Member> member=memberService.findMemberById(id);
        return new ResponseEntity<Optional<Member>>(member,HttpStatus.OK);
    }

    @PostMapping("/sign-up")
    public ResponseEntity<?> createNewMember(@Valid @RequestBody Member member , BindingResult result){
        ResponseEntity<?> errorMap = mapValidationError.MapValidationService(result);
        if(errorMap!=null) return errorMap;
        member.setPassword(bCryptPasswordEncoder.encode(member.getPassword()));
        memberService.saveOrUpdateMember(member);
        return new ResponseEntity<Member>(member, HttpStatus.CREATED);
    }
    @PostMapping("/login")
    public ResponseEntity<?> login(String username,String password,BindingResult result){
        ResponseEntity<?> errorMap = mapValidationError.MapValidationService(result);
        if(errorMap!=null) return errorMap;
        password=(bCryptPasswordEncoder.encode(password));
        memberService.existsByUsernameAndPassword(username,password);
        Member member=memberService.findMemberByUsernameAndPassword(username,password);
        return new ResponseEntity<Member>(member, HttpStatus.CREATED);
    }

}
