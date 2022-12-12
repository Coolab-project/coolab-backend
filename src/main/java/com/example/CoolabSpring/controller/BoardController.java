package com.example.CoolabSpring.controller;

import com.example.CoolabSpring.domain.Board;
import com.example.CoolabSpring.service.BoardServices;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

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
                      @RequestParam String subscription, RedirectAttributes redirectAttributes){
        Board newBoard = new Board(teamname, maxpeople, subscription);
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




}
