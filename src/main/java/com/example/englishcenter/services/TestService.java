package com.example.englishcenter.services;

import com.example.englishcenter.dtos.PassageDTO;
import com.example.englishcenter.dtos.QuestionDTO;
import com.example.englishcenter.models.*;
import com.example.englishcenter.repositories.QuestionRepository;
import com.example.englishcenter.repositories.PassageRepository;
import com.example.englishcenter.repositories.FormNhapHocRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.*;
import java.util.stream.Collectors;

@Service
public class TestService {
    @Autowired
    private QuestionRepository questionRepository;

    @Autowired
    private PassageRepository passageRepository;

    @Autowired
    private FormNhapHocRepository formNhapHocRepository;

    public QuestionDTO convertToDTO(Question question) {
        return QuestionDTO.builder()
                .macauhoi(question.getMacauhoi())
                .noidung(question.getNoidung())
                .dapanA(question.getDapanA())
                .dapanB(question.getDapanB())
                .dapanC(question.getDapanC())
                .dapanD(question.getDapanD())
                .dapandung(question.getDapandung())
                .dokho(question.getDokho())
                .kynang(question.getKynang())
                .madoan(question.getMadoan() != null ? question.getMadoan().getMadoan() : null)
                .build();
    }

    public Map<String, Object> generateTest() {
        Map<String, Object> test = new HashMap<>();

        // Get Grammar and Vocabulary questions (mixed)
        List<SkillType> skills = Arrays.asList(SkillType.Grammar, SkillType.Vocabulary);
        List<Question> grammarQuestions = questionRepository.findByKynang(SkillType.Grammar);
        List<Question> vocabQuestions = questionRepository.findByKynang(SkillType.Vocabulary);

        Collections.shuffle(grammarQuestions);
        Collections.shuffle(vocabQuestions);
        // Filter 20 Grammar
        List<Question> selectedGrammarQuestions = grammarQuestions.stream()
                .limit(20)
                .collect(Collectors.toList());
        // Filter 20 Vocabulary
        List<Question> selectedVocabularyQuestions = vocabQuestions.stream()
                .limit(20)
                .collect(Collectors.toList());

        List<Question> grammarVocabCombined = new ArrayList<>();
        grammarVocabCombined.addAll(selectedGrammarQuestions);
        grammarVocabCombined.addAll(selectedVocabularyQuestions);
        Collections.shuffle(grammarVocabCombined);

        test.put("grammar_vocab_questions", grammarVocabCombined);

        // Get one Reading passage with questions
        List<Passage> readingPassages = passageRepository.findByLoaidoan(PassageType.Reading); // Medium difficulty
        if (!readingPassages.isEmpty()) {
            Collections.shuffle(readingPassages);
            Passage readingPassage = readingPassages.get(0);
            List<Question> readingQuestions = questionRepository.findByMadoan(readingPassage);
            Collections.shuffle(readingQuestions);
            List<QuestionDTO> selectedReading = readingQuestions.stream()
                    .limit(10)
                    .map(this::convertToDTO)
                    .collect(Collectors.toList());

            test.put("reading_passage", new PassageDTO(readingPassage));
            test.put("reading_questions", selectedReading);
        }

        // Get one Listening passage with questions
        List<Passage> listeningPassages = passageRepository.findByLoaidoan(PassageType.Listening); // Medium difficulty
        if (!listeningPassages.isEmpty()) {
            Collections.shuffle(listeningPassages);
            Passage listeningPassage = listeningPassages.get(0);
            List<Question> listeningQuestions = questionRepository.findByMadoan(listeningPassage);
            Collections.shuffle(listeningQuestions);
            List<QuestionDTO> selectedListening = listeningQuestions.stream()
                    .limit(10)
                    .map(this::convertToDTO)
                    .collect(Collectors.toList());

            test.put("listening_passage", new PassageDTO(listeningPassage));
            test.put("listening_questions", selectedListening);
        }

        return test;
    }

    public Boolean verifyStudent(String email, String sdt) {
        return formNhapHocRepository.findByEmailOrSdt(email, sdt).isPresent();
    }
}
