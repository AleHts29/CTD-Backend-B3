public class ApiCantidad {
     public int descuentoXCantidad(int cantidad){
         if(cantidad > 12){
             return 15;
         }
         return 0;
     }
}
