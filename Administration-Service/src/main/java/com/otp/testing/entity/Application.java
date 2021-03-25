package com.otp.testing.entity;

import java.util.HashSet;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.Table;

@Entity
@Table(name = "application-data")
public class Application {
	
	@Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "genId")
    private Integer app_genId;

    @Column(name = "name")
    private String appName;

    @Column(name = "description")
    private String appDescription;

    @Column(name = "classification")
    private String appClassification;
    
    @Column(name = "type")
    private String appType;
    
    @Column(name = "apiExposure")
    private String appApiExposureMech;
    
    @ManyToMany(cascade = CascadeType.ALL, fetch = FetchType.EAGER)
    @JoinTable(
            name = "application_models",
            joinColumns = @JoinColumn(name = "genId"),
            inverseJoinColumns = @JoinColumn(name = "appGenId")
            )
    private Set<ApplicationModels> appModels = new HashSet<>();
    
    

}
