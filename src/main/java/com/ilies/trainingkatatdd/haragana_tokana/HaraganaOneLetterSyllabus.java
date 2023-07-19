package com.ilies.trainingkatatdd.haragana_tokana;

public enum HaraganaOneLetterSyllabus {
    A("a","あ"),
    I("i",	"い"),
    U("u","う"),
    E("e","え"),
    O("o","お"),
    N("n","ん");

    private final String haraganaSyllabus;
    private final String kanaEquivalent;

    public String getHaraganaSyllabus() {
        return haraganaSyllabus;
    }

    public String getKanaEquivalent() {
        return kanaEquivalent;
    }

    HaraganaOneLetterSyllabus(String haraganaSyllabus, String kanaEquivalent) {
        this.haraganaSyllabus = haraganaSyllabus;
        this.kanaEquivalent = kanaEquivalent;
    }
}
