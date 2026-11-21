package Objetos;
/**
 * @author Francisco Javier Montiel Montejano, Pablo Isaac Martinez Giles,Angel Uriel Gutierrez Contreras
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
    public String getCalle() {
        return calle;
    }

    /**
     * setter del atributo de calle 
     * @param calle recibe como parametro el nuevo valor String de la calle
     */
    public void setCalle(String calle) {
        this.calle = calle;
    }

    /**
     * getter del atributo colonia
     * @return retorna la colonia del domicilio
     */
    public String getColonia() {
        return colonia;
    }

    /**
     * setter de colonia
     * @param colonia recibe como parametro el nuevo valor de la colonia
     */
    public void setColonia(String colonia) {
        this.colonia = colonia;
    }

    /**
     * getter del atributo numnext
     * @return retorna el numero exterior del domicilio
     */
    public int getNumext() {
        return numext;
    }

    /**
     * setter del numero exterior
     * @param numext recibe como parametro el numero exterior
     */
    public void setNumext(int numext) {
        this.numext = numext;
    }

    
}
