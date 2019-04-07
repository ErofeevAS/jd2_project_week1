package com.gmail.erofeev.st.alexei.repository;

import java.util.List;

public interface FileRepository {

    List<String> getLines(String fileName);
}
