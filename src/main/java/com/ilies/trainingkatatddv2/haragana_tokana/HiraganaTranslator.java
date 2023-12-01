package com.ilies.trainingkatatddv2.haragana_tokana;


public class HiraganaTranslator {
    public String translateToKanji(String hiraganaSentence) {
        return HiraganaSyllabus.all().stream()
                .reduce(hiraganaSentence,
                        (sentence, hiraganaSyllabus) -> hiraganaSyllabus.translateKanji(sentence),
                        String::concat);
    }
}
