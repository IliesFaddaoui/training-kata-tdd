package com.ilies.trainingkatatdd.haragana_tokana;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

import static org.junit.jupiter.api.Assertions.*;

class HiraganaWordTest {

    @Test
    void no_kana_for_empty_hiragana() {
        HiraganaWord empty = new HiraganaWord("");
        assertEquals("", empty.getKanaTranslation());
    }

    @ParameterizedTest
    @CsvSource(value = { "A,あ", "I,い"})
    void syllabus_composed_by_only_one_vowel_should_be_translated_into_one_single_kana(String hiraganaSyllabus, String kanaExpected) {
        HiraganaWord a = new HiraganaWord(hiraganaSyllabus);
        assertEquals(kanaExpected, a.getKanaTranslation());
    }

    @ParameterizedTest
    @CsvSource(value = { "a,あ", "i,い"})
    void translation_is_not_case_sensitive_for_one_vowel_hiragana(String hiraganaSyllabus, String kanaExpected) {
        HiraganaWord a = new HiraganaWord(hiraganaSyllabus);
        assertEquals(kanaExpected, a.getKanaTranslation());
    }

    @ParameterizedTest
    @CsvSource(value = {"ka,か", "ni,に"})
    void syllabus_composed_by_a_consonant_followed_by_a_vowel_is_translated_by_a_single_kana(String hiraganaSyllabus, String kanaExpected) {
        HiraganaWord ka = new HiraganaWord(hiraganaSyllabus);
        assertEquals(kanaExpected, ka.getKanaTranslation());
    }

    @ParameterizedTest
    @CsvSource(value = {"ai,あい"})
    void two_consecutive_syllabus_should_be_translated_into_two_kana(String hiraganaSyllabus, String kanaExpected){
        HiraganaWord ai = new HiraganaWord(hiraganaSyllabus);
        assertEquals(kanaExpected, ai.getKanaTranslation());
    }

    @ParameterizedTest
    @CsvSource(value = {"kon,こん"})
    void syllabus_composed_by_a_vowel_and_consonant_followed_by_a_single_vowel_syllabus_is_translated_by_two_kana(String hiraganaSyllabus, String kanaExpected) {
        HiraganaWord kon = new HiraganaWord(hiraganaSyllabus);
        assertEquals(kanaExpected, kon.getKanaTranslation());
    }

    @ParameterizedTest
    @CsvSource(value = {"chi,ち","tsu,つ","shi,し"})
    void syllabus_composed_by_three_letters_starting_by_a_consonant_t_s(String hiraganaSyllabus, String kanaExpected) {
        HiraganaWord threeLettersSyllabusCorrect = new HiraganaWord(hiraganaSyllabus);
        assertEquals(kanaExpected, threeLettersSyllabusCorrect.getKanaTranslation());
    }
    @Test
    void word_composed_by_all_three_hiragana_patterns() {
        HiraganaWord wordWithAllHiraganaPatterns = new HiraganaWord("konnichiwa");

        assertEquals("こんにちわ", wordWithAllHiraganaPatterns.getKanaTranslation());
    }

    @Test
    void spaces_between_world_is_translated_by_space() {
        HiraganaWord twoWordsWithSpaceInMiddle = new HiraganaWord("konnichiwa kaki");
        assertEquals("こんにちわ かき", twoWordsWithSpaceInMiddle.getKanaTranslation());
    }
}