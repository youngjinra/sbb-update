package com.mysite.sbb.question;

<<<<<<< HEAD
import com.mysite.sbb.answer.Answer;
import com.mysite.sbb.answer.AnswerForm;
import com.mysite.sbb.answer.AnswerService;
=======
import com.mysite.sbb.answer.AnswerForm;
>>>>>>> 709b3cdbba9424ac5c032d634c5b6900a343d0bc
import com.mysite.sbb.user.SiteUser;
import com.mysite.sbb.user.UserService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.http.HttpStatus;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.server.ResponseStatusException;

import java.security.Principal;
<<<<<<< HEAD
import java.util.List;
=======
>>>>>>> 709b3cdbba9424ac5c032d634c5b6900a343d0bc

@RequestMapping("/question")
@RequiredArgsConstructor
@Controller
<<<<<<< HEAD
public class
QuestionController {
    private final AnswerService answerService;
=======
public class QuestionController {
>>>>>>> 709b3cdbba9424ac5c032d634c5b6900a343d0bc

    private final QuestionService questionService;
    private final UserService userService;

    @GetMapping("/list")
<<<<<<< HEAD
    public String list(Model model, @RequestParam(value="page", defaultValue="0") int page,
                       @RequestParam(value = "kw", defaultValue = "") String kw) {

        // List<Question>은 Question이 여러개 들어있는 꾸러미.
        // questionRepository는 question을 가지고 있다.
        // questionRopository야 전체 다 가져와서 questionList라는 이름의 꾸러미에다가 넣어줘
         // answerRepository야 전체 다 가져와서 answerList라는 이름의 꾸러미에다가 넣어줘

=======
    public String list(Model model, @RequestParam(value="page", defaultValue="0") int page, @RequestParam(value = "kw", defaultValue = "") String kw) {
>>>>>>> 709b3cdbba9424ac5c032d634c5b6900a343d0bc
        Page<Question> paging = this.questionService.getList(page, kw);
        model.addAttribute("paging", paging);
        model.addAttribute("kw", kw);
        return "question_list";
    }
    @GetMapping(value = "/detail/{id}")
    public String detail(Model model, @PathVariable("id") Integer id, AnswerForm answerForm) {
        Question question = this.questionService.getQuestion(id);
        model.addAttribute("question", question);
        return "question_detail";
    }
    @PreAuthorize("isAuthenticated()")
    @GetMapping("/create")
    public String questionCreate(QuestionForm questionForm) {
        return "question_form";
    }
    @PreAuthorize("isAuthenticated()")
    @PostMapping("/create")
<<<<<<< HEAD
    public String questionCreate(@Valid QuestionForm questionForm,
                                 BindingResult bindingResult, Principal principal) {
=======
    public String questionCreate(@Valid QuestionForm questionForm, BindingResult bindingResult, Principal principal) {
>>>>>>> 709b3cdbba9424ac5c032d634c5b6900a343d0bc
        if (bindingResult.hasErrors()) {
            return "question_form";
        }
        SiteUser siteUser = this.userService.getUser(principal.getName());
        this.questionService.create(questionForm.getSubject(), questionForm.getContent(), siteUser);
        return "redirect:/question/list";
    }
    @PreAuthorize("isAuthenticated()")
    @GetMapping("/modify/{id}")
<<<<<<< HEAD
    public String questionModify(QuestionForm questionForm, @PathVariable("id") Integer id, Principal principal)
    {
        Question question = this.questionService.getQuestion(id);
        if (!question.getAuthor().getUsername().equals(principal.getName())) {
=======
    public String questionModify(QuestionForm questionForm, @PathVariable("id") Integer id, Principal principal) {
        Question question = this.questionService.getQuestion(id);
        if(!question.getAuthor().getUsername().equals(principal.getName())) {
>>>>>>> 709b3cdbba9424ac5c032d634c5b6900a343d0bc
            throw new ResponseStatusException(HttpStatus.BAD_REQUEST, "수정권한이 없습니다.");
        }
        questionForm.setSubject(question.getSubject());
        questionForm.setContent(question.getContent());
        return "question_form";
    }
    @PreAuthorize("isAuthenticated()")
    @PostMapping("/modify/{id}")
    public String questionModify(@Valid QuestionForm questionForm, BindingResult bindingResult,
                                 Principal principal, @PathVariable("id") Integer id) {
        if (bindingResult.hasErrors()) {
            return "question_form";
        }
        Question question = this.questionService.getQuestion(id);
        if (!question.getAuthor().getUsername().equals(principal.getName())) {
            throw new ResponseStatusException(HttpStatus.BAD_REQUEST, "수정권한이 없습니다.");
        }
        this.questionService.modify(question, questionForm.getSubject(), questionForm.getContent());
        return String.format("redirect:/question/detail/%s", id);
    }
    @PreAuthorize("isAuthenticated()")
    @GetMapping("/delete/{id}")
    public String questionDelete(Principal principal, @PathVariable("id") Integer id) {
        Question question = this.questionService.getQuestion(id);
        if (!question.getAuthor().getUsername().equals(principal.getName())) {
            throw new ResponseStatusException(HttpStatus.BAD_REQUEST, "삭제권한이 없습니다.");
        }
        this.questionService.delete(question);
        return "redirect:/";
    }
    @PreAuthorize("isAuthenticated()")
    @GetMapping("/vote/{id}")
    public String questionVote(Principal principal, @PathVariable("id") Integer id) {
        Question question = this.questionService.getQuestion(id);
        SiteUser siteUser = this.userService.getUser(principal.getName());
        this.questionService.vote(question, siteUser);
        return String.format("redirect:/question/detail/%s", id);
    }
<<<<<<< HEAD
}
///asdfsdf
=======
}
>>>>>>> 709b3cdbba9424ac5c032d634c5b6900a343d0bc
