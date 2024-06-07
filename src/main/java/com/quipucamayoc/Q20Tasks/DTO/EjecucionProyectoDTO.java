package com.quipucamayoc.Q20Tasks.DTO;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class EjecucionProyectoDTO {

	private Double totalreq;
	private Double totalcerti;
	private Double totalcanual;
	private Double totalcmenssual;
	private Double totaldeven;
	private Double totalgiro;
	private Double totalsaldo;
}
