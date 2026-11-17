package Objetos;

public class Domicilio 
{
    private String calle;
    private String colonia;
    private int numext;

    public Domicilio(String calle, String colonia, int numext)
    {
        this.calle=calle;
        this.colonia=colonia;
        this.numext=numext;
    }

    public String getCalle() {
        return calle;
    }

    public void setCalle(String calle) {
        this.calle = calle;
    }

    public String getColonia() {
        return colonia;
    }

    public void setColonia(String colonia) {
        this.colonia = colonia;
    }

    public int getNumext() {
        return numext;
    }

    public void setNumext(int numext) {
        this.numext = numext;
    }

    
}
