package com.ilies.trainingkatatdd.haragana_tokanaV2;


public class HiraganaTranslator {
    public String translateToKanji(String hiraganaSentence) {
        return HiraganaSyllabus.all().stream()
                .reduce(hiraganaSentence,
                        (sentence, hiraganaSyllabus) -> hiraganaSyllabus.translateKanji(sentence),
                        String::concat);
    }
}
