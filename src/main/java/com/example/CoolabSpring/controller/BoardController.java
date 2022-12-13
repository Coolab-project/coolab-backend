package com.example.CoolabSpring.controller;

import com.example.CoolabSpring.domain.Board;
import com.example.CoolabSpring.domain.Teams;
import com.example.CoolabSpring.domain.User;
import com.example.CoolabSpring.service.BoardServices;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;
import java.io.FileWriter;
import java.io.IOException;
import java.util.List;

import org.json.simple.JSONObject;

@Controller
@RequestMapping("/boards")
@RequiredArgsConstructor
public class BoardController {

    private final BoardServices boardService;

    @GetMapping
    public String main(Model model){
        model.addAttribute("boards", boardService.boardList());

        return "/board/boards";
    }

    @GetMapping("/{boardId}")
    public String board(@PathVariable long boardId, Model model){
        model.addAttribute("board", boardService.findById(boardId));

        return "/board/board";
    }
    @GetMapping("/add")
    public String add(){
        return "/board/addForm";
    }

    @PostMapping("/add")
    public String add(@RequestParam String teamname, @RequestParam int maxpeople,
                      @RequestParam String subscription, @RequestParam int template, RedirectAttributes redirectAttributes){
        Board newBoard = new Board(teamname, maxpeople, subscription, template);
        Long boardId = boardService.add(newBoard);
        System.out.println("boardId = " + boardId);
        redirectAttributes.addAttribute("boardId", boardId);
        redirectAttributes.addAttribute("status", true);

        JSONObject obj = new JSONObject();
        obj.put("teamname", teamname);
        obj.put("maxpeople", maxpeople);
        obj.put("subscription", subscription);
        obj.put("tempalte", template);
        return obj.toJSONString();
    }

    @GetMapping("/{boardId}/edit")
    public String editForm(@PathVariable Long boardId, Model model){
        Board findBoard = boardService.findById(boardId);
        model.addAttribute("board", findBoard);

        return "board/editForm";
    }

    @PostMapping("/{boardId}/edit")
    public String editForm(@PathVariable Long boardId, @RequestParam String teamname,
                           @RequestParam int maxpeople, @RequestParam String subscription)
    {

        Board findBoard = boardService.findById(boardId);
        findBoard.setTeamname(teamname);
        findBoard.setMaxpeople(maxpeople);
        findBoard.setSubscription(subscription);

        boardService.update(findBoard);

        return "redirect:/boards/{boardId}";
    }

    @GetMapping("/{boardId}/delete")
    public String deleteBoard(@PathVariable Long boardId){
        boardService.deleteById(boardId);
        return "redirect:/boards";
    }

    @GetMapping("/getuser")
    public String getUser(Model model, @PathVariable long userid) {
        model.addAttribute("users", boardService.finduser(userid));
        return "/getuser";

    }

    @GetMapping("/getuserteam")
    public String getUserTeam(Model model, @PathVariable long userid) {
        model.addAttribute("userteam", boardService.finduserteam(userid));
        String teamsList = boardService.finduserteam(userid).toString();
        System.out.println(teamsList);
        return teamsList;
    }

}
