package com.herprogramacion.alquileres.DTO;

/**
 * Created by Miguel on 26-09-16.
 */

public class Proposal {
    private String ID_PROPUESTA; // Pk
    private String TITULO;
    private String URL_IMAGEN;
    private String FECHA;
    private String UBICACION;
    private String DESCRIPCION;
    private String STATUS;
    private String STATUS_FLAG;
    private String FOLLOW;
    private String REPAIRIT;
    private String CATEGORIA;
    private String IMG_PARALAX;
    private String LAT;
    private String LON;
    private String USER_NAME;
    private String FOTO_USERCOM;
    private String BODY_COMMENT;

    public String getID_PROPUESTA() {
        return ID_PROPUESTA;
    }

    public void setID_PROPUESTA(String ID_PROPUESTA) {
        this.ID_PROPUESTA = ID_PROPUESTA;
    }

    public String getTITULO() {
        return TITULO;
    }

    public void setTITULO(String TITULO) {
        this.TITULO = TITULO;
    }

    public String getURL_IMAGEN() {
        return URL_IMAGEN;
    }

    public void setURL_IMAGEN(String URL_IMAGEN) {
        this.URL_IMAGEN = URL_IMAGEN;
    }

    public String getFECHA() {
        return FECHA;
    }

    public void setFECHA(String FECHA) {
        this.FECHA = FECHA;
    }

    public String getUBICACION() {
        return UBICACION;
    }

    public void setUBICACION(String UBICACION) {
        this.UBICACION = UBICACION;
    }

    public String getDESCRIPCION() {
        return DESCRIPCION;
    }

    public void setDESCRIPCION(String DESCRIPCION) {
        this.DESCRIPCION = DESCRIPCION;
    }

    public String getSTATUS() {
        return STATUS;
    }

    public void setSTATUS(String STATUS) {
        this.STATUS = STATUS;
    }

    public String getSTATUS_FLAG() {
        return STATUS_FLAG;
    }

    public void setSTATUS_FLAG(String STATUS_FLAG) {
        this.STATUS_FLAG = STATUS_FLAG;
    }

    public String getFOLLOW() {
        return FOLLOW;
    }

    public void setFOLLOW(String FOLLOW) {
        this.FOLLOW = FOLLOW;
    }

    public String getREPAIRIT() {
        return REPAIRIT;
    }

    public void setREPAIRIT(String REPAIRIT) {
        this.REPAIRIT = REPAIRIT;
    }

    public String getCATEGORIA() {
        return CATEGORIA;
    }

    public void setCATEGORIA(String CATEGORIA) {
        this.CATEGORIA = CATEGORIA;
    }

    public String getIMG_PARALAX() {
        return IMG_PARALAX;
    }

    public void setIMG_PARALAX(String IMG_PARALAX) {
        this.IMG_PARALAX = IMG_PARALAX;
    }

    public String getLAT() {
        return LAT;
    }

    public void setLAT(String LAT) {
        this.LAT = LAT;
    }

    public String getLON() {
        return LON;
    }

    public void setLON(String LON) {
        this.LON = LON;
    }

    public String getUSER_NAME() {
        return USER_NAME;
    }

    public void setUSER_NAME(String USER_NAME) {
        this.USER_NAME = USER_NAME;
    }

    public String getFOTO_USERCOM() {
        return FOTO_USERCOM;
    }

    public void setFOTO_USERCOM(String FOTO_USERCOM) {
        this.FOTO_USERCOM = FOTO_USERCOM;
    }

    public String getBODY_COMMENT() {
        return BODY_COMMENT;
    }

    public void setBODY_COMMENT(String BODY_COMMENT) {
        this.BODY_COMMENT = BODY_COMMENT;
    }
}
