/*
 * Copyright (c) 2016. Andrew Burr
 *  Permission is hereby granted, free of charge, to any person obtaining a copy of this software and
 *  associated documentation files (the "Software"), to deal in the Software without restriction,
 *  including without limitation the rights to use, copy, modify, merge, publish, distribute,
 *  sublicense, and/or sell copies of the Software, and to permit persons to whom the Software is
 *  furnished to do so, subject to the following conditions:
 *
 * The above copyright notice and this permission notice shall be included in all copies or
 * substantial portions of the Software.
 *
 * THE SOFTWARE IS PROVIDED "AS IS", WITHOUT WARRANTY OF ANY KIND, EXPRESS OR IMPLIED,
 * INCLUDING BUT NOT LIMITED TO THE WARRANTIES OF MERCHANTABILITY, FITNESS FOR A
 * PARTICULAR PURPOSE AND NONINFRINGEMENT. IN NO EVENT SHALL THE AUTHORS OR
 * COPYRIGHT HOLDERS BE LIABLE FOR ANY CLAIM, DAMAGES OR OTHER LIABILITY, WHETHER IN AN
 * ACTION OF CONTRACT, TORT OR OTHERWISE, ARISING FROM, OUT OF OR IN CONNECTION WITH
 * THE SOFTWARE OR THE USE OR OTHER DEALINGS IN THE SOFTWARE.
 */

package com.dragovorn.edline.grade;

public class Assignment {

    private String name;
    private String due;
    private String category;

    private double weight;
    private double grade;
    private double max;

    private char letter;

    private boolean incomplete = false;

    Assignment(String name, String due, String category, String weight, String grade, String max, String letter) {
        this.name = name;
        this.due = due;
        this.category = category;

        try {
            this.weight = Double.valueOf(weight);
            this.grade = Double.valueOf(grade);
            this.max = Double.valueOf(max);
            this.letter = letter.charAt(0);
        } catch (NumberFormatException exception) {
            this.weight = 0;
            this.grade = 0;

            try {
                this.max = Double.valueOf(max);
            } catch (NumberFormatException ex) {
                this.max = 0;
            }

            this.letter = (letter + ' ').replace('&', '~').charAt(0);

            this.incomplete = true;
        }
    }

    public String getName() {
        return this.name;
    }

    public String getDue() {
        return this.due;
    }

    public String getCategory() {
        return this.category;
    }

    public double getWeight() {
        return this.weight;
    }

    public double getGrade() {
        return this.grade;
    }

    public double getMax() {
        return this.max;
    }

    public char getLetter() {
        return this.letter;
    }

    public boolean isIncomplete() {
        return this.incomplete;
    }

    @Override
    public String toString() {
        return this.name + " - Due: " + this.due + " Category: " + this.category + " Weight: " + this.weight + " Grade: " + this.grade + "/" + this.max + " = " + this.letter;
    }
}