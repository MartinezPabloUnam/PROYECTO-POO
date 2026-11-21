package Objetos;

/**
 * @author Francisco Javier Montiel Montejano, Pablo Isaac Martinez Giles,Angel Uriel Gutierrez Contreras 
 * Usuario Clase abtracta usuario
 */
public abstract class Usuario 
{
    protected String nombreusu;
    /**
     * Constructor de una instancia de Usuario
     * @param nombreusu recibe como parametro el nombre del usuario
     */
    public Usuario(String nombreusu)
    {
        this.nombreusu = nombreusu;
    }

    /**
     * getter del nombre del usuario
     * @return retorna el nombre del usuario(String)
     */
    public String getNombreusu()
    {
        return this.nombreusu;
    }

    /**
     * setter del nombre del usuario
     * @param nombreusu recibe como parametro el nuevo nombre del usuario
     */
    public void SetNombreusu(String nombreusu)
    {
        this.nombreusu=nombreusu;
    }

}

