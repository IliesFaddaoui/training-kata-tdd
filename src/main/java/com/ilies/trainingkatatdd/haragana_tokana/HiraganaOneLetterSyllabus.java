package com.ilies.trainingkatatdd.haragana_tokana;

public enum HiraganaOneLetterSyllabus implements HaraganaSyllabus{
    A("a","あ"),
    I("i",	"い"),
    U("u","う"),
    E("e","え"),
    O("o","お"),
    N("n","ん");

    private final String hiraganaSyllabus;
    private final String kanaEquivalent;

    public String getHiraganaSyllabus() {
        return hiraganaSyllabus;
    }

    public String getKanaEquivalent() {
        return kanaEquivalent;
    }

    HiraganaOneLetterSyllabus(String hiraganaSyllabus, String kanaEquivalent) {
        this.hiraganaSyllabus = hiraganaSyllabus;
        this.kanaEquivalent = kanaEquivalent;
    }
}
