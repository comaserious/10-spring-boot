package com.ohgiraffers.thymeleaf.controller;


import com.ohgiraffers.thymeleaf.model.dto.MemberDTO;
import com.ohgiraffers.thymeleaf.model.dto.SelectCriteria;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Controller
@RequestMapping("/lecture")
public class LectureController {

    @GetMapping("/expression")
    public ModelAndView expression(ModelAndView mv){
        /*ModelAndView  클래스는 spring-web-MVC 패턴을 배울때 더 자세히 다룰 예정이다
        * 따라서 지금은 단순히 내가 보여줄 동적인 페이지와 정보들을 담을 클래스 정도로 생각하자*/

        mv.addObject("member",new MemberDTO("hong",22,'M',"서울시"));
        mv.addObject("hello","hello <h3>thymeleaf</h3>");


        mv.setViewName("/lecture/expression");


        return mv;
    }

    @GetMapping("/conditional")
    public ModelAndView conditional(ModelAndView mv){

        // GetMapping 으로 가지고온 주소와
        // 다시 보내주는 주소가 동일할 경우 setViewName을 하지 않아도 자동으로 보내준다

        mv.addObject("num",1);
        mv.addObject("str","바나나");

        List<MemberDTO> members = new ArrayList<>();
        members.add(new MemberDTO("홍길동",20,'M',"서울시 노원구"));
        members.add(new MemberDTO("고길동",50,'M',"서울시 송파구"));
        members.add(new MemberDTO("유관순",18,'F',"부산"));
        members.add(new MemberDTO("신사임당",30,'F',"덕수"));

        mv.addObject("memberList",members);

        return mv;
    }
    @GetMapping("/etc")
    public ModelAndView etc(ModelAndView mv){

        SelectCriteria selectCriteria = new SelectCriteria(1,10,3);
        mv.addObject(selectCriteria);

        MemberDTO member = new MemberDTO("leleel",33,'F',"SanFrancisco");
        mv.addObject("member",member);

        List<MemberDTO> memberList = new ArrayList<>();
        memberList.add(new MemberDTO("홍길동",20,'M',"서울시 도봉구"));
        memberList.add(new MemberDTO("고길동",50,'M',"서울시 송파구"));
        memberList.add(new MemberDTO("유관",20,'M',"부산 서구현"));
        memberList.add(new MemberDTO("자이",20,'M',"강원 철길"));

        mv.addObject("memberList",memberList);

        Map<String,MemberDTO> memberMap = new HashMap<>();
        memberMap.put("m01",new MemberDTO("홍길동",20,'M',"서울시 도봉구"));
        memberMap.put("m02",new MemberDTO("고길동",50,'M',"서울시 송파구"));
        memberMap.put("m03",new MemberDTO("ㅇㅇㄹㄷ",30,'F',"부산222"));
        memberMap.put("m04",new MemberDTO("ㅇㅇㅇ",20,'F',"덕수444"));
        mv.addObject("memberMap",memberMap);
        return mv;
    }

}
