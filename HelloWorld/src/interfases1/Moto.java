package interfases1;

class Moto implements Vehiculos{ 
    
    int velocidad; 
    int marcha; 
      
    // Para cambiar de marcha
    @Override
    public void cambiaMarcha(int nuevaMarcha){ 
          
        marcha = nuevaMarcha; 
    } 
      
    // para aumentar la velocidad
    @Override
    public void acelera(int subida){ 
          
        velocidad = velocidad + subida; 
    } 
      
    // para disminuir la velocidad 
    @Override
    public void frena(int bajada){ 
          
        velocidad = velocidad - bajada; 
    } 
    // Imprime los valores guardados para velocidad y marcha  
    public void printStates() { 
         System.out.println("Velocidad: " + velocidad 
              + "\nMarcha: " + marcha); 
    } 
}
