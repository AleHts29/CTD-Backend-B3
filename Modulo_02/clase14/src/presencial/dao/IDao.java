package presencial.dao;

import java.util.ArrayList;

public interface IDao <T> {
    T guardar(T t);
    T buscar(Integer id);
}
