package org.generalka.PAZ1c_Generalka.rest;

import org.generalka.PAZ1c_Generalka.storage.Test;
import org.generalka.PAZ1c_Generalka.storage.TestDao;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class TestController {
    private final TestDao testDao;

    public TestController(TestDao testDao) {
        this.testDao = testDao;
    }

    @GetMapping("/tests")
    public List<Test> getAll() {
        return testDao.getAllTests();
    }

    @PostMapping("/tests")
    public Test save(@RequestBody Test test) {
        return testDao.saveTest(test);
    }

    @DeleteMapping("/tests/{id}")
    public void delete(@PathVariable long id) {
        testDao.deleteTest(id);
    }

    @GetMapping("/tests/{id}")
    public Test getById(@PathVariable long id) {
        return testDao.getTestById(id);
    }

    @GetMapping("/tests/{id}/questions_count")
    public int getQuestionsCount(@PathVariable long id) {
        return testDao.getNumberOfQuestions(id);
    }
}
