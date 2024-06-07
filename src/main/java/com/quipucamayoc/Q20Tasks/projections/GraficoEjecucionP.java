package com.quipucamayoc.Q20Tasks.projections;

import java.math.BigDecimal;

public interface GraficoEjecucionP {

	BigDecimal getTotalReq();
	BigDecimal getTotalCerti();
	BigDecimal getTotalCAnual();
	BigDecimal getTotalCMensual();
	BigDecimal getTotalDeven();
	BigDecimal getTotalGiro();
	BigDecimal getTotalSaldo();
}
