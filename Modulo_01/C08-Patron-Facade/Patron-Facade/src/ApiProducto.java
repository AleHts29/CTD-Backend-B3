public class ApiProducto {
    public int descuentoXproducto(Producto producto){
        if(producto.getTipo().equals("Latas")){
            return 10;
        }
        return 0;
    }
}
