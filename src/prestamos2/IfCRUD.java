
package prestamos2;

import java.util.List;


public interface IfCRUD<T> {
        List<T> listarElems();
        void insertarElem(T elem);
        T buscarElem(int id);
        void actualizarElem(int id);
        void eliminarElem(int id);    
}
