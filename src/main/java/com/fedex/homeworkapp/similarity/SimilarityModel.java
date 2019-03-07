package com.fedex.homeworkapp.similarity;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class SimilarityModel {

    private Long studentId;
    private String studentName;
    private String title;
    private Double similarity;

    @Override
    public String toString() {
        return "There are similarity with " + studentName +
                " (id: " + studentId + ") " + " title of homework: " + title +
                " and the similarity is " + similarity;
    }
}
