package com.ilies.trainingkatatdd.haragana_tokana;

public class HaraganaWord {
    private final String word;
    private final String kanaTranslation;

    public String getKanaTranslation() {
        return kanaTranslation;
    }

    public HaraganaWord(String word) {
        this.word = word.toLowerCase();
        this.kanaTranslation = generateKanaFromHaragana();
    }

    private String generateKanaFromHaragana() {
        String wordToTranslateToKana = this.word;
        for(HaraganaThreeLettersSyllabus h: HaraganaThreeLettersSyllabus.values()) {
            wordToTranslateToKana = wordToTranslateToKana.replace(h.getHaraganaSyllabus(), h.getKanaEquivalent());
        }
        for(HaraganaTwoLettersSyllabus h: HaraganaTwoLettersSyllabus.values()) {
            wordToTranslateToKana = wordToTranslateToKana.replace(h.getHaraganaSyllabus(), h.getKanaEquivalent());
        }
        for(HaraganaOneLetterSyllabus h: HaraganaOneLetterSyllabus.values()) {
            wordToTranslateToKana = wordToTranslateToKana.replace(h.getHaraganaSyllabus(), h.getKanaEquivalent());
        }
        return wordToTranslateToKana;
    }
}
