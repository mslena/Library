package org.example.Interface;

import java.util.List;
import java.util.Optional;

public interface DAO<T> {

    List<T> getAll();
}
