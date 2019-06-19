package Test;
import org.testng.annotations.Test;

import Page.PageTsoft;

public class TestFlight{
	
	
	@Test
	public void pruebaFligth() throws Exception {
		
	PageTsoft.AbrirUrl();
	
	PageTsoft.LoginMenu();
	
	PageTsoft.IngresoVuelo();
	
	PageTsoft.BuscarVuelo();
	
	PageTsoft.ModificarVuelo();
	
	PageTsoft.BorrarVuelo();
	
	}
}
