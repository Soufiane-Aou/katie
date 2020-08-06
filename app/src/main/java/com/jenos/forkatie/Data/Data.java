package com.jenos.forkatie.Data;

public class Data {
    private String englishWord;
    private String ArabicWord;
    private  int audioWord;

    public Data(String englishWord, String arabicWord, int audioWord) {
        this.englishWord = englishWord;
        ArabicWord = arabicWord;
        this.audioWord = audioWord;
    }

    public String getEnglishWord() {
        return englishWord;
    }

    public String getArabicWord() {
        return ArabicWord;
    }

    public int getAudioWord() {
        return audioWord;
    }
}
