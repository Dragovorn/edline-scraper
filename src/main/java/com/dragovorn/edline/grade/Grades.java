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

import com.dragovorn.edline.Course;

import java.util.ArrayList;
import java.util.Iterator;

public class Grades {

    private String source;
    private ArrayList<String> sourceArray;
    private Iterator<String> iterator;

    private Course course;

    private double grade;

    private ArrayList<Category> categories;
    private ArrayList<Assignment> assignments;

    public Grades(Course course, String source) {
        this.course = course;
        this.source = source.substring(source.indexOf("<div class=\"edlDocViewContents\" style=\"\" >"), source.indexOf("</div>", source.indexOf("<div class=\"edlDocViewContents\" style=\"\" >")));
        this.sourceArray = shaveSource(this.source);

    }

    private ArrayList<String> shaveSource(String source) {
        boolean inHtml = false;
        String output = "";
        char[] array = source.toCharArray();

        for (int x = 0; x < array.length; x++) {
            char c = array[x];

            if (c == '<') {
                inHtml = true;

                if ((array[x + 1] + "" + array[x + 2]).toLowerCase().equals("tr")) {
                    output += "\n[STARTROW]\n";
                }

                if ((array[x + 1] + "" + array[x + 2] + array[x + 3]).toLowerCase().equals("/tr")) {
                    output += "\n[ENDROW]\n";
                }
            }

            if (!inHtml) {
                output += c;
            }

            if (c == '>') {
                inHtml = false;
            }
        }

        String[] sourceArray = output.split("\n");

        ArrayList<String> sourceList = new ArrayList<String>();

        for (String str : sourceArray) {
            if (!str.replaceAll("\n", "").trim().equals("")) {
                sourceList.add(str.replaceAll("\n", "").trim());
            }
        }

        return sourceList;
    }

    public Course getCourse() {
        return this.course;
    }

    public ArrayList<Category> getCategories() {
        return this.categories;
    }

    public ArrayList<Assignment> getAssignments() {
        return this.assignments;
    }

    public double getGrade() {
        return grade;
    }
}