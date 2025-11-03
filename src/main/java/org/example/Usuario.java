package org.example;

public class Usuario {
    private String correo;
    private String pais;
    private String plataforma;

    public Usuario(String correo, String pais, String plataforma) {
        this.correo = correo;
        this.pais = pais;
        this.plataforma = plataforma;
    }

    public Usuario() {
    }

    @Override
    public String toString() {
        return "Usuario{" +
                "correo='" + correo + '\'' +
                ", pais='" + pais + '\'' +
                ", plataforma='" + plataforma + '\'' +
                '}';
    }

    public String getCorreo() {
        return correo;
    }

    public void setCorreo(String correo) {
        this.correo = correo;
    }

    public String getPais() {
        return pais;
    }

    public void setPais(String pais) {
        this.pais = pais;
    }

    public String getPlataforma() {
        return plataforma;
    }

    public void setPlataforma(String plataforma) {
        this.plataforma = plataforma;
    }
}
