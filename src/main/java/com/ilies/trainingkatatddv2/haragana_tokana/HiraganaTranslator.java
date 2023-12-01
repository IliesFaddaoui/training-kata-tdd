package com.ilies.trainingkatatddv2.haragana_tokana;


import java.util.List;

public class HiraganaTranslator {
    public String translateToKanji(String hiraganaSentence) {
        List<HiraganaSyllabus> sortedHiraganaList = HiraganaSyllabus.getSortedHiraganaSyllabus();

        return sortedHiraganaList.stream()
                .reduce(new StringBuilder(hiraganaSentence.toLowerCase()), (sentence, hiraganaSyllabus) ->
                                new StringBuilder(sentence.toString().replace(hiraganaSyllabus.getHiragana(), hiraganaSyllabus.getKanji())),
                        StringBuilder::append)
                .toString();
    }
}
