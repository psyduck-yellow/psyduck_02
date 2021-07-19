package com.comsize.dev;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

@org.springframework.stereotype.Controller
public class Controller {

    @Autowired
    private Service Service;

    /**
     * GET用の処理.
     */
    @GetMapping("/hello")
    public String getHello() {

        // hello.htmlに画面遷移
        return "hello";
    }

    /**
     * POST用の処理.
     */
    @PostMapping("/hello")
    public String postRequest(@RequestParam("text_1") String str, Model model) {

        // 画面から受け取った文字列をModelに登録
        model.addAttribute("sample", str);

        // helloResponse.htmlに画面遷移
        return "helloRepositoryDB";
    }

    /**
     * POST用の処理（DB）.
     */
    @PostMapping("/hello/db")
    public String postDbRequest(@RequestParam("ID") String str, Model model) {

        // Stringからint型に変換
        int id = Integer.parseInt(str);

        // １件検索
        Employee employee = Service.findOne(id);

        // 検索結果をModelに登録
        model.addAttribute("id", employee.getId());
        model.addAttribute("name", employee.getName());
        model.addAttribute("area", employee.getArea());

        // helloResponseDB.htmlに画面遷移
        return "helloRepositoryDB.html";
    }
}
