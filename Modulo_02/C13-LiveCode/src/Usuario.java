public class Usuario {
    private String nombre;
    private Long id;
    private String email;
    private double sueldo;

    public Usuario(String nombre, Long id, String email, double sueldo) {
        this.nombre = nombre;
        this.id = id;
        this.email = email;
        this.sueldo = sueldo;
    }

    public Usuario(String nombre, String email, double sueldo) {
        this.nombre = nombre;
        this.email = email;
        this.sueldo = sueldo;
    }

    //Metodo
    public double subirSueldo(double precio){
        this.sueldo = this.sueldo + precio;
        return this.sueldo;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public double getSueldo() {
        return sueldo;
    }

    public void setSueldo(double sueldo) {
        this.sueldo = sueldo;
    }
}
