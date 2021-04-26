package com.study.homework.day3c.controller;

import com.study.homework.day3c.domain.Member;
import com.study.homework.day3c.domain.MemberRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/member")
public class WebController {
    // rest
    @Autowired
    private MemberRepository memberDao;

    @RequestMapping("/add")
    @ResponseBody
    public Member add(Member member) {
        Member memberData = memberDao.save(member);
        return memberData;
    }

    @RequestMapping("/list")
    @ResponseBody
    public List<Member> list() {
        return memberDao.findAll();
    }

    @RequestMapping("/edit/{id}")
    @ResponseBody
    public Member edit(Member member) {
        return memberDao.save(member);
    }

    // web ::
    @RequestMapping("/jsp")
    public String jspPage(Model model) {
        model.addAttribute("name", "hello springBoot1234");
        return "hello";
    }

    @RequestMapping("/")
    public String index() {
        return "helloHome";
    }
}