package com.megacenter.Model;

import javax.persistence.*;

@Entity
@Table(name = "leyenda")
public class Leyenda {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int idLeyenda;

    @Column(name = "CodLeyenda", nullable = false, length = 15)
    private String CodLeyenda;

    @Column(name = "Leyenda", nullable = false, length = 150)
    private String Leyenda;

    @OneToOne
    @JoinColumn(name = "id_Venta", nullable = false)
    private Venta venta;


    public int getIdLeyenda() {
        return idLeyenda;
    }

    public void setIdLeyenda(int idLeyenda) {
        this.idLeyenda = idLeyenda;
    }

    public String getCodLeyenda() {
        return CodLeyenda;
    }

    public void setCodLeyenda(String codLeyenda) {
        CodLeyenda = codLeyenda;
    }

    public String getLeyenda() {
        return Leyenda;
    }

    public void setLeyenda(String leyenda) {
        Leyenda = leyenda;
    }

    public Venta getVenta() {
        return venta;
    }

    public void setVenta(Venta venta) {
        this.venta = venta;
    }
}
