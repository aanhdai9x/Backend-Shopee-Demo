package com.cmc.demoshopee.controller;

import com.cmc.demoshopee.entity.exam.Question;
import com.cmc.demoshopee.entity.exam.Quiz;
import com.cmc.demoshopee.service.QuestionService;
import com.cmc.demoshopee.service.QuizService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.*;

@RestController
@CrossOrigin("*")
@RequestMapping("/question")
public class QuestionController {
    @Autowired
    private QuestionService questionService;

    @Autowired
    private QuizService quizService;

    //add question
    @PostMapping("/")
    public ResponseEntity<Question> add(@RequestBody Question question){
        return ResponseEntity.ok(this.questionService.addQuestion(question));
    }

    //update question
    @PutMapping("/")
    public ResponseEntity<Question> update(@RequestBody Question question){
        return ResponseEntity.ok(this.questionService.updateQuestion(question));
    }

    //get all questions of any quiz
    @GetMapping("/quiz/{qid}")
    public ResponseEntity<?> getQuestionsOfQuiz(@PathVariable("qid") int qid){
//        Quiz quiz = new Quiz();
//        quiz.setqId(qid);
//        Set<Question> questionsOfQuiz = this.questionService.getQuestionOfQuiz(quiz);
//        return ResponseEntity.ok(questionsOfQuiz);
        Quiz quiz = this.quizService.getQuiz(qid);
        Set<Question> questions = quiz.getQuestions();
        List list = new ArrayList(questions);
        if(list.size()>Integer.parseInt(quiz.getNumberOfQuestions())){
            list=list.subList(0, Integer.parseInt(quiz.getNumberOfQuestions()+1));
        }
        Collections.shuffle(list);
        return ResponseEntity.ok(list);
    }

//    @GetMapping("/quiz/all/{qid}")
//    public ResponseEntity<?> getQuestionsOfQuizAdmin(@PathVariable("qid") int qid){
//        Quiz quiz = new Quiz();
//        quiz.setqId(qid);
//        Set<Question> questionsOfQuiz = this.questionService.getQuestionOfQuiz(quiz);
//        return ResponseEntity.ok(questionsOfQuiz);
//    }

    //get single question
    @GetMapping("/{quesId}")
    public Question get(@PathVariable("quesId") int quesId){
        return this.questionService.getQuestion(quesId);
    }

    //delete question
    @DeleteMapping("/{quesId}")
    public void delete(@PathVariable("quesId") int quesId){
        this.questionService.deleteQuestion(quesId);
    }

    //eval quiz
    @PostMapping("/eval-quiz")
    public ResponseEntity<?> evalQuiz(@RequestBody List<Question> questions){
        System.out.println(questions);
        Integer correctAnswer = 0;
        double marksGot = 0;
        Integer attempted = 0;
        for(Question question : questions) {
            //single question
            Question question1 = this.questionService.get(question.getQuesId());
            if(question1.getAnswer().equals(question.getGivenAnswer())){
                //correct
                correctAnswer++;
                double marksSingle = Double.parseDouble(questions.get(0).getQuiz().getMaxMarks())/questions.size();
                marksGot += marksSingle;
            }
            if(question.getGivenAnswer() != null){
                attempted++;
            }

        }
        Map<String, Object> map = new HashMap<String, Object>();
        map.put("marksGot", marksGot);
        map.put("correctAnswers", correctAnswer);
        map.put("attempted", attempted);
        return ResponseEntity.ok(map);
    }
}
