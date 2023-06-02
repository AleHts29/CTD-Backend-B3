public class FacadeDescuento implements IDescuento{

    ApiCantidad apiCantidad;
    ApiProducto apiProducto;
    ApiTarjeta apiTarjeta;

    public FacadeDescuento() {
        apiCantidad = new ApiCantidad();
        apiProducto = new ApiProducto();
        apiTarjeta = new ApiTarjeta();
    }

    @Override
    public int descuento(Tarjeta tarjeta, Producto producto, int cantidad) {
        //LLamar a los metodos de otras clases
        int descuentoFinal = 0;

        //Verificar Tarjeta
        descuentoFinal = descuentoFinal+apiTarjeta.descuentoXTarjeta(tarjeta);

        //Verificar Producto
        descuentoFinal = descuentoFinal+apiProducto.descuentoXproducto(producto);

        //Verificar cantidad
        descuentoFinal = descuentoFinal+apiCantidad.descuentoXCantidad(cantidad);


        return descuentoFinal;
    }
}
