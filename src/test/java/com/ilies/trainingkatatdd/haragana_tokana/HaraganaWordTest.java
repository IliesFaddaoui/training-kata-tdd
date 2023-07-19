package com.ilies.trainingkatatdd.haragana_tokana;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class HaraganaWordTest {

    @Test
    void shouldReturnEmptyWordWhenHavingNothing() {
        HaraganaWord empty = new HaraganaWord("");
        assertEquals("", empty.getKanaTranslation());
    }

    @Test
    void shouldReturnAWhenHavingA() {
        HaraganaWord a = new HaraganaWord("A");
        assertEquals("あ", a.getKanaTranslation());
    }

    @Test
    void shouldReturnIWhenHavingI() {
        HaraganaWord i = new HaraganaWord("I");
        assertEquals("い", i.getKanaTranslation());
    }

    @Test
    void shouldReturnAIWhenHavingAI() {
        HaraganaWord ai = new HaraganaWord("AI");
        assertEquals("あい", ai.getKanaTranslation());
    }

    @Test
    void shouldReturnKAWhenHavingKA() {
        HaraganaWord ka = new HaraganaWord("KA");
        assertEquals("か", ka.getKanaTranslation());
    }

    @Test
    void shouldReturnKonnichiwaWhenHavingKonnichiwa() {
        HaraganaWord konnichiwa = new HaraganaWord("konnichiwa");

        assertEquals("こんにちわ", konnichiwa.getKanaTranslation());
    }

    @Test
    void shouldReturnKonnichiwaKakiWhenHavingKonnichiwaKaki() {
        HaraganaWord konnichiwa = new HaraganaWord("konnichiwa kaki");

        assertEquals("こんにちわ かき", konnichiwa.getKanaTranslation());
    }

}