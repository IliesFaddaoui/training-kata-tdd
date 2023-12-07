package com.ilies.trainingkatatdd.haragana_tokanaV2;

import java.util.Arrays;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;


public enum HiraganaSyllabus {
    SHI("shi","し"),
    CHI("chi","ち"),
    TSU("tsu","つ"),
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
    WO("wo","を"),
    A("a","あ"),
    I("i",	"い"),
    U("u","う"),
    E("e","え"),
    O("o","お"),
    N("n","ん");
    private final String hiragana;
    private final String kanji;

    HiraganaSyllabus(String hiragana, String kanji){
        this.hiragana = hiragana;
        this.kanji = kanji;
    }

    public static List<HiraganaSyllabus> all() {
        return Arrays.stream(values())
                .sorted(Comparator.comparingInt(entry -> entry.hiragana.length()))
                .collect(Collectors.toList()).reversed();
    }

    public String translateKanji(String sentence) {
        return sentence.toLowerCase().replace(hiragana, kanji);
    }
}
