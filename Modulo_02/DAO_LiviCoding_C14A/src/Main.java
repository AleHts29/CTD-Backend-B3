import DAOs.EstudiantesDAO_H2;
import modelo.Estudiante;
import service.EstudianteService;

public class Main {
    public static void main(String[] args) {

        Estudiante estudiante = new Estudiante();
        Estudiante estudiante2 = new Estudiante();

        estudiante.setId(1L);
        estudiante.setNombre("Juan");
        estudiante.setApellido("Florez");
        estudiante2.setId(2L);
        estudiante2.setNombre("Camilo");
        estudiante2.setApellido("Ortiz");

        EstudianteService estudianteService = new EstudianteService();

        // seteamos una estrategia de persistencia
        estudianteService.setEstudianteIDao(new EstudiantesDAO_H2());

//        estudianteService.guardarEstudiante(estudiante);
        estudianteService.guardarEstudiante(estudiante2);
        System.out.println(estudianteService.buscarTodos());


    }
}