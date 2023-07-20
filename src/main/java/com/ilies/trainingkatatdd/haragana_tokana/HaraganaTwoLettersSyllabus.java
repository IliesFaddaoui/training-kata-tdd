package com.ilies.trainingkatatdd.haragana_tokana;

public enum HaraganaTwoLettersSyllabus {
    KA("ka",	"か"),
    KI("ki","き"),
    KU("ku","く"),
    KE("ke","け"),
    KO("ko","こ"),
    SA("sa","さ"),
    SU("su","す"),
    SE("se","せ"),
    SO("so","そ"),
    TA("ta","た"),
    TE("te","て"),
    TO("to","と"),
    NA("na","な"),
    NI("ni","に"),
    NU("nu","ぬ"),
    NE("ne","ね"),
    NO("no","の"),
    HA("ha","は"),
    HI("hi","ひ"),
    FU("fu","ふ"),
    HE("he","へ"),
    HO("ho","ほ"),
    MA("ma","ま"),
    MI("mi","み"),
    MU("mu","む"),
    ME("me","め"),
    MO("mo","も"),
    YA("ya","や"),
    YU("yu","ゆ"),
    YO("yo","よ"),
    RA("ra","ら"),
    RI("ri","り"),
    RU("ru","る"),
    RE("re","れ"),
    RO("ro","ろ"),
    WA("wa","わ"),
    WI("wi","ゐ"),
    WE("we","ゑ"),
    WO("wo","を");
    private String haraganaSyllabus;
    private String kanaEquivalent;

    public String getHaraganaSyllabus() {
        return haraganaSyllabus;
    }

    public String getKanaEquivalent() {
        return kanaEquivalent;
    }

    HaraganaTwoLettersSyllabus(String haraganaSyllabus, String kanaEquivalent) {
        this.haraganaSyllabus = haraganaSyllabus;
        this.kanaEquivalent = kanaEquivalent;
    }
}
