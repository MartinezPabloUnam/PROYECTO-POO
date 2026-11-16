package Objetos;
/**
 * @author Francisco Javier Montiel Montejano, Pablo Issac Martinez Giles,Angel Uriel Gutierrez Contreras
 * Domicilio
 */
public class Domicilio 
{
    private String calle;
    private String colonia;
    private int numext;

    /**
     * Contructor de la instancia del domicilio
     * @param calle recibe la calle del domicilio(String)
     * @param colonia recibe la colonia del domicicio(Sting)
     * @param numext recibe el numero exterior del domicilio(int)
     */
    public Domicilio(String calle, String colonia, int numext)
    {
        this.calle=calle;
        this.colonia=colonia;
        this.numext=numext;
    }
    /**
     * getter del atributo calle
     * @return retorna la calle del domicilio
     */
    public String getCalle(){
        return this.calle;
    }

    /**
     * getter del atributo colonia
     * @return retorna la colonia del domicilio
     */
    public String getColonia(){
        return this.colonia;
    }

    /**
     * getter del atributo numnext
     * @return retorna el numero exterior del domicilio
     */
    public int getNumext(){
        return this.numext;
    }



}
