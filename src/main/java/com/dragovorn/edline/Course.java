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

package com.dragovorn.edline;

import com.dragovorn.edline.grade.Grades;
import org.jsoup.Connection.Response;

public class Course {

    private String name;
    private String link;
    private String teacher;

    private Response response;

    private Grades grades;

    public Course(String name, String link, Response response) {
        this.name = name;
        this.name = toTitleCase(name);
    }

    private String toTitleCase(String given) {
        String[] strs = given.split(" ");
        String str = "";

        for (String s : strs) {
            if (s.length() > 0) {
                if (s.length() < 3) {
                    str += s.toUpperCase() + " ";
                } else {
                    str += s.toUpperCase().charAt(0) + s.toLowerCase().substring(1) + " ";
                }
            }
        }

        return str;
    }

    protected void setTeacher(String teacher) {
        this.teacher =teacher;
    }
}