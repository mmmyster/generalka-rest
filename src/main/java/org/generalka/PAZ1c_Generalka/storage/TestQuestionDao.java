package org.generalka.PAZ1c_Generalka.storage;

import java.util.List;

public interface TestQuestionDao {

    // save test question
    TestQuestion saveTestQuestion(TestQuestion testQuestion) throws EntityNotFoundException;;


    // get a test question by its id
    TestQuestion getTestQuestionById(Long testQuestionId) throws EntityNotFoundException;;

    // get questions which belong to specific test
    List<TestQuestion> getTestQuestionsByTestId(Long testId) throws EntityNotFoundException;;
}

