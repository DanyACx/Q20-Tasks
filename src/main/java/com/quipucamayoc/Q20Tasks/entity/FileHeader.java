package com.quipucamayoc.Q20Tasks.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.Getter;
import lombok.Setter;


@Setter
@Getter
@Entity
@Table(name = "file_header", schema = "bytsscom_bytcore")
public class FileHeader {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_fileheader")
    private Integer idFileHeader;

    @Column(name = "titu_fheader", length = 100)
    private String tituFheader;
}
