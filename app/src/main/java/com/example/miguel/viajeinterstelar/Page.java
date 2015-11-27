package com.example.miguel.viajeinterstelar;

/**
 * Created by 21443251 on 27/11/2015.
 */
public class Page {
    private int imageId;
    private String text;
    private Choice choice1;
    private Choice choice2;
    private boolean isFinal=false;

    public Page(){

    }

    public String getText(){
        return text;

    }

    public int getImageId() {
        return imageId;
    }

    public Choice getChoice1() {
        return choice1;
    }

    public Choice getChoice2() {
        return choice2;
    }

    public boolean isFinal() {
        return isFinal;
    }

    public Page(int imageId, String text, Choice choice1, Choice choice2) {
        this.imageId = imageId;
        this.text = text;
        this.choice1 = choice1;
        this.choice2 = choice2;
    }

    public Page(int imageId, String text) {
        this.imageId = imageId;
        this.text = text;
    }
}
