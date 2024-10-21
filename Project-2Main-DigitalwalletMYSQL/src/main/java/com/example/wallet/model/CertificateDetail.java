package com.example.wallet.model;
import com.fasterxml.jackson.annotation.JsonBackReference;

import jakarta.persistence.Entity;
//import jakarta.persistence.GeneratedValue;
//import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;
//import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
@Table(name="certi")
public class CertificateDetail {
	@Id
//	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private int numb;
	private int cer_number;
	private String cer_name;	
	@ManyToOne
    @JsonBackReference
	@JoinColumn(name="user_id")
	private UserDetail userDetail;	
}