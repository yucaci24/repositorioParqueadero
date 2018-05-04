//package com.ceiba.parqueadero;
//
//import static org.junit.Assert.assertEquals;
//
//import org.junit.Test;
//import org.junit.runner.RunWith;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.boot.test.context.SpringBootTest;
//import org.springframework.test.context.junit4.SpringRunner;
//
//import com.ceiba.parqueadero.model.ReciboPago;
//import com.ceiba.parqueadero.service.ParqueaderoService;
//
//@RunWith(SpringRunner.class)
//@SpringBootTest
//public class ParqueaderoServiceImpTest {
	
//	@Autowired
//	ParqueaderoService validaciones;
//	
//	@Test
//	public void ComprobarConsultaOk () throws Exception {
//		//Arrange
//		String placa = "wer013";
//		
//		//Act
//		ReciboPago consultaOk = validaciones.consultarVehiculoPorPlaca(placa);
//		
//		//Assert
//		assertEquals(placa, consultaOk.getPlaca());
//	}
//
//}
