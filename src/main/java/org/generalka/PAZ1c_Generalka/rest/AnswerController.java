package org.generalka.PAZ1c_Generalka.rest;

import org.generalka.PAZ1c_Generalka.storage.Answer;
import org.generalka.PAZ1c_Generalka.storage.AnswerDao;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class AnswerController {
    private final AnswerDao answerDao;

    public AnswerController(AnswerDao answerDao) {
        this.answerDao = answerDao;
    }

    @GetMapping("/answers")
    public List<Answer> getAll() {
        return answerDao.getAllAnswers();
    }

    @PostMapping("/answers")
    public Answer save(@RequestBody Answer answer) {
        return answerDao.saveAnswer(answer);
    }

    @DeleteMapping("/answers/{id}")
    public void delete(@PathVariable long id) {
        answerDao.deleteAnswer(id);
    }

    @GetMapping("/answers/{id}")
    public Answer getById(@PathVariable long id) {
        return answerDao.getAnswerById(id);
}

    @GetMapping("/answers/question/{id}")
    public List<Answer> getByQuestion(@PathVariable long id) {
        return answerDao.getAnswersByQuestionId(id);
    }

    @GetMapping("/answers/correct/{id}")
    public Answer getCorrectAnswer(@PathVariable long id) {
        return answerDao.getCorrectAnswerByQuestionId(id);
    }
}
