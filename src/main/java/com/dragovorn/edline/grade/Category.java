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

public class Category {
    private String name;

    private int weight;

    private double points;
    private double max;
    private double percent;
    private double accPercent;

    private boolean incomplete = false;

    Category(String name, String weight, String points, String percent) {
        this.name = name;
        this.weight = Integer.parseInt(weight);

        try {
            this.points = Double.parseDouble(points.split("/")[0].trim());
            this.max = Double.parseDouble(points.split("/")[1].trim());
            this.percent = Double.parseDouble(percent);

            this.accPercent = this.points / this.max;
        } catch (NumberFormatException exception) {
            this.points = 0;
            this.max = 0;
            this.percent = 0;
            this.accPercent = 0;

            incomplete = true;
        }
    }

    public String getName() {
        return this.name;
    }

    public int getWeight() {
        return this.weight;
    }

    public double getPoints() {
        return this.points;
    }

    public double getMax() {
        return this.max;
    }

    public double getPercent() {
        return this.percent;
    }

    public double getAccPercent() {
        return this.accPercent;
    }

    public boolean isIncomplete() {
        return this.incomplete;
    }

    @Override
    public String toString() {
        return this.name + ": " + this.weight + " " + this.points + "/" + this.max + " = " + this.percent + "%";
    }
}