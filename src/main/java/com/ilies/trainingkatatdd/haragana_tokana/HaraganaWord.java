package com.ilies.trainingkatatdd.haragana_tokana;

public class HaraganaWord {
    private final String word;
    private String kanaTranslation;

    public HaraganaWord(String word) {
        this.word = word;
        generateKanaFromHaragana(word.toLowerCase());
    }

    private void generateKanaFromHaragana(String wordToTranslateToKana) {
        this.kanaTranslation = wordToTranslateToKana;
        checkAndReplaceTheseSyllabusByKanaIfPresentInWord(HaraganaThreeLettersSyllabus.values());
        checkAndReplaceTheseSyllabusByKanaIfPresentInWord(HaraganaTwoLettersSyllabus.values());
        checkAndReplaceTheseSyllabusByKanaIfPresentInWord(HaraganaOneLetterSyllabus.values());
    }

    private void checkAndReplaceTheseSyllabusByKanaIfPresentInWord(HaraganaSyllabus[] values) {
        for(HaraganaSyllabus syllabus: values) {
            this.kanaTranslation = replaceKanaInWordIfSyllabusPresent(this.kanaTranslation, syllabus);
        }
    }

    private static String replaceKanaInWordIfSyllabusPresent(String wordToTranslateToKana, HaraganaSyllabus syllabus) {
        return wordToTranslateToKana.replace(syllabus.getHaraganaSyllabus(), syllabus.getKanaEquivalent());
    }

    public String getKanaTranslation() {
        return kanaTranslation;
    }
}
