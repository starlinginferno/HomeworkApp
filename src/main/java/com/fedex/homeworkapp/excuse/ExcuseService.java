package com.fedex.homeworkapp.excuse;

import java.io.IOException;
import java.util.List;

public interface ExcuseService {

    String generateExcuse() throws IOException;

    List<String> listExcuses() throws IOException;

    ExcuseDTO mapExcuseDTO() throws IOException;
}
