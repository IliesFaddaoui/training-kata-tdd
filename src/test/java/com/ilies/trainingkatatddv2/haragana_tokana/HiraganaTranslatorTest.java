package com.ilies.trainingkatatddv2.haragana_tokana;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

import static org.junit.jupiter.api.Assertions.assertEquals;

class HiraganaTranslatorTest {

    private static HiraganaTranslator hiraganaTranslator;

    @BeforeAll
    static void init_translator() {
        hiraganaTranslator = new HiraganaTranslator();
    }

    @Test
    void no_kana_for_empty_hiragana() {
        assertEquals("", hiraganaTranslator.translateToKanji(""));
    }

    @ParameterizedTest
    @CsvSource(value = {"A,あ", "I,い"})
    void syllabus_composed_by_only_one_vowel_should_be_translated_into_one_single_kana(String hiraganaSyllabus, String kanaExpected) {
        assertEquals(kanaExpected, hiraganaTranslator.translateToKanji(hiraganaSyllabus));
    }

    @ParameterizedTest
    @CsvSource(value = {"a,あ", "i,い"})
    void translation_is_not_case_sensitive_for_one_vowel_hiragana(String hiraganaSyllabus, String kanaExpected) {
        assertEquals(kanaExpected, hiraganaTranslator.translateToKanji(hiraganaSyllabus));
    }

    @ParameterizedTest
    @CsvSource(value = {"ka,か", "ni,に"})
    void syllabus_composed_by_a_consonant_followed_by_a_vowel_is_translated_by_a_single_kana(String hiraganaSyllabus, String kanaExpected) {
        assertEquals(kanaExpected, hiraganaTranslator.translateToKanji(hiraganaSyllabus));
    }

    @ParameterizedTest
    @CsvSource(value = {"ai,あい"})
    void two_consecutive_syllabus_should_be_translated_into_two_kana(String hiraganaSyllabus, String kanaExpected) {
        assertEquals(kanaExpected, hiraganaTranslator.translateToKanji(hiraganaSyllabus));
    }

    @ParameterizedTest
    @CsvSource(value = {"kon,こん"})
    void syllabus_composed_by_a_vowel_and_consonant_followed_by_a_single_vowel_syllabus_is_translated_by_two_kana(String hiraganaSyllabus, String kanaExpected) {
        assertEquals(kanaExpected, hiraganaTranslator.translateToKanji(hiraganaSyllabus));
    }

    @ParameterizedTest
    @CsvSource(value = {"chi,ち", "tsu,つ", "shi,し"})
    void syllabus_composed_by_three_letters_starting_by_a_consonant_t_s(String hiraganaSyllabus, String kanaExpected) {
        assertEquals(kanaExpected, hiraganaTranslator.translateToKanji(hiraganaSyllabus));
    }

    @Test
    void word_composed_by_all_three_hiragana_patterns() {
        assertEquals("こんにちわ", hiraganaTranslator.translateToKanji("konnichiwa"));
    }

    @Test
    void spaces_between_world_is_translated_by_space() {
        assertEquals("こんにちわ かき", hiraganaTranslator.translateToKanji("konnichiwa kaki"));
    }
}