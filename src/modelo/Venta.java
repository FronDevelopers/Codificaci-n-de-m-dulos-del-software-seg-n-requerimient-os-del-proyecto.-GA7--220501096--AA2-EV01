package modelo;

public class Venta {
    //Atributos
    private int id_venta;
    private String productos;
    private String descripcion;
    private int cantidad;
    private double precio;
    private double total; 
    
    //Método Get y Set
    
    public int getId_venta(){
        return id_venta;
    }
    
        public void setId_venta(int id_venta){
        this.id_venta = id_venta;
    }
        
        public String getProductos(){
        return productos;
    }
    
        public void setProductos(String productos){
        this.productos = productos;
    }
        
        public String getDescripcion(){
        return descripcion;
    }
    
        public void setDescripcion(String descripcion){
        this.descripcion = descripcion;
    }
      
        public int getCantidad(){
        return cantidad;
    }
    
        public void setCantidad(int cantidad){
        this.cantidad = cantidad;
    }
        
        public double getPrecio(){
        return precio;
    }
    
        public void setPrecio(double precio){
        this.precio = precio;
    }
        
        public double getTotal(){
        return total;
    }
    
        public void setTotal(double total){
        this.total = total;
    }     
}

