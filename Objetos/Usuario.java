package Objetos;

/**
 * @author Francisco Javier Montiel Montejano, Pablo Issac Martinez Giles,Angel Uriel Gutierrez Contreras
 * Usuario
 */
public abstract class Usuario 
{
    protected String nombreusu;

    /**
     * Constructor de la instancia usuario
     * @param nombreusu recibe como parametro el nombre del usuario(String)
     */
    public Usuario(String nombreusu)
    {
        this.nombreusu = nombreusu;
    }

    /**
     * getter del nombre de usuario
     * @return retorna el valor String del atributo nombreusu
     */
    public String getNombreusu()
    {
        return this.nombreusu;
    }

    /**
     * Setter del atributo nombreusu
     * @param nombreusu recibe como parametro el nuevo valor String de nombreusu
     */
    public void SetNombreusu(String nombreusu)
    {
        this.nombreusu=nombreusu;
    }

}
