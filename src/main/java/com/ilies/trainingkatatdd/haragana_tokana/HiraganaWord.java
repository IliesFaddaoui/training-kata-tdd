package com.ilies.trainingkatatdd.haragana_tokana;

import lombok.Getter;

@Getter
    public class HiraganaWord {
    private final String word;
    private String kanaTranslation;

    public HiraganaWord(String word) {
        this.word = word;
        generateKanaFromHiragana(word.toLowerCase());
    }

    private void generateKanaFromHiragana(String wordToTranslateToKana) {
        this.kanaTranslation = wordToTranslateToKana;
        checkAndReplaceTheseSyllabusByKanaIfPresentInWord(HiraganaThreeLettersSyllabus.values());
        checkAndReplaceTheseSyllabusByKanaIfPresentInWord(HiraganaTwoLettersSyllabus.values());
        checkAndReplaceTheseSyllabusByKanaIfPresentInWord(HiraganaOneLetterSyllabus.values());
    }

    private void checkAndReplaceTheseSyllabusByKanaIfPresentInWord(HaraganaSyllabus[] values) {
        for(HaraganaSyllabus syllabus: values) {
            this.kanaTranslation = replaceKanaInWordIfSyllabusPresent(this.kanaTranslation, syllabus);
        }
    }

    private static String replaceKanaInWordIfSyllabusPresent(String wordToTranslateToKana, HaraganaSyllabus syllabus) {
        return wordToTranslateToKana.replace(syllabus.getHiraganaSyllabus(), syllabus.getKanaEquivalent());
    }

}
