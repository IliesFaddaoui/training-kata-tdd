package com.ilies.trainingkatatdd.haragana_tokana;

public enum HaraganaThreeLettersSyllabus implements HaraganaSyllabus{
    SHI("shi","し"),
    CHI("chi","ち"),
    TSU("tsu","つ");

    private final String haraganaSyllabus;
    private final String kanaEquivalent;

    public String getHaraganaSyllabus() {
        return haraganaSyllabus;
    }

    public String getKanaEquivalent() {
        return kanaEquivalent;
    }

    HaraganaThreeLettersSyllabus(String haraganaSyllabus, String kanaEquivalent) {
        this.haraganaSyllabus = haraganaSyllabus;
        this.kanaEquivalent = kanaEquivalent;
    }
}
