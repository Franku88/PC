import java.util.concurrent.locks.*;

public class Serie {
  private Lock capitulos = new ReentrantLock();
  private Condition verCapitulo = capitulos.newCondition();
  private int capitulosFilmados = 0;
  
  private Lock traduccion = new ReentrantLock();
  private Condition iniciarTraduccion = traduccion.newCondition();
  private Condition finalizoTraduccion = traduccion.newCondition();
  private int capitulosTraducidos = 0;

  public Serie() {
  }

  public void filmarCap() throws InterruptedException{
    this.capitulos.lock(); //se filma un capitulo a la vez
    try {
      System.out.println(Thread.currentThread().getName()+" finalizo la filmacion del capitulo "); 
      this.capitulosFilmados++; //se filmo un capitulo
      this.verCapitulo.signalAll(); //avisa que el cap en español ya esta
      this.iniciarTraduccion.signalAll(); //avisa para que se inicie la traduccion
    } catch (Exception e) {
      e.printStackTrace();
    } finally {
      this.capitulos.unlock();
    }
  }

  public void iniciarTraduccion() throws  InterruptedException {
    this.traduccion.lock();
    try {  
      this.capitulos.lock();
      while (this.capitulosFilmados == this.capitulosTraducidos) {
        this.capitulos.unlock();
        System.out.println("No hay caps para traducir...");
        this.iniciarTraduccion.await();
        this.capitulos.lock();
      }
      this.capitulos.unlock();
      
      System.out.println(Thread.currentThread().getName()+" inicia traduccion de capitulo");
      this.capitulosTraducidos++;
    } catch (Exception e) {
      e.printStackTrace();
    } finally {
      this.traduccion.unlock();
    }
  }
  public void finalizarTraduccion() throws InterruptedException{
    this.traduccion.lock();
    try {
      System.out.println(Thread.currentThread().getName()+" finalizo la traduccion del capitulo ");
      this.finalizoTraduccion.signalAll(); //avisa que esta traducido
    } catch (Exception e) {
      e.printStackTrace();
    } finally {
      this.traduccion.unlock();
    }
  }

  public void verEnIngles() throws InterruptedException{
    this.traduccion.lock();
    try {
      if(this.capitulosTraducidos == 0){
        this.finalizoTraduccion.await(); //espera el episodio
      }
      System.out.println(Thread.currentThread().getName()+" ve  el capitulo en ingles");
    } catch (Exception e) {
      e.printStackTrace();
    } finally {
      this.traduccion.unlock();
    }
  }
  
  public void verEnEspañol () throws InterruptedException{
    this.capitulos.lock();
    try {
      if(this.capitulosFilmados == 0){
        this.verCapitulo.await();//espera el episodio
      }
      System.out.println(Thread.currentThread().getName()+" ve  el capitulo en español");
    } catch (Exception e) {
      e.printStackTrace();
    } finally {
      this.capitulos.unlock();
    }
  }

}
