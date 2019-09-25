package com.starlc.constructor;

public class Glyph {
    void draw(){
        System.out.println("Glyph draw()");
    }

    public Glyph() {
        System.out.println("before glyph drwa()");
        draw();
        System.out.println("after glyph drwa()");
    }
}

class RoundGlyph extends Glyph{
    private int radius = 1;
    void draw(){
        System.out.println("RoundGlyph draw()radius="+radius);
    }

    public RoundGlyph(int radius) {
        this.radius =  radius;
        System.out.println("RoundGlyph RoundGlyph() radius="+radius);
    }

    public static void main(String[] args) {
        new RoundGlyph(5);
        /* 输出结果
        before glyph drwa()
        RoundGlyph draw()radius=0
        after glyph drwa()
        RoundGlyph RoundGlyph() radius=5*/
    }
}
