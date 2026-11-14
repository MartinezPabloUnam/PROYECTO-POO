package Objetos;


public abstract class Usuario 
{
    protected String nombreusu;

    public Usuario(String nombreusu)
    {
        this.nombreusu = nombreusu;
    }

    public String getNombreusu()
    {
        return this.nombreusu;
    }

    public void SetNombreusu(String nombreusu)
    {
        this.nombreusu=nombreusu;
    }

}
