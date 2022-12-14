package com.example.CoolabSpring.controller;

import com.example.CoolabSpring.domain.Board;
import com.example.CoolabSpring.service.BoardServices;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;
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
        ObjectMapper mapper = new ObjectMapper();
        String teamsList = null;
        try {
            teamsList = mapper.writeValueAsString(model);
            System.out.println(teamsList);
        }
        catch(JsonProcessingException j) {
            j.printStackTrace();
        }
        System.out.println(teamsList);
        return "/board/board";
    }
    @GetMapping("/add")
    public String add(){
        return "/board/addForm";
    }

    @PostMapping("/add")
    public String add(@RequestParam String teamname, @RequestParam int maxpeople,
                      @RequestParam String subscription, @RequestParam boolean template, RedirectAttributes redirectAttributes){
        Board newBoard = new Board(teamname, maxpeople, subscription, template);
        Long boardId = boardService.add(newBoard);
        System.out.println("boardId = " + boardId);
        redirectAttributes.addAttribute("boardId", boardId);
        redirectAttributes.addAttribute("status", true);
        return "redirect:/boards/{boardId}";
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

    @RequestMapping(value = {"/getuserteam/{userid}", "/getuseritem"}, method = RequestMethod.GET)
    @ResponseBody
    public String getuserteam(Model model, @PathVariable(required = false) long userid)  {
        model.addAttribute("userteam", boardService.finduserteam(userid));
        ObjectMapper mapper = new ObjectMapper();
        String teamsList = null;
        try {
            System.out.println(teamsList);
            teamsList = mapper.writeValueAsString(model);
        }
        catch(JsonProcessingException j) {
            j.printStackTrace();
        }
        System.out.println(teamsList);
        return "/board/userteam";
    }
}
