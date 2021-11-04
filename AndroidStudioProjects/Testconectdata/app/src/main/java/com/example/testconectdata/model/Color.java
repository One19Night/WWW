package com.example.testconectdata.model;
import java.util.Random;
public class Color {
    int R;
    int G;
    int B;

    public Color(int r, int g, int b) {
        R = r;
        G = g;
        B = b;
    }
    {
        Color color = new Color(R, G, B);
        Random random = new Random();
        final float hue = random.nextFloat();
        final float saturation = 0.9f;
        final float luminance = 1.0f;
        Random rand = new Random();
        float R = rand.nextFloat();
        float G = rand.nextFloat();
        float B = rand.nextFloat();
    }
}