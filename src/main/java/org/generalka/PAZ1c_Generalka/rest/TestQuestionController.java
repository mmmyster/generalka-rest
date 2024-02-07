package org.generalka.PAZ1c_Generalka.rest;

import org.generalka.PAZ1c_Generalka.storage.TestQuestion;
import org.generalka.PAZ1c_Generalka.storage.TestQuestionDao;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class TestQuestionController {
    private final TestQuestionDao testQuestionDao;

    public TestQuestionController(TestQuestionDao testQuestionDao) {
        this.testQuestionDao = testQuestionDao;
    }

    @GetMapping("/questions/{id}")
    public TestQuestion getById(@PathVariable long id) {
        return testQuestionDao.getTestQuestionById(id);
    }

    @GetMapping("/questions/test/{id}")
    public List<TestQuestion> getByTest(@PathVariable long id) {
        return testQuestionDao.getTestQuestionsByTestId(id);
    }

    @PostMapping("/questions")
    public TestQuestion save(@RequestBody TestQuestion testQuestion) {
        return testQuestionDao.saveTestQuestion(testQuestion);
    }

}
