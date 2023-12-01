package com.ilies.trainingkatatdd.haragana_tokana;

public enum HiraganaThreeLettersSyllabus implements HaraganaSyllabus{
    SHI("shi","し"),
    CHI("chi","ち"),
    TSU("tsu","つ");

    private final String hiraganaSyllabus;
    private final String kanaEquivalent;

    public String getHiraganaSyllabus() {
        return hiraganaSyllabus;
    }

    public String getKanaEquivalent() {
        return kanaEquivalent;
    }

    HiraganaThreeLettersSyllabus(String hiraganaSyllabus, String kanaEquivalent) {
        this.hiraganaSyllabus = hiraganaSyllabus;
        this.kanaEquivalent = kanaEquivalent;
    }
}
