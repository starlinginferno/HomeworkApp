package com.fedex.homeworkapp.similarity;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
public class SimilarityModel {

    private Long studentId;
    private String studentName;
    private String title;
    private Double similarity;

    public SimilarityModel(Long studentId, String studentName, String title, Double similarity) {
        this.studentId = studentId;
        this.studentName = studentName;
        this.title = title;
        this.similarity = similarity;
    }

    @Override
    public String toString() {
        return "There are similarity with " + studentName +
                " (id: " + studentId + ") " + " title of homework: " + title +
                " and the similarity is " + similarity;
    }
}
