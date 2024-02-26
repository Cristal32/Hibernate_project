package com.hibernate.HibPrjct;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;

@Entity
public class Entreprise {

	@Id
    @Column(name = "id_entreprise", unique = true, nullable = false)
    private String id;

    @Column(name = "raison sociale")
    private String raison_soc;

    @Column(name = "forme juridique")
    private String forme_jur;

    @Column(name = "adresse")
    private String adrs;

    @Column(name = "tel standard")
    private String tel_standard;

    @Column(name = "contact")
    private String contact;

    @Column(name = "tel contact")
    private String tel_contact;

    public Entreprise() { }

    public Entreprise(String id, String raison_social, String forme_juridique, String adrs_entreprise, String tel_standard, String contact, String tel_contact) {
        this.id = id;
    	this.raison_soc = raison_social;
        this.forme_jur = forme_juridique;
        this.adrs = adrs_entreprise;
        this.tel_standard = tel_standard;
        this.contact = contact;
        this.tel_contact = tel_contact;
    }

    public String getId() {
        return id;
    }

    public String getRaisonSoc() {
        return raison_soc;
    }

    public String getFormeJur() {
        return forme_jur;
    }

    public String getAdrs() {
        return adrs;
    }

    public String getTelStandard() {
        return tel_standard;
    }

    public String getContact() {
        return contact;
    }

    public String getTelContact() {
        return tel_contact;
    }

    //setters
    
    public void setId(String siret) {
        this.id = siret;
    }

    public void setRaisonSoc(String raison_social) {
        this.raison_soc = raison_social;
    }

    public void setFormeJur(String forme_juridique) {
        this.forme_jur = forme_juridique;
    }

    public void setAdrs(String adrs_entreprise) {
        this.adrs = adrs_entreprise;
    }

    public void setTelStandard(String tel_standard) {
        this.tel_standard = tel_standard;
    }

    public void setContact(String contact) {
        this.contact = contact;
    }

    public void setTelContact(String tel_contact) {
        this.tel_contact = tel_contact;
    }
    
    // to string
    @Override
    public String toString() {
    	return "Entreprise [ id = " + id + ", raison sociale = " + raison_soc + " ]";
    }
}
