package com.boost.example1.controller;


import org.springframework.web.bind.annotation.*;

//RequestMapping : GET, POST 다 가능
//GetMapping : GET만 가능(데이터를 넘겨주고, 서버로부터 새로운 데이터를 조회받고 싶을 때)
//Posting : POST만 가능(데이터를 넘겨주고, 서버내에 데이터를 저장하거나 비교할때 사용)

@RestController
public class SampleController {

    @RequestMapping("/login")
    public String test01() {
        return "hihihihihihihi";
    }

    @GetMapping("/search")
    public String test02(@RequestParam(value = "query") String query,
                         @RequestParam(value = "age") int age) {
        System.out.println(age + "나이를 찾고 있네요");
        return query + "응답입니다.";
    }

    @PostMapping("/search.post")
    public String test03(@RequestBody String img) {
        return img + "응답입니다.~~~~";
    }

    @GetMapping("/check")
    public String test04(@RequestParam(value = "id") String userId,
                         @RequestParam(value = "pw") String password){
        if (userId.equals("admin") && password.equals("1234")) {
            return "로그인 성공";
        }else {
            return "로그인 실패";
        }
    }
}